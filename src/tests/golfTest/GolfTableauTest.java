package tests.golfTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Deck.Card;
import code.Deck.Deck;
import code.FinalGolf.Golf_Game;

public class GolfTableauTest {
	
//	Test the inital hold 5 cards
	@Test
	public void Golf_InitialHoldTest() {
		Golf_Game a = new Golf_Game();
		for (int i = 0; i < 7; i++) {
			assertEquals(5,a.getTableaus(i).getTablestack().size(),0.01);
		}
	}
	
//	nope, non of these card can be added after the initialization done
	@Test 
	public void Golf_AddCardTest() {
		Golf_Game a = new Golf_Game();
		for (int i = 0; i < 7; i++) {
			assertFalse(a.getTableaus(i).addCard());
		}
	}
	
//	Only topCard can be removed from each pile result to a dreasing in number
	@Test
	public void Golf_RemoveCardTest() {
		Golf_Game a = new Golf_Game();
		Card topCard = null;
		Card notTopCard = null;
		Deck d = new Deck();
		d.shuffle();
		
		for (int i = 0; i < 7; i++) {
			d.getCards().remove(topCard);
			topCard = a.getTableaus(i).getTablestack().get(0);
			assertTrue(a.getTableaus(i).RemoveCard(topCard));
			assertEquals(4,a.getTableaus(i).getTablestack().size(),0.01);
			notTopCard = d.deal();
			assertFalse(a.getTableaus(i).RemoveCard(notTopCard));
		}
		
		//  * Test when Golf_Tableaus is empty
		Golf_Game b = new Golf_Game();
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 5; j++) {
				topCard = b.getTableaus(i).getTablestack().get(0);
				b.getTableaus(i).RemoveCard(topCard);
				
			}
		assertFalse(b.getTableaus(i).RemoveCard(d.getCards().get(0)));
		}
		
	}
	
//	Only topCard can be removed from each pile result to a dreasing in number
//	The second Card become the top
	@Test
	public void Golf_RemoveCardDecreaseTest() {
		Golf_Game a = new Golf_Game();
		Card topCard;
		Card secondCard;
		
		for (int i = 0; i < 7; i++) {
			topCard = a.getTableaus(i).getTablestack().get(0);
			secondCard = a.getTableaus(i).getTablestack().get(1);
			a.getTableaus(i).RemoveCard(topCard);
			assertEquals(4,a.getTableaus(i).getTablestack().size(),0.01);
			assertTrue(a.getTableaus(i).getTablestack().get(0).equals(secondCard));
		}
	}
}
