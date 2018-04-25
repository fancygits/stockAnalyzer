package edu.westga.cs6312.stock.testing.stockmanager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.stock.model.StockManager;
import edu.westga.cs6312.stock.model.StockRecord;

/**
 * Tests the getRecord method of StockManager
 * 
 * @author James Luke Johnson
 * @version 2018.04.25
 */
class TestStockManagerGetRecord {

	/**
	 * Test to confirm that getRecord returns the correct record
	 * Test method for {@link edu.westga.cs6312.stock.model.StockManager#getRecord(int)}.
	 */
	@Test
	void testGetRecordForStockManagerWith1StockRecordShouldReturnThatRecord() {
		StockManager appleStock = new StockManager();
		appleStock.addRecord(new StockRecord("2018-03-16", 178.649994, 179.119995, 177.619995, 178.020004, 178.020004, 39404700));
		assertEquals("2018-03-16      178.65     179.12     177.62     178.02     178.02  39404700", appleStock.getRecord(0).toString());
	}
	
	/**
	 * Test to confirm that a StockManager with 5 stocks will return the correct
	 * record with the getRecord method
	 */
	@Test
	void testGetRecordForStockManagerWith5StocksShouldReturnRecordAtIndex3() {
		StockManager appleStocks = new StockManager();
		appleStocks.addRecord(new StockRecord("2018-03-16", 178.649994, 179.119995, 177.619995, 178.020004, 178.020004, 39404700));
		appleStocks.addRecord(new StockRecord("2018-03-19", 177.320007, 177.470001, 173.660004, 175.300003, 175.300003, 33446800));
		appleStocks.addRecord(new StockRecord("2018-03-20", 175.240005, 176.800003, 174.940002, 175.240005, 175.240005, 19649400));
		appleStocks.addRecord(new StockRecord("2018-03-21", 175.039993, 175.089996, 171.259995, 171.270004, 171.270004, 37054900));
		appleStocks.addRecord(new StockRecord("2018-03-22", 170, 172.679993, 168.600006, 168.850006, 168.850006, 41490800));
		assertEquals("2018-03-21      175.04     175.09     171.26     171.27     171.27  37054900", appleStocks.getRecord(3).toString());
	
	}

}
