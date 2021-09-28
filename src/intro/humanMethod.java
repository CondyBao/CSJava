package intro;

public class humanMethod {
    private int age;
    private char gender;
    private boolean vote = false;
    private boolean shot = false;
    private boolean dis = false;
    private boolean teenager = false;

    public void setAge (int x) {
        age = x;
    }

    public void setGender (char x) {
        gender = x;
    }

    public void vote () {
        if (age >= 18) {
            vote = true;
            System.out.println("Can Vote");
        }
        else {
            System.out.println("Cannot Vote");
        }
    }

    public void tetanus () {
        if (age % 4 == 0) {
            shot = true;
            System.out.println("Gets Shot");
        }
        else {
            System.out.println("Do not Need Shot");
        }
    }

    public void toddler () {
        if (age < 4) {
            if (gender == 'b') {
                System.out.println("Toddler Boy");
            }
            else {
                System.out.println("Toddler Girl");
            }
        }
        else {
            System.out.println("Not a Toddler");
        }
    }

    public void discount () {
        if (age > 65 || age < 12) {
            dis = true;
            System.out.println("Gets Discount");
        }
        else {
            System.out.println("No Discount");
        }
    }

    public void teen () {
        if (age >= 12 && age <= 18) {
            teenager = true;
            System.out.println("Teenager");
        }
        System.out.println("Not Teenager");
    }

    public void team (humanMethod x) {
        if (x.gender == gender && Math.abs(x.age - age) <= 2) {
            System.out.println("Can be Teammates");
        }
        else {
            System.out.println("Cannot be Teammates");
        }
    }

    public static void main (String[] args) {
        humanMethod runner = new humanMethod();
        runner.setAge(16);
        runner.setGender('b');
        humanMethod runner2 = new humanMethod();
        runner2.setAge(18);
        runner2.setGender('b');

        runner.vote();
        runner.tetanus();
        runner.toddler();
        runner.discount();
        runner.teen();
        runner.team(runner2);
    }
}
