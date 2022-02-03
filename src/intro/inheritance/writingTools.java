package intro.inheritance;

public class writingTools {
    private String color;
    private String wordsWritten = "";
    private int age;
    private int price;

    public int getPrice() {
        return price;
    }

    public void write(String words) {
        wordsWritten += words;
    }

    public void changeWordsWritten(String wordsWritten) {
        this.wordsWritten = wordsWritten;
    }

    public String getColor() {
        return color;
    }

    public String getWordsWritten() {
        return wordsWritten;
    }

    public int getAge() {
        return age;
    }

    public void usedXYears(int n) {
        age += n;
        price -= n;
    }

    public writingTools(String color, int age, int price) {
        this.color = color;
        this.age = age;
        this.price = price;
    }

    public String toString() {
        return "User wrote " + wordsWritten + " with a " + color + ", and " + age + " years old, " + price + "-dollar pen(cil)";
    }
}
