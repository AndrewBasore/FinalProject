package application;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
	
	
	ArrayList<TableDisplay> tableArray;
	
	
	String currentServer;
	
	public RestaurantDisplay(ArrayList<Scene> previousList, Stage primaryStage){
		super(previousList, primaryStage);
		
		

		makeDisplay();
		super.makeScene(this.display);
		
	}

	@Override
	void makeDisplay() {
		style();
		populateTableArray();
		VBox restaurantDisplay = new VBox(20);
		
		HBox tables = new HBox(75);
		tables.setPadding(new Insets(10));
		
		VBox deskBoard = new VBox(5);
		
		
		for(int i = 1; i < 8; i++){
			
			int index = i;
			Button tensButton = new TableDisplay(i, super.primaryStage, super.getPreviousScenesList()).getButton();
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
			
			
			
			Button thirtiesButton = new TableDisplay(i, super.primaryStage, super.getPreviousScenesList()).getButton();
			Button fortiesButton = new TableDisplay(i+10, super.primaryStage, super.getPreviousScenesList()).getButton();
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
		
			Button teensButton = new TableDisplay(i, super.primaryStage, super.getPreviousScenesList()).getButton();
			Button twentiesButton = new TableDisplay(i+10, super.primaryStage, super.getPreviousScenesList()).getButton();
			teensButton.setOnAction(e->{
				tableArray.get(index);
			});
			twentiesButton.setOnAction(e->{
				tableButtonPress(index + 10);
			});
			
			row.getChildren().addAll(teensButton, twentiesButton);
			colFiftiesSixties.getChildren().add(row);
		}
		
		for(int i = 71; i < 78; i++){
			
			int index = i;
			Button seventiesButton = new TableDisplay(i, super.primaryStage, super.getPreviousScenesList()).getButton();
			seventiesButton.setOnAction(e ->{
				tableButtonPress(index);
			});
			colSeventies.getChildren().add(seventiesButton);
		}
		
		tables.getChildren().addAll(colOnes, colTeensTwenties, colThirtiesForties, colFiftiesSixties,colSeventies);
		
		HBox buttonRow = new HBox(1);
		
		Button makeNewCheck = new Button("New Check");
		makeNewCheck.setOnAction(e ->{
			//Show prompt to ask for table number
		});
		
		Button logout = new Button("Logout");
		logout.setOnAction(e->{
			logout();
		});;
		
		buttonRow.getChildren().addAll(makeNewCheck,logout);

		
		buttonRow.setPadding(new Insets(20,0,0,0));
		restaurantDisplay.setPadding(new Insets(20));
		
		display.setCenter(tables);
		display.setBottom(buttonRow);
		
		
	}

	public void setcurrentServer(String currentServer){
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
		
		
		if(tableArray.get(tableNum).checks.isEmpty()){
			
			tableArray.get(tableNum).addCheck(new Check(this.currentServer, tableNum));
			SalesDisplay salesDisplay = new SalesDisplay(super.getPreviousScenesList(), super.primaryStage, tableArray.get(tableNum).checks.get(0));
			
			salesDisplay.showScene();
		}
		else{
			//Work on this later to show multiple checks that exist at the table. For now, it opens the only check
			SalesDisplay salesDisplay = new SalesDisplay(super.getPreviousScenesList(), super.primaryStage, tableArray.get(tableNum).checks.get(0));
			salesDisplay.showScene();
		}
	}
	private void logout(){
		
		super.goToSceneAt(0, "Please Sign In: ");
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
