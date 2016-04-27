

package application;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/*
 * Notes from Andrew: The plan is to make the implementation of the Menu, Options area
 * to be similar to the CheckDisplay class. This should make the code here cleaner, and the
 * other areas easier to manage. However, for now, I have a button in the menu pane that
 * adds to the check, and the display updates automatically. I think the best option to divide 
 * up the work would be to have an area for each person, and then we can integrate them
 * into the display afterwards.
 */
public class SalesDisplay extends DisplayScene<BorderPane>{
	

	VBox checkDisplay = new VBox(1);
	VBox options = new VBox(4);
	BorderPane display = new BorderPane();
	Check currentCheck;
	
	RestaurantDisplay restaurant;
	
	BorderPane paymentDisplay = new BorderPane();
	
	MenuElement menu;
	PaymentElement pay = new PaymentElement(this);

	Button logout = new Button("logout");
	
	public SalesDisplay( ArrayList<Scene> previousList, Stage primaryStage, Check check, RestaurantDisplay restaurant){
		super(previousList, primaryStage);
		this.restaurant = restaurant;
		check.sales = this;
		this.currentCheck = check;
		menu = new MenuElement(currentCheck);
		this.primaryStage = primaryStage;
		
		


		makeDisplay();
		make();
		makeCheckDisplay();
		makeOptionsArea();
		style();
		BorderPane.setAlignment(display.getCenter(), Pos.CENTER);
	}
	
	protected void setCheck(Check newCheck){
		this.currentCheck = newCheck;
	}
	
	private void makeOptionsArea(){
		
		options.setPadding(new Insets(10));
		
		//Make logout button and put it into options
		Button logout = new Button("Logout");
		logout.setPrefWidth(150);
		logout.setPrefHeight(50);
		logout.setStyle(scanCSS("OptionsButtonsCSS.txt"));
		logout.setOnAction(e->{
			logout();
		});
		options.getChildren().add(logout);
		
		//Make pay button that replaces menu with payment UI
		Button pay = new Button("Pay");
		pay.setStyle(scanCSS("OptionsButtonsCSS.txt"));
		pay.setPrefWidth(150);
		pay.setPrefHeight(50);
		pay.setOnAction(e->{
			display.setCenter(this.pay.getDisplay());
			
		});
		options.getChildren().add(pay);
	
		
		//Make menu button that replaces payment with menu UI
		Button menuMain = new Button("Menu");
		menuMain.setPrefWidth(150);
		menuMain.setPrefHeight(50);
		menuMain.setStyle(scanCSS("OptionsButtonsCSS.txt"));
		menuMain.setOnAction(e->{
			display.setCenter(this.menu.getDisplay());
		});
		options.getChildren().add(menuMain);
		
		options.setAlignment(Pos.TOP_CENTER);
		
	}

	protected void style(){
	/*
	 * Reads in CSS for each component of the display
	 */

	options.setStyle(scanCSS("optionsPaneCSS.txt"));
	display.setStyle(scanCSS("mainPaneCSS.txt"));
	
	/*
	 * Some other styling methods are called
	 */
	
	display.setMinWidth(960);
	display.setMinHeight(500);
	

	
	}

	private void logout(){
		
		super.goToSceneAt(0);
	}
	
	private void showMenuArea(){
		display.setCenter(menu.getDisplay());
	}

	public BorderPane getDisplay(){
		
		return this.display;
	}

	@Override
	void makeDisplay() {
		
		
		
		
		display.setLeft(checkDisplay);
		display.setRight(options);
		showMenuArea();

		
		
	}

	protected void makeCheckDisplay(){
		
		Label tableNum = new Label("Table: "+this.currentCheck.tableNum);
		tableNum.setPadding(new Insets(2));
		
		Label serverName = new Label("Server: " + this.currentCheck.serverName);
		serverName.setPadding(new Insets(2));
		VBox infoPane = new VBox();
		VBox paymentPane = new VBox();
		Label tax = new Label(String.format("%50s%5.2f", "Tax:   ", this.currentCheck.tax));
		Label subTotal = new Label(String.format("%47s%5.2f", "Subtotal:   ", this.currentCheck.subTotal));
		Label total = new Label(String.format("%50s%5.2f", "Total:  ", this.currentCheck.total));
		
		paymentPane.setPadding(new Insets(5));
		paymentPane.getChildren().addAll(subTotal, tax, new Label("                                     -----------------"), total);
		paymentPane.setStyle("-fx-background-color: lavender;");
		infoPane.getChildren().addAll(tableNum, serverName);
		infoPane.setStyle("-fx-background-color: lavender;");
		
		
		this.checkDisplay.getChildren().addAll(infoPane, currentCheck.getListView(),paymentPane);
		this.checkDisplay.setPadding(new Insets(20));
	}

	void updateCheckDisplay(){
		

		VBox paymentPane = new VBox();
		Label tax = new Label(String.format("%50s%5.2f", "Tax:   ", this.currentCheck.tax));
		Label subTotal = new Label(String.format("%47s%5.2f", "Subtotal:   ", this.currentCheck.subTotal));
		Label total = new Label(String.format("%50s%5.2f", "Total:  ", this.currentCheck.total));
		Label amountDue = new Label(String.format("Amount Due: %7.2f", this.currentCheck.amountDue));
		paymentPane.getChildren().addAll(subTotal, tax, new Label("                                     -----------------"), total, amountDue);
		paymentPane.setStyle("-fx-background-color: lavender;");
		
		paymentPane.setPadding(new Insets(5));
		
		
		
		this.checkDisplay.getChildren().set(2, paymentPane);

		
		
	}
	
	void updateCheckDisplay(double payment){
		
	}
	
	
	


	@Override
	protected void setStageTitle() {
		super.primaryStage.setTitle("Sales Display: ");
		
	}

	@Override
	protected void setStageTitle(String message) {
		super.primaryStage.setTitle("Sales Display: " + message);
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Sales Display";
	}
	

	
}
