package intro.HouseModeling;

public class Room {
    private String name;
    private int length, width, height;
    private int steelUsed, glassUsed;
    private final int steelPrice = 5, glassPrice = 10;

    public String getName() {
        return name;
    }

    public void changeLength(int newLength) {
        length = newLength;
    }

    public void changeWidth(int newWidth) {
        width = newWidth;
    }

    public void changeHeight(int newHeight) {
        height = newHeight;
    }

    public void changeName(String newName) {
        name = newName;
    }

    public void changeSteelUsed(int newSteelUsed) {
        steelUsed = newSteelUsed;
    }

    public void changeGlassUsed(int newGlassUsed) {
        glassUsed = newGlassUsed;
    }

    public int squareFootage() {
        return length * width;
    }

    public int volume() {
        return length * width * height;
    }

    public int price() {
        return steelUsed * steelPrice + glassUsed * glassPrice;
    }

    public Room(String name, int length, int width, int height, int steelUsed, int glassUsed) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.height = height;
        this.steelUsed = steelUsed;
        this.glassUsed = glassUsed;
    }
}
