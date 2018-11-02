package tests.DeckTests;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import code.Deck.Card;
import code.Deck.Deck;

public class DeckTest {

//	@Test
//	public void test() {
//		Deck d = new Deck();
//		Card c = d.deal();
//		System.out.println(c.getRank() + " " + c.getSuit());
//		assertEquals(c.getRank(), Card.Ranks.TWO);
//		assertEquals(c.getSuit(), Card.Suits.SPADES);
//
//		c = d.deal();
//		System.out.println(c.getRank() + " " + c.getSuit());
//		assertEquals(c.getRank(), Card.Ranks.THREE);
//		assertEquals(c.getSuit(), Card.Suits.SPADES);
//
//		d.reset();
//		d.shuffle();
//		ArrayList<Card> d2 = new ArrayList<Card>();
//		System.out.println("Should look random...");
//		for(int i = 0 ; i < 52 ; i++) {
//			c = d.deal();
//			System.out.println(c.getRank() + " " + c.getSuit());
//			d2.add(c);
//		}
//		assertEquals(d2.size() == 52, true);
//
//	}
	
	@Test
	public void removeCardTest() {
		Deck d = new Deck();
		Card c = new Card(Card.Ranks.ACE, Card.Suits.DIAMONDS);
		d.removeCard(c);
		assertEquals("Testing if Card is removed.", 51, d.size());
	}
	
	@Test
	public void sizeTest() {
		Deck d = new Deck();
		int o = d.size();
		assertEquals("Testing if Size method works", 52, o);
	}

}
