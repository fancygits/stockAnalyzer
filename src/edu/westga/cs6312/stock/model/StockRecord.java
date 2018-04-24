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
	private double open;
	private double high;
	private double low;
	private double close;
	private double adjClose;
	private long volume;

	/**
	 * Constructs a new StockRecord object
	 * @param strDate	A string representing a date in the format MM/dd/yyyy
	 * @param open		The opening stock price
	 * @param high		The high stock price
	 * @param low		The low stock price
	 * @param close		The closing stock price
	 * @param adjClose	The adjusted closing stock price
	 * @param volume	The volume of stocks bought and sold
	 */
	public StockRecord(String strDate, double open, double high, double low, double close, double adjClose, long volume) {
		if (open < 0 | high < 0 | low < 0 | close < 0 | adjClose < 0 | volume < 0) {
			throw new IllegalArgumentException("Stock numbers must be positive");
		}
		this.date = strDate;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.adjClose = adjClose;
		this.volume = volume;
	}
	
	/**
	 * Constructs a new StockRecord object from a line of input
	 * @param lineOfInput	A line from a CSV file
	 */
	public StockRecord(String lineOfInput) {
		String[] record = lineOfInput.split(",");
		if (record.length != 7) {
			throw new IllegalArgumentException("Not enough data to create a record");
		}
		this.date = record[0];
		this.open = Double.parseDouble(record[1]);
		this.high = Double.parseDouble(record[2]);
		this.low = Double.parseDouble(record[3]);
		this.close = Double.parseDouble(record[4]);
		this.adjClose = Double.parseDouble(record[5]);
		this.volume = Long.parseLong(record[6].trim());
	}
	
	private String dateReformatter(String strDate) {
		SimpleDateFormat outputFormat = new SimpleDateFormat("MM/dd/yyyy");
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
	 */
	@Override
	public String toString() {
		String output = String.format("%11s%11.2f%11.2f%11.2f%11.2f%11.2f%10d", this.date, this.open, this.high, this.low, this.close, this.adjClose, this.volume);
		return output;
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
	 * Accessor for the opening price
	 * @return	The opening price
	 */
	public double getOpen() {
		return this.open;
	}

	/**
	 * Accessor for the high price
	 * @return	The high price
	 */
	public double getHigh() {
		return this.high;
	}

	/**
	 * Accessor for the low price
	 * @return	The low price
	 */
	public double getLow() {
		return this.low;
	}

	/**
	 * Accessor for the closing price
	 * @return	The closing price
	 */
	public double getClose() {
		return this.close;
	}

	/**
	 * Accessor for the adjusted closing price
	 * @return	The adjusted closing price
	 */
	public double getAdjClose() {
		return this.adjClose;
	}

	/**
	 * Accessor for the volume sold
	 * @return	The volume
	 */
	public long getVolume() {
		return this.volume;
	}
}

