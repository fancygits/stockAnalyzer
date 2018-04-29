package edu.westga.cs6312.stock.testing.stockrecord;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.stock.model.StockRecord;

/**
 * Tests the getDate method of StockRecord
 * @author James Luke Johnson
 * @version 2018.04.23
 */
class TestStockRecordGetDate {

	/**
	 * Test to confirm that the getDate method returns the date from the constructor
	 */
	@Test
	void testGetDateShouldReturnTheStringDate3162018() {
		StockRecord apple = new StockRecord("2018-03-16,178.649994,179.119995,177.619995,178.020004,178.020004,39404700");
		assertEquals("2018-03-16", apple.getDate());
	}

	/**
	 * Test to confirm that the getDate method returns the date from the constructor
	 */
	@Test
	void testGetDateShouldReturnTheStringDate4202018() {
		StockRecord brka = new StockRecord("2018-04-20,301680.000000,301680.000000,298450.000000,300140.000000,300140.000000,139");
		assertEquals("2018-04-20", brka.getDate());
	}
}
