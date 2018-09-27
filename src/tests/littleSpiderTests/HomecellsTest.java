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
		assertEquals("Tests that a homecell starts with one card", 1, h.size());
	}
	
	@Test
	public void testCheckSuit() {
		assertTrue("Comparing the correct suit", h.checkSuit(c2));
		assertFalse("Checking a different suit 1", h.checkSuit(c3));
		assertFalse("Checking a different suit 2", h.checkSuit(c4));
		assertFalse("Checking a different suit 3", h.checkSuit(c5));
	}

	@Test
	public void testCheckNumber() {
		assertTrue("Comparing a working number", h.checkNumber(c2));
		assertFalse("Comparing a wrong number", h.checkNumber(c3));
		assertFalse("Comparing the same number", h.checkNumber(c7));
	}

	@Test
	public void testCheckFinished() {
		h.alwaysAddCard(c9);
		h4.alwaysAddCard(c7);
		assertTrue("Testing a homecell starting with Ace of Hearts", h.checkFinished());
		assertTrue("Testing a homecell starting with King of Clubs", h4.checkFinished());
		assertFalse("Testing that it correctly identifies an incomplete homecell", h2.checkFinished());
	}

	@Test
	public void testRemoveCard() {
		Homecells h5 = new Homecells(c1);
		h5.removeCard();
		assertEquals("Testing that the first card can't be removed", 1, h5.size());
		h5.addCard(c2);
		Card c = h5.getCard(0);
		h5.removeCard();
		assertEquals("Testing that a card was removed", 1, h5.size());
		assertEquals("Testing that the top card was the one removed", c, h5.getCard(0));
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
		
	}
	
	@Test
	public void testCheckMoveToTableau() {
		Deck qwe = new Deck();
		Card c = new Card(Ranks.SIX, Suits.DIAMONDS);
		Card c2 = new Card(Ranks.SEVEN, Suits.DIAMONDS);
		Card c3 = new Card(Ranks.SIX, Suits.CLUBS);
		ArrayList<Card> a = new ArrayList<Card>();
		ArrayList<Card> a1 = new ArrayList<Card>();
		a.add(c);
		a1.add(c3);
		Homecells h6 = new Homecells(c);
		Tableaus t = new Tableaus(a,qwe);
		Tableaus t1 = new Tableaus(a1,qwe);
		assertFalse("Testing that the bottom card can't be removed", h6.checkMoveToTableau(t));
		h6.addCard(c2);
		assertTrue("Testing that the card can move if valid (a lower number)", h6.checkMoveToTableau(t));
		assertTrue("Testing that the card can move if valid (a higher number and different suit)", h6.checkMoveToTableau(t1));
	}

}
