package thieveGameTests;

import static org.junit.Assert.*;

import ThieveGameLogic.Decks;
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
	public void testPutWasteFromStock() {
		Decks d = new Decks();
		thievePile t = new thievePile(d);
		assertTrue(t.putWaste(t.getStock(), t.getWaste()));

	}
	
	@Test
	public void testPutWasteFromOther() {
		Decks d = new Decks();
		thievePile t = new thievePile(d);
		assertFalse(t.putWaste());
	}
	
	@Test
	public void testWasteRemove() {
		Decks d = new Decks();
		thievePile t = new thievePile(d);
		
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

}
