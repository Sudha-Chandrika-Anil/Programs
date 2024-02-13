import java.io.*;

class Sort
{
	public static void main(String args[])
	 {
	   int a[],n,i,temp,j;
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
		
		 for(i=0;i<n;i++) 
		  {
		    for(j=i+1;j<n;j++)
		     {
		       if(a[i]>a[j])
		        {
			  temp=a[i];
			  a[i]=a[j];
			  a[j]=temp;
		        }
		     }
		  } 

		 System.out.println("\n \nSORTED ARRAY");
		 
		 for(i=0;i<n;i++) 
		  {
		    System.out.print(a[i]+" ");
		  }
	       }
	      catch(Exception e)
		{
		  System.out.print("ERROR:"+e);
		}
	 }
}