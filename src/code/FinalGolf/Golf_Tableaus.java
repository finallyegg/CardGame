package code.FinalGolf;

import java.util.ArrayList;

import code.Deck.Card;

public class Golf_Tableaus {
	
	/**
	 *  Only one field ! -- Card Stack
	 */
	final private ArrayList<Card> Tablestack;
	
	public Golf_Tableaus () {
		Tablestack = new ArrayList<Card>();
	}
	
//	public Golf_Tableaus (Card a, Card b, Card c, Card d, Card e) {
//		Tablestack = new ArrayList<Card>();
//		Tablestack.add(a);
//		Tablestack.add(b);
//		Tablestack.add(c);
//		Tablestack.add(d);
//		Tablestack.add(e);
//	}
	
	/**
	 * @param i
	 * @return check if the Card is the top of the card stack
	 */
	public boolean RemoveCard (Card i) {
		if (this.Tablestack.isEmpty() == true) {
			return false;
		}
		if (i.equals(Tablestack.get(0))){
			Tablestack.remove(0);
			return true;
		}
		
		return false;
	}
	
	/**
	 * @return Nope, you can not add card once initialzation finished
	 */
	public boolean addCard () {
		return false;
	}

//	public boolean addCard (Card c) {
//		// need to deal with logic regarding not being
//		// allowed to add a card once game is setup
//		return Tablestack.add(c);
//	}
	
	/**
	 * @return current list
	 */
	public ArrayList<Card> getTablestack() {
		return Tablestack;
	}

	

}
