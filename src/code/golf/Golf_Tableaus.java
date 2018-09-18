package code.golf;

import java.util.ArrayList;

import code.Deck.Card;

public class Golf_Tableaus {
	
	private static ArrayList<Card> Tablestack;
	
	public Golf_Tableaus () {
		Tablestack = new ArrayList<Card>();
	}
	
	public Golf_Tableaus (Card a, Card b, Card c, Card d, Card e) {
		Tablestack = new ArrayList<Card>();
		Tablestack.add(a);
		Tablestack.add(b);
		Tablestack.add(c);
		Tablestack.add(d);
		Tablestack.add(e);
	}
	
	public void RemoveCard () {
		Tablestack.remove(0);
	}
	
	public boolean addCard () {
		return false;
	}

	public boolean addCard (Card c) {
		// need to deal with logic regarding not being
		// allowed to add a card once game is setup
		return Tablestack.add(c);
	}
	
	public static ArrayList<Card> getTablestack() {
		return Tablestack;
	}

	public void setTablestack(ArrayList<Card> tablestack) {
		Tablestack = tablestack;
	}

}
