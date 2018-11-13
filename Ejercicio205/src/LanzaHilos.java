import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LanzaHilos {
	public static void main(String[] args) {
		Scanner tcl = new Scanner(System.in);

		System.out.print("Cuántos hilos quieres crear: ");
		int veces = tcl.nextInt();
		tcl.close();
		
		for (int i = 1; i <= veces; i++ ) {
			CrearHilos hilo = new CrearHilos("Hilo" + i);
			hilo.start();
		}
	}
}