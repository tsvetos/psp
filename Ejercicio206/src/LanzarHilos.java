import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LanzarHilos {
	public static void main(String[] args) {
		Scanner tcl = new Scanner(System.in);

		
		System.out.print("Cuántos hilos quieres crear: ");
		int veces = tcl.nextInt();
		tcl.close();
		
		HiloEspera[] hilos = new HiloEspera[veces];
		
		for (int i = 0; i < hilos.length; i++ ) {
			hilos[i]= new HiloEspera(String.valueOf(i));
			hilos[i].start();
		}
	}
}