package edu.westga.cs6312.stock.testing.stockrecord;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.stock.model.StockRecord;

/**
 * Tests the getSummary method of StockRecord
 * @author James Luke Johnson
 * @version 2018.04.24
 */
class TestStockRecordGetSummary {

	/**
	 * Test method for {@link edu.westga.cs6312.stock.model.StockRecord#getSummary()}.
	 */
	@Test
	void testGetSummaryForStockRecordShouldReturnSummary() {
		StockRecord apple = new StockRecord("2018-03-20,175.240005,176.800003,174.940002,175.240005,175.240005,19649400");
		assertEquals("Closed at $175.24 on 2018-03-20", apple.getSummary());
	}

}
