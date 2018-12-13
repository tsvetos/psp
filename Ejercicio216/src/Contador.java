
public class Contador {
	
	public static int num=0;
	
	public Contador() {
	
	}
	
	public Contador (int num) {
		Contador.num = num;
		
	}
	
	public static void incrementa() {
		num = num +1;
		
	}
	
	public static void decrementa() {
		num = num - 1;
	}
	
	public static void mostrarValor() {
		System.out.println("El valor actual del contador es: " +num);
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		Contador.num = num;
		
	}
	
	public int valor() {
		return num;
	}

}
