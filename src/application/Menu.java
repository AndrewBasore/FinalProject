package application;

import java.util.ArrayList;
import java.util.TreeSet;

/*
 * Menu class holds sets representing categories, and all
 * of the items the restaurant offers is stored in the sets
 */
public class Menu {
	
	ArrayList<Beverage> bevSet = new ArrayList<>();
	ArrayList<Pancake> cakeSet = new ArrayList<>();
	ArrayList<Appetizer> appSet = new ArrayList<>();
	
	
	public Menu(){
		populateBev();
		populateCake();
		populateApps();

	}
	
	
	private void populateBev(){
		bevSet.add(new Beverage(2.09, "Pepsi"));
		bevSet.add(new Beverage(2.09, "Sierra"));
		bevSet.add(new Beverage(2.09, "Diet"));
		bevSet.add(new Beverage(2.09, "Root Beer"));
		bevSet.add(new Beverage(2.09, "Iced Tea"));
		bevSet.add(new Beverage(2.39, "Rasp Tea"));
		bevSet.add(new Beverage(2.09, "Mtn Dew"));
		bevSet.add(new Beverage(2.09, "Coffee"));
		bevSet.add(new Beverage(2.09, "Decaff"));
		bevSet.add(new Beverage(1.49, "Hot Tea"));
		bevSet.add(new Beverage(2.09, "Lemonade"));
		bevSet.add(new Beverage(2.29, "Straw Lem"));
		bevSet.add(new Beverage(2.09, "Hot Choc"));
		bevSet.add(new Beverage(2.39, "OJ"));
		bevSet.add(new Beverage(2.39, "Milk"));
		System.out.println("bevSet finished populating and it's size is: " + bevSet.size());
		
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
