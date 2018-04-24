package edu.westga.cs6312.stock.model;

import java.util.ArrayList;

/**
 * Defines the StockManager class, which will keep up with 
 * one or more historical records about a particular stock. 
 * 
 * @author James Luke Johnson
 * @version 2018.04.22
 */
public class StockManager {
	private ArrayList<StockRecord> stockRecords;
	
	/**
	 * Constructs a new StockManager object
	 */
	public StockManager() {
		this.stockRecords = new ArrayList<StockRecord>();
	}
	
	/**
	 * Adds a StockRecord to the ArrayList of records
	 * @param record	A StockRecord
	 * 
	 * Precondition: 	record != null
	 */
	public void addRecord(StockRecord record) {
		if (record == null) {
			throw new IllegalArgumentException("StockRecord cannot be null");
		}
		this.stockRecords.add(record);
	}
	
	/**
	 * Returns the given StockRecord from the ArrayList
	 * 
	 * @param index	The index of the record to retrieve
	 * @return		The StockRecord of the given index
	 */
	public StockRecord getRecord(int index) {
		if (index > this.stockRecords.size() - 1) {
			throw new IllegalArgumentException("That StockRecord doesn't exist");
		}
		return this.stockRecords.get(index);
	}
	
	/**
	 * Accessor for the size of the ArrayList
	 * @return	int Size of StockManager ArrayList<StockRecord>
	 */
	public int getSize() {
		return this.stockRecords.size();
	}
	
	/**
	 * Returns a String representation of the object
	 */
	@Override
	public String toString() {
		String output = "";
		for (StockRecord current: this.stockRecords) {
			output += current.toString() + "\n";
		}
		return output;
	}
}
