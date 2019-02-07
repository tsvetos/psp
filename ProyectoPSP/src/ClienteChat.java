import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClienteChat extends JFrame implements ActionListener, Runnable {
	
	public static void main(String args[]) {
		int puerto = 44444;
		Socket s = null;
		
		//Añadido variable ip que pide la ip para conectar en vez de tener ip fija
		String nombre = JOptionPane.showInputDialog("Introduce tu nombre o nick: ");
		String ip = JOptionPane.showInputDialog("Introduce ip del servidor: ");
		
		if(nombre.trim().length() == 0) {
			System.out.println("El nombre esta vacio...");
			return;
		}
		
		try {
			
			s = new Socket ("192.168.26.127", puerto);
			ClienteChat cliente = new ClienteChat(s, nombre);
			cliente.setBounds(0,0,540,400);
			cliente.setVisible(true);
			new Thread(cliente).start(); //lanzar hilo cliente
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "IMPOSIBLE CONECTAR CON EL SERVIDOR\n" + e.getMessage(), "<<MENSAJE DE ERROR:1",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private static final long serialVesionUID = 1L;
	Socket socket = null;
	
	//streams
	DataInputStream fentrada;
	DataOutputStream fsalida;
	
	String nombre;
	static JTextField mensaje = new JTextField();
	
	private JScrollPane scrollpane1;
	static JTextArea textarea1;
	
	JButton botonEnviar = new JButton("Enviar");
	JButton botonSalir = new JButton("Salir");
	JTextArea areaUsu = new JTextArea("Usuarios conectados");
	boolean repetir = true;
	
	//constructor
	public ClienteChat(Socket s, String nombre){
		super(" CONEXIÓN DEL CLIENTE CHAT : " + nombre);
		setLayout(null);
		mensaje.setBounds(10, 10, 400, 30);
		add(mensaje);
		
		//Añadida funcion que manda el mensaje con Intro
		textarea1 = new JTextArea();
		mensaje.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				 if(e.getKeyCode() == KeyEvent.VK_ENTER){
				        botonEnviar.doClick();
				        }
			}
		});
		
		
		scrollpane1 = new JScrollPane(textarea1);
		scrollpane1.setBounds(10, 50, 400, 300);
		add(scrollpane1);
		
		botonEnviar.setBounds(420, 10, 100, 30);
		add(botonEnviar);
		botonSalir.setBounds(420, 50, 100, 30);
		add(botonSalir);
		areaUsu.setBounds(420, 90, 100, 30);
		add(areaUsu);
		
		textarea1.setEditable(false);
		botonEnviar.addActionListener(this);
		botonSalir.addActionListener(this);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		socket = s;
		this.nombre = nombre;
		try {
			fentrada = new DataInputStream(socket.getInputStream());
			fsalida = new DataOutputStream(socket.getOutputStream());
			String texto = " > Entra en el Chat... " + nombre;
			fsalida.writeUTF(texto);
		}catch(IOException e) {
			System.out.println("ERROR DE E/S");
			e.printStackTrace();
			System.exit(0);
		}
		
	}

	@Override
	public void run() {
		String texto = "";
		while(repetir) {
			try {
				texto = fentrada.readUTF();			//leer mensajes
				textarea1.setText(texto); 			//visualizarlos
 			}catch (IOException e) {
 				//este error sale cuando el servidor cierra
 				JOptionPane.showMessageDialog(null, "IMPOSIBLE CONECTAR CON EL SERVIDOR\n" + 
 				e.getMessage(), "<<MENSAGE DE ERROR:2>>", 
 					JOptionPane.ERROR_MESSAGE);
 				repetir = false; // salir del bucle
 			}
		}//fin del while
		
		try {
			socket.close(); //cerar socket
			System.exit(0);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}//fin run

	//acion cuando pulsamos botones
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String fechaYHora = String.valueOf(LocalDateTime.now().getHour() + ":" + String.valueOf(LocalDateTime.now().getMinute()));
		
		if(e.getSource() == botonEnviar) { //SE PULSA ENVIAR
			if(mensaje.getText().trim().length() == 0)
				return;
			String texto = fechaYHora + ":" +  nombre + "> " + mensaje.getText();
			
			try {
				mensaje.setText("");
				fsalida.writeUTF(texto);
			}catch(IOException e1) {
				e1.printStackTrace();
			}
		}
		
		if (e.getSource() == botonSalir) {//SE PULSA SALIR
			String texto = " > Abandona el Chat... " + nombre;
			try {
				fsalida.writeUTF(texto);
				fsalida.writeUTF("*");
				repetir = false; //Para salir del bucle
			}catch(IOException e1) {
				e1.printStackTrace();
			}
			
		}
		
	}

}
