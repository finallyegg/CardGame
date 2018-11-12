package ThieveGameLogic;

import java.util.ArrayList;
import java.util.Collections;




public class Tablaeus {
	private ArrayList<TCards> cardStack;
	TCards pop = new TCards(null,null);
	Decks d = new Decks();
	
	public Tablaeus(ArrayList<TCards> lol, Decks q) {
		d = q;
		cardStack = lol;
		cardStack.add(d.deal());
		cardStack.add(d.deal());
		cardStack.add(d.deal());
	
	}
	
	
	/*Checks the card to see if its legal to move it
	*/
	public boolean checkNumber(TCards  a) {
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
	public void removeCard(TCards a) {
		if(checkNumber(a) == true && cardStack.size() >0) {
		cardStack.remove(0);		
	}
	}
	
	/*
	 * adds a card if it is legal to move it
	 */
	public void addCard(TCards a, Tablaeus b, Tablaeus c) {
		if(b.checkNumber(a) == true) {
			Collections.reverse(c.getCardStack());
			c.addTest(a);
			Collections.reverse(c.getCardStack());
			b.removeCard(a);
		}
	}	
	
	public void addToHomecell(TCards a, Tablaeus b, thieveCells c) {
		if(c.checkNumber(a) == true) {
			Collections.reverse(c.getHomecellStack());
			c.addCard(a);
			Collections.reverse(c.getHomecellStack());
			b.removeCard(a);
		}
	}
	
		 //returns the amount of cards in the Tableaus
	public TCards index(int a) {
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
	public void addTest(TCards a) {
		cardStack.add(a);
	}
	public void add(TCards a, int index) {
		cardStack.add(index, a);
	}
	//getting the card of the first index
	public TCards checkFirstIndex(){
		return cardStack.get(0);
	}
	//getting the card stack of the Tableaus
	public ArrayList<TCards> getCardStack(){
		return cardStack;
	}
	public TCards cardAtIndex(int i) {
		return cardStack.get(i);
	}
	public int getInitialStart() {
		return 6;
	}
}




