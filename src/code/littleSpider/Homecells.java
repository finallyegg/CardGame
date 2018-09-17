package code.littleSpider;
import java.util.ArrayList;

import code.Deck.Card;

public class Homecells {
	
	private Card card = new Card(null, null);
	private ArrayList<Card> cardStack;
	
	public Homecells(Card s) {
		card = s;
	
		cardStack.add(s);
		
	}
	
	//this gets the first card and checks to see if the suits match
	public boolean checkSuit() {
		
		if(cardStack.get(0).getSuit() == card.getSuit() ) {
			return true;
		}
		else {
			return false;	
		}
		
	}
	//this checks to see if the first card is either 1 or -1 off of the original card. for ex if the index was King it would check if the new card's
	//value is either a queen or a Ace and if it is it will return true
	public boolean checkNumber() {
		if(cardStack.get(0).value() + 1 == card.value() || cardStack.get(0).value() -1 == card.value()) {
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

}

