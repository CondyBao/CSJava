package intro;

public class introStrings {
    public static void printHalf(String x) {
        System.out.println(x.substring(x.length() / 2));
    }

    public static void concatenateString(String x, String y) {
        System.out.println(x.substring(1) + y.substring(1));
    }

    public static void adverb(String x) {
        if (x.endsWith("ly")) {
            System.out.println("yes");
        }
        else System.out.println("no");
    }

    public static void contain(String x, String y) {
        if (x.contains(y)) {
            System.out.println("yes");
        }
        else System.out.println("no");
    }

    public static void printBack(String x) {
        for (int i = 0; i < x.length(); i++) {
            System.out.print(x.charAt(x.length() - i - 1));
        }
        System.out.println();
     }

     public static void square(String x) {
        for (int startIndex = 0; startIndex < x.length(); startIndex++) {
            for (int i = 0; i < x.length(); i++) {
                System.out.print(x.charAt((i + startIndex) % x.length()));
            }
            System.out.println();
        }
     }

    public static void main(String[] args) {
        printHalf("hi there");
        concatenateString("hello", "there");
        adverb("happy");
        contain("hippo", "hii");
        printBack("hello");
        square("hello");
    }
}
