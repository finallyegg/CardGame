package test.golfTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import code.Deck.Card;
import code.Deck.Deck;
import code.golf.ProGolf;

public class GolfTableauTest {
			
	@Test
	public void Golf_InitialHoldTest() {
		new ProGolf();
		for (int i = 0; i < 7; i++) {
			assertEquals(5,ProGolf.getTableaus(i).getTablestack().size(),0.01);
		}
	}
	
	@Test 
	public void Golf_AddCardTest() {
		new ProGolf();
		for (int i = 0; i < 7; i++) {
			assertFalse(ProGolf.getTableaus(i).addCard());
		}
	}
	
	@Test
	public void Golf_RemoveCardTest() {
		new ProGolf();
		Card topCard = null;
		Card notTopCard = null;
		Deck d = new Deck();
		d.shuffle();
		
		for (int i = 0; i < 7; i++) {
			d.getCards().remove(topCard);
			topCard = ProGolf.getTableaus(i).getTablestack().get(0);
			assertTrue(ProGolf.getTableaus(i).RemoveCard(topCard));
			notTopCard = d.deal();
			assertFalse(ProGolf.getTableaus(i).RemoveCard(notTopCard));
		}
		
		//  * Test when Golf_Tableaus is empty
		new ProGolf();
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 5; j++) {
				topCard = ProGolf.getTableaus(i).getTablestack().get(0);
				ProGolf.getTableaus(i).RemoveCard(topCard);
				
			}
		assertFalse(ProGolf.getTableaus(i).RemoveCard(d.getCards().get(0)));
		}
		
	}
}
