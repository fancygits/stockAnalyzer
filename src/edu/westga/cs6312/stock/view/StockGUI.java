package edu.westga.cs6312.stock.view;

import edu.westga.cs6312.stock.model.StockManager;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Defines the Stock Graphical User Interface
 * @author James Luke Johnson
 * @version 2018.04.27
 */
public class StockGUI extends Application {
	private static StockManager stockManager;
	
	public static void setManager(StockManager givenStockManager) {
		stockManager = givenStockManager;
		StockGUI.launch(StockGUI.class);
	}

	/**
	 * Starts the application
	 * @param	primaryStage The primary stage
	 */
	public void start(Stage primaryStage) {
		 pane = new ();
		Scene scene = new Scene(pane, 500, 500);

		primaryStage.setResizable(false);
		primaryStage.setTitle("CS6312 - Lab13 - Rules to Live By");
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
	
	/**
	 * This method is the entry point of the application
	 * 
	 * @param args	Command-line arguments, not used
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
