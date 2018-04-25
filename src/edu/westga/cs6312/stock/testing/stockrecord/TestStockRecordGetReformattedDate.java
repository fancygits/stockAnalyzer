package edu.westga.cs6312.stock.testing.stockrecord;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.stock.model.StockRecord;

/**
 * Tests the getReformattedDate method of StockRecord
 * @author James Luke Johnson
 * @version 2018.04.23
 */
class TestStockRecordGetReformattedDate {

	/**
	 * Test to confirm that the getReformattedDate method returns the reformatted date from the constructor
	 */
	@Test
	void testGetDateShouldReturnTheStringDate20180316() {
		StockRecord apple = new StockRecord("2018-03-16", 178.649994, 179.119995, 177.619995, 178.020004, 178.020004, 39404700);
		assertEquals("03/16/2018", apple.getReformattedDate());
	}

	/**
	 * Test to confirm that the getReformattedDate method returns the reformatted date from the constructor
	 */
	@Test
	void testGetDateShouldReturnTheStringDate20180420() {
		StockRecord brka = new StockRecord("2018-04-20", 301680, 301680, 298450, 300140, 300140, 139);
		assertEquals("04/20/2018", brka.getReformattedDate());
	}
}
