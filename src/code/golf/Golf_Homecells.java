package code.golf;

import java.util.ArrayList;

import code.Deck.Card;

public class Golf_Homecells {
	
	private ArrayList<Card> Homecellstack;
	
	public Golf_Homecells () {
		Homecellstack = new ArrayList<Card>();
		
	}
	
	public boolean RemoveCard() {
		return false;
	}
	
	public void addCard (Card x) {
		Card top = Golf_Tableaus.getTablestack().get(0);
		ArrayList<Card> optionalChoice = new ArrayList<>();
		for (Card i : Golf.getAllTableausCard()) {
			if (Math.abs(i.value() - top.value()) == 1) {
				optionalChoice.add(i);
			}
		}
		for (Card i : Golf_Stock.getStockStack()) {
			optionalChoice.add(i);
		}
		if (optionalChoice.contains(x)) {
			Homecellstack.add(x);
		}
	}

	public ArrayList<Card> getHomecellstack() {
		return Homecellstack;
	}

	public void setHomecellstack(ArrayList<Card> homecellstack) {
		Homecellstack = homecellstack;
	}
}
