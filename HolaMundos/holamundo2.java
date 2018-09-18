import java.util.Scanner;
class holamundo2{
	public static void main(String [ ] args){
	int num=0; 
	String nombre;
		
	Scanner tcl = new Scanner (System.in);
	System.out.println("Dime tu nombre");
	nombre = tcl.nextLine();
	while(num < 20){
		System.out.println("Hola " + nombre);
		num = num + 1; 
				   }
	}
}


