package intro.remixSongs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RemixerFiller {

	private String[] lyrics;
	private String fileName = "lyrics.txt";	// this should match your txt file
	
	private String[] wordsToReplace = new String[]{"doo", "shark", "baby"};	// for part 2, if you finish the main project
	private String[] newWords = new String[]{"boo", "fox", "puppy"};
	
	public void remix() {
		for (String i : lyrics) System.out.println(i + " ");
		for (int i = 0; i < lyrics.length; i++) {
			for (int j = 0; j < wordsToReplace.length; j++) {
				if (lyrics[i].equalsIgnoreCase(wordsToReplace[j])) {
					lyrics[i] = newWords[j];
				}
			}
		}
	}
	
	// DON'T TOUCH THE BELOW CODE //
	
	public RemixerFiller() {
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			ArrayList<String> tempLyrics = new ArrayList<String>();
			for (String line = in.readLine(); line != null; line = in.readLine()) {
				
				String[] words = line.split(" ");
				for (String w : words) {
					tempLyrics.add(w.toLowerCase().replaceAll("^[^a-zA-Z0-9\\s]+|[^a-zA-Z0-9\\s]+$", ""));
				}
				tempLyrics.add("\n");
			}
			in.close();
			lyrics = new String[tempLyrics.size()];
			for (int i = 0; i < tempLyrics.size(); i++) {
				lyrics[i] = tempLyrics.get(i);
			}
			

			remix();
			
			if (fileName.substring(fileName.length()-4).equals(".txt")) {
				fileName = fileName.substring(0, fileName.length()-4);
			}
			
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName + "_remixed.txt"));
			
			for (String s : lyrics) {
				out.write(s + (s.equals("\n") ? "" : " "));
			}
			out.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			System.exit(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new RemixerFiller();
	}
}
