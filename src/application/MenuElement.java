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
	
	FlowPane itemsShown;	
	VBox categories;
	
	public MenuElement(){
		makeDisplay();
	}
	
	
	
	@Override
	void makeDisplay() {
		display = new BorderPane();
		
		makeCategories();
		makeModifiers();
		
	}

	@Override
	BorderPane getDisplay() {
		
		return this.display;
	}
	
	private void makeCategories(){
		categories = new VBox();
		categories.setPadding(new Insets(5));
		
		//Make bev button
		Button bev = new Button("Beverages");
		bev.setStyle(scanCSS("CategoryButton.txt"));
		bev.setOnAction(e ->{
			// showBeverages(); set display.center to flowpane of beverages
		});
		categories.getChildren().add(bev);
		
		//Set categories to display.Left
		display.setLeft(categories);
		
		
		
		
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
		
	}

	@Override
	protected void style() {
		// TODO Auto-generated method stub
		
	}

}
