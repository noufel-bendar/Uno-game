package uno;

import java.util.ArrayList;
import java.util.Collections;
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
                for (int i = 0; i <= 9; i++) {
                    cards.add(new Card(color, Value.values()[i]));
                    if (i != 0) {
                        cards.add(new Card(color, Value.values()[i]));
                    }
                }

                // Add special cards
                for (int i = 0; i < 2; i++) {
                    cards.add(new Card(color, Value.SKIP));
                    cards.add(new Card(color, Value.REVERSE));
                    cards.add(new Card(color, Value.DRAW_TWO));
                }
            }
        }

        // Add wild cards
        for (int i = 0; i < 4; i++) {
            cards.add(new Card(Color.WILD, Value.WILD));
            cards.add(new Card(Color.WILD,Value.WILD_DRAW_FOUR));
        }
    }


    private void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("The deck is empty!");
        }
        return cards.pop();
    }

    public int getRemainingCards() {
        return cards.size();
    }
}
