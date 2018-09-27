package tests.littleSpiderTests;

import static org.junit.Assert.assertEquals;


import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import code.Deck.Card;
import code.Deck.Card.Ranks;
import code.Deck.Card.Suits;
import code.Deck.Deck;
import code.littleSpider.Tableaus;

class TableausTest {
	Deck op =  new Deck();
	Card a1 = new Card(Ranks.ACE, Suits.CLUBS);
	Card a2 = new Card(Ranks.FIVE, Suits.CLUBS);
	Card a3 = new Card(Ranks.KING, Suits.DIAMONDS);
	Card a4 = new Card(Ranks.TWO, Suits.CLUBS);
	Card a5 = new Card(Ranks.FIVE, Suits.DIAMONDS);
	Card a6 = new Card(Ranks.ACE, Suits.SPADES);
	ArrayList<Card> lol = new ArrayList<>();
	
	@Test
	public void testCheckNumber() {
		lol.add(a1);
		lol.add(a2);
		lol.add(a3);
		lol.add(a4);
		lol.add(a5);
		lol.add(a6);
		Tableaus group1 = new Tableaus(lol,op);
		Card t1 = new Card(Ranks.EIGHT, Suits.CLUBS);
		Card t2 = new Card(Ranks.KING, Suits.DIAMONDS);
		Card t3 = new Card(Ranks.ACE, Suits.DIAMONDS);
		Card t4 = new Card(Ranks.TWO, Suits.SPADES);
	
		boolean k1 = group1.checkNumber(t1);
		assertEquals("see if its legal to put a eight on a ace",k1, false);
		
		boolean k2 = group1.checkNumber(t2);
		assertEquals("check to see if it is legal to out a king on a ace",k2,true);
		
		
		boolean k3 = group1.checkNumber(t3);
		assertEquals("check to see if it is legal to put a ace on a ace",k3, false);
		
		
		boolean k4 = group1.checkNumber(t4);
		assertEquals("check to see if it is legal to put a 2 on a ace",k4,true);
	}

	@Test
	public void testCheckEmpty() {
		Deck op =  new Deck();
		Tableaus group1 = new Tableaus(lol, op);
		boolean a = group1.checkEmpty();
		assertEquals("cardStack is empty",a, false);
		
		group1.removeTest();
		group1.removeTest();
		group1.removeTest();
		group1.removeTest();
		group1.removeTest();
		group1.removeTest();
		boolean b = group1.checkEmpty();

		assertEquals("cardStack is Empty",b, true );
		
	}

	@Test
	public void testRemoveCard() {
		lol.add(a1);
		lol.add(a2);
		lol.add(a3);
		lol.add(a4);
		lol.add(a5);
		lol.add(a6);
		
		Tableaus group1 = new Tableaus(lol, op);
		Card test1 = new Card(Ranks.KING, Suits.CLUBS);
		group1.removeCard(test1);
		//since lol has 6 random cards i had to add in my own to test
		assertEquals("check to see if the tableaus size decreases",group1.getCardSize(), 11);
		
		
		
		
		
	}

	@Test
	public void testAddCard() {
		//since lol has 6 random cards i had to add in my own to test
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
		group2.addCard(test1, group1, group2);
		
		
		assertEquals("check if the size is right after adding card",group2.getCardSize(), 13);
		assertEquals("Check the index of the removed card to see if the net card is right",group1.index(0), a2);
		assertEquals("Checks to see if the card added is in the first index", group2.index(0), test1);
		assertEquals("check if the size is right after removing card",group1.getCardSize(), 11);   
		
	}
	@Test
	public void testTableausSize() {
		Deck op =  new Deck();
		ArrayList<Card> pop = new ArrayList<>();
		

		Tableaus t1 = new Tableaus(pop, op);
		assertEquals("check the tableaus starting size",t1.getCardSize(), 6);
		
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
