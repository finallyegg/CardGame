package code.FinalGolf;

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
	
	public boolean AddCard(Card x) {
		return false;
	}
	
	
}
