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


	/**
	 * @return current list
	 */
	public ArrayList<Card> getTablestack() {
		return Tablestack;
	}

	

}
