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
	
	private String dateReformatter(String strDate) {
		SimpleDateFormat inputFormat = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = inputFormat.parse(strDate);
			String output = outputFormat.format(date);
			return output;
		} catch (ParseException pe) {
			throw new IllegalArgumentException("Invalid date format");
		}
		
	}
	
	public String toString() {
		String output = this.dateReformatter(this.date);
		output += String.format("%11.2f%11.2f%11.2f%11.2f%11.2f%10d", this.open, this.high, this.low, this.close, this.adjClose, this.volume);
		return output;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public String getReformattedDate() {
		return this.dateReformatter(this.date);
	}
	
	public double getOpen() {
		return this.open;
	}
	
	public double getHigh() {
		return this.high;
	}
	
	public double getLow() {
		return this.low;
	}
	
	public double getClose() {
		return this.close;
	}
	
	public double getAdjClose() {
		return this.adjClose;
	}
	
	public long getVolume() {
		return this.volume;
	}
}

