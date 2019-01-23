import java.util.concurrent.Semaphore;

public class LanzaHilos219 {
	private static Semaphore sem = new Semaphore(1);
	
	public static void main(String[] args) {
		Contador contador = new Contador(100);

		HiloSumador hs1 = new HiloSumador("HSum1", contador, 100,  sem);
		HiloRestador hs2 = new HiloRestador("HSum2", contador, 100, sem);

		Contador.mostrarValor();
		System.out.println("Voy a lanzar los hilos");
		hs1.start();
		hs2.start();

		try {
			hs1.join();
			hs2.join();
		} catch (InterruptedException e) {e.printStackTrace(); }

		Contador.mostrarValor();
	}
}