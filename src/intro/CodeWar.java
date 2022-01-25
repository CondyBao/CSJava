package intro;

import java.util.Arrays;

public class CodeWar {
    public static long nextSmaller(long n)
    {
        long copy = n;
        int digits = 0, index = -1;
        while (copy > 0) {
            copy /= 10;
            digits++;
        }
        copy = n;
        long[] numbers = new long[digits];
        while (copy > 0) {
            numbers[++index]  = copy % 10;
            copy /= 10;
        }
        System.out.println(Arrays.toString(numbers));
        boolean swapped = false;
        for (int i = 1; i < digits; i++) {
            long max_min = -1;
            int max_index = 0;
            for (int j = 0; j < i; j++) {
                if (numbers[j] == 0 && i == digits - 1) continue;
                if (numbers[j] < numbers[i] && numbers[j] > max_min) {
                    max_min = numbers[j];
                    max_index = j;
                    swapped = true;
                }
            }
            if (i == max_index) continue;
            numbers[i] += numbers[max_index];
            numbers[max_index] = numbers[i] - numbers[max_index];
            numbers[i] -= numbers[max_index];
            if (swapped) break;
        }
        System.out.println(Arrays.toString(numbers));
        n = 0;
        for (int i = digits - 1; i >= 0; i--) {
            n += numbers[i];
            n *= 10;
        }
        n /= 10;
        if (!swapped) return -1;
        return n;
    }
    public static String[] solution(String s) {
        //Write your code here
        int length = s.length();
        int x1 = length / 2;
        if (length % 2 == 1) x1++;
        String[] solution = new String[x1];
        for (int i = 0; i < x1; i++) {
            solution[i] = "";
        }
        for (int i = 0; i < length / 2; i++) {
            int a1 = i * 2, a2 = i * 2 + 1;
            solution[i] += s.charAt(a1);
            solution[i] += s.charAt(a2);
        }
        if (length % 2 == 1) {
            solution[length / 2] += s.charAt(length - 1);
            solution[length / 2] += "_";
        }
        return solution;
    }

    public static int getCount (String str) {
        int vowelsCount = 0;
        // your code here
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowelsCount++;
            }
        }
        return vowelsCount;
    }

    public static String SongDecoder (String song) {
        // Your code is here...
        String newSong = "";
        int index = 0;
        boolean flag = true;
        for (int i = 0; i < song.length() - 2; i++) {
            char c = song.charAt(i), c1 = song.charAt(i + 1), c2 = song.charAt(i + 2);
            if (c == 'W' && c1 == 'U' && c2 =='B') {
                flag = false;
                if (newSong.length() >= 2) {
                    if (newSong.charAt(newSong.length() - 1) == ' ') {
                        newSong = newSong.substring(0, newSong.length() - 1);
                    }
                }
            }
            if (flag) {
                newSong += c;
            }
            if (!flag && c == 'B') {
                flag = true;
                newSong += ' ';
            }
        }
        for (int i = 0; i < newSong.length(); i++) {
            if (newSong.charAt(i) != ' ') {
                index = i;
                break;
            }
        }
        newSong = newSong.substring(index);
        return newSong;
    }

    public static boolean stringEnds(String str, String ending) {
        String end = str.substring(str.length() - ending.length());
        return end == ending;
    }

    public static void main(String[] args) {
        CodeWar tester = new CodeWar();
        System.out.println(nextSmaller(21));
    }
}
