package intro;

public class CodeWar {
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
        String newSong = new String("");
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
        newSong = newSong.substring(index, newSong.length());
        return newSong;
    }

    public static void main(String[] args) {
        CodeWar tester = new CodeWar();
        System.out.println(tester.SongDecoder("WUBWUBABCWUB"));
    }
}
