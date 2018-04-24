package edu.westga.cs6312.stock.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.westga.cs6312.stock.model.StockManager;
import edu.westga.cs6312.stock.view.StockTUI;

/**
 * Defines the VersionChooser class
 * 
 * @author James Luke Johnson
 * @version 2018.04.24
 */
public class VersionChooser {
	private Scanner input;
	private StockManager stockManager;
	
	/**
	 * Constructs a new VersionChooser object
	 */
	public VersionChooser() {
		this.input = new Scanner(System.in);
	}
	
	/**
	 * Prompts the user to choose a version of the application
	 */
	public void chooseVersion() {
		System.out.println("Welcome to the Stock Market Application");
		String fileName = this.getFileName();
		this.stockManager = FileInteractor.readData(fileName);
		this.runTextOption();
	}
	
	/**
	 * Runs the TUI Stock Market Application
	 */
	private void runTextOption() {
		StockTUI textOption = new StockTUI(this.stockManager);
		textOption.run();
	}
	
	/**
	 * Uses the console to prompt the user for a file to be read and 
	 * returns that filename.
	 * 
	 * @return	String valid fileName
	 */
	private String getFileName() {
		boolean isValid = false;
		String fileName = "";
		do {
			try {
				System.out.print("Please enter the file name: ");
				fileName = this.input.nextLine().trim();
				File sourceFile = new File(fileName);
				Scanner inFile = new Scanner(sourceFile);
				inFile.nextLine();
				inFile.close();
				isValid = true;
			} catch (FileNotFoundException fnfe) {
				System.out.println("That file doesn't exist in this location. Please try again.");
			}
		} while (!isValid);
		return fileName;
	}
}
