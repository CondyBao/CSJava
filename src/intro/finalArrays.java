package intro;

public class finalArrays {
    public static void weightedSum(double[] array1) {
        double sum = 0;
        for (int i = 0; i < array1.length; i++) {
            sum += array1[i] * i;
        }
        System.out.println(sum);
    }

    public static void printLower(char[] array1) {
        for (char i : array1) {
            if (i >= 'a' && i <= 'z') {
                System.out.print(i);
            }
        }
        System.out.println();
    }

    public static void sumTo(int[] array1, int n) {
        for (int i = 1; i < array1.length; i++) {
            if (array1[i] + array1[i - 1] == n) {
                System.out.println("yes");
                return;
            }
        }
        System.out.println("no");
    }

    public static void appearance(char[] array1) {
        int[] ap = new int[128];
        int maxID = 0;
        for (char i : array1) {
            ap[(int)i]++;
        }
        for (int i = 0; i < ap.length; i++) {
            if (ap[maxID] < ap[i]) {
                maxID = i;
            }
        }
        System.out.print((char)maxID);
    }

    public static void main(String[] args) {
        weightedSum(new double[]{5.8, 3.1, 2.5});
        printLower(new char[]{'h', 'i', '!', 'H', 'e', 'l', 'L', 'o', '?'});
        sumTo(new int[]{1, 5, 2, 7, 3}, 9);
        appearance(new char[]{'h', 'k', 'h', 'u', 'b', 'e', 'k', 'u', 'u'});
    }
}
