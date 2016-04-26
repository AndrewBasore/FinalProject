package application;

import java.util.TreeSet;

/*
 * Menu class holds sets representing categories, and all
 * of the items the restaurant offers is stored in the sets
 */
public class Menu {
	
	TreeSet<Beverage> bevSet = new TreeSet<>();
	TreeSet<Pancake> cakeSet = new TreeSet<>();
	TreeSet<Appetizer> appSet = new TreeSet<>();
	
	
	public Menu(){
		populateBev();
		populateCake();
		populateApps();

	}
	
	
	private void populateBev(){
		bevSet.add(new Beverage(2.09, "Pepsi"));
		bevSet.add(new Beverage(2.09, "Sierra Mist"));
		bevSet.add(new Beverage(2.09, "Diet Pepsi"));
		bevSet.add(new Beverage(2.09, "Root Beer"));
		bevSet.add(new Beverage(2.09, "Iced Tea"));
		bevSet.add(new Beverage(2.39, "Rasp Tea"));
		bevSet.add(new Beverage(2.09, "Mtn Dew"));
		bevSet.add(new Beverage(2.09, "Coffee"));
		bevSet.add(new Beverage(2.09, "Decaff"));
		bevSet.add(new Beverage(1.49, "Hot Tea"));
		bevSet.add(new Beverage(2.09, "Lemonade"));
		bevSet.add(new Beverage(2.29, "Strawberry Lemonade"));
		bevSet.add(new Beverage(2.09, "Hot Choc"));
		bevSet.add(new Beverage(2.39, "Orange Juice"));
		bevSet.add(new Beverage(2.39, "Milk"));
		
	}
	
	private void populateCake(){
		
		cakeSet.add(new Pancake(3.99, "Short"));
		cakeSet.add(new Pancake(4.99, "Full"));
		cakeSet.add(new Pancake(5.99, "Rasp Pan"));
		cakeSet.add(new Pancake(5.99, "NY Chz Pan"));
		cakeSet.add(new Pancake(4.99, "AYCE Pan"));
		cakeSet.add(new Pancake(5.99, "RWCC Pan"));
		cakeSet.add(new Pancake(3.99, "Choc Pan"));
		
	}
	
	private void populateApps(){
		appSet.add(new Appetizer(7.99, "Mozz Sticks"));
		appSet.add(new Appetizer(8.50, "Quesadilla"));
		appSet.add(new Appetizer(4.50, "OR Basket"));
	}

}
