package uno;

public class UnoGame {
    public static void main(String[]args){
        Deck deck=new Deck();
        Game game=new Game(deck);
        game.startGame();
    }
}