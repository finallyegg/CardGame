package tests.golfTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import code.Deck.Card;
import code.Deck.Deck;
import code.FinalGolf.Golf_Game;

public class GolfStockTest {
	// Golf Stack initially holds 17 cards [2 pts]
	@Test
	public void Golf_Test_Inital() {
		Golf_Game a = new Golf_Game();
		assertEquals(17, a.getStockPile().getStockStack().size());
	}
	
//	Cannot add Card to Stock pile once the inizized is finished
	@Test
	public void Golf_Test_addCard() {
		Golf_Game a = new Golf_Game();
		Deck d = new Deck();
		d.shuffle();
		Card x = d.getCards().get(0);
		assertFalse(a.getStockPile().AddCard(x));
	}

//	only top card can be removed
	@Test
	public void Golf_Test_RemoveCard() {
		Golf_Game a = new Golf_Game();
		Card topCard = a.getStockPile().getStockStack().get(0);
		Deck d = new Deck();
		d.removeCard(topCard);
//		looped all other card, should be all false
		for (Card i : d.getCards()) {
			assertFalse(a.getStockPile().RemoveCard(i));
		}

		// * Golf stock pile correctly returns if removing top card is legal or illegal
		// (e.g., if the stock pile is NOT empty) [2 points]
		// since the stock pile now contains 17 cards, we should be able to remove all
		// 17, bc its legal
		Golf_Game b = new Golf_Game();
		for (int i = 0; i < 17; i++) {
			topCard = b.getStockPile().getStockStack().get(0);
			assertTrue(b.getStockPile().RemoveCard(topCard));
		}

		// and the 18th removal should fail bc the pile is empty
		
		    assertFalse(b.getStockPile().RemoveCard(topCard));
			
	}
	
	// * Removing card from Golf's stock pile decreases its number of cards and results in following card being the new top card [2 points
	@Test
	public void Golf_Test_RemoveCard_Size() {
		Golf_Game a = new Golf_Game();
		Card topCard = a.getStockPile().getStockStack().get(0);
		Card SecondCard = a.getStockPile().getStockStack().get(1);
		a.getStockPile().RemoveCard(topCard);
		assertEquals(16, a.getStockPile().getStockStack().size());
		assertTrue(a.getStockPile().getStockStack().get(0) == SecondCard);
	}

}
