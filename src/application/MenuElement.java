package application;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/*
 * display is a borderPane that will display everything pertaining to the menu.
 * display.Left will hold buttons that represent categories of items. When pressed,
 * display.Center will populate different items available.
 * display.Top will eventually hold buttons to different modifiers.
 */

public class MenuElement extends Display<BorderPane>{

	BorderPane display;
	
	FlowPane bevsFP = new FlowPane(5,5);
	FlowPane cakesFP = new FlowPane(5,5);
	FlowPane appsFP = new FlowPane(5,5);;
	
	Check targetCheck;
	
	VBox categories;
	
	Menu menu = new Menu();
	
	public MenuElement(Check targetCheck){
		this.targetCheck = targetCheck;
		makeDisplay();
	}
	
	
	
	@Override
	void makeDisplay() {
		
		display = new BorderPane();
		
		//Populates FlowPanes with Item.button's
		makeBevs();
		makeCakes();
		makeApps();
		
		//Create category and modifier buttons
		makeCategories();
		makeModifiers();
		
	}

	@Override
	BorderPane getDisplay() {
		
		return this.display;
	}
	
	private void makeCategories(){
		categories = new VBox(10);
		categories.setPadding(new Insets(5));
		
		//Make bev button and add to categories
		Button bev = new Button("Beverages");
		bev.setPrefWidth(100);
		bev.setPrefHeight(40);
		bev.setStyle(scanCSS("CategoryButton.txt"));
		bev.setOnAction(e ->{
			showBeverages();
		});
		categories.getChildren().add(bev);
		
		//Make pancake button and add to categories
		
		Button cakes = new Button("Pancakes");
		cakes.setStyle(scanCSS("CategoryButton.txt"));
		cakes.setPrefWidth(100);
		cakes.setPrefHeight(40);
		cakes.setOnAction(e->{
			showPancakes();
		});
		categories.getChildren().add(cakes);
		
		//Make appetizer button and add to categories
		
		Button apps = new Button("Appetizers");
		apps.setPrefWidth(100);
		apps.setPrefHeight(40);
		apps.setStyle(scanCSS("CategoryButton.txt"));
		apps.setOnAction(e->{
			showApps();
		});
		categories.getChildren().add(apps);
		
		
		//Set categories to display.Left
		display.setLeft(categories);
		
		
		
		
	}
	
	private void makeBevs(){
		menu.sortArray(menu.bevSet);

		
		for(int i = 0; i < menu.bevSet.size(); i++){
			Item bev = menu.bevSet.get(i);
			bev.getButton().setOnAction(e->{
				targetCheck.addItem(bev);
			});
			bevsFP.getChildren().add(bev.getButton());
			
		
		}
	}
	
	private void makeCakes(){
		menu.sortArray(menu.cakeSet);
		
		
		for(int i = 0; i < menu.cakeSet.size(); i++){
			Item cake = menu.cakeSet.get(i);
			cake.getButton().setOnAction(e->{
				targetCheck.addItem(cake);
			});
			cakesFP.getChildren().add(cake.getButton());
			
		
		}
	}
	
	private void makeApps(){
		menu.sortArray(menu.appSet);
		
		for(int i = 0; i < menu.appSet.size(); i++){
			Item app = menu.appSet.get(i);
			app.getButton().setOnAction(e->{
				targetCheck.addItem(app);
			});
			appsFP.getChildren().add(app.getButton());
			
		
		}
		
		
		
	}
	
	
	private void makeModifiers(){
		Button mod1 = new Button("Modifier 1");
		mod1.setStyle(scanCSS("ModifierButton.txt"));
		Button mod2 = new Button("Modifier 2");
		mod2.setStyle(scanCSS("ModifierButton.txt"));
		Button mod3 = new Button("Modifier 3");
		mod3.setStyle(scanCSS("ModifierButton.txt"));
		
		HBox modBox = new HBox(3);
		modBox.setPadding(new Insets(5));
		
		modBox.getChildren().addAll(mod1, mod2, mod3);
		
		display.setTop(modBox);
		
	}
	
	private void showBeverages(){
		
		display.setCenter(bevsFP);
	}
	
	private void showPancakes(){
		display.setCenter(cakesFP);
	}
	
	private void showApps(){
		display.setCenter(appsFP);
	}

	@Override
	protected void style() {
		// TODO Auto-generated method stub
		
	}
	
	

}
