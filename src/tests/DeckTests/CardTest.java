package tests.DeckTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import code.Deck.Card;
import code.Deck.Card.Ranks;
import code.Deck.Card.Suits;

class CardTest {


	
	@Test
	void test_card() {
		Card c = new Card(Card.Ranks.TWO, Card.Suits.CLUBS);
		assertEquals(c.value() == 2, true);
		assertEquals(c.getRank() == Card.Ranks.TWO, true);
		
		c = new Card(Card.Ranks.ACE, Card.Suits.CLUBS);
		assertEquals(c.value() == 14, true);
		assertEquals(c.getSuit() == Card.Suits.CLUBS, true);
	}

}
