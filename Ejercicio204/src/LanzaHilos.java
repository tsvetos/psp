
public class LanzaHilos {
	public static void main(String[] args) throws Exception
	    {
		
		 try
         {
              HiloFibonacci fib = new HiloFibonacci();
              fib.start();
              
         }
         catch (Exception ex)
         {
              ex.printStackTrace();
         }

}
}