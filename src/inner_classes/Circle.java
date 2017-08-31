package inner_classes;

public class Circle {

	// define a Point as an inner class within Circle class
	/* any access modifier is allowed for the inner class */
	class Point {
		private int xPos;
		private int yPos;
		
		// you can provide constructor for an inner class like this
		/* any access modifier is allowed for the inner class */
		public Point(int x, int y){
			xPos = x;
			yPos = y;
		}
		
		// the inner class is like any other class - you can override methods here
		public String toString() {
			return "(" + xPos + "," + yPos + ")";
		}
	}
	
	// make use of the inner class for declaring a field
	private Point center;
	private int radius;
	
	public Circle(int x, int y, int r) {
		// note how to make use of the inner class to instantiate it
		center = this.new Point(x, y);
		radius = r;
		
		/* also works */
//		center = new Point(x, y);
	}
	
	public String toString(){
		return "mid point = " + center + " and radius = " + radius;
	}
	
	public static void main(String[] args) {
		System.out.println(new Circle(10, 10, 20));
	}
}
