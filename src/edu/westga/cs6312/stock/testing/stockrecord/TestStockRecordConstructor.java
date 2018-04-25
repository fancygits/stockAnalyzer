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
		StockRecord apple1 = new StockRecord("2018-03-16", 178.649994, 179.119995, 177.619995, 178.020004, 178.020004, 39404700);
		assertEquals("2018-03-16      178.65     179.12     177.62     178.02     178.02  39404700", apple1.toString());
	}

	/**
	 * Test StockRecord constructor for very high priced stocks
	 */
	@Test
	void testStockRecordConstructorShouldReturnFormattedString() {
		StockRecord brka = new StockRecord("2018-04-20", 301680, 301680, 298450, 300140, 300140, 139);
		assertEquals("2018-04-20   301680.00  301680.00  298450.00  300140.00  300140.00       139", brka.toString());
	}
	
	/**
	 * Test the confirm that the 1-parameter constructor correctly creates
	 * a StockRecord and can output its toString method.
	 */
	@Test
	void testStockRecord1ParameterConstructorShouldReturnFormattedString() {
		StockRecord apple2 = new StockRecord("2018-03-21, 175.039993, 175.089996, 171.259995, 171.270004, 171.270004, 37054900");
		assertEquals("2018-03-21      175.04     175.09     171.26     171.27     171.27  37054900", apple2.toString());
	}
}
