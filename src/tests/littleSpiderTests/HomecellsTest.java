package tests.littleSpiderTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import code.Deck.Card;
import code.Deck.Card.Ranks;
import code.Deck.Card.Suits;
import code.littleSpider.Homecells;

public class HomecellsTest {

	Card c1 = new Card(Ranks.ACE, Suits.HEARTS);
	Card c2 = new Card(Ranks.TWO, Suits.HEARTS);
	Card c3 = new Card(Ranks.KING, Suits.DIAMONDS);
	Card c4 = new Card(Ranks.FIVE, Suits.SPADES);
	Card c5 = new Card(Ranks.JACK, Suits.CLUBS);
	Card c6 = new Card(Ranks.ACE, Suits.SPADES);
	Card c7 = new Card(Ranks.ACE, Suits.CLUBS);
	Card c8 = new Card(Ranks.KING, Suits.DIAMONDS);
	Card c9 = new Card(Ranks.KING, Suits.HEARTS);
	Card c10 = new Card(Ranks.ACE, Suits.DIAMONDS);
	Card c11 = new Card(Ranks.KING, Suits.SPADES);
	Card c12 = new Card(Ranks.KING, Suits.CLUBS);
	
	Homecells h = new Homecells(c1);
	Homecells h2 = new Homecells(c10);
	Homecells h3 = new Homecells(c11);
	Homecells h4 = new Homecells(c12);
	
	@Test
	public void testInitialSetup() {
		assertEquals(1, h.size());
	}
	
	@Test
	public void testCheckSuit() {
		boolean b1 = h.checkSuit(c2);
		boolean b2 = h.checkSuit(c3);
		boolean b3 = h.checkSuit(c4);
		boolean b4 = h.checkSuit(c5);
		assertTrue(b1);
		assertFalse(b2);
		assertFalse(b3);
		assertFalse(b4);
	}

	@Test
	public void testCheckNumber() {
		boolean b1 = h.checkNumber(c2);
		boolean b2 = h.checkNumber(c3);
		boolean b3 = h.checkNumber(c7);
		assertTrue(b1);
		assertFalse(b2);
		assertFalse(b3);
	}

	@Test
	public void testCheckFinished() {
		
	}

	@Test
	public void testRemoveCard() {
		
	}

}
