package intro;

import java.util.Arrays;

public class arrayAlgorithms {
    public static int largeInt(int[] array1) {
        int index = 0;
        for (int i = 1; i < array1.length; i++) {
            if (array1[index] < array1[i]) {
                index = i;
            }
        }
        return index;
    }

    public static int[] mergeArray(int[] array1, int[] array2) {
        int[] mergedArray = new int[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++) {
            mergedArray[i] = array1[i];
        }
        for (int i = 0; i < array2.length; i++) {
            mergedArray[array1.length + i] = array2[i];
        }
        return mergedArray;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 6, 8};
        System.out.println(largeInt(array2));
        System.out.println(Arrays.toString(mergeArray(array1, array2)));
    }
}
