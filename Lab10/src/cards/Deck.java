package cards;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Deck {

	private ArrayList<Card> cards;
	private Iterator<Card> cardIterator;

	/** Skapar en blandad kortlek med 52 kort.
	 ** Creates a mixed deck of 52 cards. */
	public Deck() {
		cards = new ArrayList<Card>();
		for(int suit = 0; suit < 4; suit++){
			for(int rank = 1; rank <= 13; rank++ ){
				cards.add(new Card(suit, rank));
			}
		}
		cardIterator = cards.iterator();
		shuffle(cards);
	}
	private void shuffle(ArrayList<Card> cards){
		Random r = new Random();
		for(int i = cards.size()-1; i > 0; i--){
			int rIndex = r.nextInt(i+1);

			/** swap */
			Card temp = cards.get(i);
			cards.set(i,cards.get(rIndex));
			cards.set(rIndex, temp);
		}
	}
	
	/** Drar det översta kortet i kortleken.
	 ** Pull(뽑다) the top card in the deck.  */
	public Card getCard() {
		return cardIterator.next();
	}
	
	/** Undersöker om det finns fler kort i kortleken.
	 ** Search if there are more cards in the deck. */
	public boolean moreCards() {
		return cardIterator.hasNext();
	}

}
