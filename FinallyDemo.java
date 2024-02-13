import java.io.*;

class FinallyDemo {
	public static void main(String args[]) {
            int a,b,c;
	    DataInputStream din = new DataInputStream(System.in);
	    try {
		System.out.println("Enter the 1st number  ");
		a=Integer.parseInt(din.readLine());
		System.out.println("Enter the 2nd number  ");
		b=Integer.parseInt(din.readLine());
		c=a/b;
		System.out.println("c=  "+c);
	    }
	   
	    catch(Exception e4) {
		System.out.println("Other errors "+e4);
	    }
	    finally {
		System.out.println("I'm always here ");
	    }
	}
}