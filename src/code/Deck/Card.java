package code.Deck;

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
	
	public Card(Ranks r, Suits s) {
		myrank = r;
		mysuit = s;
	}
	
	public Ranks getRank() {
		return myrank;
	}
	
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
}
