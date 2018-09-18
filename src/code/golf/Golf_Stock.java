package code.golf;

import java.util.ArrayList;

import code.Deck.Card;

public class Golf_Stock {
	
	private static ArrayList<Card> StockStack; 
	
	public Golf_Stock(ArrayList<Card> Cardlist) {
		Golf_Stock.StockStack = Cardlist;
	}

	public static ArrayList<Card> getStockStack() {
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
