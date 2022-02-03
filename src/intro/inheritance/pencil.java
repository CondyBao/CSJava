package intro.inheritance;

public class pencil extends writingTools{
    private double thickness;

    public void eraseLastXCharacters(int n) {
        String replaceString = getWordsWritten();
        replaceString = replaceString.substring(0, replaceString.length() - n);
        changeWordsWritten(replaceString);
    }

    public void write(String words) {
        String wordsWritten = getWordsWritten() + words;
        changeWordsWritten(wordsWritten);
    }

    public double getThickness() {
        return thickness;
    }

    public String toString() {
        return "User wrote " + getWordsWritten() + " (monochrome) with a " + getColor() + ", and " + getAge() + " years old, " + getPrice() + "-dollar pen(cil) that is " + thickness + " (unit) thick.";
    }

    public pencil(String color, int age, int price, double thickness) {
        super(color, age, price);
        this.thickness = thickness;
    }
}