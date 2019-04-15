package CST135.Bank;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import CST135.Bank.Savings;
import CST135.Bank.Trans;
import CST135.Bank.Transaction;

public class Loan extends Account implements Trans{
	
	Bank bank = new Bank("Grand Canyon Credit Union");
	Scanner sc = new Scanner(System.in);
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	private double interestRate;
	private double lateFee;
	double amount;
	
	List<Transaction> translist = new ArrayList<Transaction>();

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getLateFee() {
		return lateFee;
	}

	public void setLateFee(double lateFee) {
		this.lateFee = lateFee;
	}
	Loan() {
		
	}
	Loan(double balance, int account) {
		super(balance, account);
	}
	Loan(double balance, int account, double lateFee, double interestRate) {
		super(balance, account);
		this.lateFee = lateFee;
		this.interestRate = interestRate;
	}

	public void addTransaction() {
		
	}

	public void displayTransaction(ArrayList<Transaction> trans) {
		
	}
	public void makeLoanPayment(Checking checking, Savings saving, Loan loan) {
		System.out.println("As of " + dateFormat.format(date) + " you owe $" + this.getBalance());
		System.out.println("How much would you like to pay towards you loan?");
		amount = sc.nextInt();
		setAmount(amount);
		this.translist.add(new Transaction(loan.getAccount(), getAmount(), "Payment"));
		this.setBalance(this.getBalance() - getAmount());
		System.out.println("After your payment of $" + getAmount() + " you still owe $" + this.getBalance());
		System.out.println("Is there another transaction you would like to complete? Enter 1 for Yes or 9 for No");
		 int userInput;
		 userInput = sc.nextInt();
		 if ( userInput == 1)
		 {
			 bank.displayMenu(checking, saving, loan);
		 }else 
		 {
			 bank.displayExitScreen();
		 }
	}
	public void takeLoan(Checking checking, Savings saving, Loan loan) {
		System.out.println("As of " + dateFormat.format(date) + " you owe $" + this.getBalance());
		System.out.println("How much would you like borrow?");
		amount = sc.nextInt();
		setAmount(amount);
		this.translist.add(new Transaction(loan.getAccount(), getAmount(), "Withdrawl"));
		this.setBalance(this.getBalance() + amount);
		System.out.println("You now owe $" + this.getBalance());
		System.out.println("Is there another transaction you would like to complete? Enter 1 for Yes or 9 for No");
		int userInput;
		 userInput = sc.nextInt();
		 if ( userInput == 1)
		 {
			 bank.displayMenu(checking, saving, loan);
		 }else 
		 {
			 bank.displayExitScreen();
		 }
	}
		


		
	}


	


