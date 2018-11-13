public class CrearHilos extends Thread {
	public CrearHilos(String nombre) {
		this.setName(nombre);
	}
	
	public void run() {
		System.out.println("Lanzando el " + getName() + ":");
		System.out.println(getName());
		System.out.println("Finalizando el " + getName());
	}
}