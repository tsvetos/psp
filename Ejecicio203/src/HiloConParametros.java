
public class HiloConParametros extends Thread {
	//Creamos uan clase que hereda de thread y creamos una variable
	//de la clase
	private int veces;
	
	//constructor con parametrose, que recoge el hilo con un nombre
	//y el numero de iteraciones
	public HiloConParametros(String nombre, int veces) {
		//se llama al constructor Thread pasando como parametro nombre
		//y al constructor de esta clase el numero de veces
		super(nombre);
		//this.setName(nombre);
		//Thread.currentThread().setName(nombre);
		
		
		this.veces= veces;
	}
	
	public void run() {
		for (int i=1; i<veces;i++) {
			System.out.println("Soy hilo: " +getName()+ " | Iteracion: " +i);
		}
		
	}

}
