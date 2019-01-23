
public class Tac extends Thread{
private int hilo;
	
	public Tac(int hilo) {
		this.hilo = hilo;
	}
	
	public void run() {
		while(true) {
			try {
				System.out.println("TAC");
				sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
}

}
