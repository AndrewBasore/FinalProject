package application;

public class Pancake extends Item{

	String type;
	
	public Pancake(double price, String name) {
		super(price, name);
		this.type = "Pancake";
	}

}
