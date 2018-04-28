package edu.westga.cs6312.stock.view;

import edu.westga.cs6312.stock.model.StockManager;
import javafx.scene.layout.BorderPane;

/**
 * Defines the InteractivePane for changing files for StockPane
 * @author James Luke Johnson
 * @version 2018.04.28
 */
public class InteractivePane extends BorderPane {
	private StockManager stockManager;
	
	public InteractivePane(StockManager stockManager) {
		this.stockManager = stockManager;
		this.drawTop();
		this.drawCenter();
	}
	
	private void drawTop() {
		
	}
	
	private void drawCenter() {
		StockPane center = new StockPane(this.stockManager);
		this.setCenter(center);
	}

}
