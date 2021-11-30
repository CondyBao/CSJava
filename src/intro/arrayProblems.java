package intro;

import java.util.Arrays;

public class arrayProblems {
    public static void printWords(String[] array1) {
        for (String i : array1) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void trimArray(int[] array1) {
        int[] array2 = new int[array1.length - 2];
        int smallIndex = 0, bigIndex = 0, index = -1;
        for (int i = 0; i < array1.length; i++) {
            if (array1[smallIndex] > array1[i]) {
                smallIndex = i;
            }
            if (array1[bigIndex] < array1[i]) {
                bigIndex = i;
            }
        }
        for (int i = 0; i < array1.length; i++) {
            if (i == smallIndex || i == bigIndex)continue;
            array2[++index] = array1[i];
        }
        System.out.println(Arrays.toString(array2));
    }

    public static void divisible(int[] array1) {
        String t = "yes", n = "no";
        String[] string1 = new String[array1.length - 1];
        for (int i = 1; i < array1.length; i++) {
            if (array1[i] % array1[i - 1] == 0) {
                string1[i - 1] = t;
            }
            else string1[i - 1] = n;
        }
        System.out.println(Arrays.toString(string1));
    }

    public static void risingAverage(int[] array1) {
        int average = 0;
        double[] averageArray = new double[array1.length];
        for (int i = 0; i < array1.length; i++) {
            average += array1[i];
            averageArray[i] = 1.0 * average / (i + 1);
        }
        System.out.println(Arrays.toString(averageArray));
    }

    public static void fibonacci(int n) {
        int a1 = 1, a2 = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(a1 + " ");
            int sum = a1 + a2;
            a1 = a2;
            a2 = sum;
        }
        System.out.println();
    }

    public static void shiftArray(String[] a, int n) {
        String[] b = new String[a.length];
        int n1 = n % a.length, index = 0;
        for (int i = 0; i < a.length; i++) {
            if (i + n1 == a.length) {
                index = i;
                break;
            }
            b[i] = a[i+ n1];
        }
        for (int i = 0; i < a.length - index; i++) {
            b[i + index] = a[i];
        }
        System.out.println(Arrays.toString(b));
    }

    public static void productArray(int[] a1, int[] a2) {
        int sum = 0;
        for (int i = 0; i < a1.length; i++) {
            sum += a1[i] * a2[i];
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        risingAverage(new int[]{4, 6, 2, 12});
        fibonacci(5);
        shiftArray(new String[]{"I", "love", "C", "S"}, 3);
        productArray(new int[]{5, 3, 1}, new int[]{8, 4, 7});
        trimArray(new int[]{5, 3, 4, 6, 1});
        divisible(new int[]{8, 3, 12, 5, 15, 45});
        printWords(new String[]{"hello", "hi", "ok"});
    }
}
