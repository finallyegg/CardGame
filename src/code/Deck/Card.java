/**
 * @author Jake
 *
 */
package code.Deck;
/*
 * Enum create card
 */
public class Card {
	public enum Suits {
		SPADES,
		CLUBS,
		DIAMONDS,
		HEARTS;
	}
	
	public enum Ranks {
		TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN,	
		JACK, QUEEN, KING, ACE;
	}
		
	private Ranks myrank;
	private Suits mysuit;
	/*
	 * constructor creates card for given rank/suite pass to constructor 
	 */
	public Card(Ranks r, Suits s) {
		myrank = r;
		mysuit = s;
	}
	/*
	 *  gets rank
	 */
	public Ranks getRank() {
		return myrank;
	}
	/*
	 * gets suit 
	 */
	public Suits getSuit() {
		return mysuit;
	}
	
	/* this returns the numeric value of the card
	 * 
	 * @param nothing
	 * @returns integer value of card
	 */
	public int value() {
		return myrank.ordinal() + 2;
	}
	public String toString() {
		return this.myrank.toString() + " " + this.mysuit.toString();
	}
}
