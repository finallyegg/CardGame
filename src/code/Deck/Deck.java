package code.Deck;

import java.util.ArrayList;
import java.util.Collections;

import code.Deck.Card.*;

public class Deck {
	
	private ArrayList<Card> deck;
	
	public Deck() {
		deck = new ArrayList<Card>();
		
		for(Suits s : Suits.values()) {
			for(Ranks r : Ranks.values()) { 
				Card c = new Card(r, s);
				deck.add(c);
			}
		}
	}
	
	public Card deal() {
		Card c = deck.remove(0);
		return c;
	}
	
	public void removeCard(Card s) {
		int z = 0;
		for(int i = 0; i < deck.size(); i++) {
			if(deck.get(i).getRank().equals(s.getRank())) {
				if(deck.get(i).getSuit().equals(s.getSuit())) {
					z = i;
				}
			}
		}
		deck.remove(z);
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public void reset() {
		deck = new ArrayList<Card>();
		
		for(Suits s : Suits.values()) {
			for(Ranks r : Ranks.values()) { 
				Card c = new Card(r, s);
				deck.add(c);
			}
		}
	}
	
	public int size() {
		int i = 0;
		for(Card z: deck) {
			i++;
		}
		return i;
	}
}
