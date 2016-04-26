package application;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/*
 * Item is a abstract type for menu items. We will make classes that extend from Item to make different types of items (Desserts/Entrees ect.)
 */
public class Item extends Stylable{
	private double price;
	private String name;
	
	protected String type;
	
	private Button itemButton;
	
	
	
	public Item(double price, String name){
		itemButton = new Button(name);
		this.price = price;
		this.name = name;
		this.type = "Item";
		
	}
	
	
	public String toString(){
	
	
		return name + "                           $" + price;
		
	}
	
	/*
	 * returns private attribute of price from Item
	 */
	public double getPrice(){
		double totalPrice = this.price;      //Later implement ability to add modifiers charges
		return totalPrice;
	}
	
	/*
	 * return private attribute of name from Item
	 */
	public String getName(){
		return this.name;
	}
	
	public Button getButton(){
		return this.itemButton;
	}
	



	@Override
	protected void style() {
		this.itemButton.setStyle(scanCSS("ItemButtonCSS.txt"));
		
	}
	
	protected int compareTo(Item otherItem){
		
		return this.toString().compareTo(otherItem.toString());
	}
	

	
}
