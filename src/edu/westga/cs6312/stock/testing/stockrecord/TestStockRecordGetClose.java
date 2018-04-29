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
		StockRecord apple = new StockRecord("2018-03-16,178.649994,179.119995,177.619995,178.020004,178.020004,39404700");
		assertEquals("178.020004", apple.getClose() + "");
	}

	/**
	 * Test to confirm that the getClose method returns the open double 300140.0
	 */
	@Test
	void testGetCloseShouldReturnTheDouble300140() {
		StockRecord brka = new StockRecord("2018-04-20,301680.000000,301680.000000,298450.000000,300140.000000,300140.000000,139");
		assertEquals("300140.0", brka.getClose() + "");
	}
}
