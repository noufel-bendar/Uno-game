package uno;

import java.util.ArrayList;

public interface Playble {
    public String getName();
    public ArrayList<Card> getHand ();
    public boolean isTurn();
    public void setTurn (boolean isTurn);
    public boolean isWinner();
    public void removeCard(Card card);
    public void drawCard(Card card);
    public ArrayList<Card> getPlayableCards(Card card);
    public int getCardCount();
    public boolean hasPlayableCard(Card card);
    public ArrayList<Card> getPlayableCards(Card card);
    public abstract Card selectPlayableCard(Card card);
    public abstract void playCard(Card card);
    public String toString();

}
