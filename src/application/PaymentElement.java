package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class PaymentElement extends Display<BorderPane> {

	SalesDisplay sales;
	NumericInputElement input;

	Button payCash;

	BorderPane display = new BorderPane();

	public PaymentElement(SalesDisplay sales) {
		this.sales = sales;
		input = new NumericInputElement(true);

		payCash = new Button("Pay Cash");

		payCash.setOnAction(e -> {
			// Pay Cash Event
		});

		display.setCenter(input.getDisplay());
		display.setPadding(new Insets(50));
		
	}

	public BorderPane getDisplay() {

		return this.display;
	}

	@Override
	void makeDisplay() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void style() {

		payCash.setStyle(scanCSS("PayCashButtonCSS.txt"));
		
	}
	
}
