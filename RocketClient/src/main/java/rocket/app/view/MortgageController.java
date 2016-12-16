package rocket.app.view;

import java.awt.Button;
import java.awt.TextField;

import com.sun.xml.ws.org.objectweb.asm.Label;

import eNums.eAction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import rocket.app.MainApp;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController {

	private MainApp mainApp;
	
	//	TODO - RocketClient.RocketMainController
	
	//	Create private instance variables for:
	//		TextBox  - 	txtIncome
	//		TextBox  - 	txtExpenses
	//		TextBox  - 	txtCreditScore
	//		TextBox  - 	txtHouseCost
	//		ComboBox -	loan term... 15 year or 30 year
	//		Labels   -  various labels for the controls
	//		Button   -  button to calculate the loan payment
	//		Label    -  to show error messages (exception throw, payment exception)
	
	// TestBox
	
	@FXML
	private TextField txtIncome;
	
	@FXML
	private TextField txtExpenses;
	
	@FXML
	private TextField txtCreditScore;
	
	@FXML
	private TextField txtHouseCost;
	
	@FXML
	private TextField txtDownPayment;
	
	@FXML
	private ComboBox loanTerm; // loan term... 15 year or 30 year
	
	//Label
	
	@FXML
	private Label lblIncome;
	
	@FXML
	private Label lblExpenses;
	
	@FXML
	private Label lblCreditScore;
	
	@FXML
	private Label lblHouseCost;
	
	@FXML
	private Label lblTerm;
	
	@FXML
	private Label lblDownPayment;
	
	@FXML
	private Label lblErrors;  //show errors
	
	@FXML
	private Label lblMortgagePayment;
	
	@FXML
	private Button btnPayment; // button
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	
	//	TODO - RocketClient.RocketMainController
	//			Call this when btnPayment is pressed, calculate the payment
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Object message = null;
		//	TODO - RocketClient.RocketMainController
	
		
		Action a = new Action(eAction.CalculatePayment);
		LoanRequest lq = new LoanRequest();
		//	TODO - RocketClient.RocketMainController
		//			set the loan request details...  rate, term, amount, credit score, downpayment
		//			I've created you an instance of lq...  execute the setters in lq
		
		lq.setdAmount(Double.parseDouble(txtHouseCost.getText()));
		
		lq.setiCreditScore(Integer.parseInt(txtCreditScore.getText()));
		
		lq.setiDownPayment(Integer.parseInt(txtDownPayment.getText()));
		
		lq.setdExpenses(Double.parseDouble(txtExpenses.getText()));
		
		lq.setdIncome(Double.parseDouble(txtIncome.getText()));
		
		a.setLoanRequest(lq);
		
		//	send lq as a message to RocketHub		
		mainApp.messageSend(lq);
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		//	TODO - RocketClient.HandleLoanRequestDetails
		//			lRequest is an instance of LoanRequest.
		//			after it's returned back from the server, the payment (dPayment)
		//			should be calculated.
		//			Display dPayment on the form, rounded to two decimal places
		
		double Payment_one = lRequest.getdIncome() * 0.28;
		
		double Payment_two = lRequest.getdIncome()* 0.36 - lRequest.getdExpenses();
		
		double Payment_replace;
		
		if (Payment_one < Payment_two) {
			
			Payment_replace = Payment_one;
				
		}
		else {
			Payment_replace = Payment_two;
		}
		
		if (Payment_replace < lRequest.getdPayment()){
			
			
			
		}
	
	}
}
