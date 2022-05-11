package intro.Huffman;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Objects;

public class HuffmanCoding {
    private final int COMPRESS_DIGIT = 7; // the length of each binary compressed string
    HashMap<Character, Integer> freq = new HashMap<>(); // record the frequency of each character
    HashMap<Character, String> huffmanTable = new HashMap<>(); // record the huffman values of each character

    public HuffmanCoding() throws IOException {
        String text = FileRead("test.txt"); // Read File
        if (Objects.equals(text, "")) return; // if the text file is empty then stop
        if (freq.size() == 1) huffmanTable.put(text.charAt(0), "1"); // if there is only one type of character in the text file
        else buildTree(); // Build Huffman Tree
        String hash = compress(text); // Compress the file
        StringBuilder huffman = new StringBuilder(); // create the output huffman table string
        for (char c : huffmanTable.keySet()) {
            huffman.append(c).append(": ").append(huffmanTable.get(c)).append("\n"); // append the huffman table to the string
        }
        FileWrite("compressed.txt", "Hash:\n" + hash + "\nHuffman Table:\n" + huffman); // Output Compressed File
        String compressed_file = FileRead("compressed.txt");
        hash = readTree(compressed_file); // build new tree based off of compressed file
        String result = decompress(hash); // Decompress hash
        FileWrite("result.txt", result); // Output File
    }

    public String readTree(String file) {
        StringBuilder hash_string = new StringBuilder(); /// create new hash string
        file = file.substring("Hash:\n".length()); // remove redundant letters
        int index = -1; // index for iteration
        while (true) { // loop to get the hash string
            index++; // move on to the next index
            hash_string.append(file.charAt(index)); // append the current character
            if (hash_string.length() >= "\nHuffman Table:\n".length()) { // if there are enough characters
                if (hash_string.substring(hash_string.length() - "\nHuffman Table:\n".length()).equals("\nHuffman Table:\n")) { // see if it is the end of the file
                    hash_string = new StringBuilder(hash_string.substring(0, hash_string.length() - "\nHuffman Table:\n".length())); // cut the string
                    break; // break
                }
            }
        }
        huffmanTable = new HashMap<>(); // empty the hashmap
        while (index < file.length() - 1) {
            index++; // ignore the return key every line
            char key = file.charAt(index); // create the key for map
            StringBuilder value = new StringBuilder(); // create an empty value string
            index += ": ".length() + 1; // ignore the unnecessary information
            while (file.charAt(index) != '\n') { // while it is still in the same line
                value.append(file.charAt(index)); // add the current value to the value string
                index++; // go to the next index
            }
            huffmanTable.put(key, value.toString()); // put the new information to the huffman table
        }
        return hash_string.toString(); // remove the hash string
    }

