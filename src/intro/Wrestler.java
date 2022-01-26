package intro;

public class Wrestler {
    private String name, outfitColor;
    private double weight;
    private int winNum = 0;

    public void intimidation() {
        System.out.println("I will kick your butt!");
    }

    public Wrestler(String name, String outfitColor, double weight) {
        this.name = name;
        this.outfitColor = outfitColor;
        this.weight = weight;
    }

    public void win() {
        winNum++;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public void fight(Wrestler x) {
        if (weight > x.getWeight()) {
            win();
            return;
        }
        if (weight < x.getWeight()) {
            x.win();
            return;
        }
        int minLength;
        boolean isX = true;
        if (x.getName().length() < name.length()) {
            minLength = x.getName().length();
            isX = false;
        }
        else minLength = name.length();
        int index = 0;
        while (index < minLength) {
            if (x.getName().charAt(index) < name.charAt(index)) {
                x.win();
                return;
            }
            if (x.getName().charAt(index) > name.charAt(index)) {
                win();
                return;
            }
            index++;
        }
        if (isX) {
            x.win();
        }
        else win();
    }

    public void changeClothes(String color) {
        outfitColor = color;
    }

    public String getOutfitColor() {
        return outfitColor;
    }

    public void tagTeam(Wrestler[] ally, Wrestler[] opponents) {
        int totalWeight = 0, totalWeightOp = 0;
        for (Wrestler wrestler : ally) {
            wrestler.changeClothes(outfitColor);
            totalWeight += wrestler.getWeight();
        }
        for (Wrestler wrestler : opponents) {
            wrestler.changeClothes(opponents[0].getOutfitColor());
            totalWeightOp += wrestler.getWeight();
        }
        boolean win = totalWeightOp <= totalWeight;
        if (win) {
            for (Wrestler wrestler : ally) {
                wrestler.win();
            }
        } else {
            for (Wrestler wrestler : opponents) {
                wrestler.win();
            }
        }
    }

    public void lift(int minutes) {
        weight += 0.01 * minutes;
    }

    public String toString() {
        return "Wrestler " + name + " is " + weight + "pounds, he has " + winNum + "wins.";
    }

    public static void main(String[] args) {

    }
}
