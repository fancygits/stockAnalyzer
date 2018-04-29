package edu.westga.cs6312.stock.view;

import java.io.File;

import edu.westga.cs6312.stock.controller.FileInteractor;
import edu.westga.cs6312.stock.model.StockManager;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

/**
 * Defines the InteractivePane for changing files for StockPane
 * @author James Luke Johnson
 * @version 2018.04.28
 */
public class InteractivePane extends BorderPane {
	private StockManager stockManager;
	
	/**
	 * Constructs a new InteractivePane
	 * @param stockManager	StockManager object filled with data
	 */
	public InteractivePane(StockManager stockManager) {
		this.stockManager = stockManager;
		this.drawTop();
		this.drawCenter();
	}
	
	private void drawTop() {
		Button newFile = new Button("New File");
		Label currentFile = new Label(this.stockManager.getFileName(), newFile);
		currentFile.setPadding(new Insets(5, 5, 5, 5));
		currentFile.setContentDisplay(ContentDisplay.LEFT);
		currentFile.setFont(Font.font("Verdana", 16));
		
		newFile.setOnAction(e -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open New Stock Market Data File");
			fileChooser.setInitialDirectory(new File("."));
			fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Files", "*.*"), 
					new FileChooser.ExtensionFilter("Comma Separated Value File", "*.csv"));
			File selectedFile = fileChooser.showOpenDialog(null);
			if (selectedFile != null) {
				try {
					currentFile.setText(selectedFile.getName());
					this.stockManager = FileInteractor.readData(selectedFile.toString());
					this.drawCenter();
				} catch (Exception ex) {
					currentFile.setText("That file doesn't contain Stock Records. Try again.");
				}
				
			}
		});
			
		this.setTop(currentFile);
	}
	
	private void drawCenter() {
		StockPane center = new StockPane(this.stockManager);
		this.setCenter(center);
	}

}
