package intro;

import java.util.Scanner;

public class scannerConditional {
    public void fourDigits(int a, int b, int c, int d) {
        System.out.println(a + b * 10 + c * 100 + d * 1000);
    }

    public void operation(String a, double x1, double x2) {
        if (a.equals("+")) {
            System.out.println(x1 + x2);
        }
        if (a.equals("-")) {
            System.out.println(x1 - x2);
        }
        if (a.equals("*")) {
            System.out.println(x1 * x2);
        }
        if (a.equals("/")) {
            System.out.println(x1 / x2);
        }
        if (a.equals("%")) {
            System.out.println(x1 % x2);
        }
    }

    public void football(int y1, int y2, int y3) {
        boolean flag = false;
        for (int i = 1; i <= y1; i++) {
            for (int j = 1; j <= y2; j++) {
                if ((i * 7 + j * 3) == y3) {
                    flag = true;
                    break;
                }
            }
        }
        if (flag) {
            System.out.println("Viable Score");
        }
        else {
            System.out.println("Unachievable Score");
        }
    }

    public void largeDigit(int number) {
        int copy = number, maxInt = 0;
        while (copy > 0) {
            int dig = copy % 10;
            maxInt = Math.max(maxInt, dig);
            copy -= dig;
            copy /= 10;
        }
        System.out.print("The largest digit is: ");
        System.out.println(maxInt);
    }

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        scannerConditional runner = new scannerConditional();
        int a, b, c, d;
        System.out.println("Input a number:");
        a = input.nextInt();
        System.out.println("Input another number:");
        b = input.nextInt();
        System.out.println("Input another number:");
        c = input.nextInt();
        System.out.println("Input another number:");
        d = input.nextInt();
        runner.fourDigits(a, b, c, d);

        String operate;
        double x1, x2;
        System.out.println("Input a string:");
        operate = input.next();
        System.out.println("Input a number:");
        x1 = input.nextDouble();
        System.out.println("Input another number:");
        x2 = input.nextDouble();
        runner.operation(operate, x1, x2);

        int y1, y2, y3;
        System.out.println("Input number of touchdowns:");
        y1 = input.nextInt();
        System.out.println("Input number of field goals:");
        y2 = input.nextInt();
        System.out.println("Input number of points:");
        y3 = input.nextInt();
        runner.football(y1, y2, y3);

        int number;
        System.out.println("Input a number");
        number = input.nextInt();
        runner.largeDigit(number);
    }
}
