package CST135.Bank;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import CST135.Bank.Trans;
import CST135.Bank.Transaction;

public class Savings extends Account implements Trans{
	

	List<Transaction> translist = new ArrayList<Transaction>();
	
	Bank bank = new Bank("Grand Canyon Credit Union");
	Scanner sc = new Scanner(System.in);
	private double serviceFee;
	private double annualInterestRate;
	private double minBalance;
	
	public double getMinBalance() {
		return minBalance;
	}
	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}
	public double getServiceFee() {
		return serviceFee;
	}
	public void setServiceFee(double serviceFee) {
		this.serviceFee = serviceFee;
	}
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	Savings() {
		
	}
	Savings(double balance, int account) {
		super(balance, account);
	}
	Savings(double balance, int account, double serviceFee, double annualInterestRate, double minBalance) {
		super(balance, account);
		this.annualInterestRate = annualInterestRate;
		this.minBalance = minBalance;
		this.serviceFee = serviceFee;
	}
	
	
	
	
	public void displayWithdrawSavings(Checking checking, Savings saving, Loan loan) {
		double amount;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		 System.out.println("WITHDRAW FROM SAVINGS (1923)");
		 System.out.println("Your Savings balance is $" + saving.getBalance() + " as of " + dateFormat.format(date));
		 System.out.println("You will have a $" + saving.getServiceFee() + " service fee if balance is below $" + saving.getMinBalance() + " at end of month");
		 System.out.println("How much would you like to withdraw : ");
		 amount = (-1 * sc.nextInt());
		 this.translist.add(new Transaction(saving.getAccount(), amount, "Withdrawl"));
		if (amount > saving.getBalance()) {
			 System.out.println("You do not have enough money in your savings, please enter a different amount ");
			 amount = sc.nextInt(); 
			 saving.setBalance  (saving.getBalance() + amount);
			 System.out.println("Your new balance is : $" + saving.getBalance() + " as of " + dateFormat.format(date));
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
		 }else {
		 saving.setBalance(saving.getBalance() + amount);
		 System.out.println("Your new balance is : $" + saving.getBalance() + " as of " + dateFormat.format(date));
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
	
	public void displayDepositSaving(Checking checking, Savings saving, Loan loan) {
		double amount;
	    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		 System.out.println("DEPOSIT INTO SAVINGS (1923)");
		 System.out.println("As of " + dateFormat.format(date));
		 System.out.println("Your Savings balance is $" + saving.getBalance());
		 System.out.println("How much would you like to deposit : ");
		 amount = sc.nextInt();
		 this.translist.add(new Transaction(saving.getAccount(), amount, "Deposit"));
		 saving.setBalance  (saving.getBalance() + amount);
		 System.out.println("Your new balance is : $" + saving.getBalance() + " as of " + dateFormat.format(date));
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
	public void addTransaction() {
		// TODO Auto-generated method stub
		
	}
	public void displayTransaction(ArrayList<Transaction> trans) {
		// TODO Auto-generated method stub
		
	}

}
