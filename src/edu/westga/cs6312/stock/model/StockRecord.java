package edu.westga.cs6312.stock.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Defines the StockRecord class, which will keep up with information 
 * about a particular stock on a given day. 
 * 
 * @author James Luke Johnson
 * @version 2018.04.22
 */
public class StockRecord {
	private String date;
	private double close;
	
	/**
	 * Constructs a new StockRecord object from a line of input
	 * @param lineOfInput	A line from a CSV file
	 * 
	 * Precondition:	lineOfInput.length >= 5
	 */
	public StockRecord(String lineOfInput) {
		String[] record = lineOfInput.split(",");
		if (record.length < 5) {
			throw new IllegalArgumentException("Not enough data to create a record");
		}
		this.date = record[0];
		this.close = Double.parseDouble(record[4]);
		
		if (this.close < 0) {
			throw new IllegalArgumentException("Stock numbers must be positive");
		}
	}
	
	/**
	 * Reformats the date to MM/dd/yyyy
	 * Created this method before testing and realized its unnecessary.
	 * Kept it for potential future expansion
	 * 
	 * @param strDate	String date in format yyyy-MM-dd
	 * @return			String date in format MM/dd/yyyy
	 */
	private String dateReformatter(String strDate) {
		SimpleDateFormat outputFormat = new SimpleDateFormat("M/d/yyyy");
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = inputFormat.parse(strDate);
			String output = outputFormat.format(date);
			return output;
		} catch (ParseException pe) {
			throw new IllegalArgumentException("Invalid date format");
		}
	}
	
	/**
	 * Returns a string representation of the object
	 * @return	String summary
	 */
	@Override
	public String toString() {
		return String.format("Closed at $%.2f on %s", this.getClose(), this.getDate());
	}
	
	/**
	 * Accessor for the date in the format yyyy-MM-dd
	 * @return	String date
	 */
	public String getDate() {
		return this.date;
	}
	
	/**
	 * Accessor for the reformatted date in the format MM/dd/yyyy
	 * @return	String reformatted date
	 */
	public String getReformattedDate() {
		return this.dateReformatter(this.date);
	}
	
	/**
	 * Accessor for the closing price
	 * @return	The closing price
	 */
	public double getClose() {
		return this.close;
	}
}

