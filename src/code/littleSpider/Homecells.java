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
	
	public boolean checkSuit() {
		return false;
	}
	
	public boolean checkNumber() {
		return false;
	}
	
	public boolean checkFinished() {
		return false;
	}
	
	public void removeCard() {
		
	}

}
