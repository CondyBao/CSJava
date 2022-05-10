package intro.Huffman;

public class Branch<auto> {
    auto info;

    int freq;

    Branch<auto> l, r; // left and right child

    public String toString() {
        return info + ": " + freq;
    }

    public Branch(auto info, int freq) { // first constructor for leaf nodes
        l = r = null;
        this.info = info;
        this.freq = freq;
    }

    public Branch(int freq, Branch<auto> l, Branch<auto> r) { // second constructor for sum nodes
        info = null;
        this.freq = freq;
        this.l = l;
        this.r = r;
    }
}
