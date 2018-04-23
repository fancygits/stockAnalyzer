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
	 * Test method for {@link edu.westga.cs6312.stock.model.StockRecord#StockRecord(String, double, double, double, double, double, long)}.
	 */
	@Test
	void testStockRecordConstructorAndToString() {
		StockRecord apple1 = new StockRecord("3/16/2018", 178.649994, 179.119995, 177.619995, 178.020004, 178.020004, 39404700);
		assertEquals("2018-03-16     178.65     179.12     177.62     178.02     178.02  39404700", apple1.toString());
	}

	@Test
	void testStockRecordConstructorShouldReturnFormattedString() {
		StockRecord brka1 = new StockRecord("4/20/2018", 301680, 301680, 298450, 300140, 300140, 139);
		assertEquals("2018-04-20  301680.00  301680.00  298450.00  300140.00  300140.00       139", brka1.toString());
	}
}
