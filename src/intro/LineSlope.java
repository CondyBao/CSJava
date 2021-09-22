package intro;

public class LineSlope {
	
	// you'll probably want some instance variables... (4 coordinates and a slope)
	double ax, ay, bx, by, k;

	// use the parameters to assign your instance variables
	public void set_coordinates (double x1, double y1, double x2, double y2) {
		ax = x1;
		bx = x2;
		ay = y1;
		by = y2;
		// your code here
	}

	
	// calculate the slope using your instance variables
	public void calculate_slope () {
		k = (ay - by) / (ax - bx);
		// your code here
	}

	
	// print the slope you calculated in calculate_slope
	public void display_slope () {
		System.out.println(k);
		// your code here
	}
	
	public static void main(String[] args) {
		
		LineSlope runner = new LineSlope();
		
		// this line should have a slope of 2
		runner.set_coordinates(3, 3, 7, 11);
		runner.calculate_slope();
		runner.display_slope();
		
		// this line should have a slope of -.75
		runner.set_coordinates(0, -2, -4, 1);
		runner.calculate_slope();
		runner.display_slope();

	}
}