package edu.westga.cs6312.stock.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.westga.cs6312.stock.model.StockManager;
import edu.westga.cs6312.stock.model.StockRecord;

/**
 * Defines the FileInteractor class
 * @author James Luke Johnson
 * @version 2018.04.23
 */
public class FileInteractor {
	
	/**
	 * Opens the file specified by the parameter, reads the data, and uses
	 *  that data to populate a StockManager object to be returned. 
	 * 
	 * @param fileName	String name of file to read from
	 * @return			StockManager object
	 */
	public static StockManager readData(String fileName) {
		File sourceFile = new File(fileName);
		Scanner inFile = null;
		StockManager stockManager = new StockManager();
		try {
			inFile = new Scanner(sourceFile);
			inFile.nextLine();
			while (inFile.hasNextLine()) {
				String nextLine = inFile.nextLine();
				try {
					stockManager.addRecord(new StockRecord(nextLine));
				} catch (IllegalArgumentException iae) {
					
				}
			}
			inFile.close();
		} catch (FileNotFoundException fnfe) {
			throw new IllegalArgumentException("That file does not exist.");
		} catch (NoSuchElementException nsee) {
			inFile.close();
			throw new NoSuchElementException("Read past end of file.");
		}
		stockManager.setFileName(fileName);
		return stockManager;
	}
}
