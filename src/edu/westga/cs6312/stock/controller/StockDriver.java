package edu.westga.cs6312.stock.controller;

/**
 * Controller for the StockTUI class
 * @author James Luke Johnson
 * @version 2018.04.24
 */
public class StockDriver {

	/**
	 * This method is the entry point of the application
	 * 
	 * @param args Command-line arguments, not used 
	 */
	public static void main(String[] args) {
		VersionChooser chooser = new VersionChooser();
		chooser.chooseVersion();
	}

}
