package uno;

import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer(String name) {
        super(name);
    }
    @Override
    public void playCard(Card card) {
        if (card != null) {
            removeCard(card);
            System.out.println(name + " played: " + card);
        } else {
            System.out.println(name + "no valid card to play");

        }
    }
    @Override
    public Card selectPlayableCard(Card card){//pick a card from the available cards
        ArrayList<Card> playable=getPlayableCards(card);
        if(playable.isEmpty()==false){
            System.out.println(name +"select a card to play:");
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