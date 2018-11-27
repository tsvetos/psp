class HiloEspera extends Thread { 
@Override 
public void run() { 
	//Mostramos el nombre del hilo actual
	System.out.println("Soy el "+ getName() +" empezando.");
	//Al dormir el hilo puede ser interrumpido y lanzar la excepcion
	try { 
		//Indicamos el tiempo de espera
		Thread.sleep(10000); 
	//Capturamos la excepcion y el hilo termina gracias al return
	} catch (InterruptedException e) { 
		System.out.println(getName()+" interrumpido."); 
		return; 
	} 
	System.out.println(getName() +" acabado."); 
	} 
} 