package uno;
import java.util.ArrayList;
import java.util.Scanner;


public class Player {
private String name;
private ArrayList<Card> hand;
private boolean isTurn;

public Player (String name){
    this.name= name;
    this.hand= new ArrayList<Card>(); // it is empty arry
    this.isTurn=false;
}
public String getName(){
    return name;
}
public ArrayList<Card> getHand (){
    return hand;
    }
public boolean isTurn(){
    return isTurn;
}
public void setTurn (boolean isTurn){
    this.isTurn=isTurn;
}
public boolean isWinner (){
    return hand.isEmpty();
}
public void removeCard(Card card){
    hand.remove(card);
}
public void drawCard(Card card){
    hand.add(card);
}
public int getCardCount(){
    return hand.size();
}
public boolean hasPlayableCard(Card card){// if the player has a playable card
    Rules rules = new Rules();
    for(int i=0;i<hand.size();i++){
        if(rules.isValidMove(hand.get(i), card)) {
            return true;
        }
    }
    return false;
}
public ArrayList<Card> getPlayableCards(Card card){ // creat a list of playable cards
    ArrayList<Card> playable =new ArrayList<Card>();
    Rules rule =new Rules();
    for(int i=0;i<hand.size();i++){
        if(rules.isValidMove(hand.get(i), card)){// if you can play the card then add it to the array of  playable cards
            playable.add(hand.get(i));
        }
    }
    return playable;
}
public Card selectPlayableCard(Card card){//pick a card from the available cards
    ArrayList<Card> playable =getPlayableCards(card);
    if(playable.isEmpty()==false){
        System.out.println(name +"select a card to play:");
        for(int i=0; i<playable.size(); i++){
            System.out.println((i+1)+":"+playable.get(i));
        }
        Scanner in =new Scanner(System.in);
        int  s=in.nextInt()-1;
        if( s>=0   &&   s<playable.size() ){
            return playable.get(s);
        }
    }
        return null;
    }

    @Override
    public String toString() {
        return "player: " + name + " cards: " + hand + " turn: " + isTurn;
    }
    public void playCard(Card card) {
    if (card!= null) {
        removeCard(card);
        System.out.println(name + " played: " + card);
        } else {
            System.out.println(name + "no valid card to play");

    }
    }


}