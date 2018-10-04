import java.io.IOException;

import java.util.Arrays;

public class RunProcess {
	public static void main(String[] args) throws IOException {
		//Si no hay un programa a ejecutar pasado como parametro avisamos.
		if (args.length <= 0) {
			System.err.println("Se necesita un programa a ejecutar");
			System.exit(-1);
		}
		//Creamos objeto ProcessBuilder pasando como parametro el comando.
		ProcessBuilder pb = new ProcessBuilder(args);
		
		//Ejecutamos el proceso.
		try {
			Process process = pb.start();
			//Espera a que el proceso lanzado termine.
			int retorno = process.waitFor();
			//Informamos sobre el resultado.
			System.out.println("La ejecución de " + Arrays.toString(args) + " devuelve " + retorno);
		} catch (IOException ex) {
			//Avisamos si hay excepcion E/S
			System.err.println("Excepción de E/S");
			System.exit(-1);

		} catch (InterruptedException ex) {
			//Avisamos si hay otro tipo de error.
			System.err.println("El proceso hijo finalizó de forma incorrecta");
		}
	}
}