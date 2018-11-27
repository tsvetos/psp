public class HiloConParametros extends Thread {
	//Creamos una clase que hereda de Thread y creamos una variable
	public String nombreHilo;
	public int veces;

	//Constructor con parámetros que recoge el hilo con un nombre y el número de iteraciones
	public HiloConParametros(String nombreHilo, int veces) {
		//Se llama al constructor Thread pasando como parámetro nombre
		//Y al constructor de esta clase el número de veces
		this.nombreHilo = nombreHilo;
		this.veces = veces;
	}

	public void run() {
		this.setName(nombreHilo);
		for (int i = 1; i <= this.veces; i++) {
			System.out.println("El hilo " + getName() + " se ha ejecutado " + i + " veces.");
		}
	}
}