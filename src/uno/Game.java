package uno;


import java.util.*;

public class Game {
    private List<Player> players;
    private Deck deck;
    private Card topCard;
    private int currentPlayerIndex;
    private int direction;
    private Rules rules;
    private PlayerStats stats;

    public Game(Deck deck) {
        this.players = new ArrayList<>();
        this.deck = deck;
        this.currentPlayerIndex = 0;
        this.direction = 1;
        this.rules = new Rules();
        this.stats = new PlayerStats();
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        setupPlayers(scanner);
        dealInitialCards();
        topCard = deck.drawCard();
        System.out.println("The starting card is: " + topCard);
        while (!isGameOver()) {
            playTurn();
        }
        announceWinner();
        endGame();
    }

    // Setup players
    private void setupPlayers(Scanner scanner) {
        System.out.println("enter the number of players 2 , 3 or 4 \uD83D\uDE0E: ");
        int playerCount = scanner.nextInt();
        if (playerCount >4 || playerCount <2) {
            System.out.println(" \uD83E\uDD26\u200D♂\uFE0F the number of players is invalid \uD83C\uDFAE");
            System.exit(0);
        }
        // add player
        for (int i = 0; i < playerCount; i++) {
            System.out.println("the name of Player " + (i + 1) + " is :");
            String name = scanner.next();
            Player player = new Player(name);
            players.add(player);
            stats.addPlayer(player);

        }

        // add bot if the number of  human players <4  (human. bot)= (3.1) (2.2) (4.0)
        while (players.size() < 4) {
            Player bot = new Bot("Bot 🤖 " + (players.size() + 1));
            players.add(bot);
            stats.addPlayer(bot);
        }
    }

    // add 7 cards to player
    private void dealInitialCards() {
        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                player.drawCard(deck.drawCard());
            }
        }
    }

    private boolean isGameOver() {
        for (Player player : players) {
            if (player.isWinner()) {
                return true;
            }
        }
        return false;
    }


    private void playTurn() {
        Player currentPlayer = players.get(currentPlayerIndex);
        System.out.println("\nPlayer: " + currentPlayer.getName());
        System.out.println("Top card \uD83C\uDCCF: " + topCard);

        // if bot display num of cards
        if (currentPlayer instanceof Bot) {
            System.out.println(currentPlayer.getName() + " has " + currentPlayer.getCardCount() + " cards");
        } else {
            // if human diplay cards
            System.out.println(currentPlayer.getName() + " have: ");
            for (Card card : currentPlayer.getHand()) {
                System.out.println(card);
            }

            //  the playable cards
            ArrayList<Card> playableCards = currentPlayer.getPlayableCards(topCard);
            if (!playableCards.isEmpty()) {
                System.out.println(" you can play this cards : ");
                for (Card card : playableCards) {
                    System.out.println(card);
                }
            } else {
                System.out.println(" \uD83D\uDE2C you don't have any cards to play ");
            }
        }

        // the player has a valid card
        if (currentPlayer.hasPlayableCard(topCard)) {
            Card playedCard = currentPlayer.selectPlayableCard(topCard);
            if (playedCard != null) {
                topCard = playedCard;
                currentPlayer.playCard(playedCard);

                // for special effect of card
                rules.applyEffect(playedCard, this);
            }
        } else {
            System.out.println(currentPlayer.getName() + " has no playable card drawing a card \uD83D\uDE2C");
            currentPlayer.drawCard(deck.drawCard());
        }
        nextTurn();
    }




    private void nextTurn() {
        currentPlayerIndex = (currentPlayerIndex + direction + players.size()) % players.size();
    }


    public void reverseDirection() {
        direction = -direction;
        System.out.println("\uD83D\uDD04\uD83D\uDD04\uD83D\uDD04\uD83D\uDD04DIRECTION   REVERSED\uD83D\uDD04\uD83D\uDD04\uD83D\uDD04\uD83D\uDD04");
    }

    public void skipNextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + direction + players.size()) % players.size();
        System.out.println("Oops! Next player got hit with a skip! \uD83D\uDE1C");
    }

    public Player getNextPlayer() {
        int nextIndex = (currentPlayerIndex + direction + players.size()) % players.size();// khdmt b l mod bach num li yji sghir 3la player size  o zadt player size 3la jal l cas ta3 direction -1 o current player 0
        return players.get(nextIndex);
    }

    public Card drawCard() {
        return deck.drawCard();
    }

    //  the player choose the next color (in case of a wild card)
    private final List<String> colors = Arrays.asList("yellow", "red", "green", "blue");

    public void chooseNextColor() {
        Player currentPlayer = players.get(currentPlayerIndex);

        if(currentPlayer instanceof Player){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose a color: \uD83D\uDD34 RED, \uD83D\uDD35 BLUE,\uD83D\uDFE2 GREEN,\uD83D\uDFE1 YELLOW");
            String colorInput = scanner.next().toUpperCase();//  yrj3o toujour uppercase

            try {
                topCard = new Card(Card.Color.valueOf(colorInput), Card.Value.WILD);
            } catch (IllegalArgumentException e) {
                System.out.println("❌ Invalid color defaulting to RED! \uD83D\uDD34");
                topCard = new Card(Card.Color.RED, Card.Value.WILD);
            }
        }
        if (currentPlayer instanceof Bot){
            Random random = new Random();
            int n = random.nextInt(4);
            String nextColor = colors.get(n);

            topCard = new Card(Card.Color.valueOf(nextColor), Card.Value.WILD);
        }
    }
    private void endGame() {
        System.out.println("\n---------- GAME OVER ----------");
        stats.calculatePoints();
        stats.displayRankings();
    }


    private void announceWinner() {
        for (Player player : players) {
            if (player.isWinner()) {
                System.out.println("\n\uD83C\uDF89 Congratulations!  " + player.getName() + "\uD83C\uDFC6✨! You won the game!\uD83C\uDFC6✨");
                return;
            }
        }
    }
}
