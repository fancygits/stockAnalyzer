package edu.westga.cs6312.stock.view;

import edu.westga.cs6312.stock.model.StockManager;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Defines the StockPane, the GUI layout class
 * @author James Luke Johnson
 * @version 2018.04.27
 */
public class StockPane extends Pane {
	private StockManager stockManager;
	
	/**
	 * Constructs a new StockPane object
	 * @param stockManager	A StockManager object
	 */
	public StockPane(StockManager stockManager) {
		this.stockManager = stockManager;
		this.drawStockPane();
	}
	
	private void drawStockPane() {
		//this.setPadding(new Insets(50, 50, 50, 50));
		GridPane graph = this.getGraph();
		graph.setLayoutX(50);
		graph.setLayoutY(50);
		this.getChildren().add(graph);
	}
	
	private GridPane getGraph() {
		GridPane graph = new GridPane();
		for (int row = 0; row < 4; row++) {
			for (int column = 0; column < 2; column++) {
				Rectangle rect = new Rectangle();
				rect.widthProperty().bind(this.widthProperty().subtract(100).divide(2));
				rect.heightProperty().bind(this.heightProperty().subtract(100).divide(4));
				rect.setFill(Color.WHITE);
				rect.setStroke(Color.BLACK);
				graph.add(rect, column, row);
			}
		}
		return graph;
	}
}
