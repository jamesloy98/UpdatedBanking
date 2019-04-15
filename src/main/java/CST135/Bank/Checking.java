package CST135.Bank;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import CST135.Bank.Loan;
import CST135.Bank.Savings;
import CST135.Bank.Trans;
import CST135.Bank.Transaction;

public class Checking extends Account implements Trans{
	
	List<Transaction> translist = new ArrayList<Transaction>();
	
	Bank bank = new Bank("Grand Canyon Credit Union");
	Scanner sc = new Scanner(System.in);
	private double overDraft;

	public double getOverDraft() {
		return overDraft;
	}

	public void setOverDraft(double overDraft) {
		this.overDraft = overDraft;
	}
	public void doWithdraw(double amount) {
		
	}
	Checking() {
		
	}
	Checking(double balance, int account) {
		super(balance, account);
	}
	Checking(double balance, int account, double overDraft) {
		super(balance, account);
		this.overDraft = overDraft;
		
	}
	public void displayWithdrawChecking(Checking checking, Savings saving, Loan loan) {
		double amount;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		 System.out.println("WITHDRAW FROM CHECKING (1773)");
		 System.out.println("As of " + dateFormat.format(date));
		 System.out.println("Your Checking balance is $" + checking.getBalance());
		 System.out.println("You will have a $" + checking.getOverDraft() + " fee if withdrawed amount is greater than balance.");
		 System.out.println("How much would you like to withdraw : ");
		 amount = (-1 * sc.nextInt());
		 this.translist.add(new Transaction(checking.getAccount(), amount, "Withdrawl"));
		 if (amount > checking.getBalance()) {
			 checking.setBalance(checking.getBalance() - checking.getOverDraft() + amount);
			 System.out.println("OVERDRAFT NOTICE : $" + checking.getOverDraft() + " fee assesed!");
			 System.out.println("Your new balance is : $" + checking.getBalance() + " as of " + dateFormat.format(date));
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
		 checking.setBalance  (checking.getBalance() + amount);
		 System.out.println("Your new balance is : $" + checking.getBalance() + " as of " + dateFormat.format(date));
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
	 
	 public void displayDepositChecking(Checking checking, Savings saving, Loan loan) {
		double amount;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		 System.out.println("DEPOSIT INTO CHECKING (1773)");
		 System.out.println("As of " + dateFormat.format(date));
		 System.out.println("Your Checking balance is $" + checking.getBalance());
		 System.out.println("How much would you like to deposit : ");
		 amount = sc.nextInt();
		 this.translist.add(new Transaction(checking.getAccount(), amount, "Deposit"));
		 checking.setBalance  (checking.getBalance() + amount);
		 System.out.println("Your new balance is : $" + checking.getBalance() + " as of " + dateFormat.format(date));
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
		
	}

	public void displayTransaction(ArrayList<Transaction> trans) {
		
	}
	
}
