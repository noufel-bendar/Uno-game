package uno;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> hand;
    private boolean isTurn;


    // Constructor for initializing the player with a name
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.isTurn = false;
    }

    // Getter for the player's name
    public String getName() {
        return name;
    }

    // Getter for the player's hand
    public ArrayList<Card> getHand() {
        return hand;
    }

    // Setter to indicate if it is the player's turn
    public void setTurn(boolean isTurn) {
        this.isTurn = isTurn;
    }

    // Method to check if it is the player's turn
    public boolean isTurn() {
        return isTurn;
    }

    // Method to draw a card and add it to the player's hand
    public void drawCard(Card card) {
        hand.add(card);
    }

    // Method to remove a card from the player's hand
    public void removeCard(Card card) {
        hand.remove(card);
    }



 // Method to check if the player has won
    public boolean isWinner() {
        return hand.isEmpty();
    }


    // Method to get the count of cards in the player's hand
    public int getCardCount() {
        return hand.size();
    }

    // Method to represent the player as a string
    @Override
    public String toString() {
        return "Player: " + name + ", Cards: " + hand + ", Turn: " + isTurn;
    }
}

