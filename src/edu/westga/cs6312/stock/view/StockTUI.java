package edu.westga.cs6312.stock.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.westga.cs6312.stock.controller.FileInteractor;
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
		
		
		int selection = -1;
		do {
			this.displayMenu();
			selection = this.getUserInt("Please enter your choice: ");
			switch (selection) {
				case 1: 
						break;
				case 2: 
						break;
				case 3: 
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
	
}
