package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PaymentElement extends Display<BorderPane> {

	SalesDisplay sales;
	NumericInputElement input;

	Button payCash;

	BorderPane display = new BorderPane();

	public PaymentElement(SalesDisplay sales) {
		this.sales = sales;
		input = new NumericInputElement(true);
		
		
		//Getting input element
		BorderPane inputDisplay = input.getDisplay();
		
		//Column for payment options
		VBox paymentOptions = new VBox(5);
		paymentOptions.setPadding(new Insets(5));

		//Creation of payCash button
		payCash = new Button("Pay Cash");
		payCash.setStyle(scanCSS("OptionsButtonsCSS.txt"));
		payCash.setOnAction(e -> {
			double payment = input.getInput();
			input.clear();
			
			
			sales.currentCheck.payCash(payment);
			sales.updateCheckDisplay();
			
		});
		
		//Putting payment opotions into their VBox
		paymentOptions.getChildren().addAll(payCash);
		

		display.setCenter(inputDisplay);
		display.setTop(paymentOptions);
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
