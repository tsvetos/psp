import java.io.IOException;
import java.util.*;

public class RuntimeProcess {
	public static void main(String[] args) {
		if (args.length <= 0) {
			System.err.println("Se necesita un programa a ejecutar");
			System.exit(-1);
		}
		Runtime runtime = Runtime.getRuntime();
		try {
			Process process = runtime.exec(args);
			Scanner tcl = new Scanner(System.in);
			System.out.println("Pulsa una tecla para destruir el proceso");
			tcl.nextLine();
			tcl.close();
			process.destroy();
			
		} catch (IOException ex) {
			System.err.println("Excepción de E/S");
			System.exit(-1);
		}
	}
}
