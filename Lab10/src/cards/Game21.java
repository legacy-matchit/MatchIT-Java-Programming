package cards;

import se.lth.cs.pt.window.SimpleWindow;

import java.util.ArrayList;
import java.util.Scanner;

public class Game21 {

    private ArrayList<Card> cards;

    public Game21(){
        cards = new ArrayList<Card>();
    }


    public static void main(String[] args) {

        CardWindow w = new CardWindow(4,13,"Game21");

        w.displayText("Click Board Try Game");

        while (w.getClickedCard() == null){

            Deck deck = new Deck();

            Game21 game21 = new Game21();

            //draw 3 cards
            for(int i = 0; i < 3; i++){
                Card card = deck.getCard();
                game21.cards.add(card);
                SimpleWindow.delay(300);
                w.displayCard(card,1,5+i);
            }

            Hand hand = new Hand(game21.cards,null);

            if(hand.rankSum(false,Hand.USER) > 21){
                w.displayText("You Lost!!!!! SUM:" + hand.rankSum(false,Hand.USER));
            }else{
                w.displayText("You Won!!!!! SUM:" + hand.rankSum(false,Hand.USER));
            }

            w.displayText("Click Try Again",w.getWidth()/2,w.getHeight()/2+20);
        }



    }

}
