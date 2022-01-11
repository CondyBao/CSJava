package intro;

public class finalStrings {
    public static String pigLatin(String x) {
        return x.substring(1) + x.charAt(0) + "ay";
    }

    public static String replaceString(String x, char a) {
        String returnString = "";
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == a) returnString += "$";
            else returnString += x.charAt(i);
        }
        return returnString;
    }

    public static String longestString(String[] x) {
        int bigID = 0;
        for (int i = 1; i < x.length; i++) {
            if (x[i].length() > x[bigID].length()) bigID = i;
        }
        return x[bigID];
    }

    public static void main(String[] args) {
        System.out.println(pigLatin("condy"));
        System.out.println(replaceString("hello", 'l'));
        System.out.println(longestString(new String[]{"hi", "hello", "hii"}));
    }
}
