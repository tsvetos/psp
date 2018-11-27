import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;

public class EjemploStream5 {
	public static void main (String args[]) throws IOException {
		
		//Escribimos que proceso queremos lanzar y se lo pasamos a un objeto PB
		ProcessBuilder pb1 = new ProcessBuilder("ls","-la");
		ProcessBuilder pb2 = new ProcessBuilder("tr","d", "D");
		pb1.directory(new File("/home/tsvtsv"));
		
		//Empieza el proceso
		Process process1 = pb1.start() ;
		Process process2 = pb2.start() ;
		
		InputStream is1 = process1.getInputStream();
		
		OutputStream os2 = process2.getOutputStream();

		
		InputStreamReader isr2 = new InputStreamReader(is1);
		BufferedReader br1 = new BufferedReader(isr2);
		

		
		String line;
        
        System.out.println("Linea normal");
        while ((line = br1.readLine()) != null )os2.write(line.getBytes()); {
            System.out.println(line);
		}

}
}
