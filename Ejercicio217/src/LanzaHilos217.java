
public class LanzaHilos217 {
public static void main(String[] args) {
		
		Contador contador = new Contador(100);
	
		HiloRestador hr = new HiloRestador("Hilo restador", contador, 300  );
		HiloSumador hs = new HiloSumador("Hilo sumador", contador, 300);

		Contador.mostrarValor();
		
		System.out.println("Voy a lanzar los hilos");
		hr.start();
		hs.start();
		
		try {
			hr.join();
			hs.join();
		}catch (InterruptedException e) {e.printStackTrace();}
		
		Contador.mostrarValor();

	}

}
