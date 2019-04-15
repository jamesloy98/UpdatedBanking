package CST135.Bank;

import java.util.ArrayList;
import java.util.Date;

public class Transaction implements Trans{
	
	Date transaction;
	private int accountName;
	private double amount;
	private String type;
	Checking checking = new Checking();
	Savings saving = new Savings();
	Loan loan = new Loan();
	
	public String toString() {
		return  accountName + " " + amount + " " + type;
	}

	public void addTransaction() {
		
	}

	public void displayTransaction(ArrayList<Transaction> trans) {
		for (Transaction t : trans)
		System.out.println(t.toString());
	}

	public void doEndOfMonth(Checking checking, Savings saving, Loan loan) {
		System.out.println(checking.translist.toString());
		System.out.println(saving.translist.toString());
		System.out.println(loan.translist.toString());
	}

	public void checkLateFee(Checking checking, Savings saving, Loan loan) {
		if (loan.getAmount() > 0) {
			System.out.println("You made a payment, no late fee assesed.");
		}else {
			System.out.println("You did not make a payment. A " + loan.getLateFee() + " charge was added to your account.");
		}
	}

	public Date getTransaction() {
		return transaction;
	}

	public void setTransaction(Date transaction) {
		this.transaction = transaction;
	}

	public int getAccountName() {
		return accountName;
	}

	public void setAccountName(int accountName) {
		this.accountName = accountName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	Transaction(){
		
	}
	Transaction(double amount){
		this.amount = amount;
		
	}
	Transaction(int accountName, double amount, String type){
		this.accountName = accountName;
		this.amount = amount;
		this.type = type;
	}
	public void doTrans() {
		
	}
	
	

}
