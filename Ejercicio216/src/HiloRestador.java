
public class HiloRestador extends Thread {
	public String nombre;
	public Contador cont;
	public int n;
	
	public HiloRestador() {
		
	}

	public HiloRestador(String nombre, Contador cont, int n  ) {
		this.nombre = nombre;
		setName(nombre);
		this.cont = cont;
		this.n= n;
	}
	public void run() {
		for (int i = 0; i < n; i++) {
			 Contador.decrementa();  
			   try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Al finalizar " +getName() + " el contador vale " +cont.getNum()) ;
			
	}

}
