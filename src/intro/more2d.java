package intro;

import java.util.Arrays;

public class more2d {
    public static void display(int[][] x) {
        for (int[] i : x) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static int[][] rectangleArray(int n, int m) {
        int[][] x = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                x[i][j] = i * n + j;
            }
        }
        return x;
    }

    public static double maximumValue(double[][] x) {
        double maxValue = x[0][0];
        for (double[] i : x) {
            for (double y : i) {
                maxValue = Math.max(y, maxValue);
            }
        }
        return maxValue;
    }

    public static double averageValue(int[][] x) {
        int sum = 0, count = 0;
        for (int[] i : x) {
            for (int j : i) {
                count++;
                sum += j;
            }
        }
        return sum * 1.0 / count;
    }

    public static int[] newArray(int[][] x) {
        int[] array = new int[x.length];
        int sum = 0, row = -1;
        for (int[] y : x) {
            for (int i : y) {
                sum += i;
            }
            array[++row] = sum;
            sum = 0;
        }
        return array;
    }

    public static boolean magicArray(int[][] x) {
        for (int i = 1; i < x.length; i++) {
            if (x[i].length != x[0].length) return false;
        }
        int sum = 0, sumCount = 0;
        for (int i : x[0]) {
            sum += i;
        }
        for (int[] i : x) {
            for (int j : i) {
                sumCount += j;
            }
            if (sum != sumCount) return false;
            sumCount = 0;
        }
        for (int i = 0; i < x.length; i++) {
            for (int[] ints : x) {
                sumCount += ints[i];
            }
            if (sumCount != sum) return false;
            sumCount = 0;
        }
        for (int i = 0; i < x.length; i++) {
            sumCount += x[i][i];
        }
        if (sumCount != sum) return false;
        sumCount = 0;
        for (int i = 0; i < x.length; i++) {
            sumCount += x[i][x.length - i - 1];
        }
        return sumCount == sum;
    }

    public static void main(String[] args) {
        display(rectangleArray(5, 6));
        System.out.println(maximumValue(new double[][]{{1.0, 2.0, 3.0}, {2.0, 1.0}}));
        System.out.println(averageValue(new int[][]{{1, 2, 3}, {2, 3}}));
        System.out.println(Arrays.toString(newArray(new int[][]{{1, 2, 3}, {2, 3}})));
        System.out.println(magicArray(new int[][]{{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}));
    }
}
