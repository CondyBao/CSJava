package intro;

public class ifStatements {
    public void isInt(int x) {
        if (x > 0) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }

    public void oddEven(int x) {
        if (x % 2 == 0) {
            System.out.println("Even");
        }
        else {
            System.out.println("Odd");
        }
    }

    public void ulCase(char x) {
        int c = x;
        if (c > 64 && c < 91) {
            System.out.println("Upper Case");
        }
        else if (c > 96 && c < 123) {
            System.out.println("Lower Case");
        }
        else {
            System.out.println("Neither");
        }
    }

    public void mult(int x) {
        if (x % 10 == 0) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }

    public void bigDouble(double a, double b, double c) {
        if (a > b) {
            if (a > c) {
                System.out.println(a);
            }
            else {
                System.out.println(c);
            }
        }
        else {
            if (b > c) {
                System.out.println(b);
            }
            else {
                System.out.println(c);
            }
        }
    }

    public static void main (String[] args) {
        ifStatements runner = new ifStatements();
        runner.isInt(10);
        runner.oddEven(3);
        runner.ulCase('b');
        runner.mult(10);
        runner.bigDouble(3.0, 3.4, 2.1);
    }
}
