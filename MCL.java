import java.io.*;

interface ishape {
	public void draw();
	public void move();
}

class line implements ishape {
	public void draw() {
		System.out.println("Line draw");
	}
 	public void move() {
		System.out.println("Line move");
	}
}
class circle implements ishape {
	public void draw() {
		System.out.println("Circle draw");
	}
 	public void move() {
		System.out.println("Circle move");
	}
}

class MCL {
	public static void main(String args[]) {
		ishape obj;
		obj= new line();
		obj.draw();
		obj.move();
		obj= new circle();
		obj.draw();
		obj.move();
	}
}
