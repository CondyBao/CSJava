package intro.carddeck;

import java.util.Random;

public class Deck {
    private Card[] cards = new Card[52];

    public Card getRandom() {
        Random rand = new Random();
        return cards[rand.nextInt(52)];
    }

    public Card[] getFirstN(int n) {
        Card[] returnCards = new Card[n];
        System.arraycopy(cards, 0, returnCards, 0, n);
        return returnCards;
    }

    public void sort() {
        for (int i = 0; i < cards.length; i++) {
            for (int j = i + 1; j < cards.length; j++) {
                if (cards[i].getNum() > cards[j].getNum()) {
                    Card copy_i = cards[i];
                    cards[i] = new Card(cards[j].getNum(), cards[j].getSuit());
                    cards[j] = copy_i;
                }
            }
        }
    }

    public void shuffle() {
        Card[] copy = new Card[52];
        Random rand = new Random();
        for (int k = 0; k < 5; k++) {
            boolean[] used = new boolean[52];
            for (int i = 0; i < 52; i++) used[i] = false;
            System.arraycopy(cards, 0, copy, 0, 52);
            for (int i = 0; i < cards.length; i++) {
                if (used[i]) continue;
                if (rand.nextInt(5) != 1) {
                    int change = i;
                    while (change == i && !used[change]) {
                        change = rand.nextInt(52);
                    }
                    used[change] = true;
                    used[i] = true;
                    Card copy_change = cards[change];
                    cards[change] = cards[i];
                    cards[i] = copy_change;
                }
            }
        }
    }

    public String toString() {
        String returnString = "";
        for (int i = 0; i < 52; i++) {
            returnString += cards[i].toString() + '\n';
        }
        return returnString;
    }

    public Deck() {
        for (int i = 0; i < 4; i++) {
            String suit = "";
            if (i == 0) suit = "clubs";
            if (i == 1) suit = "hearts";
            if (i == 2) suit = "diamonds";
            if (i == 3) suit = "spades";
            for (int j = 0; j < 13; j++) {
                Card newCard = new Card(j, suit);
                cards[i * 13 + j] = newCard;
            }
        }
    }
}

