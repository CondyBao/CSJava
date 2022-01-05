package intro;

import java.util.Arrays;

public class warmingBackUp {
    public static boolean alphabetical(String x) {
        boolean status = true;
        for (int i = 1; i < x.length(); i++) {
            if (x.charAt(i) < x.charAt(i - 1)) status = false;
        }
        return status;
    }

    public static String name(String[] x, int[] y) {
        int value = 0;
        for (int i = 1; i < y.length; i++) {
            if (y[i] > y[value])value = i;
        }
        return x[value];
    }

    public static int[] perfectSquares(int x) {
        int[] array = new int[x];
        int cur_num = 0;
        for (int i = 0; i < x; i++) {
            while (Math.sqrt(cur_num) * 10 % 10 != 0) cur_num++;
            array[i] = cur_num;
            cur_num++;
        }
        return array;
    }

    public static String three(String x) {
        String newx = "";
        for (int i = 0; i < x.length(); i++) {
            if (i % 6 < 3) newx += x.charAt(i);
        }
        return newx;
    }

    public static String factorization(int x) {
        boolean check = false;
        String factor = "";
        int newx = x;
        for (int i = 2; i * i <= x; i++) {
            while (newx % i == 0) {
                newx /= i;
                factor += i + " ";
                check = true;
            }
        }
        if (!check) return "This number is a prime";
        return factor;
    }

    public static void main(String[] args) {
        System.out.println(alphabetical("behlo"));
        String[] x = {"Condy", "Ondy", "Ndy"};
        int[] y = {3, 4, 1};
        System.out.println(name(x, y));
        System.out.println(Arrays.toString(perfectSquares(10)));
        System.out.println(three("abcdefghijklm"));
        System.out.println(factorization(30));
    }
}
