package uno;
import java.util.ArrayList;
import java.util.Scanner;


public  class Player extends Players {
    public Player(String name) {
        super(name);
    }
    @Override
    public void playCard(Card c) {
        if (c != null) {
            removeCard(c);
            System.out.println(name + " played: " + c);
        } else {
            System.out.println(name + "\uD83D\uDE2Cno valid card to play");
        }
    }
    @Override
    public Card selectPlayableCard(Card c){//pick a card from the available cards
        ArrayList<Card> playable=getPlayableCards(c);
        if(playable.isEmpty()==false){
            System.out.println(name +"choose a card:");
            for(int i=0; i<playable.size(); i++){
                System.out.println((i+1)+":"+playable.get(i));
            }
            Scanner in =new Scanner(System.in);
            int  s=in.nextInt()-1;
            if( s>=0     &&      s<playable.size() ){
                return playable.get(s);
            }
        }
        return null;
    }
}