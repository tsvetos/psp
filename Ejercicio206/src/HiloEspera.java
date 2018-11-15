public class HiloEspera extends Thread {
	public HiloEspera(String nombre) {
		this.setName(nombre);
	}
	
	public void run() { 
		System.out.println("Soy el "+ getName() +" empezando."); 
		try { 
		this.sleep(3000); 
		            // También se puede hacer así y lo aplicará al hilo actual. 
		            // Thead.sleep(3000); 
		} catch (InterruptedException e) { 
		System.out.println(getName() +" interrumpido."); 
		return; 
		} 
		System.out.println(getName() +" acabado."); 
		} 
}