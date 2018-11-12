package ThieveGameLogic;

import java.util.ArrayList;
import java.util.Collections;


import ThieveGameLogic.TCards.TRanks;
import ThieveGameLogic.TCards.TSuits;





public class Decks {
	
	private ArrayList<TCards> deck;
	/*
	 * This makes a new deck of cards. adds twice the amount of cards
	 */
	public Decks() { 
		deck = new ArrayList<TCards>();
		
		for(TSuits s : TSuits.values()) {
			for(TRanks r : TRanks.values()) { 
				TCards c = new TCards(r, s);
				deck.add(c);
				deck.add(c);
			}
		}
	}
	/*
	 * This removes one card from deck and returns it. 
	 */
	public TCards deal() {
		Collections.shuffle(deck);
		TCards c = deck.remove(0);
		return c;
	}
	/*
	 * This removes a given card from the deck.
	 */
	public TCards removeCard(TCards s) {
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
		deck = new ArrayList<TCards>();
		/*
		 * Creates card and suit and adds to deck.
		 */
		for(TSuits s : TSuits.values()) {
			for(TRanks r : TRanks.values()) { 
				TCards c = new TCards(r, s);
				deck.add(c);
			}
		}
		
	}
	/*
	 * Returns current size of deck. 
	 */
	public int size() {
		int i = 0;
		for(TCards z: deck) {
			i++;
		}
		return i;
	}
	
	public ArrayList<TCards> getCards(){
		return this.deck;
	}
}

