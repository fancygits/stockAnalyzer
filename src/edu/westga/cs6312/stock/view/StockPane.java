package edu.westga.cs6312.stock.view;

import edu.westga.cs6312.stock.model.StockManager;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
		this.drawGrid();
		this.drawXLabels();
	}
	
	private void drawGrid() {
		GridPane graph = new GridPane();
		graph.setLayoutX(50);
		graph.setLayoutY(50);
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
		this.getChildren().add(graph);
	}
	
	private void drawXLabels() {
		String beginning = this.stockManager.getRecord(0).getReformattedDate();
		Label firstDate = new Label(beginning);
		firstDate.setLayoutX(25);
		firstDate.layoutYProperty().bind(this.heightProperty().subtract(45));

		String middle = this.stockManager.getRecord(this.stockManager.getSize() / 2).getReformattedDate();
		Label secondDate = new Label(middle);
		secondDate.layoutXProperty().bind(this.widthProperty().divide(2).subtract(25));
		secondDate.layoutYProperty().bind(this.heightProperty().subtract(45));
		
		String end = this.stockManager.getRecord(this.stockManager.getSize() - 1).getReformattedDate();
		Label thirdDate = new Label(end);
		thirdDate.layoutXProperty().bind(this.widthProperty().subtract(75));
		thirdDate.layoutYProperty().bind(this.heightProperty().subtract(45));
		
		this.getChildren().addAll(firstDate, secondDate, thirdDate);
	}
	
}
