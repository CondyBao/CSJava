package intro;

public class tuesdayPrep {
    public void printDigits(int x) {
        while (x > 0) {
            System.out.println(x % 10);
            x /= 10;
        }
    }

    public void rect(int x, int y) {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print('X');
            }
            System.out.print('\n');
        }
    }

    public void factor(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    System.out.print(j + " ");
                }
            }
            System.out.print('\n');
        }
    }

    public static void main(String[] args) {
        tuesdayPrep runner = new tuesdayPrep();
        runner.printDigits(582);
        runner.rect(3, 2);
        runner.factor(8);
    }
}
