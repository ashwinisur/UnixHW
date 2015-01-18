package HW02;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Homework_Common extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		HistogramPane_Common pane = new HistogramPane_Common();

		pane.setStyle("-fx-border-color: black");

		Button btStep = new Button("Step");
		Button btReset = new Button("Reset");
		TextField tfKey = new TextField();
		
		HBox hBox = new HBox(5);
		hBox.getChildren().addAll(
				new Label("Key (in double)"), tfKey, btStep, btReset);
		hBox.setAlignment(Pos.CENTER);

		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(pane);
		borderPane.setBottom(hBox);

		Label lblStatus = new Label();
		borderPane.setTop(lblStatus);
		BorderPane.setAlignment(lblStatus, Pos.CENTER);

		// Create a scene and place it in the stage
		Scene scene = new Scene(borderPane, 400, 250);
		primaryStage.setTitle("HOMEWORK2"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		/**
		 * Homework 2
		 * Create two stepControl classes, one for binary search and one for linear search with following methods:
		 *  searchType = 0 for binary search and 1 for linear search
		 *
		 * 
		 *  StepControl_linearSearch class:
		 * 
		 *  StepControl_linearSearch() {
      			initializeNumbers();
            }
		 *  public int getSearchType() //return 1
		 *  public int[] getArray()
		 *  public int getLow()  // not useful for linear search just return 0
		 *  public int getHigh() // not useful for linear search just return 0
		 *  public void setKey(double key)
		 *  public void initializeNumbers()
		 *  public int getCurrentIndex()
		 *  public void reset()
		 *  public int step()
		 *  
		 *   StepControl_binarySearch class:
		 *   
		 *  StepControl_binarySearch() {
				initializeNumbers();
			}		
			
			public int getSearchType() // return 0
		 *  public int[] getArray()
		 *  public void setKey(double key)
		 *  public void initializeNumbers()
		 *  public int getCurrentIndex()
		 *  public void reset()
		 *  public int getLow()
		 *  public int getHigh()
		 *  public int step() 
		 *  
		 *  
		 */


		StepControl_linearSearch stepControl = new StepControl_linearSearch();
	//StepControl_binarySearch stepControl = new StepControl_binarySearch();
		
	    pane.setNumbers(stepControl.getSearchType(), stepControl.getArray());
	        
	    pane.widthProperty().addListener(ov -> pane.repaint()); 
	    pane.heightProperty().addListener(ov -> pane.repaint());

	    btStep.setOnAction(e -> {    
	        if (tfKey.isEditable()) {
	          stepControl.setKey(Double.parseDouble(tfKey.getText()));
	          tfKey.setEditable(false);
	        }
 
	        pane.setColoredBarIndex(stepControl.getLow(), stepControl.getHigh()); // Continue >>>binary
	        
	        int status = stepControl.step();

	        if (status == 0)
	          pane.setColoredBarIndex(stepControl.getCurrentIndex() - 1); // Continue
	        else if (status == 1) {
	          pane.setColoredBarIndex(stepControl.getCurrentIndex()); // Found
	          lblStatus.setText("The key is found in the array at index " +
	            stepControl.getCurrentIndex()); // Found
	        }
	        else if (status == -1)
	          lblStatus.setText("The key is not in the array");
	      });
	      
	      btReset.setOnAction(e -> {
	        stepControl.reset();
	        tfKey.setEditable(true);
	        lblStatus.setText(""); 
	        tfKey.setText("");
	        pane.setColoredBarIndex( 0, -1); 
	      });
	}
}


