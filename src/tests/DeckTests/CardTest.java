package tests.DeckTests;



import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.Deck.Card;

public class CardTest {


	
	@Test
	public void test_card() {
		Card c = new Card(Card.Ranks.TWO, Card.Suits.CLUBS);
		assertEquals(c.value() == 2, true);
		assertEquals(c.getRank() == Card.Ranks.TWO, true);
		
		c = new Card(Card.Ranks.ACE, Card.Suits.CLUBS);
		assertEquals(c.value() == 14, true);
		assertEquals(c.getSuit() == Card.Suits.CLUBS, true);
	}

}
