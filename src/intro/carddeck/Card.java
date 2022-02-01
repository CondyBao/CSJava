package intro.carddeck;

public class Card {
    private String suit;
    private int num;

    public Card(int num, String suit){
        this.num = num;
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }

    public int getNum() {
        return num;
    }

    public String toString() {
        return suit + " " + (num + 1);
    }
}
