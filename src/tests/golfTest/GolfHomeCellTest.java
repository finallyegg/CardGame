package tests.golfTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Deck.Card;
import code.FinalGolf.Golf_Main;

public class GolfHomeCellTest {
	@Test
	public void test_inital_HomeC() {
		new Golf_Main();
		for (int i = 0; i < 7; i++) {
			assertEquals(0,Golf_Main.getHomeCell().getHomecellstack().size(),0.01);
		}
	}
	
	@Test
	public void golf_addCard_test() {
		Card King = new Card(Card.Ranks.KING,Card.Suits.HEARTS);
		Card Ace = new Card(Card.Ranks.ACE,Card.Suits.CLUBS);
		Card Queen = new Card(Card.Ranks.QUEEN,Card.Suits.SPADES);
		Card Two = new Card(Card.Ranks.TWO,Card.Suits.DIAMONDS);
		
		new Golf_Main();
		Card topCardofStock = Golf_Main.getStockPile().getStockStack().get(0);
		assertTrue(Golf_Main.getHomeCell().addCard(topCardofStock));
		
		new Golf_Main();
		Golf_Main.getHomeCell().getHomecellstack().add(Ace);
		Golf_Main.getTableaus(1).getTablestack().add(0, Two);;
		assertTrue("Fail555",Golf_Main.getHomeCell().addCard(Two));
		assertFalse("Fail555",Golf_Main.getHomeCell().addCard(Queen));
		
		new Golf_Main();
		Golf_Main.getHomeCell().getHomecellstack().add(Ace);
		Golf_Main.getTableaus(1).getTablestack().add(0, King);
		assertTrue("Fail555",Golf_Main.getHomeCell().addCard(King));
	}
	@Test
	public void golf_remove_test() {
		assertFalse(Golf_Main.getHomeCell().RemoveCard(null));

	}
//	Adding card to Golf homecell pile increases its number of cards and results in that card being the homecell pile's new top card
	@Test
	public void golf_addCardIncreaseNumber() {
		new Golf_Main();
		
		assertEquals(0,Golf_Main.getHomeCell().getHomecellstack().size());
		Card topCardofStock = Golf_Main.getStockPile().getStockStack().get(0);
		Golf_Main.getHomeCell().addCard(topCardofStock);
		assertEquals(1,Golf_Main.getHomeCell().getHomecellstack().size());
		assertTrue(topCardofStock.equals(Golf_Main.getHomeCell().getHomecellstack().get(0)));
	}

}
