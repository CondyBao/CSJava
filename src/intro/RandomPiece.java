package intro;

import java.util.Scanner;

public class RandomPiece {
    // This code finds the number 0 < x 's prime term

    final int INT_MAX = 214748364;
    StringBuilder xpdsa;

    private final boolean[] ab;

    public boolean jk(int xk) {
        return !ab[xk];
    }

    public void ak(int xt) {
        for (int i = xt; i < INT_MAX; i += xt) {
            ab[i] = true;
        }
    }

    public RandomPiece(int x) {
        int xs = 0, ck = 2;
        xpdsa = new StringBuilder("");
        ab = new boolean[INT_MAX];
        while (xs < x) {
            if (jk(ck)) {
                xpdsa.append(ck);
                ak(ck);
                xs++;
            }
            ck++;
        }
        System.out.println(xpdsa);
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        new RandomPiece(inp.nextInt());
    }
}
