package thieveGameTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import ThieveGameLogic.Decks;
import ThieveGameLogic.Tablaeus;
import code.Deck.Card;
import code.Deck.Card.Ranks;
import code.Deck.Card.Suits;

public class TablaeusTest {
	
	ArrayList<Card> a = new ArrayList<>();
	ArrayList<Card> a2 = new ArrayList<>();
	ArrayList<Card> a3 = new ArrayList<>();
	
	Decks d =  new Decks();
	
	Card c = new Card(Ranks.THREE, Suits.CLUBS);
	Card c2 = new Card(Ranks.TWO, Suits.CLUBS);
	Card c3 = new Card(Ranks.ACE, Suits.DIAMONDS);
	Card c4 = new Card(Ranks.FOUR, Suits.DIAMONDS);
	Card c5 = new Card(Ranks.FIVE, Suits.HEARTS);
	Card c6 = new Card(Ranks.SIX, Suits.HEARTS);
	
	Tablaeus t = new Tablaeus(a, d);
	Tablaeus t2 = new Tablaeus(a2, d);
	Tablaeus t3 = new Tablaeus(a3, d);
	
	@Before
	public void setup() {
		t2.removeTest();
		t2.removeTest();
		t2.removeTest();
		t3.removeTest();
		t3.removeTest();
		t3.removeTest();
		t2.addTest(c);
		t2.addTest(c3);
		t2.addTest(c5);
		t3.addTest(c2);
		t3.addTest(c4);
		t3.addTest(c6);	
	}
	
	@Test
	public void testTableauInit() {
		assertEquals("Check the tableaus starting size", t.getCardSize(), 3);
	}
	
	@Test
	public void testTableauAddandRemove() {
		Card SpadeThree = new Card(Card.Ranks.THREE,Card.Suits.SPADES);
		Card SpadeFour = new Card(Card.Ranks.FOUR,Card.Suits.SPADES);
		t2.add(SpadeThree, 0);
		t3.add(SpadeFour, 0);
		assertTrue("Should add card if same suit and +1 rank.", t3.addCard(SpadeThree, t2, t3));
		t2.add(c, 0);
		t3.removeTest();
		assertFalse("Should not add card if not same suit.", t3.addCard(t2.cardAtIndex(3), t2, t3));
		assertFalse("Should not add card if not +1 rank.", t3.addCard(t2.cardAtIndex(2), t2, t3));
	}

	
	@Test
	public void testTableauAddLogic() {
		Card SpadeThree = new Card(Card.Ranks.THREE,Card.Suits.SPADES);
		Card SpadeFour = new Card(Card.Ranks.FOUR,Card.Suits.SPADES);
		t2.add(SpadeThree, 0);
		t3.add(SpadeFour, 0);
		t3.addCard(SpadeThree, t2, t3);
		assertEquals("The size of the tableau should increase.", 5, t3.getCardSize());
		assertEquals("The added card should now be on top.", SpadeThree, t3.cardAtIndex(0));
		t2.add(c, 0);
		t3.removeTest();
	}
	
	@Test
	public void testTableauRemoveLogic() {
		Card SpadeThree = new Card(Card.Ranks.THREE,Card.Suits.SPADES);
		Card SpadeFour = new Card(Card.Ranks.FOUR,Card.Suits.SPADES);
		t2.add(SpadeThree, 0);
		t3.add(SpadeFour, 0);
		t3.addCard(SpadeThree, t2, t3);
		Card a = t2.getCardStack().get(3);
		assertEquals("The size of the tableau should increase.", 5, t3.getCardSize());
		assertEquals("The size of the tableau should increase.", 4, t2.getCardSize());
		assertEquals("The added card should now be on top.", a, t2.cardAtIndex(3));
		t2.add(c, 0);
		t3.removeTest();
		System.out.println("Hello CSE 116 Teaching Team");
		System.out.println("Thank you for your effort!");
	}
}
