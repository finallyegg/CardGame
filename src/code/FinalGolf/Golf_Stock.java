package code.FinalGolf;

import java.util.ArrayList;

import code.Deck.Card;

public class Golf_Stock {
	
	/**
	 *  Card stack
	 */
	private ArrayList<Card> StockStack; 
	
	/**
	 * @param contstructor takes the rest cards as a list, store in field.
	 */
	public Golf_Stock(ArrayList<Card> Cardlist) {
		StockStack = Cardlist;
	}

	/**
	 * @return get stock card stack
	 */
	public ArrayList<Card> getStockStack() {
		return StockStack;
	}

	
	/**
	 * @param x
	 * @return check if the stack is empty and card is the top one
	 */
	public boolean RemoveCard(Card x) {
		if(this.StockStack.isEmpty()) {
			return false;
		}
		else if (this.StockStack.get(0).equals(x)) {
			this.StockStack.remove(0);
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * @param x
	 * @return Nope, you can not
	 */
	public boolean AddCard(Card x) {
		return false;
	}
	
	
}
