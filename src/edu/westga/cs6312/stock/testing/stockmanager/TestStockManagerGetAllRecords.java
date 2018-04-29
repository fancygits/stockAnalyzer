package edu.westga.cs6312.stock.testing.stockmanager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.stock.model.StockManager;
import edu.westga.cs6312.stock.model.StockRecord;

/**
 * Tests the getAllRecords method of StockManager
 * @author James Luke Johnson
 * @version 2018.04.28
 */
class TestStockManagerGetAllRecords {

	/**
	 * Test to confirm that getAllRecords returns an ArrayList<StockRecords>
	 * Test method for {@link edu.westga.cs6312.stock.model.StockManager#getAllRecords()}.
	 */
	@Test
	void testGetAllRecords() {
		StockManager appleStocks = new StockManager();
		appleStocks.addRecord(new StockRecord("2018-03-16,178.649994,179.119995,177.619995,178.020004,178.020004,39404700"));
		appleStocks.addRecord(new StockRecord("2018-03-19,177.320007,177.470001,173.660004,175.300003,175.300003,33446800"));
		appleStocks.addRecord(new StockRecord("2018-03-20,175.240005,176.800003,174.940002,175.240005,175.240005,19649400"));
		appleStocks.addRecord(new StockRecord("2018-03-21,175.039993,175.089996,171.259995,171.270004,171.270004,37054900"));
		appleStocks.addRecord(new StockRecord("2018-03-22,170.000000,172.679993,168.600006,168.850006,168.850006,41490800"));
		assertEquals(5, appleStocks.getAllRecords().size());
	}

}
