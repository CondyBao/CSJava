package intro;

import java.util.Scanner;

public class Loops {
    public void printNum (int a, int b) { // indefinite loop
        int a1 = Math.min(a, b), a2 = Math.max(a, b);
        while (a1 <= a2) {
            System.out.println(a1);
            a1++;
        }
    }

    public void exp (double base, double coefficient) { //definite finite loop
        int i = 0;
        while (i <= 5) {
            System.out.println(coefficient * Math.pow(base, i));
            i++;
        }
    }

    public void sqt (int sqr) { //indefinite loop
        int i = 1;
        while (i * i <= sqr) {
            if (i * i == sqr) {
                System.out.println(i);
                return;
            }
            i++;
        }
        System.out.println("does not have a root");
    }

    public void inp () { // indefinite loop
        Scanner input = new Scanner(System.in);
        System.out.println("Insert number n: ");
        int n = input.nextInt(), i = 1, maxn = 0;
        while (i <= n) {
            System.out.println("Insert a number: ");
            int inpu = input.nextInt();
            if (i == 1) {
                maxn = i;
            }
            maxn = Math.max(maxn, inpu);
            i++;
        }
        System.out.println("The biggest number is: " + maxn);
    }

    public void taylorSin (double x) { //definite finite
        double i = 0, sum = 0;
        while (i <= 100) {
            double j = 1, bound = 2 * i + 1, numerator = Math.pow(x, bound) * Math.pow(-1, i), factorial = 1;
            while(j <= bound) {
                factorial *= j;
                j++;
            }
            sum += numerator / factorial;
            i++;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Loops runner = new Loops();
        runner.printNum(7, 3);
        runner.exp(2, 3);
        runner.sqt(36);
        runner.inp();
        runner.taylorSin(Math.PI / 6);
    }
}
