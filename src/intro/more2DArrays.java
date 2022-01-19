package intro;

public class more2DArrays {
    public static String buildArray (char[][] a) {
        String word = "";
        for (char[] i : a) {
            for (char j : i) {
                word += j;
            }
        }
        return word;
    }

    public static int[][] nArray (int n) {
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            array[i][i] = n;
            array[n - i - 1][i] = n;
        }
        return array;
    }

    public static void displayArray (int[][] printArray) {
        for (int[] i : printArray) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static int[][] consecutiveArray (int n) {
         int count = 1;
         int[][] returnArray = new int[n][];
         for (int i = 1; i <= n; i++) {
             if (i == 1) returnArray[0] = new int[]{1};
             else {
                 int[] newArray = new int[i];
                 for (int j = 0; j < i; j++) {
                     newArray[j] = ++count;
                 }
                 returnArray[i - 1] = newArray;
             }
         }
         return returnArray;
    }

    public static int[][] sortArray (int[][] n) {
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n[i].length; j++) {
                for (int k = j + 1; k < n[i].length; k++) {
                    if (n[i][j] > n[i][k]) {
                        int sum = n[i][j] + n[i][k];
                        n[i][j] = n[i][k];
                        n[i][k] = sum - n[i][k];
                    }
                }
            }
        }
        return n;
    }
    public static int[][] sortSnakeArray (int[][] n) {
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n[i].length; j++) {
                for (int k = j + 1; k < n[i].length; k++) {
                    if (i % 2 == 0 && n[i][j] > n[i][k]) {
                        int sum = n[i][j] + n[i][k];
                        n[i][j] = n[i][k];
                        n[i][k] = sum - n[i][k];
                    }
                    if (i % 2 == 1 && n[i][j] < n[i][k]) {
                        int sum = n[i][j] + n[i][k];
                        n[i][j] = n[i][k];
                        n[i][k] = sum - n[i][k];
                    }
                }
            }
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(buildArray(new char[][]{{'h', 'e'}, {'l', 'l', 'o'}}));
        displayArray(nArray(5));
        displayArray(consecutiveArray(5));
        displayArray(sortArray(new int[][]{{1, 3, 2}, {5, 6, 3}}));
        displayArray(sortSnakeArray(new int[][]{{1, 3, 2}, {5, 6, 3}}));
    }
}
