package intro;

public class moreString {
    public static void end2(String a, String b) {
        System.out.println(a.endsWith(b.substring(b.length() - 2)));
    }

    public static void palindrome(String a) {
        boolean isPalindrome = true;
        for (int i = 0; i <= a.length() / 2; i++) isPalindrome = isPalindrome && a.charAt(i) == a.charAt(a.length() - i - 1);
        System.out.println(isPalindrome);
    }

    public static void takeOut(String a) {
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != 'e') System.out.print(a.charAt(i));
        }
        System.out.println();
    }

    public static void longBlock(String a) {
        int length = 1;
        for (int i = 0; i < a.length(); i++) {
            int newLength = 1;
            while (newLength + i < a.length() && a.charAt(newLength + i) == a.charAt(i)) newLength++;
            length = Math.max(length, newLength);
        }
        System.out.println(length);
    }

    public static void words(String a) {
        int cnt = 1;
        for (int i = 0; i < a.length(); i++) if (a.charAt(i) == ' ') cnt++;
        System.out.println(cnt);
    }
    
    public static void main(String[] args) {
        end2("happy", "puppy");
        palindrome("helloolleh");
        takeOut("Hello");
        longBlock("Helllooooo");
        words("Hello World!");
    }
}
