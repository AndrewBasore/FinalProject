package application;

import javafx.scene.control.ListView;

/*
 * Item is a generic type for menu items. We will make classes that extend from Item to make different types of items (Desserts/Entrees ect.)
 */
public class Item {
	private double price;
	private String name;
	private String type;
	
	//ArrayList<Modifier>  modifierList; (NYI)
	
	
	
	public Item(double price, String name, String type){
		this.price = price;
		this.name = name;
		this.type = type;
		
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
	
	public String getType(){
		return this.type;
	}
	
}
