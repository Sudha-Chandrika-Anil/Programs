import java.io.*;

class Search
{
	public static void main(String args[])
	 {
	   int a[],n,i,x,f=0;
	   DataInputStream din;
	   din= new DataInputStream(System.in);

	      try
	       {
		 System.out.println("Enter no:of elements ");
		 n=Integer.parseInt(din.readLine()); 
		 a= new int[n];
		
		 for(i=0;i<n;i++) 
		  {
		    System.out.print("Enter a["+i+ "] ");
		    a[i]=Integer.parseInt(din.readLine()); 
		  }

		 System.out.println("ARRAY:");
		 for(i=0;i<n;i++) 
		  {
		    System.out.print(a[i]+" ");
		  }
		System.out.print("\nEnter the element to be searched");
		x=Integer.parseInt(din.readLine());
		
		for(i=0;i<n;i++) 
		  {
		    if(a[i]==x)
		    f=1;
		  }

		if(f==1)
		System.out.print("Element found");
		else
		System.out.print("Element not found");
	       }
	      catch(Exception e)
		{
		  System.out.print("ERROR:"+e);
		}
	 }
}