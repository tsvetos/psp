public class CrearHilos { 
public static void main(String args[]) { 
	//Creamos los hilos
	HiloEspera hilo1 = new HiloEspera(); 
	HiloEspera hilo2 = new HiloEspera(); 
	//Añadimos el nombre usando el metodo setName() de la clase Thread
	hilo1.setName("hilo 1"); 
	hilo2.setName("hilo 2"); 
	//Iniciamos los hilos usando el metodo start
	hilo1.start(); 
	hilo2.start(); 
        try { 
        	//El hilo principal esperara 5 segundos
            Thread.currentThread().sleep(5000); 
        } catch (InterruptedException e) { 
            System.out.println(Thread.currentThread().getName() +" interrumpido. "); 
            return; 
        } 
        //Interrumpimos hilo1
        
        hilo1.interrupt(); 
        //Mostramos mensaje de fin de programa
        System.out.println("\tHilo principal acabado");
	} 
} 