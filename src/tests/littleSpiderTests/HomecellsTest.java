package tests.littleSpiderTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import code.Deck.Card;
import code.Deck.Card.Ranks;
import code.Deck.Card.Suits;
import code.Deck.Deck;
import code.littleSpider.Homecells;
import code.littleSpider.Tableaus;

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
		assertEquals("Homecell should start with one card.", 1, h.size());
	}
	
	@Test
	public void testCheckSuit() {
		assertTrue("Should accept the correct suit (Hearts).", h.checkSuit(c2));
		assertFalse("Should reject the wrong suit (Diamonds)", h.checkSuit(c3));
		assertFalse("Should reject the wrong suit (Spades)", h.checkSuit(c4));
		assertFalse("Should reject the wrong suit (Clubs)", h.checkSuit(c5));
	}

	@Test
	public void testCheckNumber() {
		Homecells h10 = new Homecells(c1);
		Homecells h11 = new Homecells(c11);
		Card two = new Card(Ranks.TWO, Suits.SPADES);
		assertTrue("Homecell should accept a number that is +1 to initial card.(Starting with an A)", h10.checkNumber(c2));
		h10.addCard(c2);
		assertTrue("Homecell should accept a number that is +1 to previous.(Starting with an A)", h10.checkNumber(c2));
		assertFalse("Homecell shouldn't accept a number not +1.(Starting with an A)", h10.checkNumber(c3));
		assertFalse("Homecell shouldn't accept a number that is the same.(Starting with an A)", h10.checkNumber(two));
		
		Card queen = new Card(Ranks.QUEEN, Suits.SPADES);
		Card jack = new Card(Ranks.JACK, Suits.SPADES);
		assertTrue("Homecell should accept a number that is -1 to initial card.(Starting with an K)", h11.checkNumber(queen));
		h11.alwaysAddCard(queen);
		assertTrue("Homecell should accept a number that is +1 to previous. (Starting with an K)", h11.checkNumber(jack));
		assertFalse("Homecell shouldn't accept a number not +1/-1. (Starting with an K)", h11.checkNumber(c4));
		assertFalse("Homecell shouldn't accept a number that is the same. (Starting with an K)", h11.checkNumber(c2));
	}

	@Test
	public void testCheckFinished() {
		h.alwaysAddCard(c9);
		h4.alwaysAddCard(c7);
		assertTrue("Should return true if game starts with an Ace of 'Suit' and ends with King of same 'Suit'", h.checkFinished());
		assertTrue("Should return true if game starts with an King of 'Suit' and ends with Ace of same 'Suit'", h4.checkFinished());
		assertFalse("Testing that it correctly identifies an incomplete homecell", h2.checkFinished());
	}

	@Test
	public void testRemoveCard() {
		Homecells h5 = new Homecells(c1);
		h5.removeCard();
		assertEquals("First card should stay", 1, h5.size());
		h5.addCard(c2);
		Card c = h5.getCard(0);
		h5.removeCard();
		assertEquals("Size should decrease by one", 1, h5.size());
		assertEquals("The previous card should now be the first one", c, h5.getCard(0));
	}
	
	@Test
	public void testAddCard() {
		Homecells h7 = new Homecells(c1);
		Card c = new Card(Ranks.TWO, Suits.DIAMONDS);
		Card cp = new Card(Ranks.THREE, Suits.HEARTS);
		Card cq = new Card(Ranks.TWO, Suits.HEARTS);
		assertFalse("Testing a the wrong suit", h7.addCard(c));
		assertFalse("Testing a the wrong number", h7.addCard(cp));
		assertTrue("Testing a correct card", h7.addCard(cq));
		assertEquals("The top card should now be the newly added one", cq, h7.getCard(h7.size() - 1));
		assertEquals("Homecell should increase in size by 1", 2, h7.size());
	}
	
	@Test
	public void testCheckMoveToTableau() {
		Deck qwe = new Deck();
		Card ca = new Card(Ranks.SIX, Suits.DIAMONDS);
		Card cb = new Card(Ranks.SEVEN, Suits.DIAMONDS);
		Card cc = new Card(Ranks.SIX, Suits.CLUBS);
		ArrayList<Card> a = new ArrayList<Card>();
		ArrayList<Card> a1 = new ArrayList<Card>();
		Homecells h6 = new Homecells(ca);
		Tableaus t = new Tableaus(a,qwe);
		Tableaus t1 = new Tableaus(a1,qwe);
		a.add(0, ca);
		a1.add(0, cc);
		assertFalse("Testing that the bottom card can't be removed", h6.checkMoveToTableau(t));
		h6.alwaysAddCard(cb);
		assertTrue("Testing that the card can move if valid (a lower number and same suit)", h6.checkMoveToTableau(t));
		assertTrue("Testing that the card can move if valid (a higher number and different suit)", h6.checkMoveToTableau(t1));
	}

}
