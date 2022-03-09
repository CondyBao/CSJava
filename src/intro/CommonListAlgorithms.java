package intro;

import java.util.ArrayList;

public class CommonListAlgorithms {
    public static double average(ArrayList<Integer> a) {
        int sum = 0;
        for (int i : a) sum += i;
        return 1.0 * sum / a.size();
    }

    public static int minimum(ArrayList<Integer> a) {
        int min = a.get(0);
        for (int i : a) min = Math.min(min, i);
        return min;
    }

    public static ArrayList<Integer> fibonacci(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result.add(0);
                continue;
            }
            if (i == 1) {
                result.add(1);
                continue;
            }
            result.add(result.get(i - 2) + result.get(i - 1));
        }
        return result;
    }

    public static ArrayList<Integer> factors(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0)result.add(i);
        }
        return result;
    }

    public static int binary_search(ArrayList<Integer> a, int n) {
        int l = 0, r = a.size() - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (n > a.get(mid)) {
                l = mid + 1;
            }
            else {
                ans = mid;
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<Integer>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(6);
        System.out.println(average(test));
        System.out.println(minimum(test));
        System.out.println(fibonacci(5));
        System.out.println(factors(24));
        System.out.println(binary_search(test, 5));
    }
}
