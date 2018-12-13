
public class HiloSumador extends Thread {
	
	public String nombre;
	public Contador cont;
	public int n;
	
	public HiloSumador() {
		
	}

	public HiloSumador(String nombre, Contador cont, int n  ) {
		this.nombre = nombre;
		setName(nombre);
		this.cont = cont;
		this.n= n;
	}
	public void run() {
		for (int i = 0; i < n; i++) {
			Contador.incrementa();
			   try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		    }
		System.out.println("Al finalizar " +getName() + " el contador vale " +cont.valor()) ;
			
	}
}
