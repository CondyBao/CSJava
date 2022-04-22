package intro;

import java.io.*;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Translator {
    private static final HashMap<String, String> Eng2Ara = new HashMap<>();

    public static void main(String[] args) throws IOException {
        new Translator();
        String input = "";
        while (!Objects.equals(input, "x")) {
            System.out.println("Please input a word(input x to terminate): ");
            Scanner sc = new Scanner(System.in);
            input = sc.nextLine();
            System.out.println(Eng2Ara.get(input));
        }
    }

    public Translator() throws IOException {
        // generates the word list from the dictionary file
        String fileName = "EnglishToArabicDictionary.txt";
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        int index = 0;
        String eng = "";
        for (String line = in.readLine(); line != null; line = in.readLine()) {
            if (index % 2 == 0) {
                if (index == 0) eng = line.trim().substring(1, line.length());
                else eng = line.trim();
            }
            else Eng2Ara.put(eng, line.trim());
            index++;
        }
        in.close();
    }
}
