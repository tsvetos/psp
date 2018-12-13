

public class LanzaHilos214 {
	public static void main(String[] args) {
		HiloPrioridad h1 = new HiloPrioridad("Hilo 1");
		HiloPrioridad h2 = new HiloPrioridad("Hilo 2");
		HiloPrioridad h3 = new HiloPrioridad("Hilo 3");
		
		//Muestra valor de las constantes 
		System.out.println("Thead.Min_Priority: " +Thread.MIN_PRIORITY);
		System.out.println("Thead.Norm_Priority: " +Thread.NORM_PRIORITY);
		System.out.println("Thead.Max_Priority: " +Thread.MAX_PRIORITY);
		
		//Asignamos prioridad
		h1.setPriority(Thread.MIN_PRIORITY);
		h2.setPriority(Thread.NORM_PRIORITY);
		h3.setPriority(Thread.MAX_PRIORITY);
		
		//Ejecutamos hilos
		h1.start();
		h2.start();
		h3.start();
		
		//Hilo principal espera 3s
		try {
			Thread.sleep(3000);
		}catch(Exception e) {}
		
		//Detenmos hilos
		h1.pararHilo();
		h2.pararHilo();
		h3.pararHilo();
		
		//Imprimimos para cada hilo el valor del contador de cada uno de los hilos
		System.out.println("h1 (Prioridad Minima): " + h1.getContador());
		System.out.println("h2 (Prioridad Normal): " + h2.getContador());
		System.out.println("h3 (Prioridad Maxima): " + h3.getContador());
}

}
