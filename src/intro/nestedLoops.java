package intro;

public class nestedLoops {
    public void printAlphabet () {
        for (int i = 65; i < 91; i++) {
            System.out.print((char)i + " ");
        }
        System.out.print('\n');
        System.out.print('\n');
    }

    public void multTable () {
        for (int i = 1; i <= 12; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(i * j + " ");
            }
            System.out.print('\n');
        }
        System.out.print('\n');
    }

    public void printPrime (int x) {
        boolean[] grid;
        grid = new boolean[10000];
        int cnt = 2, i = 0;
        while (i <= x) {
            if (!grid[cnt]) {
                i++;
                System.out.print(cnt + " ");
                for (int j = cnt * 2; j < 10000; j += cnt) { //definite finite, for loop, linear
                    grid[j] = true;
                }
            }
            if (cnt != 2) cnt+=2;
            else {
                cnt++;
            }
        }
        System.out.print('\n');
        System.out.print('\n');
    }

    public void xStars(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j || i == n - j + 1) {
                    System.out.print("X");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.print('\n');
        }
        System.out.print('\n');
    }

    public void pascal (int x) {
        for (int i = 0; i <= x; i++) {
            int num = 1;
            for(int j = 0; j <= i; j++) {
                System.out.print(num + " ");
                num = num * (i - j) / (j + 1);
            }
            System.out.print('\n');
        }
    }

    public static void main (String[] args) {
        nestedLoops runner = new nestedLoops();
        runner.printAlphabet();
        runner.multTable();
        runner.printPrime(10);
        runner.xStars(6);
        runner.pascal(5);
    }
}
