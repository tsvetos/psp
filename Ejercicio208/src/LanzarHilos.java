public class LanzarHilos {
	public static void main(String args[]) {
		HiloEsperaNseg HiloEsperahilo1 = new HiloEsperaNseg(3);
		HiloEsperaNseg HiloEsperahilo2 = new HiloEsperaNseg(5);
		HiloEsperahilo1.setName("hilo 1");
		HiloEsperahilo2.setName("hilo 2");

		HiloEsperahilo1.start();
		HiloEsperahilo2.start();
		try {
			System.out.println("Soy el hilo principal y voy a esperar a que esperen los hilos");
			HiloEsperahilo1.join();
			HiloEsperahilo2.join();
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " interrumpido. ");
			return;
		}
		System.out.println("Soy el hilo principal y he terminado");
	}
}