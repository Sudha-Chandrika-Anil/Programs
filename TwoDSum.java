import java.io.*;

class TwoDSum
{
	public static void main(String args[])
	 {
	   int a[][],r,c,i,sum,j;
	   DataInputStream din;
	   din= new DataInputStream(System.in);

	      try
	       {
		 System.out.println("Enter no:of rows and columns ");
		 r=Integer.parseInt(din.readLine()); 
		 c=Integer.parseInt(din.readLine());
		 a= new int[r][c];
		
		 for(i=0;i<r;i++) 
		  {
 		     for(j=0;j<c;j++) 
		      {
		        System.out.print("Enter a["+i+ "] ["+j+"]  ");
		        a[i][j]=Integer.parseInt(din.readLine()); 
		      }
		  }

		 System.out.println("ARRAY:");
		 for(i=0;i<r;i++) 
		  {
 		     for(j=0;j<c;j++) 
		      {
		        System.out.print(a[i][j]+"\t");
		      }
		     System.out.println("");
		  }
		 System.out.println("Sum of row:");
		 for(i=0;i<r;i++) 
		  {
		     sum=0;
 		     for(j=0;j<c;j++) 
		      {
			sum=sum + a[i][j];
			System.out.print(a[i][j]+"\t");
		      }
		     System.out.print("|"+sum);
		     System.out.println("");
		  }
		    
	       }
	      catch(Exception e)
		{
		  System.out.print("ERROR:"+e);
		}
	 }
}