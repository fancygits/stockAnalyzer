package edu.westga.cs6312.stock.testing.stockmanager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.stock.model.StockManager;
import edu.westga.cs6312.stock.model.StockRecord;

/**
 * Tests the getAverage method of StockManager
 * @author James Luke Johnson
 * @version 2018.04.25
 */
class TestStockManagerGetAverage {

	/**
	 * Test to confirm that a StockManager with 5 entries correctly calculates the average
	 * 
	 * Test method for {@link edu.westga.cs6312.stock.model.StockManager#getAverage()}.
	 */
	@Test
	void testGetAverageForStockManagerWith5StockRecordsShouldReturnAverage() {
		StockManager apple = new StockManager();
		apple.addRecord(new StockRecord("2018-03-16,178.649994,179.119995,177.619995,178.020004,178.020004,39404700"));
		apple.addRecord(new StockRecord("2018-03-19,177.320007,177.470001,173.660004,175.300003,175.300003,33446800"));
		apple.addRecord(new StockRecord("2018-03-20,175.240005,176.800003,174.940002,175.240005,175.240005,19649400"));
		apple.addRecord(new StockRecord("2018-03-21,175.039993,175.089996,171.259995,171.270004,171.270004,37054900"));
		apple.addRecord(new StockRecord("2018-03-22,170.000000,172.679993,168.600006,168.850006,168.850006,41490800"));
		assertEquals(173.7360044, apple.getAverage());
	}
	
	
	/**
	 * Test to confirm that a StockManager with only 1 StockRecord will return its closing
	 * price as the average.
	 */
	@Test
	void testGetAverageForStockManagerWith1StockRecordShouldReturnCloseAsAverage() {
		StockManager apple2 = new StockManager();
		apple2.addRecord(new StockRecord("2018-03-16,178.649994,179.119995,177.619995,178.020004,178.020004,39404700"));
		assertEquals(178.020004, apple2.getAverage());
	}

}
