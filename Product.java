import java.io.*;

class Product
{
       public static void main(String args[])
	{ 
	  DataInputStream din;
	  int a,b;
	  din= new DataInputStream(System.in);
	  try
	   { System.out.println("Enter first number");
	     a=Integer.parseInt(din.readLine());
	     System.out.println("Enter the second number");
	     b=Integer.parseInt(din.readLine()); 
	     System.out.println("Product of numbers:"+(a*b));
	   }
	  catch(Exception e)
	   {
	     System.out.println("Error : "+e);
	   }
	}
}