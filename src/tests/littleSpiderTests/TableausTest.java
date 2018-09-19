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
		
		Tableaus t1 = new Tableaus(a1, a2, a3, a4, a5, a6);
		Card a7 = new Card(Ranks.EIGHT, Suits.CLUBS);
		/*Tested to see if its legal to put a eight on top of a Ace and it returned false which is correct.
		 * 
		 */
		boolean k = t1.checkNumber(a7);
		assertEquals(k, false);
		
		
	}

	@Test
	void testCheckEmpty() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveCard() {
		fail("Not yet implemented");
	}

	@Test
	void testAddCard() {
		fail("Not yet implemented");
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
