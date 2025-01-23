package uno;

import java.util.ArrayList;

public class Bot extends Players {
    public Bot(String name) {
        super(name);
    }

    @Override
    public void playCard(Card card) {
        if (card != null) {
            removeCard(card);
            System.out.println(getName() + " played: " + card);
        } else {
            System.out.println(getName() + " has no valid card to play.");
        }
    }

    @Override
    public Card selectPlayableCard(Card topCard) {
        ArrayList<Card> playableCards = new ArrayList<>();

        for (int i = 0; i < getHand().size(); i++) {
            Card card = getHand().get(i);
            if (new Rules().isValidMove(card, topCard)) {
                playableCards.add(card);
            }
        }

        if (!playableCards.isEmpty()) {
            return playableCards.get(0);

            return null;
        }
    }
}