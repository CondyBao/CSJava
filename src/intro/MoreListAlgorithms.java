package intro;

import java.util.ArrayList;
import java.util.Random;

public class MoreListAlgorithms {
    public static ArrayList<Integer> randomArray(int n, int x) {
        ArrayList<Integer> returnV = new ArrayList<Integer>();
        boolean[] visited = new boolean[2 * x];
        for (int i = 0 ; i < 2 * x; i++) visited[i] = false;
        while (returnV.size() <= n) {
            Random rand = new Random();
            int newNum = rand.nextInt(2 * x);
            while (visited[newNum]) {
                newNum = rand.nextInt(2 * x);
            }
            visited[newNum] = true;
            returnV.add(newNum - x);
        }
        return returnV;
    }

    public static void separator(ArrayList<Integer> a) {
        ArrayList<Integer> positive = new ArrayList<Integer>();
        ArrayList<Integer> negative = new ArrayList<Integer>();
        for (int i : a) {
            if (i > 0) positive.add(i);
            if (i < 0) negative.add(i);
        }
        System.out.println(positive);
        System.out.println(negative);
    }

    public static void reverse(ArrayList<Double> a) {
        for (int i = 0; i < a.size() / 2; i++) {
            double copy = a.get(i);
            a.set(i, a.get(a.size() - i - 1));
            a.set(a.size() - i - 1, copy);
        }
    }

    public static void main(String[] args) {
        System.out.println(randomArray(5, 10));
        ArrayList<Integer> test = new ArrayList<Integer>();
        test.add(-9);
        test.add(1);
        test.add(3);
        test.add(0);
        test.add(5);
        test.add(-4);
        separator(test);
        ArrayList<Double> test1 = new ArrayList<Double>();
        test1.add(9.0);
        test1.add(1.0);
        test1.add(-3.0);
        test1.add(4.1);
        test1.add(5.2);
        test1.add(-4.0);
        reverse(test1);
        System.out.println(test1);
    }
}
