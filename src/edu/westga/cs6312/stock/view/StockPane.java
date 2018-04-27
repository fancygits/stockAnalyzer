package edu.westga.cs6312.stock.view;

import edu.westga.cs6312.stock.model.StockManager;
import javafx.scene.layout.Pane;

/**
 * @author James Luke Johnson
 * @version 2018.04.27
 */
public class StockPane extends Pane {
	private StockManager stockManager;
	
	public StockPane(StockManager stockManager) {
		this.stockManager = stockManager;
		this.drawStockPane();
	}
	
	private void drawStockPane() {
		
	}
}
