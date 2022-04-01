package intro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DictionarySorter {
	
	public String mode = "merge";
	public String fileName = "wordsShuffled.txt";
	
	public void selectionSort(List<String> words) {
		for (int i = 0; i < words.size(); i++) {
			for (int j = i + 1; j < words.size(); j++) {
				if (words.get(j).compareTo(words.get(i)) < 0) {
					String copy = words.get(i);
					words.set(i, words.get(j));
					words.set(j, copy);
				}
			}
		}
	}
	
	public void insertionSort(List<String> words) {
		for (int i = 0; i < words.size(); i++) {
			int j = i - 1;
			String key = words.get(i);
			while (j >= 0 && key.compareTo(words.get(j)) < 0) {
				words.set(j + 1, words.get(j));
				j--;
			}
			words.set(j + 1, key);
		}
	}

	public void mergeSort(List<String> words) {	// starter for your recursion
		mergeSort(words, 0, words.size()-1);
	}
	
	public void mergeSort(List<String> words, int start, int end) {
		if (start >= end) {
			return;
		}
		int mid = (start + end) / 2;
		mergeSort(words, start, mid);
		mergeSort(words, mid + 1, end);
		merge(words, start, mid, end);
	}
	
	public void merge(List<String> words, int start, int mid, int end) {
		ArrayList<String> sorted = new ArrayList<String>();
		int i = start, j = mid + 1;
		while (i <= mid && j <= end) {
			if (words.get(i).compareTo(words.get(j)) < 0) {
				sorted.add(words.get(i));
				i++;
			}
			else {
				sorted.add(words.get(j));
				j++;
			}
		}
		while (i <= mid) {
			sorted.add(words.get(i));
			i++;
		}
		while (j <= end) {
			sorted.add(words.get(j));
			j++;
		}
		for (i = start; i <= end; i++) {
			words.set(i, sorted.get(i - start));
		}
	}
	
	public static void main(String[] args) throws IOException {
		new DictionarySorter();
	}
	public DictionarySorter() throws IOException{
		// generates the word list from the dictionary file
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		List<String> words = new ArrayList<String>();
		for (String line = in.readLine(); line != null; line = in.readLine()) {
			words.add(line.trim());
		}
		in.close();
		long startTime = System.currentTimeMillis();
		if (mode.equals("selection"))
			selectionSort(words);
		else if (mode.equals("insertion"))
			insertionSort(words);
		else
			mergeSort(words);
		System.out.println("runtime: " + (System.currentTimeMillis() - startTime));
		
		BufferedWriter out = new BufferedWriter(new FileWriter("wordsSorted.txt"));
		for (String s : words)
			out.write(s + "\n");
		out.close();
	}
}
