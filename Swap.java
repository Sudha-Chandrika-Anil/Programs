import java.io.*;

class Swap
{
	public static void main(String args[])
	 {
	   int a,b,temp;
	   DataInputStream din;
	   din= new DataInputStream(System.in);

	      try
	       {
		 System.out.println("Enter a number ");
		 a=Integer.parseInt(din.readLine());  
		 System.out.println("Enter next number ");
		 b=Integer.parseInt(din.readLine());  
 	 	 temp=a;
		 a=b;
		 b=temp;
		 System.out.println("1st number : "+a+ "\n2nd number : "+b);
	       }
	      catch(Exception e)
		{
		  System.out.print("ERROR:"+e);
		}
	 }
}