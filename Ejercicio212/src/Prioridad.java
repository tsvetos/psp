public class Prioridad { 
	public static void main(String[] args) { 
		HiloPrioridad thread1 = new HiloPrioridad(); 
		thread1.setName("Hilo 1"); 
		thread1.setPriority(1); 
		HiloPrioridad thread2 = new HiloPrioridad(); 
		thread2.setName("Hilo 2"); 
		thread2.setPriority(Thread.MAX_PRIORITY); 
		thread1.start(); 
		thread2.start(); 
	} 
} 