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
		thievePile t = new thievePile();

	}

}
