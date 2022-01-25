package intro;

public class Human {
    private int age, height;
    private String gender, name;

    public void getOlder() {
        age++;
    }

    public void changeName(String newName) {
        name = newName;
    }

    public boolean canVote(int year) {
        return year % 4 == 0 && age >= 18;
    }

    public String toString() {
        return "Human [age=" + age + ", height=" + height +", name=" + name + ", gender=" + gender + "]";
    }

    public Human(int age, int height, String gender, String name) {
        this.age = age;
        this.height = height;
        this.gender = gender;
        this.name = name;
    }

    public static void main(String[] args) {
        Human test = new Human(5, 300, "unidentified", "anon");
        test.getOlder();
        test.changeName("anon#2");
        System.out.println("Can vote = " + test.canVote(2020));
        System.out.println(test);
    }
}

