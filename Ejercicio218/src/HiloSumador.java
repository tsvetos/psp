
public class HiloSumador extends Thread {
	public String nombre;
	public Contador contador;
	public int n;

	public HiloSumador() {
	}

	public HiloSumador(String nombre, Contador contador, int n) {
		this.nombre = nombre;
		setName(nombre);
		this.contador = contador;
		this.n = n;
	}
	
	public void run() {
		synchronized (contador) {
			for (int i = 0; i < n; i++) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Contador.incrementa();
			}
		}
		System.out.println("Al finalizar " + getName() + " el contador vale " + contador.valor());
}
}
