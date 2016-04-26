package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public abstract class DisplayScene<E extends Parent> extends Display{
	
	ArrayList<Scene> previousScenesList;
	
	Scene thisScene;
	Stage primaryStage;
	String className;
	
	Node display;
	
	/*
	 * DisplayScene holds the information regarding all previously visited scenes to 
	 * get to this point in the GUI. This implementation should help the programmer
	 * traverse the scene on the primaryStage, and the abstraction of this process
	 * should make it easier for classes extending this to construct and style themselves
	 * without the redundancies of implementing it in each subclass.
	 */
	
	public DisplayScene(ArrayList<Scene> lastPreviousScenesList, Stage primaryStage){
		
		
		this.primaryStage = primaryStage;
		previousScenesList = new ArrayList<>();
		printPreviousList();
		previousScenesList = copyList(lastPreviousScenesList);
		
		
		//makeDisplay must create a Parent Object, typically named 'display', and getDisplay() must return that object.
		 //Scene of display is made, and can be shown to primaryStage by calling showScene()
		
	}
	

	protected void make(){
		makeDisplay();
		makeScene(getDisplay());
	}
	private ArrayList<Scene> copyList(ArrayList<Scene> copiedList){
		ArrayList<Scene> newList = new ArrayList<>();
		for(int i = 0 ; i <  copiedList.size(); i++){
			newList.add(copiedList.get(i));
		}
		
		return newList;
		
	}
	

	
	
	protected void makeScene(Parent display){
		
		this.thisScene = new Scene(display);
		
	}
	
	protected void showScene(){
		this.previousScenesList.add(this.thisScene);
		this.primaryStage.setScene(this.thisScene);
		this.primaryStage.show();
	}
	
	protected ArrayList<Scene> getPreviousScenesList(){
		//This method allows extended classes to see what Scenes are stored
		return previousScenesList;
	}
	
	protected void goToSceneAt(int i){
		if(i < previousScenesList.size()){
			this.primaryStage.setScene(previousScenesList.get(i));
			setStageTitle();
			this.primaryStage.show();
		}
	}
	
	protected void goToSceneAt(int i, String message){
		if(i < previousScenesList.size()){
			this.primaryStage.setScene(previousScenesList.get(i));
			setStageTitle(message);
			this.primaryStage.show();
		}
	}
	
	protected void printPreviousList(){
		for(int i = 0; i< previousScenesList.size(); i++){
			System.out.println(previousScenesList.get(i));
		}
	}
	
	public abstract String toString();
	
	
	
	protected abstract void setStageTitle();
	protected abstract void setStageTitle(String message);

}
