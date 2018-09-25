package tests.littleSpiderTests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import code.Deck.Card;
import code.Deck.Card.Ranks;
import code.Deck.Card.Suits;
import code.Deck.Deck;
import code.littleSpider.Tableaus;

class TableausTest {

	
	@Test
	public void testCheckNumber() {
		Deck op =  new Deck();
		Card a1 = new Card(Ranks.ACE, Suits.CLUBS);
		Card a2 = new Card(Ranks.FIVE, Suits.CLUBS);
		Card a3 = new Card(Ranks.KING, Suits.DIAMONDS);
		Card a4 = new Card(Ranks.TWO, Suits.CLUBS);
		Card a5 = new Card(Ranks.FIVE, Suits.DIAMONDS);
		Card a6 = new Card(Ranks.ACE, Suits.SPADES);
		ArrayList<Card> lol = new ArrayList<>();
		lol.add(a1);
		lol.add(a2);
		lol.add(a3);
		lol.add(a4);
		lol.add(a5);
		lol.add(a6);
		Tableaus group1 = new Tableaus(lol,op);
		Card t1 = new Card(Ranks.EIGHT, Suits.CLUBS);
		/*Tested to see if its legal to put a eight on top of a Ace and it returned false which is correct. 
		 */
		boolean k1 = group1.checkNumber(t1);
		assertEquals(k1, false);
		/*Test if the King can be put onto Ace even though the suits are different and it returned true which is correct.
		 */
		Card t2 = new Card(Ranks.KING, Suits.DIAMONDS);
		boolean k2 = group1.checkNumber(t2);
		assertEquals(k2,true);
		/*Test if you can place the same value on top of another card and it returned false which is correct since you can place the same value on top of
		 * each other.
		 */
		Card t3 = new Card(Ranks.ACE, Suits.DIAMONDS);
		boolean k3 = group1.checkNumber(t3);
		assertEquals(k3, false);
		//fix the 2 exception
		Card t4 = new Card(Ranks.TWO, Suits.SPADES);
		boolean k4 = group1.checkNumber(t4);
		assertEquals(k4,true);
	}
//problems
	@Test
	public void testCheckEmpty() {
		Deck op =  new Deck();
		ArrayList<Card> lol = new ArrayList<>();
		
		Tableaus group1 = new Tableaus(lol, op);
		boolean a = group1.checkEmpty();
		assertEquals("cardStack is not full",a, false);
		
		group1.removeTest();
		group1.removeTest();
		group1.removeTest();
		group1.removeTest();
		group1.removeTest();
		group1.removeTest();
		boolean b = group1.checkEmpty();

		assertEquals("cardStack is not Empty",b, true );
		
	}
/*Testing if it is legal to remove card and check the size if it decreased
 * 
 */
	@Test
	public void testRemoveCard() {
		//since lol has 6 random cards I couldn't test it so I just added 6 cards to test so if it removes it will have a total of 11 cards
		Deck op =  new Deck();
		Card a1 = new Card( Ranks.ACE, Suits.CLUBS);
		Card a2 = new Card( Ranks.FIVE, Suits.CLUBS);
		Card a3 = new Card( Ranks.KING, Suits.DIAMONDS);
		Card a4 = new Card( Ranks.TWO, Suits.CLUBS);
		Card a5 = new Card( Ranks.FIVE, Suits.DIAMONDS);
		Card a6 = new Card( Ranks.ACE, Suits.SPADES);
		ArrayList<Card> lol = new ArrayList<>();
		lol.add(a1);
		lol.add(a2);
		lol.add(a3);
		lol.add(a4);
		lol.add(a5);
		lol.add(a6);
		
		Tableaus group1 = new Tableaus(lol, op);
		Card test1 = new Card(Ranks.KING, Suits.CLUBS);
		group1.removeCard(test1);
		
		
		
			
		assertEquals(group1.getCardSize(), 11);
		
		
		
		
		
	}
// test if it is legal to add the card and check if the size increased
	@Test
	public void testAddCard() {
//since lol has 6 random cards I couldn't test it so I just added 6 cards to test so if it adds it will have a total of 13 cards
		Deck op =  new Deck();
		Card a1 = new Card( Ranks.ACE, Suits.CLUBS);
		Card a2 = new Card( Ranks.FIVE, Suits.CLUBS);
		Card a3 = new Card( Ranks.KING, Suits.DIAMONDS);
		Card a4 = new Card( Ranks.TWO, Suits.CLUBS);
		Card a5 = new Card( Ranks.FIVE, Suits.DIAMONDS);
		Card a6 = new Card( Ranks.ACE, Suits.SPADES);
		ArrayList<Card> lol = new ArrayList<>();
		ArrayList<Card> lol1 = new ArrayList<>();
		lol1.add(a1);
		lol1.add(a2);
		lol1.add(a3);
		lol1.add(a4);
		lol1.add(a5);
		lol1.add(a6);
		lol.add(a1);
		lol.add(a2);
		lol.add(a3);
		lol.add(a4);
		lol.add(a5);
		lol.add(a6);
		Tableaus group1 = new Tableaus(lol, op);
		Tableaus group2 = new Tableaus(lol1, op);
		
		Card test1 = new Card(Ranks.KING, Suits.SPADES);
		group1.addCard(test1, group1, group2);
		
		assertEquals(group2.getCardSize(), 13);
		assertEquals(group1.getCardSize(), 11);
		
	}
	@Test
	public void testTableausSize() {
		Deck op =  new Deck();
		ArrayList<Card> lol = new ArrayList<>();
		

		Tableaus t1 = new Tableaus(lol, op);
		assertEquals(t1.getCardSize(), 6);
		
	}
	@Test
	public void testRemoveTest() {
		Deck op =  new Deck();
		ArrayList<Card> lol = new ArrayList<>();
		Tableaus t1 = new Tableaus(lol, op);
		t1.removeTest();
		assertEquals(t1.getCardSize(), 5);
	}

}
