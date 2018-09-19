package code.littleSpider;
import java.util.ArrayList;

import code.Deck.Card;
import code.Deck.Card.Ranks;
import code.Deck.Card.Suits;

public class Homecells {
	
	Card card = new Card(null, null);
	private ArrayList<Card> cardStack;
	
	public Homecells(Card s) {
		cardStack = new ArrayList<Card>();
		card = s;
	
		cardStack.add(card);
		
	}
	
	//this gets the first card and checks to see if the suits match
	public boolean checkSuit(Card c) {
		
		if(cardStack.get(0).getSuit() == c.getSuit() ) {
			return true;
		}
		else {
			return false;	
		}
		
	}
	//this checks to see if the first card is either 1 or -1 off of the original card. for ex if the index was King it would check if the new card's
	//value is either a queen or a Ace and if it is it will return true
	public boolean checkNumber(Card c) {
		if(cardStack.get(0).value() == 14) {
			if(c.value() == 2) {
				return true;
			}
			else
				return false;
		}
		else if((cardStack.get(0).value() + 1) == c.value() || cardStack.get(0).value() -1 == c.value()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean checkFinished() {
		return false;
	}
	
	public void removeCard() {
		
	}

	public int size() {
		return cardStack.size();
	}
	
	public static void main(String[] args) {
		Card c = new Card(Ranks.ACE, Suits.HEARTS);
		Card c2 = new Card(Ranks.TWO, Suits.HEARTS);
		Card c3 = new Card(Ranks.KING, Suits.CLUBS);
		Homecells h = new Homecells(c);
		System.out.println(h.checkNumber(c2));
		System.out.println(h.checkNumber(c3));
	}
}

