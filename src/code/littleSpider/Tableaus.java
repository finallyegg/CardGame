package code.littleSpider;
import java.util.ArrayList;

import code.Deck.Card;
import code.Deck.Deck;
//I extended the Deck class since I wanted to use the deal() method
public class Tableaus extends Deck{
	
	private ArrayList<Card> cardStack;
	private Card card = new Card(null, null);
	

	/*Should prob change the parameter to an arrayList of cards and initialize it by adding 6 cards to start out with so there you can actually change 
	 * the amount of cards in it when you add and remove cards.
	 * 
	 */
	public Tableaus(ArrayList<Card> lol) {
		cardStack = lol;
		cardStack.add(deal());
		cardStack.add(deal());
		cardStack.add(deal());
		cardStack.add(deal());
		cardStack.add(deal());
		cardStack.add(deal());
		
	}
		
	
	/*Checks the card to see if its legal to move it
	*/
	public boolean checkNumber(Card  a) {
		card = a;
		if(cardStack.get(0).value() + 1 == card.value() || cardStack.get(0).value() -1 == card.value()) {
			return true;
		}
		else {
		return false;
		}
	}
	/*
	 * check to see if the Tableaus is empty or not
	 */
	public boolean checkEmpty() {
		
		if(cardStack.size() == 0) {
			return true;
		}
		else {
		
		return false;
		}
	}
	/* 
	 * removes a card if it is legal to move it
	 */
	public void removeCard(Card a) {
		if(checkNumber(a) == true) {
		cardStack.remove(0);		
	}
	}
	/*
	 * adds a card if it is legal to move it
	 */
	public void addCard(Card a) {
		
		if(checkNumber(a) == true) {
			cardStack.add(a);
		}
		
		/*
		 * returns the amount of cards in the Tableaus
		 */
	}
	public int getCardSize() {
		return cardStack.size();
	}
	public void removeTest() {
		cardStack.remove(0);
	}

}


