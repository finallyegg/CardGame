package ThieveGameLogic;



/*
 * Enum create card
 */
public class Cards {
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
		
	private Ranks myranks;
	private Suits mysuits;
	/*
	 * constructor creates card for given rank/suite pass to constructor 
	 */
	public Cards(Ranks r, Suits s) {
		myranks = r;
		mysuits = s;
	}
	
	/*
	 *  gets rank
	 */
	public Ranks getRank() {
		return myranks;
	}
	/*
	 * gets suit 
	 */
	public Suits getSuit() {
		return mysuits;
	}
	
	/* this returns the numeric value of the card
	 * 
	 * @param nothing
	 * @returns integer value of card
	 */
	public int value() {
		return myranks.ordinal() + 2;
	}
	public String toString() {
		return this.myranks.toString() + " " + this.mysuits.toString();
	}
}

