package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FinalProject extends Application {

	LoginDisplay login;
	RestaurantDisplay restaurant;

	
	public void start(Stage primaryStage)  {
		primaryStage.setX(0);
		primaryStage.setY(0);
		
		

		login = new LoginDisplay(primaryStage);
		login.make();
		
		login.showScene();
		restaurant = new RestaurantDisplay(login.getPreviousScenesList(), primaryStage);
		login.setRestaurant(restaurant);
		
		
		
		
		

		primaryStage.setTitle("Login Screen");
	
		
		
		
	}
	
	public static void main(String[] args){
		launch();
	}

}
