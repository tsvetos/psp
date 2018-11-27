class LanzaHilos211  { 
	public static void main(String[] args) {
		//declaramos dos hilos de la clase HiloEsperaNseg pasando como parámetros 3 y 5 segundos
		HiloEspera HiloEsperahilo1 = new HiloEspera(3);
		HiloEspera HiloEsperahilo2 = new HiloEspera(5);
		HiloEspera hiloDaemon = new HiloEspera(20);
		
		//Declaramos hiloDaemon como daemonhiloDaemon.setDaemon(true);
		hiloDaemon.setDaemon(true);
		
		//definimos los nombres de los hilos utilizando el método setName() de la clase Thread
		HiloEsperahilo1.setName("hilo 1");
		HiloEsperahilo2.setName("hilo 2");
		hiloDaemon.setName("hilo daemon");

		//inicializamos los hilos
		
		HiloEsperahilo1.start();
		HiloEsperahilo2.start();
		hiloDaemon.start();
		//hacemos que el hilo principal espera 4 segundos con el método sleep()
		try {
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " interrumpido. ");
			return;
		}
	}
} 