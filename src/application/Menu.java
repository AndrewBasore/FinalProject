package application;

import java.util.ArrayList;
import java.util.TreeSet;

/*
 * Menu class holds sets representing categories, and all
 * of the items the restaurant offers is stored in the sets
 */
public class Menu {

	ArrayList<Item> bevSet = new ArrayList<>();
	ArrayList<Item> cakeSet = new ArrayList<>();
	ArrayList<Item> appSet = new ArrayList<>();

	public Menu() {
		populateBev();
		populateCake();
		populateApps();

	}

	private void populateBev() {
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
		sortArray(bevSet);

	}

	private void populateCake() {

		cakeSet.add(new Pancake(3.99, "Short"));
		cakeSet.add(new Pancake(4.99, "Full"));
		cakeSet.add(new Pancake(5.99, "Rasp Pan"));
		cakeSet.add(new Pancake(5.99, "NY Chz Pan"));
		cakeSet.add(new Pancake(4.99, "AYCE Pan"));
		cakeSet.add(new Pancake(5.99, "RWCC Pan"));
		cakeSet.add(new Pancake(3.99, "Choc Pan"));

	}

	private void populateApps() {
		appSet.add(new Appetizer(7.99, "Mozz Sticks"));
		appSet.add(new Appetizer(8.50, "Quesadilla"));
		appSet.add(new Appetizer(4.50, "OR Basket"));
	}

	// helper method to sort arrays of Items. Sloppy sort sorry dont judge
	public void sortArray(ArrayList<Item> listToSort) {

		int counter = 1;
		while (counter != 0) {
			counter = 0;
			for (int i = 0; i < listToSort.size() - 1; i++) {
				Item a = listToSort.get(i);
				Item b = listToSort.get(i + 1);
				if (a.compareTo(b) > 0) {

					listToSort.set(i, b); // Items are swapped in list
					listToSort.set(i + 1, a);
					counter++;

				}

			}

		}

	}

}
