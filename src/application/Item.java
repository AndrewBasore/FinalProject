package application;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/*
 * Item is a abstract type for menu items. We will make classes that extend from Item to make different types of items (Desserts/Entrees ect.)
 */
public class Item extends Stylable implements Comparable{
	private double price;
	private String name;
	
	protected String type;
	
	private Button itemButton;
	
	
	
	public Item(double price, String name){
		itemButton = new Button(name);
		style();
		this.price = price;
		this.name = name;
		this.type = "Item";
		
	}
	
	
	public String toString(){
		
				
	
	
		return String.format("%-25s$%7.2f", this.name, this.price);
		
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
		this.itemButton.setMaxWidth(125);
		this.itemButton.setMaxHeight(50);
		
		this.itemButton.setMinWidth(125);
		this.itemButton.setMinHeight(50);
		
	}
	
	protected int compareTo(Item otherItem){
		
		int result = this.toString().compareTo(otherItem.toString());
		System.out.println("compareTo(Item) is being called. result: "+ result);
		return result;
	}


	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		System.out.println("compareTo(Object) is being called");
		return this.toString().compareTo(arg0.toString());
	}
	

	
}
