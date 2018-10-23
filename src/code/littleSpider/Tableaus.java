package code.littleSpider;
import java.util.ArrayList;
import java.util.Collections;


import code.Deck.Card;
import code.Deck.Deck;

public class Tableaus {
	
	private ArrayList<Card> cardStack;
	Card pop = new Card(null,null);
	Deck d = new Deck();
	
	public Tableaus(ArrayList<Card> lol, Deck q) {
		d = q;
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
		
		else if(cardStack.get(0).value() + 1 == a.value() || cardStack.get(0).value() -1 == a.value() && (cardStack.isEmpty() == false)) {
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
			c.addTest(a);
			Collections.reverse(c.getCardStack());
			b.removeCard(a);
		}
	}	
	
	public void addToHomecell(Card a, Tableaus b, Homecells c) {
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


