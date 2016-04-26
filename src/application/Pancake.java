package application;

public class Pancake extends Item{

	String type;
	
	public Pancake(double price, String name, String type) {
		super(price, name);
		this.type = type;
	}

}
