import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;

public class EjemploStream3 {
	public static void main (String args[]) throws IOException {
	
		//Escribimos que proceso queremos lanzar y se lo pasamos a un objeto PB
		ProcessBuilder pb = new ProcessBuilder("passwd");
		
		//Empieza el proceso
		Process process = pb.start() ;
		
		//Conectamos OS a la entrada estandard de proceso para poder escribir en ella
		OutputStream os = process.getOutputStream();
		
		
		os.write("Seve\n".getBytes());
		os.write("Seve2\n".getBytes());
		os.write("Seve\n".getBytes());
		os.flush();
		
		//Caputamos salida de proceso
		InputStream is = process.getInputStream() ;
		InputStreamReader isr2 = new InputStreamReader(is);
		BufferedReader br2 = new BufferedReader(isr2);

		
		
		//Capturamos salida de error
		InputStream err = process.getErrorStream() ;
		InputStreamReader isr = new InputStreamReader(err);
		BufferedReader br = new BufferedReader(isr);
		
		
		
		
		
		
		
		
		int cont;
		while ((cont = br.read()) != -1)
			System.out.print((char) cont);
		String line;
		System.out.println("Salida del proceso " + Arrays.toString(args) + " :" ) ;
		while((line=br2.readLine())!= null ) {
		System.out.println(line);
		}
		}
}


