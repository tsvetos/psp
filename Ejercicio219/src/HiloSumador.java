import java.util.concurrent.Semaphore;

public class HiloSumador extends Thread {
	
	public Contador cont;
	public Semaphore sem;
	public int cuenta;
	public String nombreHilo;
	
	public HiloSumador() {
		
	}

	public HiloSumador(String nombre, Contador cont, int cuenta, Semaphore sem ) {
		this.nombreHilo = nombre;
        this.cont = cont ; 
        this.sem = sem; 
	}
	
	public void sumar(){
		Contador.num++;
	}
	public void run() {
		for (int i = 0; i < cuenta; i++) {
			Contador.incrementa();
			   try {
				sem.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sumar();
			sem.release();

		    }
		System.out.println("Al finalizar " +getName() + " el contador vale " +cont.valor()) ;
			
	}
}
