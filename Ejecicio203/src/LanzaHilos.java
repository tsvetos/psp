

public class LanzaHilos {
	public static void main(String args[]) {
		//creamos tres hilos pasando parametros 
		HiloConParametros hilo1 = new HiloConParametros("David", 10);
		HiloConParametros hilo2 = new HiloConParametros("tsvetos", 6);
		HiloConParametros hilo3 = new HiloConParametros("Rafa", 5);
	
		System.out.println("Soy lanzahilos y voy a lanzar tres hilos");
		hilo1.start();
		hilo2.start();
		hilo3.start();
		
		System.out.println("Lanzahilos ha termiando su mision");
	}
	

}
