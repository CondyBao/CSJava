package intro;

import java.util.Scanner;

public class teamLoop {
    public void powers (int n, double x) {
        for (int i = 1; i <= x; i++) {
            System.out.println(Math.pow(n, i));
        }
    }

    public void average () {
        Scanner input2 = new Scanner(System.in);
        int inp = 0, sum = 0, num = -1;
        while (inp != -1) {
            System.out.println("Input an integer: ");
            sum += inp;
            num++;
            inp = input2.nextInt();
        }
        System.out.println((double) sum / num);
    }

    public void reverse (int num) {
        int reversed = 0;
        while(num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        System.out.println(reversed);
    }

    public void decode (int n) {
        int copy = n, copy_num = 0;
        while (copy > 0) {
            copy_num *= 100;
            int a = copy % 100;
            copy_num += a;
            copy /= 100;
        }
        while (copy_num > 0) {
            int a = copy_num % 100;
            copy_num /= 100;
            System.out.print((char) a);
        }
    }

    public void summation (int n) {
        System.out.println(n * (n + 1) / 2);
    }

    public static void main (String[] args) {
        int a, b;
        teamLoop runner = new teamLoop();
        Scanner input = new Scanner(System.in);
        System.out.println("Input base and exponent: ");
        a = input.nextInt();
        b = input.nextInt();
        runner.powers(a, b);
        System.out.println("Input an integer: ");
        a = input.nextInt();
        runner.summation(a);
        runner.average();
        System.out.println("Input an integer: ");
        a = input.nextInt();
        runner.reverse(a);
        System.out.println("Input an integer: ");
        a = input.nextInt();
        runner.decode(a);
    }
}
