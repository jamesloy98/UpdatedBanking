package CST135.Bank;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import CST135.Bank.Checking;
import CST135.Bank.Customer;
import CST135.Bank.Loan;
import CST135.Bank.Login;
import CST135.Bank.Savings;
import CST135.Bank.Transaction;

public class Bank {
	static Scanner sc = new Scanner(System.in);
	static String name;
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	static Customer customer = new Customer("","");
	static Transaction transactions = new Transaction();
	static Login login = new Login();


	
	public static void main(String[] args) {
		//declare objects of classes to call private methods
//		Loan loan = new Loan();
//		Savings saving = new Savings();
//		Checking checking = new Checking();
		//Transaction transaction = new Transaction();

		displayCustomerWelcome(customer.checking, customer.saving, customer.loan);

	}

		
		Bank(String name) {
			this.name = name;	
		}
		//This method is the Interface for the user to see
		public static void displayMenu(Checking checking, Savings saving, Loan loan) {
			int option;
			do {
				System.out.println("=====================================");
				System.out.println("             Main Menu");
				System.out.println("         " + name.toUpperCase());
				System.out.println("=====================================");
				System.out.println("Please Pick An Option : ");
				System.out.println("----------------------------------");
				System.out.println("1: : Deposit to Checking");
				System.out.println("2: : Deposit To Savings");
				System.out.println("3: : Make Loan Payment");
				System.out.println("4: : Withdraw From Checking");
				System.out.println("5: : Withdraw From Savings");
				System.out.println("6: : Take a Loan");
				System.out.println("7: : Get Balance");
				System.out.println("8: : Close Month");
				System.out.println("----------------------------------");
				System.out.println("9: : Exit");
				option = sc.nextInt();
				//This next step will run them to the actionMenu method
				actionMenu(option, checking, saving, loan);
			}while (option !=9);
			
			}
		//Once called here from the Display menu, the user can now pick a method to go to.
		public static void actionMenu(int option, Checking checking, Savings saving, Loan loan) {
			//Case statement for user input
			//depending on what the user chooses will depend on what screen it goes to
			switch (option) {
			case 1:
				checking.displayDepositChecking(checking, saving, loan);
				break;
			case 2: 	
				saving.displayDepositSaving(checking, saving, loan);
				break;
			case 3:
				loan.makeLoanPayment(checking, saving, loan);
				break;
			case 4:
				checking.displayWithdrawChecking(checking, saving, loan);
				break;
			case 5:
				saving.displayWithdrawSavings(checking, saving, loan);
				break;
			case 6:
				loan.takeLoan(checking, saving, loan);
				break;
			case 7:
				displayBalanceScreen(checking, saving, loan);
				break;
			case 8:
				doEndMonth(checking, saving, loan);
				break;
			case 9:	
				displayExitScreen();
				break;
			default :
				System.out.println("You have entered an invalid number, please try again");
			}

		}
		public static void doEndMonth(Checking checking, Savings saving, Loan loan) {
			double interest;
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			interest = (saving.getBalance() * (saving.getAnnualInterestRate()/12));
			System.out.println("You have earned $" + interest + " interest on your savings account!");
			if (saving.getBalance() < saving.getMinBalance()) {
				System.out.println("Your account balance is below the minimum value of $" + saving.getMinBalance());
				System.out.println("There was a $" + saving.getServiceFee() + " fee charged to your account");
				System.out.println("As of " + dateFormat.format(date));
				System.out.println("Your Checking balance is : $" + checking.getBalance());
				System.out.println("Your Savings balance is : $" + ((saving.getBalance() + interest) - saving.getServiceFee()));
				System.out.println("The Loan amount still owed is $" + loan.getBalance());
				System.out.println("Here is a list of transactions for the month!");
				//displayTransaction(saving.translist);
				transactions.doEndOfMonth(checking, saving, loan);
				System.out.println("Thank you for using GCU Credit Union! See you again soon!");
				System.exit(0);
				
			}else {
				System.out.println("As of " + dateFormat.format(date));
				System.out.println("Your Checking balance is : $" + checking.getBalance());
				System.out.println("Your Savings balance is : $" + (saving.getBalance() + interest));
				System.out.println("The Loan amount still owed is $" + loan.getBalance());
				transactions.checkLateFee(checking, saving, loan);
				System.out.println("Here is a list of transactions for the month!");
				//displayTransaction(saving.translist);
				transactions.doEndOfMonth(checking, saving, loan);
				System.out.println("Thank you for using GCU Credit Union! See you again soon!");
				System.exit(0);
			}
		}
		 public static void displayExitScreen() {
			 System.out.println("Thank you for using GCU Credit Union! See you again soon!");
			 System.exit(0);
		 }
		 private static void displayBalanceScreen(Checking checking, Savings saving, Loan loan) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			System.out.println("As of " + dateFormat.format(date));
			System.out.println("Your Checking balance is : $" + checking.getBalance());
			System.out.println("Your Savings balance is : $" + saving.getBalance());
			System.out.println("The Loan amount still owed is $" + loan.getBalance());
			System.out.println("Is there another transaction you would like to complete? Enter 1 for Yes or 9 for No");
			 int userInput;
			 userInput = sc.nextInt();
			 //There is this is else statement in every method to ask the user if they would like to continue or end their program
			 if ( userInput == 1)
			 {
				 displayMenu(checking, saving, loan);
			 }else 
			 {
				 displayExitScreen(); 
			 }
		 }
		 
		 
		 public static void displayCustomerWelcome(Checking checking, Savings saving, Loan loan) {
				login.getConnectionPractice();
			 	System.out.println("=====================================");
				System.out.println("Welcome to Grand Canyon Credit Union!");
				System.out.println("           Main Menu");
				System.out.println("");
				System.out.println("1. Create a Customer");
				System.out.println("2. Login");
				System.out.println("3. Exit Bank");
				System.out.println("");
				System.out.println("Please enter a corresponding number!");
				System.out.println("=====================================");
				 int mainMenuInput = sc.nextInt();
				 sc.nextLine();
				if (mainMenuInput == 1) {
					createCustomer(checking, saving, loan);
				}else if ( mainMenuInput == 2) {
					displayCustomers(checking, saving, loan);
				}else displayExitScreen();

		 }
		 public static void createCustomer(Checking checking, Savings saving, Loan loan) {
			 customer.createSavingsAccount();
			 customer.createCheckingAccount();
			 customer.createLoanAccount();
			 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			 Date date = new Date();
			 System.out.println("=====================================");
			 System.out.println("Please enter your FIRST and LAST name");
			 System.out.println("First name : "  );
			 //customer.setFirstName(sc.nextLine());
			 String firstNameInput = sc.nextLine();
			 customer.setFirstName(firstNameInput);
			 System.out.println("Last name : ");
			 //customer.setLastName(sc.nextLine());
			 String lastNameInput = sc.nextLine();
			 customer.setLastName(lastNameInput);
			 login.createUser(checking, saving, loan);
			 System.out.println("You created your account on: ");
			 System.out.println(dateFormat.format(date));
			 System.out.println("=====================================");
			 //displayCustomerWelcome(checking, saving, loan);
			 displayCustomerWelcome(checking, saving, loan);
		 }
		 public static void displayCustomers(Checking checking, Savings saving, Loan loan) {
			 customer.createSavingsAccount();
			 customer.createCheckingAccount();
			 customer.createLoanAccount();
			 System.out.println("=========================================");
			 System.out.println("Please enter your username and password!");
			 //login.showCustomers();
			 login.checkLogin(checking, saving, loan);
			 System.out.println("==========================================");

		 }
			public static void displayTransaction(List<Transaction> trans) {
				for (Transaction t : trans)
				System.out.println(t.toString());
			}
}
