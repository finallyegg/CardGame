package code.golf;

import java.util.ArrayList;

import code.Deck.Card;

public class Golf_Stock {
	
	private ArrayList<Card> StockStack; 
	
	public Golf_Stock(ArrayList<Card> Cardlist) {
		StockStack = Cardlist;
	}

	public ArrayList<Card> getStockStack() {
		return StockStack;
	}

	public void setStockStack(ArrayList<Card> stockStack) {
		StockStack = stockStack;
	}
	
	public Card RemoveCard() {
		return StockStack.remove(0);
	}
	
	public boolean AddCard() {
		return false;
	}
	
	
}
