package code.littleSpider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import code.Deck.Card;
import code.Deck.Deck;

public class Tableaus {
	
	private ArrayList<Card> cardStack;
	Card pop = new Card(null,null);
	

	
	public Tableaus(ArrayList<Card> lol, Deck d) {
		
		cardStack = lol;
		cardStack.add(d.deal());
		cardStack.add(d.deal());
		cardStack.add(d.deal());
		cardStack.add(d.deal());
		cardStack.add(d.deal());
		cardStack.add(d.deal());
		
		
	}
		
	
	/*Checks the card to see if its legal to move it
	*/
	public boolean checkNumber(Card  a) {
		if(cardStack.get(0).value() == 14 && a.value() == 2) {
			return true;
		}
		
		else if(cardStack.get(0).value() + 1 == a.value() || cardStack.get(0).value() -1 == a.value()) {
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
		if(checkNumber(a) == true && cardStack.size() >0) {
		cardStack.remove(0);		
	}
	}
	/*
	 * adds a card if it is legal to move it
	 */
	public void addCard(Card a, Tableaus b, Tableaus c) {
		
		if(b.checkNumber(a) == true) {
			Collections.reverse(c.getCardStack());
			c.add(a);
			Collections.reverse(c.getCardStack());
			
			b.removeCard(a);
			
		}
		
	}
	
		
		public Card getIndexCard(int a) {
			return cardStack.get(a);
		}
		/*
		 * returns the amount of cards in the Tableaus
		 */
		public Card index(int a) {
			
			return cardStack.get(a);
		}
	
	public int getCardSize() {
		return cardStack.size();
	}
	
	public void removeTest() {
		cardStack.remove(0);
	}
	public void add(Card a) {
		cardStack.add(a);
	}
	
	public Card checkFirstIndex(){
		return cardStack.get(0);
	}
	
	public ArrayList<Card> getCardStack(){
		return cardStack;
	}

}


