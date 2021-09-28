package intro;

import java.util.Scanner;

public class finalIf {
    public void bin2Dec(int x1, int x2, int x3, int x4, int x5) {
        System.out.println(x1 * 16 + x2 * 8 + x3 * 4 + x4 * 2 + x5);
    }

    public void mod(int x) {
        int x4 = x / 1000, x3 = x / 100 % 10, x2 = x / 10 % 10, x1 = x % 10;
        System.out.println(x4 % x1);
        System.out.println(x4 % x2);
        System.out.println(x4 % x3);
    }

    public void switchStr() {
        Scanner input = new Scanner(System.in);
        scannerConditional runner = new scannerConditional();
        String str1 = input.next();
        String str2 = input.next();
        String str3 = str1;
        str1 = str2;
        str2 = str3;
        System.out.println(str1);
        System.out.println(str2);
    }

    public static void main (String[] args) {
        finalIf runner = new finalIf();
        runner.bin2Dec(1, 0, 1, 1, 1);
        runner.switchStr();
        runner.mod(34924);
    }
}
