package intro;
import java.util.Scanner;

public class arraysStart {
    public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print('\n');
    }

    public static int[] createArray(int n) {
        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            newArr[i] = i + 1;
        }
        return newArr;
    }

    public static void swapArrayElement(int[] arr) {
        arr[0] += arr[arr.length - 1];
        arr[arr.length - 1] = arr[0] - arr[arr.length - 1];
        arr[0] -= arr[arr.length - 1];
        display(arr);
    }

    public static void userArray(int n) {
        Scanner input = new Scanner(System.in);
        int[] array1 = new int[100];
        int k, index = -1;
        k = input.nextInt();
        while (k != n) {
            array1[++index] = k;
            k = input.nextInt();
        }
        for (int i = 0; i <= index; i++) {
            System.out.print(array1[i] + " ");
        }
        System.out.print('\n');
    }

    public static void reverseArray(int[] arr) {
        int[] array2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array2[i] = arr[arr.length - 1 - i];
        }
        display(array2);
    }

    public static void main(String[] args) {
        int[] array1 = new int[5];
        display(array1);
        int[] array2 = createArray(10);
        display(array2);
        swapArrayElement(array2);
        userArray(10);
        reverseArray(array2);
    }
}
