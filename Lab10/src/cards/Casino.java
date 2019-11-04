package cards;

import se.lth.cs.pt.window.SimpleWindow;

import javax.print.attribute.HashAttributeSet;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Casino {

    private ArrayList<Card> cards;
    private ArrayList<Card> computerCards;
    private int money;
    private int battingMoney;
    private CardWindow w;

    public Casino() {
        w = new CardWindow(1, 13, "Casino");
        money = 1000;
        battingMoney = 100;

    }

    public boolean checkAce() {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getRank() == 1) {
                return true;
            }
        }
        return false;
    }

    public int getIndex(Card clickedCard) {
        for (int i = 0; i < cards.size(); i++) {
            if (clickedCard.getRank() == cards.get(i).getRank() &&
                    clickedCard.getSuit() == cards.get(i).getSuit()) {
                return i;
            }
        }
        return -1;
    }

    public void checkWhoisWin(int userSum, int computerSum){
        if(userSum > computerSum){
            money += battingMoney;
            showDialog("You Win");
        }else{
            money -= battingMoney;
            showDialog("You Lost");
        }
    }

    public void showDialog(String str){
        //when finish game
        String[] options = {"OK"};
        int x = JOptionPane.showOptionDialog(null, str, "",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        start();
    }

    public void start(){

        w.clear();

        Deck deck = new Deck();

        boolean useAce14 = false;

        computerCards = new ArrayList<Card>();

        cards = new ArrayList<Card>();

        Hand hand = new Hand(cards,computerCards);

        for(int i = 0; i < 2; i++){
            hand.insert(deck.getCard(),Hand.COMPUTER);
            hand.insert(deck.getCard(),Hand.USER);
            hand.displayCard(w,0,0,Hand.USER);
        }

        w.displayText("o = Receive one more card s = Stand\n Your Money : " + String.valueOf(money),w.getWidth()/2-150,w.getHeight()/2+10);

        char input = w.waitForKey();

        if(input == 'o'){

            if(hand.rankSum(useAce14,Hand.USER) < 21){
                hand.insert(deck.getCard(),Hand.USER);
                hand.displayCard(w,0,0,Hand.USER);
                checkWhoisWin(hand.rankSum(useAce14,Hand.USER),hand.rankSum(useAce14,Hand.COMPUTER));
            }else{
                money -= battingMoney;
                showDialog("You Lost");
            }

        }else if(input == 's'){
            hand.displayCard(w,0,11,Hand.COMPUTER);
            checkWhoisWin(hand.rankSum(useAce14,Hand.USER),hand.rankSum(useAce14,Hand.COMPUTER));
        }

        for(int i=0; i < cards.size(); i++){
            cards.remove(hand.remove(i,Hand.USER));
            hand.display(w, Hand.USER);
        }
        for(int i=0; i < computerCards.size(); i++){
            computerCards.remove(hand.remove(i,Hand.COMPUTER));
            hand.display(w, Hand.COMPUTER);
        }

    }

    public static void main(String[] args) {

        Casino casino = new Casino();

        casino.start();
    }
}
