package intro;

import java.util.ArrayList;
import java.util.Arrays;

public class Lists_References {
    public static String concatenate(ArrayList<Character> x) {
        String y = "";
        for (char c : x) {
            y += c;
        }
        return y;
    }

    public static void average(ArrayList<Double> x) {
        for (int i = 0; i < x.size(); i++) {
            double sum = 0;
            for (double v : x) {
                sum += v;
            }
            x.set(i, sum / x.size());
        }
    }

    public static void addElements(ArrayList<Integer> a, ArrayList<Integer> b) {
        for (int i = 1; i <= a.size(); i++) {
            for (int j = 0; j < i; j++) {
                b.add(a.get(j));
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Character> a = new ArrayList<Character>();
        a.add('h');
        a.add('e');
        a.add('l');
        a.add('l');
        a.add('o');
        String b = "";
        b = concatenate(a);
        System.out.println(b);
        ArrayList<Double> c = new ArrayList<Double>();
        c.add(3.0);
        c.add(6.0);
        c.add(1.0);
        c.add(8.0);
        c.add(19.0);
        average(c);
        System.out.println(c);
        ArrayList<Integer> d = new ArrayList<Integer>();
        d.add(3);
        d.add(1);
        d.add(4);
        d.add(2);
        ArrayList<Integer> e = new ArrayList<Integer>();
        addElements(d, e);
        System.out.println(e);
    }
}
