package thieveGameTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Deck.Card;
import code.Deck.Card.Ranks;
import code.Deck.Card.Suits;
import ThieveGameLogic.thieveCells;

public class thieveCellsTest {
	
	Card c1 = new Card(Ranks.ACE, Suits.HEARTS);
	Card c2 = new Card(Ranks.TWO, Suits.HEARTS);
	Card c3 = new Card(Ranks.KING, Suits.DIAMONDS);
	Card c4 = new Card(Ranks.FOUR, Suits.HEARTS);
	
	thieveCells h = new thieveCells(c1);

	@Test
	public void testHomecellInit() {
		assertEquals("Homecell should start with one card.", 1, h.size());
	}
	
	@Test
	public void testHomeCellAdd() {
		assertTrue("Should accept the correct suit (Hearts).", h.checkSuit(c2));
		assertFalse("Should reject the wrong suit (Diamonds)", h.checkSuit(c3));
		
		assertTrue("Should accept a card +1 to the previous card.", h.checkNumber(c2));
		assertFalse("Should reject a card not +1 to previous.", h.checkNumber(c4));	
	}
	
	@Test
	public void testHomeCellRemove() {
		assertFalse("Cannot remove card from Homecell.", h.removeCard());
	}
	
	@Test
	public void testHomeCellAddLogic() {
		h.addCard(c2);
		assertEquals("Homecell should increase by one", 2, h.size());
		assertEquals("The newly added card should be on top.", c2, h.getCard(h.size() - 1));
	}
	
}
