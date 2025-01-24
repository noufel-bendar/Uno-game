package uno;

import java.util.ArrayList;
import java.util.List;

public class PlayerStats {

    private List<Player> players;
    private List<Integer> points;
    private List<Integer> cardsleft;

    public PlayerStats() {
        this.players = new ArrayList<>();
        this.points = new ArrayList<>();
        this.cardsleft = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
        points.add(0);
        cardsleft.add(0);
    }


    public void calculatePoints() {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            int totalPoints = 0;

            // n7sbo les point
            for (Card card : player.getHand()) {
                totalPoints += getCardPoints(card);
            }

            // the number of cards left in his hand
            int playedCards =player.getCardCount();

            points.set(i, totalPoints);
            cardsleft.set(i, playedCards);
        }
    }

    // les point pour chaque cart
    private int getCardPoints(Card card) {
        switch (card.getValue()) {
            case ZERO: return 0;
            case ONE: return 1;
            case TWO: return 2;
            case THREE: return 3;
            case FOUR: return 4;
            case FIVE: return 5;
            case SIX: return 6;
            case SEVEN: return 7;
            case EIGHT: return 8;
            case NINE: return 9;
            case DRAW_TWO: return 20;
            case REVERSE: return 25;
            case SKIP: return 30;
            case WILD: return 35;
            case WILD_DRAW_FOUR: return 35;
            default: return 0;
        }
    }

    public void displayRankings() {
        System.out.println("\n--- Final Rankings \uD83C\uDFC6\uD83E\uDD47\uD83E\uDD48\uD83E\uDD49 ---");

        int[] indices = new int[players.size()];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }

        // sort
        for (int i = 0; i < indices.length - 1; i++) {
            for (int j = 0; j < indices.length - i - 1; j++) {
                if (points.get(indices[j]) > points.get(indices[j + 1])) {
                    int temp = indices[j];
                    indices[j] = indices[j + 1];
                    indices[j + 1] = temp;
                }
            }
        }

        // print the rank
        for (int rank = 0; rank < indices.length; rank++) {
            int i = indices[rank];
            System.out.println((rank + 1) + "- " + players.get(i).getName() + " \uD83D\uDD22 Points: " + points.get(i) + " \uD83C\uDCCF Cards left: " + cardsleft.get(i));
        }
    }
}


