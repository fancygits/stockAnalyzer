package edu.westga.cs6312.stock.testing.stockmanager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.stock.model.StockManager;

/**
 * @author James Luke Johnson
 * @version 2018.04.25
 */
class TestStockManagerSetFileName {

	/**
	 * Test to confirm that a StockManager with a setFileName also gets the same name
	 * 
	 * Test method for {@link edu.westga.cs6312.stock.model.StockManager#setFileName(java.lang.String)}.
	 */
	@Test
	void testSetFileNameForSetNameStockManagerShouldReturnSetName() {
		StockManager panasonic = new StockManager();
		panasonic.setFileName("PANA.csv");
		assertEquals("PANA.csv", panasonic.getFileName());
	}
	
	/**
	 * Test to confirm that a StockManager with a filename set twice returns
	 * the most recently set name
	 */
	@Test
	void testSetFileNameForStockManagerSetTwiceShouldReturnMostRecentName() {
		StockManager sony = new StockManager();
		sony.setFileName("sony");
		sony.setFileName("SNY.csv");
		assertEquals("SNY.csv", sony.getFileName());
	}

}
