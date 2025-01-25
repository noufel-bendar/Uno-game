package uno;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

public class Deck {
    private Stack<Card> cards;

    public Deck() {
        cards = new Stack<>();
        initializeDeck();
        shuffleDeck();
    }

    private void initializeDeck() {
        for (Color color : Color.values()) {
            if (color != Color.WILD) { // Only normal colors
                // Add number cards (0-9)
                for (int i = 0; i <= 9; i++) { // khdmna b 3 ghir bach ji deck kbira bzaf
                    cards.add(new Card(color, Value.values()[i]));
                    cards.add(new Card(color, Value.values()[i]));
                    cards.add(new Card(color, Value.values()[i]));
                }
                for (int i = 0; i < 4; i++) {// 4 bach ji deck kbira
                    cards.add(new Card(color, Value.SKIP));
                    cards.add(new Card(color, Value.REVERSE));
                    cards.add(new Card(color, Value.DRAW_TWO));
                }
            }
        }
        for (int i = 0; i < 7; i++) { //kifkif
            cards.add(new Card(Color.WILD, Value.WILD));
            cards.add(new Card(Color.WILD, Value.WILD_DRAW_FOUR));
        }
    }


    private void shuffleDeck() {
        Random r = new Random();
        for (int i = cards.size() - 1; i > 0; i--) {
            int k = r.nextInt(i + 1);
            Card temp = cards.get(i);
            cards.set(i, cards.get(k));
            cards.set(k, temp);
        }
    }


    public Card drawCard() {
        if (cards.isEmpty()) {
            initializeDeck();
            shuffleDeck();
        }
        return cards.pop();
    }

    public int getRemainingCards() {
        return cards.size();
    }
}
