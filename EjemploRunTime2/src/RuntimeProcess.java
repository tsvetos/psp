import java.io.File;
import java.io.IOException;
import java.util.*;

public class RuntimeProcess {
	public static void main(String[] args) throws IOException {
		//Necesitamos un comando o nombre de programa
		if (args.length <= 0) {
			System.err.println("Se necesita un programa a ejecutar");
			System.exit(-1);
		}
		//obtenemos el objeto Runtime
		Runtime runtime = Runtime.getRuntime();
		
				
		try {
			//ejecutamos el proceso, obtenemos el objeto
			Process process = runtime.exec(args,
					null, new File("/home/tsvtsv/eclipse-workspace/EjemploRunTime/bin"));
			//pedimos que pulse uan tecla
			Scanner tcl = new Scanner(System.in);
			
			System.out.println("Pulsa una tecla para destruir el proceso");
			tcl.nextLine();
			tcl.close();
			//matamos el proceso
			process.destroy();

			
		} catch (IOException ex) {
			System.err.println("Excepción de E/S");
			System.exit(-1);
		}
	}
}
