package application;

public class Appetizer extends Item{

	String type;

	public Appetizer(double price, String name) {
		super(price, name);
		
		this.type = "Appetizer";
		
	}
}
