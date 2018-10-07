package tests.golfTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import code.Deck.Card;
import code.Deck.Deck;
import code.FinalGolf.Golf_Main;

public class GolfTableauTest {
	
//	Test the inital hold 5 cards
	@Test
	public void Golf_InitialHoldTest() {
		new Golf_Main();
		for (int i = 0; i < 7; i++) {
			assertEquals(5,Golf_Main.getTableaus(i).getTablestack().size(),0.01);
		}
	}
	
//	nope, non of these card can be added after the initialization done
	@Test 
	public void Golf_AddCardTest() {
		new Golf_Main();
		for (int i = 0; i < 7; i++) {
			assertFalse(Golf_Main.getTableaus(i).addCard());
		}
	}
	
//	Only topCard can be removed from each pile result to a dreasing in number
	@Test
	public void Golf_RemoveCardTest() {
		new Golf_Main();
		Card topCard = null;
		Card notTopCard = null;
		Deck d = new Deck();
		d.shuffle();
		
		for (int i = 0; i < 7; i++) {
			d.getCards().remove(topCard);
			topCard = Golf_Main.getTableaus(i).getTablestack().get(0);
			assertTrue(Golf_Main.getTableaus(i).RemoveCard(topCard));
			assertEquals(4,Golf_Main.getTableaus(i).getTablestack().size(),0.01);
			notTopCard = d.deal();
			assertFalse(Golf_Main.getTableaus(i).RemoveCard(notTopCard));
		}
		
		//  * Test when Golf_Tableaus is empty
		new Golf_Main();
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 5; j++) {
				topCard = Golf_Main.getTableaus(i).getTablestack().get(0);
				Golf_Main.getTableaus(i).RemoveCard(topCard);
				
			}
		assertFalse(Golf_Main.getTableaus(i).RemoveCard(d.getCards().get(0)));
		}
		
	}
	
//	Only topCard can be removed from each pile result to a dreasing in number
//	The second Card become the top
	@Test
	public void Golf_RemoveCardDecreaseTest() {
		new Golf_Main();
		Card topCard;
		Card secondCard;
		
		for (int i = 0; i < 7; i++) {
			topCard = Golf_Main.getTableaus(i).getTablestack().get(0);
			secondCard = Golf_Main.getTableaus(i).getTablestack().get(1);
			Golf_Main.getTableaus(i).RemoveCard(topCard);
			assertEquals(4,Golf_Main.getTableaus(i).getTablestack().size(),0.01);
			assertTrue(Golf_Main.getTableaus(i).getTablestack().get(0).equals(secondCard));
		}
	}
}
