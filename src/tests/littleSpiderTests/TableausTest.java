package tests.littleSpiderTests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import code.Deck.Card;
import code.Deck.Card.Ranks;
import code.Deck.Card.Suits;
import code.littleSpider.Tableaus;

class TableausTest {

	
	@Test
	void testCheckNumber() {
		Card a1 = new Card( Ranks.ACE, Suits.CLUBS);
		Card a2 = new Card( Ranks.FIVE, Suits.CLUBS);
		Card a3 = new Card( Ranks.KING, Suits.DIAMONDS);
		Card a4 = new Card( Ranks.TWO, Suits.CLUBS);
		Card a5 = new Card( Ranks.FIVE, Suits.DIAMONDS);
		Card a6 = new Card( Ranks.ACE, Suits.SPADES);
		
		Tableaus group1 = new Tableaus(a1, a2, a3, a4, a5, a6);
		Card t1 = new Card(Ranks.EIGHT, Suits.CLUBS);
		/*Tested to see if its legal to put a eight on top of a Ace and it returned false which is correct. 
		 */
		boolean k1 = group1.checkNumber(t1);
		assertEquals(k1, false);
		/*Test if the King can be put onto Ace even though the suits are different and it returned true which is correct.
		 */
		Card t2 = new Card(Ranks.KING, Suits.DIAMONDS);
		boolean k2 = group1.checkNumber(t2);
		assertEquals(k2,true);
		/*Test if you can place the same value on top of another card and it returned false which is correct since you can place the same value on top of
		 * each other.
		 */
		Card t3 = new Card(Ranks.ACE, Suits.DIAMONDS);
		boolean k3 = group1.checkNumber(t3);
		assertEquals(k3, false);
		
		
	}
//problems
	@Test
	void testCheckEmpty() {
		Card a1 = new Card( Ranks.ACE, Suits.CLUBS);
		Card a2 = new Card( Ranks.FIVE, Suits.CLUBS);
		Card a3 = new Card( Ranks.KING, Suits.DIAMONDS);
		Card a4 = new Card( Ranks.TWO, Suits.CLUBS);
		Card a5 = new Card( Ranks.FIVE, Suits.DIAMONDS);
		Card a6 = new Card( Ranks.ACE, Suits.SPADES);
		
		Tableaus group1 = new Tableaus(a1, a2, a3, a4, a5, a6);
		boolean a = group1.checkEmpty(group1.getCardSize());
		assertEquals("cardStack is not full",a, false);
		group1.removeCard(a1);
		group1.removeCard(a2);
		group1.removeCard(a3);
		group1.removeCard(a4);
		group1.removeCard(a5);
		group1.removeCard(a6);
		boolean b = group1.checkEmpty(group1.getCardSize());
		
		assertEquals("cardStack is not Empty",b, true );
		
	}
/*Testing if removing the card from the tableaus would change the Tableaus size.
 * 
 */
	@Test
	void testRemoveCard() {
		Card a1 = new Card( Ranks.ACE, Suits.CLUBS);
		Card a2 = new Card( Ranks.FIVE, Suits.CLUBS);
		Card a3 = new Card( Ranks.KING, Suits.DIAMONDS);
		Card a4 = new Card( Ranks.TWO, Suits.CLUBS);
		Card a5 = new Card( Ranks.FIVE, Suits.DIAMONDS);
		Card a6 = new Card( Ranks.ACE, Suits.SPADES);
		/*Tested correctly I removed a card and the tableaus size reduced by one.
		 * 
		 */
		Card a7 = new Card(Ranks.KING, Suits.CLUBS);
		Tableaus group1 = new Tableaus(a1, a2, a3, a4, a5, a6);
		group1.removeCard(a7);
		int t1 = group1.getCardSize();
		assertEquals(t1, 5);
	}
// problems
	@Test
	void testAddCard() {
		Card a1 = new Card( Ranks.FIVE, Suits.CLUBS);
		Card a2 = new Card( Ranks.FIVE, Suits.CLUBS);
		Card a3 = new Card( Ranks.KING, Suits.DIAMONDS);
		Card a4 = new Card( Ranks.TWO, Suits.CLUBS);
		Card a5 = new Card( Ranks.FIVE, Suits.DIAMONDS);
		Card a6 = new Card( Ranks.ACE, Suits.SPADES);
		Tableaus group1 = new Tableaus(a1, a2, a3, a4, a5, a6);
		Tableaus group2 = new Tableaus(a1, a2, a3, a4, a5, a6);
		
		Card test1 = new Card(Ranks.FOUR, Suits.SPADES);
		group2.addCard(test1);
		
		
		assertEquals(group1.getCardSize(), 7);
		
	}
	@Test
	void testTableausSize() {
		Card a1 = new Card( Ranks.ACE, Suits.CLUBS);
		Card a2 = new Card( Ranks.FIVE, Suits.CLUBS);
		Card a3 = new Card( Ranks.KING, Suits.DIAMONDS);
		Card a4 = new Card( Ranks.TWO, Suits.CLUBS);
		Card a5 = new Card( Ranks.FIVE, Suits.DIAMONDS);
		Card a6 = new Card( Ranks.ACE, Suits.SPADES);
	
		Tableaus t1 = new Tableaus(a1, a2, a3, a4, a5, a6);
		assertEquals(t1.getCardSize(), 6);
		
	}

}
