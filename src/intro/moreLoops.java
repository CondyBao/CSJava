package intro;

import java.util.Scanner;

public class moreLoops {
    private final int maxINT = 10000;
    public void hiPrint(int a) {
        for (int i = 0; i < a; i++) { //definite finite, linear, for loop
            System.out.println("hi");
        }
    }

    public void factorial1(int a) {
        int sum = 1;
        for (int i = 1; i <= a; i++) { //definite finite, linear, for loop
            sum *= i;
        }
        System.out.println(sum);
    }

    public int factorial2(int a) {
        if (a == 1) return a;
        return a * factorial2(a - 1);
    }

    public void gcd(int a, int b) {
        int maxInt = Math.min(a, b), ans = 1;
        for (int i = 1; i <= maxInt; i++) { //definite finite loop, linear, for loop
            if (a % i == 0 && b % i == 0) {
                 ans = i;
            }
        }
        System.out.println(ans);
    }

    public void lcm(int a, int b) {
        int copy = a;
        while (copy % b != 0) { //indefinite, linear, while loop
            copy += a;
        }
        System.out.println(copy);
    }

    public void primeCheck(int x) {
        boolean flag = true;
        for (int i = 2; i < x; i++) { //definite finite, linear, for loop
            if (x % i == 0) {
                flag = false;
            }
        }
        if (flag && x > 1) {
            System.out.println("Prime");
        }
        else {
            System.out.println("Not a Prime");
        }
    }

    public void magicSquare (int x) {
        int num = 0, sum = 0;
        moreLoops runner2 = new moreLoops();
        while (sum < x) { //definite finite, while loop, linear
            if (runner2.magicSquarecheck(num)) {
                sum++;
                System.out.println(num);
            }
            num++;
        }
    }

    public boolean magicSquarecheck (int x) {
        boolean square = false, magic = false;
        for (int i = 1; i * i <= x; i++) { //definite finite, linear, for loop
            if (i * i == x) {
                square = true;
                break;
            }
        }

        if (!square) return false;

        for (int i = 1; i <= (x + 1) / 2; i++) { //definite finite, linear, for loop
            int num = i * (i + 1) / 2;
            if (num == x) {
                magic = true;
                break;
            }
        }
        return magic;
    }

    public void primeCount (int x) {
        boolean[] grid;
        grid = new boolean[maxINT];
        int cnt = 2, i = 0;
        while (i <= x) {
            if (!grid[cnt]) {
                i++;
                if (i == x) System.out.println(cnt);
                for (int j = cnt * 2; j < maxINT; j += cnt) { //definite finite, for loop, linear
                    grid[j] = true;
                }
            }
            cnt++;
        }
    }

    public static void main(String[] args) {
        int x, y;

        moreLoops runner = new moreLoops();
        Scanner input = new Scanner(System.in);
//        System.out.println("Input a number: ");
//        x = input.nextInt();
//        runner.hiPrint(x);
//
//        System.out.println("Input a number: ");
//        x = input.nextInt();
//        runner.factorial1(x);
//        System.out.println(runner.factorial2(x));
//
//        System.out.println("Input two numbers: ");
//        x = input.nextInt();
//        y = input.nextInt();
//        runner.gcd(x, y);
//
//        System.out.println("Input two numbers: ");
//        x = input.nextInt();
//        y = input.nextInt();
//        runner.lcm(x, y);
//
//        System.out.println("Input a number: ");
//        x = input.nextInt();
//        runner.primeCheck(x);
//
//        System.out.println("Input a number: ");
//        x = input.nextInt();
//        runner.magicSquare(x);

        System.out.println("Input a number: ");
        x = input.nextInt();
        runner.primeCount(x);
    }
}
