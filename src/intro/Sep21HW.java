package intro;

public class Sep21HW {
    public void int2char(int integer) {
        System.out.println((char) (integer + 48));
    }

    public void lastDigit(int integer) {
        System.out.println(integer % 10);
    }

    public void avg(double double1, double double2) {
        System.out.println((double1 + double2) / 2);
    }

    public static void main(String[] args) {
        Sep21HW runner = new Sep21HW();
        runner.int2char(50);
        runner.lastDigit(101);
        runner.avg(65.0, 32.1);
    }
}