import java.io.*;
import java.util.*;

class Copy {
    public static void main (String [] args){

	FileInputStream fin;
	FileOutputStream fout;
	Scanner s = new Scanner(System.in);
	String sname,dname;
	try {
	
		System.out.println("Enter the source file name");
		sname = s.nextLine();
		fin = new FileInputStream(sname);
	
		System.out.println("Enter the dest file name");
		dname = s.nextLine();
		fout = new FileOutputStream(dname);
		
		byte[] b;
		b=new byte[fin.available()];
		fin.read(b);
		String data= new String(b,0,b.length);
		fout.write(b);
		fin.close();
		fout.close();

	}
	catch(Exception e){
		System.out.println(e);
	}

    }
}