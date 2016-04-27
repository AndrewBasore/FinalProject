package application;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/*
 * Check class holds all information for guest checks and payment. It is a List of Items, fields that hold information on money,
 * and a CheckDisplay, which is handled in the CheckDisplay class.
 */
public class Check {

	/*
	 * itemList field and a unique checkNum identifier
	 */
	int checkNum, tableNum;
	protected ArrayList<Item> itemList;
	protected ListView<String> checkList;
	private boolean isCheckClosed;
	protected String serverName = "Andrew B";
	
	SalesDisplay sales;
	RestaurantDisplay restaurant;

	/*
	 * Fields pertaining to $
	 */
	protected double subTotal, total, tax, discounts, amountDue, changeDueBack, payment;
	protected final double taxRate = .06; // Sales tax rate for Michigan, can be
										// changed for other places

	public Check(String serverName, int tableNum) {
		/*
		 * constructor opens the check by setting isCheckClosed to false,
		 * initializes the itemList
		 */
		
		this.serverName = serverName;
		

		isCheckClosed = false;
		checkList = new ListView<>();
		itemList = new ArrayList<Item>();

		/*
		 * Implement assignment for checkNum and tableNum later. literal values
		 * are used right now for display purposes
		 */
		
		this.tableNum = tableNum;

	}
	
	

	public void print() {

		// This method prints the check as a reciept to the console (Or to a
		// printer)

	}

	public void addItem(Item newItem) {

		/*
		 * addItem takes newItem as a parameter and appends it to the check.
		 */

		// Item is added to ItemList and display is updated
		itemList.add(newItem);
		
		
		checkList.getItems().add(newItem.toString());
		// Total is recalculated
		calculateTotal();
		calculateAmountDue();
	
		sales.updateCheckDisplay();

	}

	public Item getLastItem() {

		return itemList.get(itemList.size() - 1);

	}
	
	public ListView<String> getListView(){
		return this.checkList;
	}

	public boolean isCheckEmpty() {
		return itemList.isEmpty();
	}

	protected void payCash(double payment) {
		/*
		 * payCash deducts payment from amountDue. Then, if amountDue is reduced
		 * to 0, or below, change is generated, amountDue is set to 0, and the
		 * check is closed.
		 */
		
		String payString = String.format("Cash Payment:       -$%7.2f",  payment);
		this.payment = this.payment + payment;
		checkList.getItems().add(payString);

		amountDue = amountDue - payment;
		if (amountDue <= 0) {
			changeDueBack = amountDue * -1;
			amountDue = 0;
			closeCheck();
		}

	}

	private void payCredit() {
		/*
		 * Implement credit gratuity?
		 */

	}

	private void calculateTotal() {
		/*
		 * calculateTotal() updates the total, discounts, and subTotal
		 */

		subTotal = 0;
		for (int i = 0; i < itemList.size(); i++) {
			subTotal += itemList.get(i).getPrice();
		}
		tax = subTotal * taxRate;
		total = subTotal + tax;
	}

	private void closeCheck() {
		/*
		 * closeCheck changes isCheckClosed to true, and removes check from RestaurantDisplay's active checks to closed checks
		 */
		this.restaurant = sales.restaurant;
		isCheckClosed = true;
		int index = restaurant.tableArray.get(tableNum).checks.indexOf(this);
		restaurant.tableArray.get(tableNum).checks.remove(index);
		restaurant.closedChecks.add(this);
		restaurant.goToSceneAt(0);
		
	}
	
	protected boolean isCheckClosed(){
		return this.isCheckClosed;
	}

	private void calculateAmountDue(){
		this.amountDue = this.total - this.payment;
	}


}
