package code.golf;

import java.util.ArrayList;

import code.Deck.Card;
import code.Deck.Deck;

public class Golf_Homecells {
	
	private ArrayList<Card> Homecellstack;
	
	public Golf_Homecells () {
		Homecellstack = new ArrayList<Card>();
	}
	
	public boolean RemoveCard() {
		return false;
	}
	
	public void addCard () {
		Card top = Golf_Tableaus.getTablestack().get(0);
		ArrayList<Card> optionalChoice = new ArrayList<>();
		Deck deck = new Deck();
		for (Card i : deck.getCards()) {
			if (i.getRank() <= top.getRank()) {
				
			}
		}
	}

	public ArrayList<Card> getHomecellstack() {
		return Homecellstack;
	}

	public void setHomecellstack(ArrayList<Card> homecellstack) {
		Homecellstack = homecellstack;
	}
}
