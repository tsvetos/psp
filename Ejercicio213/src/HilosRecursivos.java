
public class HilosRecursivos extends Thread {
	
	protected int n;
	
	public HilosRecursivos(int n) {
		//n = numero de iteraciones recursivas que quedan o numero de hilos que faltan por crear
		this.n = n;
		
	}
	
	public void run() {
		if(n> 0) {
			this.setName("Hilo " + n);
			System.out.println("Soy el " + getName()+": y voy a llamar al hilo: " + (n));
			HilosRecursivos hilo = new HilosRecursivos(n-1);
			hilo.start();
		}else if(n==0) {
			this.setName("Hilo " + n);
			System.out.println("Soy el " + getName());
		}
	}
}
