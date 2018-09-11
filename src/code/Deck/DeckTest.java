package code.Deck;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DeckTest {

	@Test
	void test() {
		Deck d = new Deck();
		Card c = d.deal();
		System.out.println(c.getRank() + " " + c.getSuit());
		assertEquals(c.getRank(), Card.Ranks.TWO);
		assertEquals(c.getSuit(), Card.Suits.SPADES);

		c = d.deal();
		System.out.println(c.getRank() + " " + c.getSuit());
		assertEquals(c.getRank(), Card.Ranks.THREE);
		assertEquals(c.getSuit(), Card.Suits.SPADES);

		d.reset();
		d.shuffle();
		for(int i = 0 ; i < 52 ; i++) {
			c = d.deal();
			System.out.println(c.getRank() + " " + c.getSuit());
		}

	}

}
