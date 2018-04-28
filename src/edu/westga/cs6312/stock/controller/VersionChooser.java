package edu.westga.cs6312.stock.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.westga.cs6312.stock.model.StockManager;
import edu.westga.cs6312.stock.view.StockGUI;
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
		this.displayOptions();
	}
	
	/**
	 * Presents a choice of User Interface and defaults to graphical
	 */
	private void displayOptions() {
		boolean isValid = false;
		do {
			System.out.println("\n1 - Text Interface");
			System.out.println("2 - Graphical Interface (default)");
			System.out.print("Please enter your choice: ");
			int choice = 0;
			try {
				choice = Integer.parseInt(this.input.nextLine());
			} catch (NumberFormatException nfe) {
				
			}
			if (choice == 1) {
				System.out.println("\nRunning TUI. Thank you.\n");
				this.runTextOption();
				isValid = true;
			} else if (choice == 2) {
				System.out.println("\nRunning GUI. Please switch windows. Thank you.\n");
				this.runGraphicsOption();
				isValid = true;
			} else {
				System.out.println("Sorry. That's not a valid choice. Please try again.");
			}
		} while (!isValid);
	}
	
	/**
	 * Runs the TUI Stock Market Application
	 */
	private void runTextOption() {
		StockTUI textOption = new StockTUI(this.stockManager);
		textOption.run();
	}
	
	/**
	 * Runs the GUI Stock Market Application
	 */
	private void runGraphicsOption() {
		StockGUI.setManager(this.stockManager);
		StockGUI.launch(StockGUI.class);
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
