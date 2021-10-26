package intro;

import java.util.Scanner;

public class moreNestedloops {
    public void box(int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 1; j <= x; j++) {
                System.out.print((i + j) - x * ((i + j) / (x + 1)) + " ");
            }
            System.out.print('\n');
        }
    }

    public void trig(int x) {
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print('X');
            }
            System.out.print('\n');
        }
    }

    public void power(int x, int y) {
        int ans = 0;
        while (y != 1) {
            y /= x;
            ans++;
        }
        System.out.println(ans);
    }

    public void asterisks(int x) {
        for (int i = 1; i < x; i++) {
            int start = x - i, end = start + i - 1;
            for (int j = 0; j < x; j++) {
                if (j >= start && j <= end) {
                    System.out.print('*');
                }
                System.out.print(' ');
            }
            System.out.print('\n');
        }
        for (int i = 1; i <= x; i++) {
            System.out.print("*" + " ");
        }
        System.out.print('\n');
        for (int i = x - 1; i > 0; i--) {
            int start = x - i, end = start + i - 1;
            for (int j = 0; j < x; j++) {
                if (j >= start && j <= end) {
                    System.out.print('*');
                }
                System.out.print(' ');
            }
            System.out.print('\n');
        }
    }

    public static void main(String[] args) {
        moreNestedloops runner = new moreNestedloops();
        runner.box(7);
        runner.trig(4);
        Scanner input = new Scanner(System.in);
        System.out.println("Input 2 numbers: ");
        int x = input.nextInt(), y = input.nextInt();
        runner.power(x, y);
        runner.asterisks(6);
    }
}
