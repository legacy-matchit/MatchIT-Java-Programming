package cards;

import se.lth.cs.pt.window.SimpleWindow;

import java.util.ArrayList;
import java.util.Collections;

public class Hand {

    public static final int COMPUTER = 0;
    public static final int USER = 1;

    private ArrayList<Card> cards;
    private ArrayList<Card> computerCards;

    public Hand(ArrayList<Card> user, ArrayList<Card> computer){
        this.cards = user;
        this.computerCards = computer;
    }

    public void insert(Card c,int key){
        if(key == COMPUTER){
            computerCards.add(c);
        }else{
            cards.add(c);
        }
    }

    public Card remove(int pos,int key){
        Card card = null;
        if(key == COMPUTER){
            card = computerCards.get(pos);
        }else{
            card = cards.get(pos);
        }
        return card;
    }

    public int nbrCards(int key){
        int size = 0;
        if(key == COMPUTER){
            size = computerCards.size();
        }else{
            size = cards.size();
        }
        return size;
    }

    public int rankSum(boolean ace14, int key){

        int sum = 0;
        int rank = 0;

        if(key == COMPUTER){
            for(Card c : computerCards){
                rank = c.getRank();
                if(ace14 && rank == 1){
                    rank = 14;
                }
                sum += rank;
            }
        }else{
            for(Card c : cards){
                rank = c.getRank();
                if(ace14 && rank == 1){ // Ace and use as 14 true
                    rank = 14;
                }
                sum += rank;
            }
        }

        return sum;
    }

    void display(CardWindow w, int key){
        if(key == COMPUTER){
            w.displayCards(computerCards);
        }else{
            w.displayCards(cards);
        }
    }

    void displayCard(CardWindow w, int row, int col, int key){

        if(key == COMPUTER){
            for (int i = 0; i < computerCards.size(); i++) {
                SimpleWindow.delay(300);
                w.displayCard(computerCards.get(i),row,col+i);
            }
        }else{
            for (int i = 0; i < cards.size(); i++) {
                SimpleWindow.delay(300);
                w.displayCard(cards.get(i),row,col+i);
            }
        }

    }
}
