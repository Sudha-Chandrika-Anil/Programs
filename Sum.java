import java.io.*;

class Sum
{
       public static void main(String args[])
        {
	   DataInputStream din;
	   int a,b;
	   din= new DataInputStream(System.in);
	  
	   try
	    { 
	        System.out.print("Enter a number  ");
	        a= Integer.parseInt(din.readLine());
                System.out.print("Enter next number ");
		b= Integer.parseInt(din.readLine());
		System.out.println(" Sum of "+a+ " and " +b+ " is " +(a+b));
	    } 
	
	  catch(Exception e)
	    {
		System.out.print("ERROR:"+e);
	    }
        }	
}
