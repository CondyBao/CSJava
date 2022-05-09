package intro.Huffman;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class HuffmanCoding {
    HashMap<Character, Integer> freq = new HashMap<>();
    HashMap<Character, String> huffmanTable = new HashMap<>();

    public HuffmanCoding() throws IOException {
        String text = FileRead();
        buildTree();
        String hash = compress(text);
        FileWrite("hash.txt", hash);
        String result = decompress(hash);
        FileWrite("result.txt", result);
    }

    public String FileRead() throws IOException {
        String fileName = "test.txt";
        StringBuilder text = new StringBuilder();
        FileReader reader;
        try {
            reader = new FileReader("src/intro/Huffman/" + fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int ascii = reader.read();
        while(ascii != -1) {
            char cur = (char)ascii;
            text.append(cur);
            if (freq.containsKey(cur)) {
                freq.put(cur, freq.get(cur) + 1);
            }
            else freq.put(cur, 1);
            ascii = reader.read();
        }
        return text.toString();
    }

    public void FileWrite(String fileName, String output) throws IOException {
        Files.write(Paths.get("src/intro/Huffman/" + fileName), output.getBytes());
    }

    public void buildTree() {
        PQ<Branch<Character>> minHeap = new PQ<>();
        for (char c : freq.keySet()) {
            minHeap.push(new Branch<>(c, freq.get(c)), freq.get(c));
        }
        Branch<Character> left, right, top;
        while (minHeap.getSize() != 1) {
            left = minHeap.top().element;
            minHeap.pop();
            right = minHeap.top().element;
            minHeap.pop();
            top = new Branch<>(left.freq + right.freq, left, right);
            minHeap.push(top, top.freq);
        }
        storeCode(minHeap.top().element, "");
    }

    public String compress(String text) {
        StringBuilder compressed = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            compressed.append(huffmanTable.get(text.charAt(i)));
        }
        int time = 0, index = 0;
        StringBuilder cur_num = new StringBuilder();
        StringBuilder hash = new StringBuilder();
        int add_zero = 0;
        while (index < compressed.length()) {
            time++;
            cur_num.append(compressed.charAt(index));
            if (time == 7) {
                add_zero = 0;
                int id = 0;
                while (id < cur_num.length() && cur_num.charAt(id) == '0') {
                    add_zero++;
                    id++;
                }
                int decimal = Integer.parseInt(cur_num.toString(), 2);
                hash.append((char) (decimal));
                time = 0;
                cur_num = new StringBuilder();
            }
            index++;
        }
        if (!(compressed.length() % 7 == 0) && !cur_num.toString().equals("")) {
            int id = 0;
            while (id < cur_num.length() && cur_num.charAt(id) == '0') {
                add_zero++;
                id++;
            }
            int decimal = Integer.parseInt(cur_num.toString(), 2);
            hash.append((char) decimal);
        }
        hash.append((char) add_zero);
        return hash.toString();
    }

    public String decompress(String hash) {
        int add_zero = hash.charAt(hash.length() - 1);
        hash = hash.substring(0, hash.length() - 1);
        StringBuilder decompressed = new StringBuilder();
        for (int i = 0; i < hash.length(); i++) {
            StringBuilder cur_bi = new StringBuilder(Integer.toBinaryString(hash.charAt(i)));
            int add_length = 7 - cur_bi.length();
            if (i == hash.length() - 1) {
                add_length = add_zero;
            }
            for (int j = 0; j < add_length; j++) {
                cur_bi.insert(0, "0");
            }
            decompressed.append(cur_bi);
        }
        StringBuilder cur = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (index < decompressed.length()) {
            cur.append(decompressed.charAt(index));
            for (char i : huffmanTable.keySet()) {
                if (cur.toString().equals(huffmanTable.get(i))) {
                    result.append(i);
                    cur = new StringBuilder();
                    break;
                }
            }
            index++;
        }
        return result.toString();
    }

    public void storeCode(Branch<Character> root, String cur) {
        if (root == null) return;
        if (root.info != null) {
            huffmanTable.put(root.info, cur);
        }
        storeCode(root.l, cur + "0");
        storeCode(root.r, cur + "1");
    }

    public static void main(String[] args) throws IOException {
        new HuffmanCoding();
    }
}
