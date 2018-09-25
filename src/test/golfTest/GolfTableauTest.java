package test.golfTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import code.Deck.Card;
import code.Deck.Deck;
import code.FinalGolf.Golf_Main;

public class GolfTableauTest {
			
	@Test
	public void Golf_InitialHoldTest() {
		new Golf_Main();
		for (int i = 0; i < 7; i++) {
			assertEquals(5,Golf_Main.getTableaus(i).getTablestack().size(),0.01);
		}
	}
	
	@Test 
	public void Golf_AddCardTest() {
		new Golf_Main();
		for (int i = 0; i < 7; i++) {
			assertFalse(Golf_Main.getTableaus(i).addCard());
		}
	}
	
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
}