    public String FileRead(String fileName) throws IOException {
        StringBuilder text = new StringBuilder(); // text content
        FileReader reader; // declare reader
        try {
            reader = new FileReader("src/intro/Huffman/" + fileName); // try reading
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int ascii = reader.read(); // read the first character
        while(ascii != -1) { // when the read is not complete
            char cur = (char)ascii;
            text.append(cur); // append the current character to the string
            if (freq.containsKey(cur)) { // if the character already exists
                freq.put(cur, freq.get(cur) + 1); // plus one to frequency
            }
            else freq.put(cur, 1); // start a new entry inf frequency
            ascii = reader.read(); // read the next character
        }
        return text.toString(); // return the text file
    }

    public void FileWrite(String fileName, String output) throws IOException { // write the file
        Files.write(Paths.get("src/intro/Huffman/" + fileName), output.getBytes());
    }

    public void buildTree() {
        PQ<Branch<Character>> minHeap = new PQ<>(); // create the priority queue
        for (char c : freq.keySet()) { // for every character in the map
            minHeap.push(new Branch<>(c, freq.get(c)), freq.get(c)); // push the character into the priority queue based on frequency
        }
        Branch<Character> left, right, top; // the three nodes
        while (minHeap.getSize() != 1) {
            left = minHeap.top().element; // extract a new element for left child
            minHeap.pop(); // pop the element
            right = minHeap.top().element; // extract a new element for right child
            minHeap.pop(); // pop the element
            top = new Branch<>(left.freq + right.freq, left, right); // create a new top node that represent the sum of left and right
            minHeap.push(top, top.freq); // push the new node to the priority queue
        }
        storeCode(minHeap.top().element, ""); // store the tree in the map
    }

    public String compress(String text) {
        StringBuilder compressed = new StringBuilder(); // create a new string
        for (int i = 0; i < text.length(); i++) {
            compressed.append(huffmanTable.get(text.charAt(i))); // get the text file after converting characters to their huffman values
        }
        int index = 0, add_zero = 0; // index is the currently pointed character, add_zero represents the prefix zeros of the last seven digit binary number
        StringBuilder cur_bi = new StringBuilder(), hash = new StringBuilder(); // create the current string and the final hash string
        while (index < compressed.length()) {
            cur_bi.append(compressed.charAt(index)); // add the current digit to the current string
            if (index % COMPRESS_DIGIT == (COMPRESS_DIGIT - 1) || index == compressed.length() - 1) { // if there are COMPRESS_DIGIT characters in cur_bi already or there is no more letter
                if (index == compressed.length() - 1) { // if it is the last digit then calculate the prefix zeros
                    int id = 0; // record index
                    while (id < cur_bi.length() && cur_bi.charAt(id) == '0') { // while the current character is zero
                        add_zero++; // add add_zero
                        id++; // go to the next character
                    }
                }
                hash.append((char) (Integer.parseInt(cur_bi.toString(), 2))); // convert the current binary string to decimal and cast it into character by ASCII, append it to the has string
                cur_bi = new StringBuilder(); // renew the current string
            }
            index++; // move on to the next character
        }
        hash.append((char) add_zero); // insert the last character's prefix zeros to the hash string
        return hash.toString(); // return the hash string
    }

    public String decompress(String hash) {
        int add_zero = hash.charAt(hash.length() - 1); // get the prefix zeros of last character
        hash = hash.substring(0, hash.length() - 1); // remove the last digit of hash string
        StringBuilder decompressed = new StringBuilder(); // create the decompressed string
        for (int i = 0; i < hash.length(); i++) { // iterate through the hash string
            StringBuilder cur_bi = new StringBuilder(Integer.toBinaryString(hash.charAt(i))); // get the current binary number from the current hash char
            int add_length = COMPRESS_DIGIT - cur_bi.length(); // get the number of zeros each character needs to fill in the front
            if (i == hash.length() - 1) { // if it is the last character
                add_length = add_zero; // set the add_length to the precalculated add_zero
            }
            for (int j = 0; j < add_length; j++) {
                cur_bi.insert(0, "0"); // append the prefix zeros
            }
            decompressed.append(cur_bi); // append the binary string
        }
        StringBuilder cur = new StringBuilder(), result = new StringBuilder(); // declare the current string and the result string
        int index = 0; // set the beginning index to zero
        while (index < decompressed.length()) { // go through the decompressed string
            cur.append(decompressed.charAt(index)); // append the current character to the current string
            for (char i : huffmanTable.keySet()) { // iterate through the map's keys
                if (cur.toString().equals(huffmanTable.get(i))) { // if the current string matches a value
                    result.append(i); // append the result
                    cur = new StringBuilder(); // renew the string builder
                    break; // break out the loop
                }
            }
            index++; // go to the next character
        }
        return result.toString(); // return the result string
    }

    public void storeCode(Branch<Character> root, String cur) { // store the huffman codes ot a map
        if (root == null) return; // if the current branch is null
        if (root.info != null) { // if the current branch is not a sum node
            huffmanTable.put(root.info, cur); // put the information into the map
        }
        storeCode(root.l, cur + "0"); // go to the left child
        storeCode(root.r, cur + "1"); // go to the right child
    }

    public static void main(String[] args) throws IOException {
        new HuffmanCoding(); // run the program
    }
}
