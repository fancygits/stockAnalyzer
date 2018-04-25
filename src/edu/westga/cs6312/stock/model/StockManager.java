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
	private String filename;
	
	/**
	 * Constructs a new StockManager object
	 */
	public StockManager() {
		this.stockRecords = new ArrayList<StockRecord>();
		this.filename = "";
	}
	
	/**
	 * Accessor for the file name the data was imported from
	 * @return	String fileName
	 */
	public String getFileName() {
		return this.filename;
	}
	
	/**
	 * Modifier for the file name
	 * @param fileName	String file name
	 */
	public void setFileName(String fileName) {
		this.filename = fileName;
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
	 * Finds the maximum closing price from the stockManager
	 * @return	The maximum closing price
	 * 
	 * Precondition:	stockManager size != 0
	 */
	public double getMaximum() {
		if (this.getSize() == 0) {
			throw new NullPointerException("The StockManager doesn't have any records.");
		}
		double maximum = this.stockRecords.get(0).getClose();
		for (StockRecord current: this.stockRecords) {
			if (current.getClose() > maximum) {
				maximum = current.getClose();
			}
		}
		return maximum;
	}
	
	
	/**
	 * Finds the minimum closing price from the stockManager
	 * @return	The minimum closing price
	 * 
	 * Precondition:	stockManager size != 0
	 */
	public double getMinimum() {
		if (this.getSize() == 0) {
			throw new NullPointerException("The StockManager doesn't have any records.");
		}
		double minimum = this.stockRecords.get(0).getClose();
		for (StockRecord current: this.stockRecords) {
			if (current.getClose() < minimum) {
				minimum = current.getClose();
			}
		}
		return minimum;
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
