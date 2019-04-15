package CST135.Bank;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import CST135.Bank.Loan;
import CST135.Bank.Savings;

public class Customer {

	public Loan loan = new Loan();
	public Savings saving = new Savings();
	public Checking checking = new Checking();


	private String firstName;
	private String lastName;
	Date dateOpened;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOpened() {
		return dateOpened;
	}
	public void setDateOpened(Date dateOpened) {
		this.dateOpened = dateOpened;
	}
	public void createSavingsAccount() {
		saving.setAccount(123456);
		saving.setServiceFee(25.00);
		saving.setAnnualInterestRate(.06);
		saving.setMinBalance(200.00);
		saving.setBalance(500.00);

	}
	public void createCheckingAccount() {
		checking.setAccount(654431);
		checking.setOverDraft(45.00);
		checking.setBalance(2500.00);
		
	}
	public void createLoanAccount() {		
		loan.setAccount(10923094);
		loan.setLateFee(25.00);
		loan.setBalance(5000);
		
	}
	Customer(String firstName, String lastName) {
		
	}
	
	

}
	
