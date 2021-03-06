package ThieveGameLogic;

import java.util.ArrayList;
import java.util.Collections;

import code.Deck.Card;




public class Tablaeus {
	private ArrayList<Card> cardStack;
//	Card pop = new Card(null,null);
	
	public Tablaeus(ArrayList<Card> lol, Decks q) {
		cardStack = lol;
		cardStack.add(q.deal());
		cardStack.add(q.deal());
		cardStack.add(q.deal());
	
	}
	
	
	/*Checks the card to see if its legal to move it
	*/
	public boolean checkNumber(Card  a) {
		if(cardStack.get(0).value() == 2 && a.value() == 14&&cardStack.get(0).getSuit()==a.getSuit()) {
			return true;
		}
		
		else if(cardStack.get(0).value() -1 == a.value() && (cardStack.isEmpty() == false)&&cardStack.get(0).getSuit()==a.getSuit()) {
			return true;
		}
		else {
		return false;
		}
	}
	
	public boolean checkSuit(Card c) {

		if (cardStack.get(0).getSuit() == c.getSuit()) {
			return true;
		} else {
			return false;
		}

	}
	
	/*
	 * check to see if the Tableaus is empty or not
	 */
	public boolean checkEmpty() {
		if(cardStack == null || cardStack.size() == 0 || cardStack.isEmpty()) {
			return true;
		}
		else {
		return false;
		}
	}
	
	/* 
	 * removes a card if it is legal to move it
	 */
	public boolean removeCard(Card a) {
		if((checkNumber(a) && checkSuit(a) == true) && cardStack.size() >0) {
			cardStack.remove(0);	
			return true;
		}
		return false;
	}
	
	/*
	 * adds a card if it is legal to move it
	 */
	public boolean addCard(Card a, Tablaeus b, Tablaeus c) {
		if(c.checkNumber(a) == true) {
			Collections.reverse(c.getCardStack());
			c.addTest(a);
			Collections.reverse(c.getCardStack());
			b.removeCard(a);
			return true;
		}
		return false;
	}	
	
	public void addToHomecell(Card a, Tablaeus b, thieveCells c) {
		if(c.checkNumber(a) == true) {
			Collections.reverse(c.getHomecellStack());
			c.addCard(a);
			Collections.reverse(c.getHomecellStack());
			b.removeCard(a);
		}
	}
	
		 //returns the amount of cards in the Tableaus
	public Card index(int a) {
		return cardStack.get(a);
		}
		//returns the size of the Tableaus
	public int getCardSize() {
		return cardStack.size();
	}
	//removes the first index
	public void removeTest() {
		cardStack.remove(0);
	}
	//add card without checking
	public void addTest(Card a) {
		cardStack.add(a);
	}
	public void add(Card a, int index) {
		cardStack.add(index, a);
	}
	//getting the card of the first index
	public Card checkFirstIndex(){
		return cardStack.get(0);
	}
	//getting the card stack of the Tableaus
	public ArrayList<Card> getCardStack(){
		return cardStack;
	}
	public Card cardAtIndex(int i) {
		return cardStack.get(i);
	}
	public int getInitialStart() {
		return 6;
	}
}




