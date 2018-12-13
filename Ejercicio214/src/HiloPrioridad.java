
public class HiloPrioridad extends Thread {
	
	//Creamos variables internas al hilo
	
	private int c = 0;
	private boolean stopHilo = false;
	
	//Constructores de clase HiloPrioridad con parametro nombre
	public HiloPrioridad(String nombre) {
		//Invocamos al constructor de la clase superior, asigna como nombre el parametro 
		//pasado como cadena de texto
		super(nombre);
	}
	//Creamos metodo getContador que devuelve valor de contador
	public int getContador() {
		return c;
	}
	//Metodo paraHilo bool, para detener el hilo
	public void pararHilo() {
		stopHilo = true;
	}
	//Metodo que se ejecuta al activar el hilo
	public void run() {
		//Imprime nombre y prioridad de hilo
		System.out.println("Prioridad hilo " +this.getName()+ ": "+this.getPriority());
		//Mientras no esta parado, esperar 2 ms
		while(!stopHilo) {
			try {
				Thread.sleep(2);
			}catch(Exception e) { }
			//Incrementa contador hasta que se cambie stopHilo a true;
			c++;
		}
		//Al salir del bucle imprime
		System.out.println("Fin hilo  " +this.getName());
	}

}
