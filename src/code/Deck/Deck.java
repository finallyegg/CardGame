/**
 * @author Jake
 *
 */
package code.Deck;

import java.util.ArrayList;
import java.util.Collections;

import code.Deck.Card.*;

public class Deck {
	
	private ArrayList<Card> deck;
	/*
	 * This makes a new deck of cards.
	 */
	public Deck() { 
		deck = new ArrayList<Card>();
		
		for(Suits s : Suits.values()) {
			for(Ranks r : Ranks.values()) { 
				Card c = new Card(r, s);
				deck.add(c);
			}
		}
	}
	/*
	 * This removes one card from deck and returns it. 
	 */
	public Card deal() {
		Collections.shuffle(deck);
		Card c = deck.remove(0);
		return c;
	}
	/*
	 * This removes a given card from the deck.
	 */
	public Card removeCard(Card s) {
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
		deck = new ArrayList<Card>();
		/*
		 * Creates card and suit and adds to deck.
		 */
		for(Suits s : Suits.values()) {
			for(Ranks r : Ranks.values()) { 
				Card c = new Card(r, s);
				deck.add(c);
			}
		}
	}
	/*
	 * Returns current size of deck. 
	 */
	public int size() {
		return deck.size();
//		int i = 0;
//		for(Card z: deck) {
//			i++;
//		}
//		return i;
	}
	
	public ArrayList<Card> getCards(){
		return this.deck;
	}
}
