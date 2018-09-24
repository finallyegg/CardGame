package test.golfTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Deck.Card;
import code.golf.ProGolf;

public class GolfHomeCellTest {
	@Test
	public void test_inital_HomeC() {
		new ProGolf();
		for (int i = 0; i < 7; i++) {
			assertEquals(0,ProGolf.getHomeCell().getHomecellstack().size(),0.01);
		}
	}
	
	@Test
	public void golf_addCard_test() {
		Card King = new Card(Card.Ranks.KING,Card.Suits.HEARTS);
		Card Ace = new Card(Card.Ranks.ACE,Card.Suits.CLUBS);
		Card Queen = new Card(Card.Ranks.QUEEN,Card.Suits.SPADES);
		Card Two = new Card(Card.Ranks.TWO,Card.Suits.DIAMONDS);
		
		new ProGolf();
		Card topCardofStock = ProGolf.getStockPile().getStockStack().get(0);
		assertTrue(ProGolf.getHomeCell().addCard(topCardofStock));
		
		new ProGolf();
		ProGolf.getHomeCell().getHomecellstack().add(Ace);
		ProGolf.getTableaus(1).getTablestack().add(0, Two);;
		assertTrue("Fail555",ProGolf.getHomeCell().addCard(Two));
		assertFalse("Fail555",ProGolf.getHomeCell().addCard(Queen));
		
		new ProGolf();
		ProGolf.getHomeCell().getHomecellstack().add(Ace);
		ProGolf.getTableaus(1).getTablestack().add(0, King);
		assertTrue("Fail555",ProGolf.getHomeCell().addCard(King));
	}
	@Test
	public void golf_remove_test() {
		assertFalse(ProGolf.getHomeCell().RemoveCard(null));

	}
//	Adding card to Golf homecell pile increases its number of cards and results in that card being the homecell pile's new top card
	@Test
	public void golf_addCardIncreaseNumber() {
		new ProGolf();
		
		assertEquals(0,ProGolf.getHomeCell().getHomecellstack().size());
		Card topCardofStock = ProGolf.getStockPile().getStockStack().get(0);
		ProGolf.getHomeCell().addCard(topCardofStock);
		assertEquals(1,ProGolf.getHomeCell().getHomecellstack().size());
		assertTrue(topCardofStock.equals(ProGolf.getHomeCell().getHomecellstack().get(0)));
	}

}
