package edu.westga.cs6312.stock.view;

import java.util.ArrayList;

import edu.westga.cs6312.stock.model.StockManager;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

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
		this.setStyle("-fx-background-color: gainsboro;");
		this.drawGrid();
		this.drawXLabels();
		this.drawYLabels();
		this.drawTitle();
		this.drawAverageLine();
		this.drawClosingPrices();
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
				rect.setFill(Color.TRANSPARENT);
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
		firstDate.layoutYProperty().bind(this.heightProperty().subtract(40));

		String middle = this.stockManager.getRecord(this.stockManager.getSize() / 2).getReformattedDate();
		Label secondDate = new Label(middle);
		secondDate.layoutXProperty().bind(this.widthProperty().divide(2).subtract(25));
		secondDate.layoutYProperty().bind(this.heightProperty().subtract(40));
		
		String end = this.stockManager.getRecord(this.stockManager.getSize() - 1).getReformattedDate();
		Label thirdDate = new Label(end);
		thirdDate.layoutXProperty().bind(this.widthProperty().subtract(75));
		thirdDate.layoutYProperty().bind(this.heightProperty().subtract(40));
		
		this.getChildren().addAll(firstDate, secondDate, thirdDate);
	}
	
	private void drawYLabels() {
		double loPrice = this.stockManager.getMinimum();
		double hiPrice = this.stockManager.getMaximum();
		double difference = hiPrice - loPrice;
		double midloPrice = loPrice + (difference * 1 / 4);
		double midPrice = loPrice + (difference * 2 / 4);
		double midhiPrice = loPrice + (difference * 3 / 4);
	
		Text loLabel = new Text(String.format("$%.2f", loPrice));
		loLabel.layoutYProperty().bind(this.heightProperty().subtract(40));
		Text midloLabel = new Text(String.format("$%.2f", midloPrice));
		midloLabel.layoutYProperty().bind(this.heightProperty().subtract(100).divide(4).multiply(3).add(55));
		Text midLabel = new Text(String.format("$%.2f", midPrice));
		midLabel.layoutYProperty().bind(this.heightProperty().subtract(100).divide(4).multiply(2).add(55));
		Text midhiLabel = new Text(String.format("$%.2f", midhiPrice));
		midhiLabel.layoutYProperty().bind(this.heightProperty().subtract(100).divide(4).add(55));
		Text hiLabel = new Text(String.format("$%.2f", hiPrice));
		hiLabel.setLayoutY(55);
		
		ArrayList<Text> yLabels = new ArrayList<Text>();
		yLabels.add(loLabel);
		yLabels.add(midloLabel);
		yLabels.add(midLabel);
		yLabels.add(midhiLabel);
		yLabels.add(hiLabel);
		
		for (Text current: yLabels) {
			if (current.getBoundsInLocal().getWidth() > 49) {
				current.setFont(Font.font(10));
			}
			current.setX(49 - current.getBoundsInLocal().getWidth());
			this.getChildren().add(current);
		}
	}
	
	private void drawTitle() {
		String filename = this.stockManager.getFileName();
		String name = filename.substring(0, filename.lastIndexOf(".")).toUpperCase();
		Text title = new Text(name);
		title.setFont(Font.font("Verdana", 30));
		title.setY(40);
		double width = title.getBoundsInLocal().getWidth();
		title.layoutXProperty().bind(this.widthProperty().divide(2).subtract(width / 2));
		this.getChildren().add(title);
	}
	
	private void drawClosingPrices() {
		int size = this.stockManager.getSize();
		for (int count = 0; count < size; count++) {
			double ratio = this.calculateYRatio(this.stockManager.getRecord(count).getClose());
			Circle point = new Circle();
			point.layoutXProperty().bind(this.widthProperty().subtract(100).divide(size - 1).multiply(count).add(51));
			point.layoutYProperty().bind(this.heightProperty().subtract(100).multiply(ratio).add(50));
			point.setFill(Color.RED);
			point.setRadius(3);
			this.getChildren().add(point);
		}
	}
	
	private void drawAverageLine() {
		double ratio = this.calculateYRatio(this.stockManager.getAverage());
		
		Line averageLine = new Line();
		averageLine.setStartX(52);
		averageLine.endXProperty().bind(this.widthProperty().subtract(50));
		averageLine.startYProperty().bind(this.heightProperty().subtract(100).multiply(ratio).add(50));
		averageLine.endYProperty().bind(averageLine.startYProperty());
		averageLine.setStroke(Color.BLUE);
		averageLine.setStrokeWidth(3);
		this.getChildren().add(averageLine);
	}
	
	private double calculateYRatio(double price) {
		double loPrice = this.stockManager.getMinimum();
		double hiPrice = this.stockManager.getMaximum();
		double difference = hiPrice - loPrice;
		double ratio = (hiPrice - price) / difference;
		return ratio;
	}
	
}
