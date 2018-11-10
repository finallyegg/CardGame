package ThieveGameLogic;

import java.util.ArrayList;
import java.util.Collections;

import ThieveGameLogic.Cards.Ranks;
import ThieveGameLogic.Cards.Suits;





public class Decks {
	
	private ArrayList<Cards> deck;
	/*
	 * This makes a new deck of cards.
	 */
	public Decks() { 
		deck = new ArrayList<Cards>();
		
		for(Suits s : Suits.values()) {
			for(Ranks r : Ranks.values()) { 
				Cards c = new Cards(r, s);
				deck.add(c);
				deck.add(c);
			}
		}
	}
	/*
	 * This removes one card from deck and returns it. 
	 */
	public Cards deal() {
		Collections.shuffle(deck);
		Cards c = deck.remove(0);
		return c;
	}
	/*
	 * This removes a given card from the deck.
	 */
	public Cards removeCard(Cards s) {
		int z = 0;
		for(int i = 0; i < deck.size(); i++) {
			if(deck.get(i).getRank().equals(s.getRank())) {
				if(deck.get(i).getSuit().equals(s.getSuit())) {
					z = i;
				}
			}
		}
		return deck.remove(z);
	}
	

	/*
	 * Shuffles Deck.
	 */
	public void shuffle() {
		Collections.shuffle(deck);
	}
	/*
	 * Resets Deck
	 */
	public void reset() {
		deck = new ArrayList<Cards>();
		/*
		 * Creates card and suit and adds to deck.
		 */
		for(Suits s : Suits.values()) {
			for(Ranks r : Ranks.values()) { 
				Cards c = new Cards(r, s);
				deck.add(c);
			}
		}
		
	}
	/*
	 * Returns current size of deck. 
	 */
	public int size() {
		int i = 0;
		for(Cards z: deck) {
			i++;
		}
		return i;
	}
	
	public ArrayList<Cards> getCards(){
		return this.deck;
	}
}

