package edu.westga.cs6312.stock.testing.stockrecord;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.stock.model.StockRecord;

/**
 * Tests the getClose method of StockRecord
 * @author James Luke Johnson
 * @version 2018.04.23
 */
class TestStockRecordGetClose {

	/**
	 * Test to confirm that the getClose method returns the open double 178.020004
	 */
	@Test
	void testGetCloseShouldReturnTheDouble178() {
		StockRecord apple = new StockRecord("3/16/2018", 178.649994, 179.119995, 177.619995, 178.020004, 178.020004, 39404700);
		assertEquals("178.020004", apple.getClose() + "");
	}

	/**
	 * Test to confirm that the getClose method returns the open double 300140.0
	 */
	@Test
	void testGetCloseShouldReturnTheDouble300140() {
		StockRecord brka = new StockRecord("4/20/2018", 301680, 301680, 298450, 300140, 300140, 139);
		assertEquals("300140.0", brka.getClose() + "");
	}
}
