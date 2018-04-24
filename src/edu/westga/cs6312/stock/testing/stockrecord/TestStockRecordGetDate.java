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
		StockRecord apple = new StockRecord("3/16/2018", 178.649994, 179.119995, 177.619995, 178.020004, 178.020004, 39404700);
		assertEquals("3/16/2018", apple.getDate());
	}

	/**
	 * Test to confirm that the getDate method returns the date from the constructor
	 */
	@Test
	void testGetDateShouldReturnTheStringDate4202018() {
		StockRecord brka = new StockRecord("4/20/2018", 301680, 301680, 298450, 300140, 300140, 139);
		assertEquals("4/20/2018", brka.getDate());
	}
}