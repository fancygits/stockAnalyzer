package edu.westga.cs6312.stock.view;

import edu.westga.cs6312.stock.model.StockManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Defines the Stock Graphical User Interface
 * @author James Luke Johnson
 * @version 2018.04.27
 */
public class StockGUI extends Application {
	private static StockManager stockManager;
	
	/**
	 * Sets the givenStockManager to this.stockManager
	 * @param givenStockManager	A loaded StockManager object
	 */
	public static void setManager(StockManager givenStockManager) {
		stockManager = givenStockManager;
	}

	/**
	 * Starts the application
	 * @param	primaryStage The primary stage
	 */
	public void start(Stage primaryStage) {
		StockPane pane = new StockPane(stockManager);
		Scene scene = new Scene(pane, 600, 500);

		primaryStage.setTitle("CS6312 - Final - Stock Market Application");
		primaryStage.setMinHeight(200);
		primaryStage.setMinWidth(350);
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
