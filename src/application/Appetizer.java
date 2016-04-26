package application;

public class Appetizer extends Item{

	String type;

	public Appetizer(double price, String name, String type) {
		super(price, name);
		
		this.type = type;
		
	}
}
