package test.golfTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Deck.Card;
import code.Deck.Deck;
import code.FinalGolf.Golf_Main;

public class GolfStockTest {
	@Test
	public void Golf_Test_Inital() {
		new Golf_Main();
		assertEquals(17,Golf_Main.getStockPile().getStockStack().size(),0.01);
	}
	
	@Test
	public void Golf_Test_addCard() {
		Deck d = new Deck();
		d.shuffle();
		Card x = d.getCards().get(0);
		assertFalse(Golf_Main.getStockPile().AddCard(x));
	}
	
	@Test
	public void Golf_Test_RemoveCard() {
		new Golf_Main();
		Card topCard = Golf_Main.getStockPile().getStockStack().get(0);
		Deck d = new Deck();
		d.removeCard(topCard);
		for (Card i : d.getCards()) {
			assertFalse(Golf_Main.getStockPile().RemoveCard(i));
		}
	}
	
	@Test
	public void Golf_Test_RemoveCard_Size() {
		new Golf_Main();
		Card topCard = Golf_Main.getStockPile().getStockStack().get(0);
		Card SecondCard = Golf_Main.getStockPile().getStockStack().get(1);
		Golf_Main.getStockPile().RemoveCard(topCard);
		assertEquals(16,Golf_Main.getStockPile().getStockStack().size(),0.01);
		assertTrue(Golf_Main.getStockPile().getStockStack().get(0)==SecondCard);
	}

}
