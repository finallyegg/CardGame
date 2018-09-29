package tests.littleSpiderTests;

import static org.junit.Assert.assertEquals;


import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import code.Deck.Card;
import code.Deck.Card.Ranks;
import code.Deck.Card.Suits;
import code.Deck.Deck;
import code.littleSpider.Homecells;
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
	public void testInitialStart() {
		Deck op =  new Deck();
		ArrayList<Card> pop = new ArrayList<>();
		

		Tableaus t1 = new Tableaus(pop, op);
		assertEquals("check the tableaus starting size",t1.getCardSize(), 6);
		
	}
	
	@Test
	public void testCheckIfLegal() {
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
	public void checkReturn() {
		
		Card t1 = new Card(Ranks.KING, Suits.CLUBS);
		lol.add(a1);
		lol.add(a2);
		lol.add(a3);
		lol.add(a4);
		lol.add(a5);
		lol.add(a6);
		ArrayList<Card> lol1 = new ArrayList<>();
		lol1.add(t1);
		lol1.add(a2);
		lol1.add(a3);
		lol1.add(a4);
		lol1.add(a5);
		lol1.add(a6);
		Tableaus group1 = new Tableaus(lol,op);
		Card t3 = new Card(Ranks.ACE, Suits.DIAMONDS);
		
		boolean k3 = group1.checkNumber(t3);
		Tableaus group2 = new Tableaus(lol1,op);
		
		
		assertEquals("check to see if it is legal to put a ace on a ace",k3, false);
	
		assertEquals("check to see if it returned correctly if illegal size wise", group1.getCardSize(), 12);
		assertEquals("check to see if it returned correctly if illegal first index wise", group1.cardAtIndex(0), a1  );
		group2.addCard(t1, group1, group2);
		assertEquals("check to see if the added card first index is t1",group2.checkFirstIndex(), t1);
		
	}
	

	@Test
	public void testRemoveCard() {
		ArrayList<Card> lol1 = new ArrayList<>();
		lol1.add(a1);
		lol1.add(a2);
		lol1.add(a3);
		lol1.add(a4);
		lol1.add(a5);
		lol1.add(a6);
		Tableaus group1 = new Tableaus(lol1, op);
		
		group1.removeTest();
		
		assertEquals("Check to see if after removing the card the second index would be the first card", group1.cardAtIndex(0), a2);
		assertEquals("check if the size is right after removing card",group1.getCardSize(), 11);   
		
	}

	@Test
	public void testAddCard() {
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
		
		
		
		
		assertEquals("Checks to see if the card added is in the first index", group2.index(0), test1);
		
		assertEquals("check if the size is right after adding card",group2.getCardSize(), 13);
		
	}
	

	
	
	@Test
	public void testMoveToHomecell() {
		Card c1 = new Card(Ranks.ACE, Suits.HEARTS);
		Homecells c = new Homecells(c1);
		Card c2 = new Card(Ranks.TWO, Suits.HEARTS);
		lol.add(c2);
		Tableaus a = new Tableaus(lol, op);
		a.addToHomecell(c2, a, c);
		assertEquals("Check the first index after checking it", c.getCard(0), c2);
	}

}
