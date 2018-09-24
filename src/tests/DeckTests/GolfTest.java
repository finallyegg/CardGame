package tests.DeckTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import code.Deck.Card;
import code.golf.Golf;
import code.golf.Golf_Stock;
import code.golf.ProGolf;

class GolfTest {

	@Test
	void test() {
		Golf g = new Golf();
		//ProGolf g = new ProGolf();

		
		// Adding card to Golf homecell pile increases its number of cards and results in that card being the homecell pile's new top card [4 points]
		Card c = new Card(Card.Ranks.ACE, Card.Suits.CLUBS);
		assertEquals(g.getHomeCell().getHomecellstack().size(), 0);
		g.getHomeCell().addCard(c);
		assertEquals(g.getHomeCell().getHomecellstack().size(), 1);

		Card c2 = g.getHomeCell().getHomecellstack().get(0);
		assertEquals(c2.getRank() == Card.Ranks.ACE, true);
		assertEquals(c2.getSuit() == Card.Suits.CLUBS, true);

		
		// Golf Stack initially holds 17 cards [2 pts]
		assertEquals(g.getStockPile().getStockStack().size(), 52-7*5);
		
		// * Golf stock pile correctly returns if adding a specific card is legal or illegal (e.g., the method should always return false) [2 points]
		assertEquals(g.getStockPile().AddCard(), false);

		
		// * Removing card from Golf's stock pile decreases its number of cards and results in following card being the new top card [2 points

		c = g.getStockPile().RemoveCard();
		assertEquals(g.getStockPile().getStockStack().size(), 16);
		

		// * Golf stock pile correctly returns if removing top card is legal or illegal (e.g., if the stock pile is NOT empty) [2 points]
		// since the stock pile now contains 16 cards, we should be able to remove all 16, bc its legal
		for (int i = 0 ; i < 16 ; i++) {
			c = g.getStockPile().RemoveCard();
			assertEquals(c != null, true);
		}
		
		// and the 17th removal should fail bc the pile is empty
		try {
			c = g.getStockPile().RemoveCard();
			fail("should not get here bc of exception");
		}
		catch (IndexOutOfBoundsException e) {
			// this is the expected behavior
		}
			
	}

}