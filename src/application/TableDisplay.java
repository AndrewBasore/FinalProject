package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TableDisplay extends DisplayScene<BorderPane>{
	Button button;
	int tableNum;
	ArrayList<Check> checks;
	BorderPane display;
	

	
	/*
	 * I'd like to implement a way to have the button change color depending on whether
	 * 1.) There's a check at the table or not
	 * 2.) If there is a check, I'd like it to change colors depending on how long the check has
	 * last been opened. (Or just how long since the check was created).
	 */
	
	public TableDisplay(int num, Stage primaryStage, ArrayList<Scene> previousList){
		super(previousList, primaryStage);
		this.primaryStage = primaryStage;
		this.tableNum = num;
		
		checks = new ArrayList<Check>();
		makeButton();
		makeDisplay();
		super.makeScene(this.display);
		
	}
	
	public Button getButton(){
		return this.button;
	}
	
	public void makeButton(){
		button = new Button(""+tableNum);
		
		style();
		
		
		if(!checks.isEmpty()){
			button.setStyle("-fx-background-color:green");
		}
		
		button.setOnAction(e->{
			
		});
	}
	
	protected void style(){
	try{
		Scanner scan = new Scanner(new File("TableButtonCSS.txt"));
		scan.useDelimiter("[$]");
		this.button.setStyle(scan.next());
		scan.close();
	}
	catch(Exception e){
		
	}

		button.setPadding(new Insets(20));
	}


	@Override
	protected void setStageTitle() {
		primaryStage.setTitle("Table view at table: " + this.tableNum);
		
	}

	@Override
	void makeDisplay() {
		display = new BorderPane();
		//do some stuff
		display.getChildren().add(new Label("Hi"));
		
	}

	@Override
	Parent getDisplay() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setStageTitle(String message) {
		// TODO Auto-generated method stub
		
	}
	
	protected void addCheck(Check newCheck){
		this.checks.add(newCheck);
	}

	@Override
	public String toString() {
		
		return "TableButton " + this.tableNum ;
	}
	
	protected void updateButton(){
		if(this.checks.isEmpty()){
			this.button.setStyle(scanCSS("TableButtonActiveCSS.txt"));
		}
		else
			this.button.setStyle(super.scanCSS("TableButtonCSS.txt"));
	}
	


}
