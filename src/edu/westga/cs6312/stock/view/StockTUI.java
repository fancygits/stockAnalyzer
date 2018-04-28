package edu.westga.cs6312.stock.view;

import java.util.Scanner;

import edu.westga.cs6312.stock.model.StockManager;

/**
 * Defines the Stock Text User Interface class
 * 
 * @author James Luke Johnson
 * @version 2018.04.22
 */
public class StockTUI {
	private StockManager stockManager;
	private Scanner input;
	
	/**
	 * Constructs a new StockTUI object
	 * @param stockManager	A StockManager object
	 */
	public StockTUI(StockManager stockManager) {
		this.stockManager = stockManager;
		this.input = new Scanner(System.in);
	}
	
	/**
	 * Displays a menu of options to use console
	 */
	private void displayMenu() {
		System.out.println("\n\t1 - View summary data");
		System.out.println("\t2 - View statistical data");
		System.out.println("\t3 - View all records");
		System.out.println("\t4 - Quit");
	}
	
	/**
	 * Welcomes the user and continuously displays a menu of choices
	 * for the user to choose from
	 */
	public void run() {
		System.out.println("Welcome to the Stock Market TUI!");
		int selection = -1;
		do {
			this.displayMenu();
			selection = this.getUserInt("Please enter your choice: ");
			switch (selection) {
				case 1: this.displaySummaryData();
						break;
				case 2: this.displayStatisticalData();
						break;
				case 3: this.displayAllRecords();
						break;
				case 4: System.out.println("\nGoodbye");
						break;
				default: System.out.println("~~~ Invalid menu choice. Please try again.");
			}
		} while (selection != 4);
	}
	
	/**
	 * Prints a message and repeats until a valid input is given
	 * @param message	The printed message to the user
	 * @return			A valid integer
	 */
	private int getUserInt(String message) {
		boolean isValid = false;
		int response = -1;
		do {
			try {
				System.out.print(message);
				String scan = this.input.nextLine();
				response = Integer.parseInt(scan);
				isValid = true;
			} catch (IllegalArgumentException iae) {
				System.out.println("That wasn't a valid integer. Please try again.\n");
			}
		} while (!isValid);
		return response;
	}

	/**
	 * Displays a summary of the StockManager (First, middle, and last record)
	 */
	private void displaySummaryData() {
		this.displayFileName();
		try {
			int middle = this.stockManager.getSize() / 2;
			int last = this.stockManager.getSize() - 1;
			System.out.print("First Record:\t\t");
			System.out.println(this.stockManager.getRecord(0).getSummary());
			System.out.print("Middle Record:\t\t");
			System.out.println(this.stockManager.getRecord(middle).getSummary());
			System.out.print("Last Record:\t\t");
			System.out.println(this.stockManager.getRecord(last).getSummary());
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}
	
	
	/**
	 * Displays some statistical data to the console (Highest, Avg, and Lowest)
	 */
	private void displayStatisticalData() {
		this.displayFileName();
		try {
			System.out.printf("Highest Closing Price: $%.2f\n", this.stockManager.getMaximum());
			System.out.printf("Lowest Closing Price:  $%.2f\n", this.stockManager.getMinimum());
			System.out.printf("Average Closing Price: $%.2f\n", this.stockManager.getAverage());
		} catch (NullPointerException npe) {
			System.out.println(npe.getMessage());
		}
	}
	
	
	/**
	 * Displays all Records to the console
	 */
	private void displayAllRecords() {
		this.displayFileName();
		for (int count = 0; count < this.stockManager.getSize(); count++) {
			System.out.println(this.stockManager.getRecord(count).getSummary());
		}
	}
	
	/**
	 * Displays the fileName of the StockManager object
	 */
	private void displayFileName() {
		System.out.println("\n" + this.stockManager.getFileName());
	}
}
