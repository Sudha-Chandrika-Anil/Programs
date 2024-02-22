import java.io.*;

class Complex {
	Double i;
	Double r;
	public void read() {
	     DataInputStream din= new DataInputStream(System.in);
	     try {
 		System.out.println("Enter real number and imaginary");
		r=Double.parseDouble(din.readLine());
		i=Double.parseDouble(din.readLine());
	     }
	     catch(Exception e) {
	      	System.out.println(e);
	     }
	public Complex add(Complex q) {
	  	Complex t= new Complex();
		Complex t.r= r + q.r;
		Complex t.i= i + q.i;
		return t;
	}
	public Complex mult(Complex q) {
		Complex t= new Complex();
		t.r = r*q.r - i*q.i;
		t.i = r*q.i + i*q.r;
		return t;
	}
	public void disp() {
	    	System.out.println("Real"+r+"\tImaginary"+i);
	}
}

class MComplex {
	public static void main(String args[]) {
