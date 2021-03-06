package application;



import java.util.Set;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button; // work on makeButtons()
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/*
 * LoginDisplay holds the display an employee will use to
 * log into the software.
 */
public class NumericInputElement extends Stylable{
	BorderPane display;
	TextField inputArea;
	VBox centerArea;
	
	VBox buttons = new VBox(3);
	HBox row1 = new HBox(3);
	HBox row2 = new HBox(3);
	HBox row3 = new HBox(3);
	HBox row4 = new HBox(3);
	HBox row5 = new HBox(3);
	
	
	boolean visible;
	double input;
	//Need a field for target to determine where input is passed to
	
	

	public NumericInputElement(boolean visibleInput){
		super();
		makeDisplay(visibleInput);
		
		}
	
	void makeDisplay(boolean visibleInput) {
		display = new BorderPane();
		
		display.setPadding(new Insets(10,10,10,10));
		display.setMaxHeight(200);
		display.setMaxWidth(210);
		
		inputArea = new TextField();
		inputArea.setMaxWidth(140);
		inputArea.setMinWidth(140);
		inputArea.editableProperty().set(false);
		centerArea = new VBox(5);
		makeButtons();
		
		//Center area is populated and styled
		if(visibleInput == true){
			centerArea.getChildren().addAll(inputArea,buttons);
		}
		else
			centerArea.getChildren().addAll(buttons);
		
		display.setCenter(centerArea);
		display.setStyle(scanCSS("optionsPaneCSS.txt"));

		
	}

	
	void updateDisplay() {
		// TODO Auto-generated method stub
		
	}

	
	BorderPane getDisplay() {
		
		return display;
	}

	
	protected void style() {
		// TODO Auto-generated method stub
		
	}
	
	private void makeButtons(){

		
		Button num1 = new Button("1");
		num1.setPrefSize(60, 50);
		
		num1.setOnAction(e -> {
			inputArea.appendText("1");
		});
		num1.setStyle(scanCSS("InputButtonCSS.txt"));
		
		Button num2 = new Button("2");
		num2.setPrefSize(60, 50);
		num2.setOnAction(e -> {
			inputArea.appendText("2");
		});
		num2.setStyle(scanCSS("InputButtonCSS.txt"));
		
		Button num3 = new Button("3");
		num3.setPrefSize(60, 50);
		num3.setOnAction(e -> {
			inputArea.appendText("3");
		});
		num3.setStyle(scanCSS("InputButtonCSS.txt"));
		
		Button num4 = new Button("4");
		num4.setPrefSize(60, 50);
		num4.setOnAction(e -> {
			inputArea.appendText("4");
		});
		num4.setStyle(scanCSS("InputButtonCSS.txt"));
		Button num5 = new Button("5");
		num5.setOnAction(e -> {
			inputArea.appendText("5");
		});
		num5.setStyle(scanCSS("InputButtonCSS.txt"));
		num5.setPrefSize(60, 50);
		Button num6 = new Button("6");
		num6.setPrefSize(60, 50);
		num6.setOnAction(e -> {
			inputArea.appendText("6");
		});
		num6.setStyle(scanCSS("InputButtonCSS.txt"));
		Button num7 = new Button("7");
		num7.setPrefSize(60, 50);
		num7.setOnAction(e -> {
			inputArea.appendText("7");
		});
		num7.setStyle(scanCSS("InputButtonCSS.txt"));
		Button num8 = new Button("8");
		num8.setPrefSize(60, 50);
		num8.setOnAction(e -> {
			inputArea.appendText("8");
		});
		num8.setStyle(scanCSS("InputButtonCSS.txt"));
		Button num9 = new Button("9");
		num9.setPrefSize(60, 50);
		num9.setOnAction(e -> {
			inputArea.appendText("9");
		});
		num9.setStyle(scanCSS("InputButtonCSS.txt"));
		Button num0 = new Button("0");
		num0.setPrefSize(60, 50);
		num0.setOnAction(e -> {
			inputArea.appendText("0");
		});
		num0.setStyle(scanCSS("InputButtonCSS.txt"));
		
		Button clear = new Button("Clear");
		clear.setPrefSize(60, 50);
		clear.setOnAction(e->{
			inputArea.clear();
		});
		clear.setStyle(scanCSS("InputButtonCSS.txt"));
		
		Button decimal = new Button(".");
		decimal.setPrefSize(60, 50);
		decimal.setOnAction(e ->{
			if(!inputArea.getText().contains(".")){
				inputArea.appendText(".");
			}
			
		});
		decimal.setStyle(scanCSS("InputButtonCSS.txt"));
		
		Button doubleZero = new Button("00");
		doubleZero.setPrefSize(60, 50);
		doubleZero.setOnAction(e->{
			inputArea.appendText("00");
		});
		doubleZero.setStyle(scanCSS("InputButtonCSS.txt"));
		
		Button submit = new Button("Submit");
		submit.setOnAction(e->{
			System.out.println("Text field is being submitted");
		});
		
		row1.getChildren().addAll(num7,num8,num9);
		row2.getChildren().addAll(num4,num5,num6);
		row3.getChildren().addAll(num1,num2,num3);
		row4.getChildren().addAll(num0,doubleZero,decimal);
		row5.getChildren().add(clear);
		
		buttons.getChildren().addAll(row1,row2,row3,row4,row5);
		
		
	}
	
	protected void removeDecimal(){
		row4.getChildren().remove(2);
		buttons.getChildren().remove(4);
		
		Button clear = new Button("Clear");
		clear.setPrefSize(60, 50);
		clear.setOnAction(e->{
			inputArea.clear();
		});
		clear.setStyle(scanCSS("InputButtonCSS.txt"));
		
		row4.getChildren().add(clear);
	}
	
	protected double getInput(){ //implement way to parse input into double value
		
		String input = inputArea.getText();
		if(input.equals(""))
			return 0;
		else
			return Double.parseDouble(inputArea.getText());
	}

	
	void makeDisplay() {
		display = new BorderPane();
		display.setPadding(new Insets(10,10,10,10));
		inputArea = new TextField();
		inputArea.setMaxWidth(140);
		inputArea.setMinWidth(140);
		inputArea.editableProperty().set(false);
		centerArea = new VBox(5);
		makeButtons();
		
		//Center area is populated and styled
		
		centerArea.getChildren().addAll(inputArea,buttons);
		
		
		display.setCenter(centerArea);
		display.setStyle(scanCSS("optionsPaneCSS.txt"));
		
	}
	
	protected void clear(){
		inputArea.clear();
	}
	

	


}
