package intro;

public class MathClass {

    int key;

    public static void main(String[] args) {

        MathClass tester = new MathClass();

        // example method
        // output: 4
        tester.halve(8);

        // you are in charge of making the rest of these work

        // output: 49
        tester.square(7);

        // output: 7
        tester.averageFive(7, 10, 5, 7, 6);

        // output: 81
        tester.raiseToTheFourth(3);

        // output: nothing, just save the number 4 as an instance variable
        tester.setKey(4);

        // output: 28
        tester.multiplyByKey(7);

        // output: 64
        tester.keyCubed();

        // output: 3
        tester.makeInteger(3.756);

        // output: 8
        tester.roundToNearestWhole(7.8);
    }

    // an example method to use as a guideline
    public void halve(double x) {
        System.out.println(x / 2);
    }

    // create your own methods here

    // I'll give you the first method's outline to fill in. For the rest, you're in charge of
    // declaring the entire method.
    public void square(int x) {
        System.out.println(Math.pow(x, 2));
        // your code here
    }

    public void averageFive(double x1, double x2, double x3, double x4, double x5) {
        System.out.println((x1 + x2 + x3 + x4 + x5) / 5);
        // your code here
    }

    public void raiseToTheFourth(int x) {
        System.out.println(Math.pow(x, 4));
        // your code here
    }

    public void setKey(int x) {
        key = x;
        // your code here
    }

    public void multiplyByKey(int x) {
        System.out.println(key * x);
        // your code here
    }

    public void keyCubed() {
        System.out.println(Math.pow(key, 3));
        // your code here
    }

    public void makeInteger(double x) {
        System.out.println((int) x);
        // your code here
    }

    public void roundToNearestWhole(double x) {
        System.out.println(Math.round(x));
        // your code here
    }
}
