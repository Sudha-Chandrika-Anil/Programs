import java.io.*;

class Maximum
{
	public static void main(String args[])
	 {
	   int a,b,c,max;
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
 	 	 
		 if(a>b && a>c)
		 System.out.println("Largest number is "+a);
		 
		 else if(b>c)
		 System.out.println("Largest number is "+b);		
		 else
		 System.out.println("Largest number is "+c);
	       }
	      catch(Exception e)
		{
		  System.out.print("ERROR:"+e);
		}
	 }
}