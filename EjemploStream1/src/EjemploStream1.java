import java.io.BufferedReader ;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;


public class EjemploStream1 {
	public static void main (String args[]) throws IOException {
		ProcessBuilder pb = new ProcessBuilder("java","HolaMundo1");
		pb.directory(new File("/home/tsvtsv/eclipse-workspace/HolaMundo1/bin"));
		Process process = pb.start() ;
		InputStream is = process.getInputStream() ;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;
		System.out.println("Salida del proceso " + Arrays.toString(args) + " :" ) ;
		while((line=br.readLine())!= null ) {
		System.out.println(line);
		}
		}
}
