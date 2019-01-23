
class Reloj {
	private boolean imprimirTac = false;
	
	public synchronized void tic() {
		while (imprimirTac) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("----------------------TIC");
		imprimirTac = true;
		notifyAll();
	}
	
	public synchronized void tac() {
		while(imprimirTac = false) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("----------------------TAC");
		imprimirTac = false;
		notifyAll();
	}
}

class HiloTic extends Thread {
	private Reloj reloj;
	private int n;
	
	public HiloTic(String nombre, Reloj r, int n) {
		super(nombre);
		reloj = r;
		this.n = n;
	}
	
	public void run() {
		int it = 0;
		while (it < n) {
			System.out.println(getName() + " llama a tic " + it);
			reloj.tic();
			it++;
		}
	}
}

class HiloTac extends Thread {
	private Reloj reloj;
	private int n;
	
	public HiloTac(String nombre, Reloj r, int n) {
		super(nombre);
		reloj = r;
		this.n = n;
	}
	
	public void run() {
		int it = 0;
		while (it < n) {
			System.out.println(getName() + " llama a tac " + it);
			reloj.tac();
			it++;
			try {
				sleep(2000);
			} catch (InterruptedException e) {
			}
		}
	}
}

public class TicTacResuelto {
	public static void main(String[] args) {
		Reloj reloj = new Reloj();
		HiloTic hiloTic = new HiloTic("HiloTic1", reloj, 6);
		HiloTac hiloTac1 = new HiloTac("HiloTac1", reloj, 6);
		//HiloTac hiloTac2 = new HiloTac("HiloTac2", reloj, 3);
		
		hiloTic.start();
		//hiloTac2.start();
		hiloTac1.start();
	}
}