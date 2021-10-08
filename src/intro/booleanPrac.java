package intro;

public class booleanPrac {
    public void smallInt (int x1, int x2, int x3) {
        if (x1 < x2) {
            if (x1 < x3) {
                System.out.println(x1);
            }
            else {
                System.out.println(x3);
            }
        }
        else {
            if (x2 < x3) {
                System.out.println(x2);
            }
            else {
                System.out.println(x3);
            }
        }
    }

    public void charIf (char a, char b) {
        int a1 = (int) a, b1 = (int) b, letter1 = 0, letter2 = 0;
        if (a1 >= 65 && a1 <= 90) {
            letter1 = a1 - 64;
        }
        if (b1 >= 65 && b1 <= 90) {
            letter2 = b1 - 64;
        }
        if (a1 >= 97 && a1 <= 122) {
            letter1 = a1 - 96;
        }
        if (b1 >= 97 && b1 <= 122) {
            letter2 = b1 - 96;
        }
        if (Math.abs(letter1 - letter2) <= 2) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }

    public static void main(String[] args) {
        booleanPrac runner = new booleanPrac();
        runner.smallInt(5, 6, 7);
        runner.charIf('d', 'G');
    }
}
