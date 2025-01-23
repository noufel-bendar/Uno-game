package uno;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Players {

        protected String name;
        protected ArrayList<Card> hand;
        protected boolean isTurn;

        public Players(String name) {
            this.name = name;
            this.hand = new ArrayList<Card>(); // it is empty arry
            this.isTurn = false;
        }
        public String getName() {
            return name;
        }
        public ArrayList<Card> getHand() {
            return hand;
        }

        public boolean isTurn() {
            return isTurn;
        }

        public void setTurn(boolean isTurn) {
            this.isTurn = isTurn;
        }

        public boolean isWinner() {
            return hand.isEmpty();
        }

        public void removeCard(Card card) {
            hand.remove(card);
        }

        public void drawCard(Card card) {
            hand.add(card);
        }

        public int getCardCount() {
            return hand.size();
        }
        public boolean hasPlayableCard(Card card) {// if the player has a playable card
            Rules rules = new Rules();
            for (int i = 0; i < hand.size(); i++) {
                if (rules.isValidMove(hand.get(i), card)) {
                    return true;
                }
            }
            return false;
        }
        public ArrayList<Card> getPlayableCards(Card card) { // creat a list of playable cards
            ArrayList<Card> playable = new ArrayList<Card>();
            Rules rule = new Rules();
            for (int i = 0; i < hand.size(); i++) {
                if (rule.isValidMove(hand.get(i), card)) {// if you can play the card then add it to the array of  playable cards
                    playable.add(hand.get(i));
                }
            }
            return playable;
        }
        public String toString() {
            return "player: " + name + " cards: " + hand + " turn: " + isTurn;
        }

        public abstract void playCard(Card card);
        public abstract Card selectPlayableCard(Card card);
    }