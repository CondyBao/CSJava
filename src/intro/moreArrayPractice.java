package intro;

import java.util.Arrays;

public class moreArrayPractice {
    public static void commonNums(int[] array1, int[] array2) {
        int maxValue = array1[0];
        for (int j : array1) {
            maxValue = Math.max(Math.abs(j), maxValue);
        }
        for (int j : array2) {
            maxValue = Math.max(Math.abs(j), maxValue);
        }
        maxValue++;
        boolean[] valuePosCheck = new boolean[maxValue];
        boolean[] valueNegCheck = new boolean[maxValue];
        boolean[] printPosCheck = new boolean[maxValue];
        boolean[] printNegCheck = new boolean[maxValue];
        for (int j : array1) {
            if (j >= 0) valuePosCheck[j] = true;
            else valueNegCheck[-j] = true;
        }
        for (int j : array2) {
            if (j >= 0) {
                if (valuePosCheck[j] && !printPosCheck[j]) {
                    System.out.print(j + " ");
                    printPosCheck[j] = true;
                }
            }
            else {
                if (valueNegCheck[-j] && !printNegCheck[-j]) {
                    System.out.print(j + " ");
                    printNegCheck[-j] = true;
                }
            }
        }
        System.out.println();
    }

    public static void printUnique(int[] array1) {
        int maxValue = array1[0];
        for (int j : array1) {
            maxValue = Math.max(maxValue, Math.abs(j));
        }
        maxValue++;
        boolean[] negNum = new boolean[maxValue];
        boolean[] posNum = new boolean[maxValue];
        for (int j : array1) {
            if (j >= 0) {
                if (!posNum[j]) {
                    System.out.print(j + " ");
                    posNum[j] = true;
                }
            }
            else {
                if (!negNum[-j]) {
                    System.out.print(j + " ");
                    negNum[-j] = true;
                }
            }
        }
        System.out.println();
    }

    public static int[] digitsArray(int num) {
        int digits = (int)(Math.log10(num) + 1);
        int[] digitsArray = new int[digits];
        int currentPos = digits;
        while(num > 0) {
            digitsArray[--currentPos] = num % 10;
            num /= 10;
        }
        return digitsArray;
    }

    public static int[] returnSame(int[] array1) {
        int maxValue = array1[0], index = -1;
        for (int j : array1) {
            maxValue = Math.max(Math.abs(j), maxValue);
        }
        maxValue++;
        boolean[] posValue = new boolean[maxValue];
        boolean[] negValue = new boolean[maxValue];
        boolean[] addedPosValue = new boolean[maxValue];
        boolean[] addedNegValue = new boolean[maxValue];
        int[] newArray = new int[maxValue];
        for (int j : array1) {
            if (j >= 0) {
                if (posValue[j] && !addedPosValue[j]) {
                    newArray[++index] = j;
                    addedPosValue[j] = true;
                }
                else posValue[j] = true;
            }
            else {
                if (negValue[-j] && !addedNegValue[-j]) {
                    newArray[++index] = j;
                    addedNegValue[-j] = true;
                }
                else negValue[-j] = true;
            }
        }
        int[] returnArray = new int[index + 1];
        System.arraycopy(newArray, 0, returnArray, 0, index + 1);
        return returnArray;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, -3, 4, 5, 3, 2}, array2 = {1, 6, -3, 3, -5, 4, 6, 2};
        commonNums(array1, array2);
        printUnique(array1);
        System.out.println(Arrays.toString(digitsArray(39564)));
        System.out.println(Arrays.toString(returnSame(array1)));
    }
}
