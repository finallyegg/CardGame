package thieveGameTests;

import static org.junit.Assert.*;

import ThieveGameLogic.Decks;
import ThieveGameLogic.TCards;
import ThieveGameLogic.TCards.TRanks;
import ThieveGameLogic.TCards.TSuits;
import ThieveGameLogic.thievePile;

import org.junit.Test;



public class thievePileTest {

	/*
	 * Waste Pile tests
	 */
	@Test
	public void testWasteEmptyInit() {
		Decks d = new Decks();
		thievePile t = new thievePile(d);
		assertEquals(0, t.getWaste().size());
	}
	
	@Test
	public void testPutWasteFromOther() {
		Decks d = new Decks();
		thievePile t = new thievePile(d);
		assertFalse(t.putWaste());
	}
	
	@Test
	public void testRemoveWasteCard() {
		Decks d = new Decks();
		thievePile t = new thievePile(d);
		assertFalse(t.removeWasteCard(t));
		TCards c = new TCards(TRanks.ACE, TSuits.DIAMONDS);
		t.putWaste(t.getWaste(), c);
		assertTrue(t.removeWasteCard(t));
	}
	
	@Test
	public void testWasteRemove() {
		Decks d = new Decks();
		thievePile t = new thievePile(d);
		TCards c = new TCards(TRanks.ACE, TSuits.DIAMONDS);
		TCards c2 = new TCards(TRanks.ACE, TSuits.CLUBS);
		t.putWaste(t.getWaste(), c);
		t.putWaste(t.getWaste(), c2);
		assertEquals(c2, t.getWaste().get(t.getWaste().size() - 1));
		assertEquals(2, t.getWaste().size());
		t.removeWasteCard(t);
		assertEquals(c, t.getWaste().get(t.getWaste().size() - 1));
		assertEquals(1, t.getWaste().size());
	}
	
	/*
	 * Stock Pile tests
	 */
	@Test
	public void testStockInit() {
		Decks d = new Decks();
		thievePile t = new thievePile(d);
		assertEquals(57, t.getStockSize());
	}
	
	@Test
	public void testAddStock() {
		Decks d = new Decks();
		thievePile t = new thievePile(d);
		assertFalse(t.addStock());
	}
	
	@Test
	public void testRemoveStockLegality() {
		Decks d = new Decks();
		thievePile t = new thievePile(d);
		assertTrue(t.removeStockCard(t));
		while(!t.getStock().isEmpty()) {
			t.removeStockCard(t);
		}
		assertFalse(t.removeStockCard(t));
	}
	
	@Test
	public void testRemoveStockLogic() {
		Decks d = new Decks();
		thievePile t = new thievePile(d);
		TCards c = new TCards(TRanks.ACE, TSuits.DIAMONDS);
		TCards c2 = new TCards(TRanks.ACE, TSuits.CLUBS);
		t.forceAddStock(c);
		t.forceAddStock(c2);
		assertEquals(c2, t.getStock().get(t.getStock().size() - 1));
		assertEquals(59, t.getStock().size());
		t.removeStockCard(t);
		assertEquals(c, t.getStock().get(t.getStock().size() - 1));
		assertEquals(58, t.getStock().size());
		assertEquals(c2, t.getWaste().get(t.getWaste().size() - 1));
	}

}
