package intro;

import java.util.ArrayList;

public class ListsI {
    public static ArrayList<String> removeSecond(ArrayList<String> a) {
        for (int i = 0; i < a.size(); i++) {
            a.remove(i);
        }
        return a;
    }

    public static ArrayList<String> reverse(ArrayList<String> b) {
        ArrayList<String> returnValue = new ArrayList<String>();
        for (int i = b.size() - 1; i > -1; i--) {
            returnValue.add(b.get(i));
        }
        return returnValue;
    }

    public static ArrayList<Double> doubleValue(ArrayList<Double> a) {
        for (int i = 0; i < a.size(); i++) {
            a.set(i, a.get(i) * 2);
        }
        return  a;
    }

    public static ArrayList<Character> addLetters(int n) {
        ArrayList<Character> returnValue = new ArrayList<Character>();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                returnValue.add(0, (char)(i + 97));
            }
            else returnValue.add((char)(i + 97));
        }
        return returnValue;
    }

    public static void main(String[] args) {
        ArrayList<String> testCase = new ArrayList<String>();
        ArrayList<String> testCase2 = new ArrayList<String>();
        testCase.add("first");
        testCase.add("second");
        testCase.add("third");
        testCase.add("forth");
        testCase.add("fifth");
        testCase2.add("first");
        testCase2.add("second");
        testCase2.add("third");
        testCase2.add("forth");
        testCase2.add("fifth");
        ArrayList<Double> testCase1 = new ArrayList<Double>();
        testCase1.add(1.0);
        testCase1.add(3.0);
        testCase1.add(4.0);
        testCase1.add(2.0);
        System.out.println(removeSecond(testCase));
        System.out.println(reverse(testCase2));
        System.out.println(doubleValue(testCase1));
        System.out.println(addLetters(5));
    }
}
