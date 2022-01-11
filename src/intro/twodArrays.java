package intro;

import java.util.Arrays;

public class twodArrays {
    public static void nArray(int n) {
        int[][] returnArray = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                returnArray[i][j] = i * n + j;
            }
        }
        for (int[] x : returnArray) {
            System.out.println(Arrays.toString(x));
        }
    }

    public static void numberColumns(int[][] x) {
        int maxColumn = 0;
        for (int[] a : x) {
            maxColumn = Math.max(maxColumn, a.length);
        }
        System.out.println(maxColumn);
        System.out.println(x.length);
    }

    public static void arrayInit(int[] values) {
        int[][] returnArray = new int[3][];
        int index = 0;
        for (int i = 1; i <= 3; i++) {
            int[] newArray = new int[i];
            for (int j = 0; j < i; j++, index++) {
                newArray[j] = values[index];
            }
            returnArray[i - 1] = newArray;
        }
        for (int[] i : returnArray) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static void main(String[] args) {
        nArray(5);
        numberColumns(new int[][]{{1, 2, 3}, {2, 3, 1}, {3, 2, 1}, {0, 1, 2}});
        arrayInit(new int[]{1, 2, 3, 4, 5, 6});
    }
}
