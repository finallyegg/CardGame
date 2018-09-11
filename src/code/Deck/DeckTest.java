package code.Deck;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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
		ArrayList<Card> d2 = new ArrayList<Card>();
		System.out.println("Should look random...");
		for(int i = 0 ; i < 52 ; i++) {
			c = d.deal();
			System.out.println(c.getRank() + " " + c.getSuit());
			d2.add(c);
		}
		assertEquals(d2.size() == 52, true);

	}

}
