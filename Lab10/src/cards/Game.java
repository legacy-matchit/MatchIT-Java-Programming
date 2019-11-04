package cards;

import se.lth.cs.pt.window.SimpleWindow;

import java.util.NavigableMap;

public class Game{

    private static final int NBR_ITERATIONS = 10000;
    private Deck deck;
    private int checkCount;
    private int loseCount;
    private int winCount;

    public Game(){
        checkCount = 0;
        loseCount = 0;
        winCount = 0;
    }


    public double getProbability(double win){
        return win/NBR_ITERATIONS;
    }



    public static void main(String[] args) {


        Game game = new Game();

        CardWindow w = new CardWindow(4, 13, "Card Game");

        for(int i = 0; i < NBR_ITERATIONS; i++){

            game.deck = new Deck();
            game.checkCount = 0;

            while (game.deck.moreCards()){
                game.checkCount++;
                if(game.checkCount%4 == 0){
                    game.checkCount = 1;
                }
                Card card = game.deck.getCard();
                //w.displayCard(card,1,6);
                //w.displayText(String.valueOf(game.checkCount));
                if(card.getRank() == game.checkCount){
                    game.loseCount++;
                    break;
                }
            }

        }

        game.winCount = NBR_ITERATIONS - game.loseCount;



       // System.out.println("LoseCount :" + game.loseCount);
        System.out.println("WinCount :" + game.winCount);
        System.out.println("Probability :" + game.getProbability(game.winCount));
    }
}
