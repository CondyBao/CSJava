package intro;

public class SumIt {
	
  // instance variables
  private double one, two, sum;
  
  // use the two parameters to set the values of your two instance variables
  public void setNums(double num1, double num2) {
	  // your code here
      one = num1;
      two = num2;
  }
  
  // sum the two numbers here
  public void sum() {
	  // your code here
      sum = one + two;
  }
  
  // print the sum here
  public void print() {
	  // your code here
      System.out.println(sum);
  }
  
  
  public static void main(String[] args) {
	  SumIt runner = new SumIt();
	  
	  // should print out 12
	  runner.setNums(5,  7);
	  runner.sum();
	  runner.print();
	  
	  // should print out 40
	  runner.setNums(13, 27);
	  runner.sum();
	  runner.print();
  }
  
}