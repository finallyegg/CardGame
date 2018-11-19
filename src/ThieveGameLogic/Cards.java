//package ThieveGameLogic;
//
//
//
///*
// * Enum create card
// */
//public class Cards {
//	public enum TSuits {
//		SPADES,
//		CLUBS,
//		DIAMONDS,
//		HEARTS;
//	}
//	
//	public enum TRanks {
//		TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN,	
//		JACK, QUEEN, KING, ACE;
//	}
//		
//	private TRanks myranks;
//	private TSuits mysuits;
//	/*
//	 * constructor creates card for given rank/suite pass to constructor 
//	 */
//	
//	 
//	
//	public Cards(TRanks ace, TSuits hearts) {
//		myranks = ace;
//		mysuits = hearts;
//	}
//
//
//	/*
//	 *  gets rank
//	 */
//	public TRanks getRank() {
//		return myranks;
//	}
//	/*
//	 * gets suit 
//	 */
//	public TSuits getSuit() {
//		return mysuits;
//	}
//	
//	/* this returns the numeric value of the card
//	 * 
//	 * @param nothing
//	 * @returns integer value of card
//	 */
//	public int value() {
//		return myranks.ordinal() + 2;
//	}
//	public String toString() {
//		return this.myranks.toString() + " " + this.mysuits.toString();
//	}
//}
//
