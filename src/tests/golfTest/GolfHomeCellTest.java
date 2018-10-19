package tests.golfTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Deck.Card;
import code.FinalGolf.Golf_Game;

public class GolfHomeCellTest {
	@Test
	public void test_inital_HomeC() {
		Golf_Game a = new Golf_Game();
		for (int i = 0; i < 7; i++) {
			assertEquals(0,a.getHomeCell().getHomecellstack().size(),0.01);
		}
	}
	
	/**
	 * 
	 */
	@Test
	public void golf_addCard_test() {
//		Create four card
		Card King = new Card(Card.Ranks.KING,Card.Suits.HEARTS);
		Card Ace = new Card(Card.Ranks.ACE,Card.Suits.CLUBS);
		Card Queen = new Card(Card.Ranks.QUEEN,Card.Suits.SPADES);
		Card Two = new Card(Card.Ranks.TWO,Card.Suits.DIAMONDS);
		
//		initialize new Golf Game, find the top card of stock, and test if it legal to add to the homecell pile 
		Golf_Game a = new Golf_Game();
		Card topCardofStock = a.getStockPile().getStockStack().get(0);
		assertTrue(a.getHomeCell().addCard(topCardofStock));
		
//		lets do some cheating and put Ace at top of Homcecell, according to Homecell rule: Two or King should be add legally from Tableaus pile
		Golf_Game b = new Golf_Game();
		b.getHomeCell().getHomecellstack().add(Ace);
		b.getTableaus(1).getTablestack().add(0, Two);;
		assertTrue("Fail555",b.getHomeCell().addCard(Two));
		assertFalse("Fail555",b.getHomeCell().addCard(Queen));
		
//		lets do some cheating and put Ace at top of Homcecell, according to Homecell rule: Two or King should be add legally from Tableaus pile
		Golf_Game c = new Golf_Game();
		c.getHomeCell().getHomecellstack().add(Ace);
		c.getTableaus(1).getTablestack().add(0, King);
		assertTrue("Fail555",c.getHomeCell().addCard(King));
	}
	
//	Can not remmove card from homecell once it finished initize
	@Test
	public void golf_remove_test() {
		Golf_Game a = new Golf_Game();
		assertFalse(a.getHomeCell().RemoveCard(null));

	}
//	Adding card to Golf homecell pile increases its number of cards and results in that card being the homecell pile's new top card
	@Test
	public void golf_addCardIncreaseNumber() {
		Golf_Game a = new Golf_Game();
		
		assertEquals(0,a.getHomeCell().getHomecellstack().size());
		Card topCardofStock = a.getStockPile().getStockStack().get(0);
		a.getHomeCell().addCard(topCardofStock);
		assertEquals(1,a.getHomeCell().getHomecellstack().size());
		assertTrue(topCardofStock.equals(a.getHomeCell().getHomecellstack().get(0)));
	}

}
