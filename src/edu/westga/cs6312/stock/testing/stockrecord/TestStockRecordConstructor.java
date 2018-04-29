package edu.westga.cs6312.stock.testing.stockrecord;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.stock.model.StockRecord;

/**
 * @author James Luke Johnson
 * @version 2018.04.23
 */
class TestStockRecordConstructor {

	/**
	 * Test StockRecord constructor for average priced stocks
	 * Test method for {@link edu.westga.cs6312.stock.model.StockRecord#StockRecord(String, double, double, double, double, double, long)}.
	 */
	@Test
	void testStockRecordConstructorAndToString() {
		StockRecord apple1 = new StockRecord("2018-03-16,178.649994,179.119995,177.619995,178.020004,178.020004,39404700");
		assertEquals("Closed at $178.02 on 2018-03-16", apple1.toString());
	}

	/**
	 * Test StockRecord constructor for very high priced stocks
	 */
	@Test
	void testStockRecordConstructorShouldReturnFormattedString() {
		StockRecord brka = new StockRecord("1980-03-01,290.000000,310.000000,260.000000,260.000000,260.000000,50000");
		assertEquals("Closed at $260.00 on 1980-03-01", brka.toString());
	}
}
