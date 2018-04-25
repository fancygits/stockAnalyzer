package edu.westga.cs6312.stock.testing.stockmanager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.stock.model.StockManager;

/**
 * Tests the getFileName method of StockManager
 * @author James Luke Johnson
 * @version 2018.04.25
 */
class TestStockManagerGetFileName {

	/**
	 * Test to confirm that getFileName on an new StockManager object returns empty string
	 * Test method for {@link edu.westga.cs6312.stock.model.StockManager#getFileName()}.
	 */
	@Test
	void testGetFileNameForNewStockManagerShouldReturnEmpty() {
		StockManager sony = new StockManager();
		assertEquals("", sony.getFileName());
	}
	
	/**
	 * Test to confirm that a StockManager with a setFileName also gets the same name
	 */
	@Test
	void testGetFileNameForSetNameStockManagerShouldReturnSetName() {
		StockManager panasonic = new StockManager();
		panasonic.setFileName("PANA.csv");
		assertEquals("PANA.csv", panasonic.getFileName());
	}

}
