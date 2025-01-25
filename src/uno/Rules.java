package uno;

public class Rules {
    public boolean isValidMove(Card card, Card topCard) {
        if (card.getColor() == topCard.getColor()) {
            return true;
        }
        if (card.getValue() == topCard.getValue()) {
            return true;
        }
        if (card.getColor() == Color.WILD) {
            return true;
        }
        return false;
    }
    public void applyEffect(Card card, Game game) {
        switch (card.getValue()) {
            case DRAW_TWO:
                enforceDrawCardsEffect(2, game);
                break;
            case WILD_DRAW_FOUR:
                game.chooseNextColor();
                enforceDrawCardsEffect(4, game);

                break;
            case REVERSE:
                game.reverseDirection();
                break;
            case SKIP:
                game.skipNextPlayer();
                break;
            case WILD:
                game.chooseNextColor();
                break;
            default:
                // Nothing
                break;
        }
    }
    private void enforceDrawCardsEffect(int count, Game game) {
        Player nextPlayer = game.getNextPlayer();
        for (int i = 0 ; i < count ; i++) {
            nextPlayer.drawCard(game.drawCard());
        }
    }
}