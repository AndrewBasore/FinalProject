package application;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoginDisplay extends DisplayScene<BorderPane>{
	
	
	BorderPane display = new BorderPane();
	RestaurantDisplay restaurant;
	
	HashMap<Integer, String> serverMap = new HashMap<>();
	NumericInputElement input;
	
	
	public LoginDisplay(Stage primaryStage){
		
		super(new ArrayList<Scene>(), primaryStage);
		display = new BorderPane();
		
				
	}
	
	
	

	@Override
	protected void style() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void makeDisplay() {
		display = new BorderPane();
		
		serverMap.put(1423, "Craig M");
		serverMap.put(5283, "Mark K");
		serverMap.put(2156, "Sue C");
		
		input = new NumericInputElement(true);
		Button signIn = new Button("Sign In");
		signIn.setOnAction(e->{
			login();
			
		});
		
		Label greeting = new Label();
		greeting.setText(" Please sign in");
		greeting.setFont(new Font(20));
		
		Image logoImage = new Image("http://www.governancecouncils.com/images/logo/restaurant.png");
		ImageView logo = new ImageView(logoImage);
		
		
		BorderPane inputDisplay = (BorderPane) input.getDisplay();
		signIn.setPadding(new Insets(10));
		signIn.setAlignment(Pos.TOP_RIGHT);
		greeting.setPadding(new Insets(10));
		
		HBox imgBox = new HBox();
		imgBox.setPadding(new Insets(10));
		imgBox.getChildren().add(logo);
		

		VBox centerBox = new VBox(5);
		centerBox.getChildren().addAll(inputDisplay,signIn);
		
		display.setCenter(centerBox);
		
		display.setPadding(new Insets(20));
		
		
		display.setTop(greeting);
		display.setLeft(imgBox);
		
	}

	@Override
	Parent getDisplay() {
		// TODO Auto-generated method stub
		return this.display;
	}

	@Override
	protected void setStageTitle() {
		primaryStage.setTitle("Login Screen");
		
	}




	@Override
	protected void setStageTitle(String message) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "LoginDisplay";
	}
	
	private void login(){
		int inputVal = (int) input.getInput();
		
		if(serverMap.containsKey(inputVal)){
			String keyValue= serverMap.get(inputVal);
			
			restaurant.setServerName(keyValue);
			restaurant.setStageTitle();	
			input.clear();
			
			restaurant.showScene();
			
			
		}
		else{
			input.clear();
			Stage errorShow = new Stage();
			Label error = new Label("Employee not found!");
			
			errorShow.initModality(Modality.APPLICATION_MODAL);
			Button ok = new  Button("ok");
			ok.setOnAction(p->{
				errorShow.close();
			});
			HBox box = new HBox(5);
			box.getChildren().addAll(error, ok);
			box.setAlignment(Pos.CENTER);
			
			Scene errorScene = new Scene(box);
			errorShow.setMinHeight(250);
			errorShow.setMinWidth(500);
			errorShow.setScene(errorScene);
			
			errorShow.setTitle("Error");
			errorShow.showAndWait();
		}
	}
	
	protected void setRestaurant(RestaurantDisplay restaurant){
		this.restaurant = restaurant;
	}

	
}
