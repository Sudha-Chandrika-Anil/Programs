import java.io.*;

class Min
{
	public static void main(String args[])
	 {
	   int a,b,c,min;
	   DataInputStream din;
	   din= new DataInputStream(System.in);

	      try
	       {
		 System.out.println("Enter a number ");
		 a=Integer.parseInt(din.readLine());  
		 System.out.println("Enter next number ");
		 b=Integer.parseInt(din.readLine()); 
		 System.out.println("Enter next number ");
		 c=Integer.parseInt(din.readLine()); 
 	 	 
		 min=(a<b && a<c)?a:(b<c)?b:c;
		 System.out.println("Smallest number is "+min);
		
	       }
	      catch(Exception e)
		{
		  System.out.print("ERROR:"+e);
		}
	 }
}