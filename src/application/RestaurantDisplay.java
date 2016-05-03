package application;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RestaurantDisplay extends DisplayScene<BorderPane>{
	
	
	BorderPane display = new BorderPane();
	/*
	 * Elements of display
	 */
	VBox colOnes = new VBox(20);
	VBox colSeventies = new VBox(20);
	VBox colTeensTwenties = new VBox(20);
	VBox colThirtiesForties = new VBox(20);
	VBox colFiftiesSixties = new VBox(20);
	HBox tables = new HBox(75);
	
	FlowPane openChecks = new FlowPane(5,5);
	
	ArrayList<TableDisplay> tableArray;
	ArrayList<Check> closedChecks = new ArrayList<>();
	
	String currentServer;
	
	public RestaurantDisplay(ArrayList<Scene> previousList, Stage primaryStage){
		super(previousList, primaryStage);
		openChecks.setPadding(new Insets(20));
		

		makeDisplay();
		super.makeScene(this.display);
		
	}

	@Override
	void makeDisplay() {
		
		style();
		populateTableArray();
		VBox restaurantDisplay = new VBox(20);
		
		
		tables.setPadding(new Insets(10));
		
		VBox deskBoard = new VBox(5);
		
		/*
		 * These loops populate columns with appropriate table buttons
		 */
		for(int i = 1; i < 8; i++){
			
			int index = i;
			Button tensButton = tableArray.get(i).getButton();
			tensButton.setOnAction(e->{
				tableButtonPress(index);
			});
			colOnes.getChildren().add(tensButton);
			
		}
		
		
		for(int i = 11; i < 18; i++){
			HBox row = new HBox(3);
			int index = i;
			Button teensButton = tableArray.get(i).getButton();
			Button twentiesButton = tableArray.get(i+10).getButton();
			teensButton.setOnAction(e->{
				tableButtonPress(index);
			});
			twentiesButton.setOnAction(e->{
				tableButtonPress(index + 10);
			});
			
			row.getChildren().addAll(teensButton, twentiesButton);
			colTeensTwenties.getChildren().add(row);
		}
		
		for(int i = 31; i < 38; i++){
			HBox row = new HBox(3);
			int index = i;
			
			
			
			Button thirtiesButton = tableArray.get(i).getButton();
			Button fortiesButton = tableArray.get(i+10).getButton();
			thirtiesButton.setOnAction(e->{
				tableButtonPress(index);
			});
			fortiesButton.setOnAction(e->{
				tableButtonPress(index+10);
			});
			
			row.getChildren().addAll(thirtiesButton, fortiesButton);
			colThirtiesForties.getChildren().add(row);
		}
		
		for(int i = 51; i < 58; i++){
			int index = i;
			HBox row = new HBox(3);
		
			Button teensButton = tableArray.get(i).getButton();
			Button twentiesButton = tableArray.get(i+10).getButton();
			teensButton.setOnAction(e->{
				tableButtonPress(index);
			});
			twentiesButton.setOnAction(e->{
				tableButtonPress(index + 10);
			});
			
			row.getChildren().addAll(teensButton, twentiesButton);
			colFiftiesSixties.getChildren().add(row);
		}
		
		for(int i = 71; i < 78; i++){
			
			int index = i;
			Button seventiesButton = tableArray.get(i).getButton();
			seventiesButton.setOnAction(e ->{
				tableButtonPress(index);
			});
			colSeventies.getChildren().add(seventiesButton);
		}
		
		tables.getChildren().addAll(colOnes, colTeensTwenties, colThirtiesForties, colFiftiesSixties,colSeventies);
		
		
		/*
		 * Create buttonRow and populate it with appropriate options
		 */
		HBox buttonRow = new HBox(1);
		
		
		Button showOpenChecks = new Button("Open Checks");
		showOpenChecks.setOnAction(e ->{
			showOpenChecks();
		});
		
		Button showClosedChecks = new Button("Closed Checks");
		showClosedChecks.setOnAction(e->{
			showClosedChecks();
		});
		
		Button logout = new Button("Logout");
		logout.setOnAction(e->{
			logout();
		});;
		
		Button restaurant = new Button("Restaurant");
		restaurant.setOnAction(e->{
			showTables();
		});
		
		
		/*
		 * some in-line styling
		 */
		showOpenChecks.setStyle(scanCSS("OptionsButtonsCSS.txt"));
		showClosedChecks.setStyle(scanCSS("OptionsButtonsCSS.txt"));
		logout.setStyle(scanCSS("OptionsButtonsCSS.txt"));
		restaurant.setStyle(scanCSS("OptionsButtonsCSS.txt"));
		
		buttonRow.getChildren().addAll(showOpenChecks, showClosedChecks, restaurant,logout);
		
	

		
		buttonRow.setPadding(new Insets(20,0,0,0));
		restaurantDisplay.setPadding(new Insets(20));
		
		display.setCenter(tables);
		display.setBottom(buttonRow);
		
		
	}

	public void setCurrentServer(String currentServer){
		this.currentServer = currentServer;
	}
	
	
	


	@Override
	BorderPane getDisplay() {
		// TODO Auto-generated method stub
		return this.display;
	}



	
	
	protected void style() {
		this.display.setStyle("-fx-background-color: #5C5393;");
		
	}

	

	
	protected void setStageTitle(){

		this.primaryStage.setTitle("Restaurant View: "+ currentServer);
	}

	@Override
	protected void setStageTitle(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "RestaurantDisplay";
	}

	public void setServerName(String string) {
		this.currentServer = string;
		
	}
	

	private void tableButtonPress(int tableNum){
		/*On tableButtonPress(), one of two things should happen:
		 * 1.) If table has no open checks, then a new check is created and shown (makeNewCheck())
		 * 2.) If table does have open checks, they should be shown in a flowPane set to the center of the display,
		 * and then open checks can be selected 
		 */
		
		if(tableArray.get(tableNum).checks.isEmpty()){
			makeNewCheck(tableNum);			
		}
		else{
			showOpenChecks(tableNum);
		}
	}
	private void logout(){
		display.setCenter(tables);
		super.primaryStage.setTitle("Login Screen");
		super.goToSceneAt(0, "Please Sign In: ");
	}
	
	private void makeNewCheck(int tableNum){
		tableArray.get(tableNum).addCheck(new Check(this.currentServer, tableNum));
		showSalesDisplay(tableArray.get(tableNum).checks.get(0));
		
	}
	
	private Button getCheckButton(Check check){
		Button checkButton = new Button(String.format("Table: %d\n\n#%d\n\n$%.2f", check.tableNum, check.checkNum, check.total));
		checkButton.setPrefSize(100, 100);
		checkButton.setOnAction(e->{
			display.setCenter(tables);
			showSalesDisplay(check);
		});
		
		
		return checkButton;
	}
	
	private void showTables(){
		super.primaryStage.setTitle("Restaurant View: " + this.currentServer);
		display.setCenter(tables);
	}
	
	private void showSalesDisplay(Check check){
		SalesDisplay salesDisplay = new SalesDisplay(super.getPreviousScenesList(), super.primaryStage, check, this);
		salesDisplay.showScene();
	}
	
	private void showOpenChecks(int tableNum){ //Shows open checks at a specific table number
		/*
		 * This method takes a tableNum that is presumably not empty, and then populates a flowpane of its open checks
		 * and then sets the center display to this flowpane
		 */
		
		super.primaryStage.setTitle("Open Checks at table " + tableNum);
		if(tableArray.get(tableNum).checks.isEmpty()){ //extra conditional check to make sure that method does not execute if table's checks is empty
			System.out.println("checks is empty!");
			return;
		}
		else{
			openChecks.getChildren().clear();

			for(Check check: tableArray.get(tableNum).checks){
				openChecks.getChildren().add(getCheckButton(check));
			}
			display.setCenter(openChecks);
		}
			
	}

	private void showOpenChecks(){ //Shows open checks for all checks in the restaurant
		openChecks.getChildren().clear();
		super.primaryStage.setTitle("Open Checks");
		for(TableDisplay table: tableArray){
			for(Check check: table.checks){
				openChecks.getChildren().add(getCheckButton(check));
			}
		}
		display.setCenter(openChecks);
		
		
	}
	
	private void showClosedChecks(){
		super.primaryStage.setTitle("Closed Checks");
		openChecks.getChildren().clear();
		for(Check check: closedChecks){
			openChecks.getChildren().add(getCheckButton(check));
		}
		display.setCenter(openChecks);
		
	}
	
	private void updateButtons(){
		for(TableDisplay table: tableArray){
			table.updateButton();
		}
	}
	
	private void populateTableArray(){
		tableArray = new ArrayList<>();
		for(int i = 0; i< 78; i++){
			tableArray.add(new TableDisplay(i, super.primaryStage, super.previousScenesList));
		}
	}
	
	protected void showScene(){
		
		updateButtons();
		super.showScene();
	}
	

	

	
}
