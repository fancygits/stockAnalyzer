package edu.westga.cs6312.stock.testing.stockmanager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.stock.model.StockManager;

/**
 * Tests the constructor of StockManager
 * @author James Luke Johnson
 * @version 2018.04.23
 */
class TestStockManagerConstructor {

	/**
	 * Test to confirm that the StockManager constructor returns an empty string since 
	 * there are no StockRecords in the ArrayList
	 * 
	 * Test method for {@link edu.westga.cs6312.stock.model.StockManager#StockManager()}.
	 */
	@Test
	void testStockManagerConstructorShouldReturnEmptyString() {
		StockManager stocks1 = new StockManager();
		assertEquals("", stocks1.toString());
	}

}
