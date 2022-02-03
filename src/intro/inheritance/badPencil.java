package intro.inheritance;

public class badPencil extends pencil{
    private int durability;

    public void write(String words) {
        String currentWords = getWordsWritten();
        if (getAge() > durability) {
            currentWords += words.substring(0, words.length() / 2);
        }
        else currentWords += words;
        changeWordsWritten(currentWords);
    }

    public badPencil(String color, int age, int price, double thickness, int durability) {
        super(color, age, price, thickness);
        this.durability = durability;
    }

    public static void main(String[] args) {
        writingTools pen = new writingTools("Red", 1, 10);
        pencil regPencil = new pencil("Black", 2, 5, 0.3);
        badPencil bad_pencil = new badPencil("Gray", 3, 8, 0.5, 4);
        pen.write("okay");
        pen.usedXYears(1);
        System.out.println(pen);
        regPencil.write("Not Okay");
        regPencil.eraseLastXCharacters(5);
        regPencil.usedXYears(2);
        System.out.println(regPencil);
        bad_pencil.write("Alright");
        bad_pencil.usedXYears(5);
        bad_pencil.write("Not Alright");
        System.out.println(bad_pencil);
    }
}
