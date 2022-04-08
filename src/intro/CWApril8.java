package intro;

import java.util.ArrayList;

public class CWApril8 {
    public static ArrayList<Integer> p1(double[] x) {
        ArrayList<Integer> rS = new ArrayList<>();
        for (int i = 1; i < x.length - 1; i++) {
            if (x[i] > x[i - 1] && x[i] > x[i + 1]) {
                rS.add(i);
            }
        }
        return rS;
    }

    public static void p2(String x, int l, int r) {
        if (l == r) {
            System.out.println(x);
        }
        else {
            for (int i = l; i <= r; i++) {
                char temp, temp2;
                String newString = "";
                temp = x.charAt(l);
                temp2 = x.charAt(i);
                for (int j = 0; j < x.length(); j++) {
                    if (j == l) {
                        newString += temp2;
                        continue;
                    }
                    if (j == i) {
                        newString += temp;
                        continue;
                    }
                    newString += x.charAt(j);
                }
                p2(newString, l + 1, r);
            }
        }
    }

    public static void main(String[] args) {
        double[] p1Array = new double[]{1.0, 2.0, 3.0, 2.0, 1.0, 2.0};
        System.out.println(p1(p1Array));
        String str = "Hello";
        p2(str, 0, str.length() - 1);
    }
}
