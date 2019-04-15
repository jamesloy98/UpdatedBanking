package CST135.Bank;


import java.util.Scanner;

import CST135.Bank.Savings;

import java.sql.*;

public class Login {


	static Scanner sc = new Scanner(System.in);
	static Bank bank = new Bank("");
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String ENDPOINT = "cst235loy.cr3hvuboxbcm.us-east-2.rds.amazonaws.com";
	static final String PORT = "3306";
	static final String USER = "cst235loy";
	static final String PASS = "cst235loy!";
	
	static Connection conn;
	
	static String secretKey= "abc";
	//static String username= "";
	static String secretKeyCheck= "";
	
	
    //static String originalString = secretKey;
    //static String encryptedString = AES.encrypt(originalString, secretKey) ;
    
    //static String originalString2 = secretKeyCheck;
    //static String encryptedString2 = AES.encrypt(originalString2, secretKeyCheck) ;


	public static Connection getConnectionPractice() {
		try {
			Class.forName(JDBC_DRIVER);
			String dbName = "CST235Loy";
			
			String jdbcConnect = "jdbc:mysql://" + ENDPOINT + ":" + PORT + "/" + dbName + "?user=" + USER + "&password=" + PASS; 
			//System.out.println(jdbcConnect);
			conn = DriverManager.getConnection(jdbcConnect);
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		finally {
			System.out.println("You got connected!!");
		}
		return conn;
	}

	
	public static void createUser(Checking checking, Savings saving, Loan loan) {
	     
	    System.out.println("Please enter a username.");
		String username = sc.nextLine();
	    System.out.println("Please enter a password.");
	    String password = sc.nextLine();
		
		Statement sqlText = null;
		
		try {
			sqlText = conn.createStatement();
			String sql = "INSERT INTO bank_login (username, password)\n" + 
					" VALUES ('"+username+"', '"+AES.encrypt(password, secretKey)+"')";
			System.out.println(sql);
			sqlText.executeUpdate(sql);

		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
	}
	public static void checkLogin(Checking checking, Savings saving, Loan loan) {
		
	    System.out.println("Let us check to see if you information matches.");
	    System.out.println("Please enter a username.");
		String usernameCheck = sc.nextLine();
	    System.out.println("Please enter a password.");
	    String passwordCheck = sc.nextLine();
		
		Statement sqlText = null;
		
		try {
			sqlText = conn.createStatement();
			String sql = "SELECT id FROM CST235Loy.bank_login\n" + 
					" WHERE username = '"+usernameCheck+"' \n" + 
					" AND password = '"+AES.encrypt(passwordCheck, secretKey)+"'";
//			if (usernameCheck.equals(username)) {
//				System.out.println("Halfway there!");
//				if(password.equals(passwordCheck)) {
//					System.out.println("ACCESS GRANTED!!!!!");
//				}else { System.out.println("ACCESS DENIED!!!");
//				checkLogin();}
//			}else { System.out.println("Please try again!");
//				checkLogin();}

			
			System.out.println(sql);
			ResultSet rs = sqlText.executeQuery(sql);
			
			if(rs.next()) {
				System.out.println("Access granted");
				bank.displayMenu(checking, saving, loan);
			}else {
				System.out.println("Please try again");
				checkLogin(checking, saving, loan);
			}


		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	public static void showCustomers() {
				
		Statement sqlText = null;
		
		try {
			sqlText = conn.createStatement();
			String sql = "SELECT * FROM CST235Loy.bank_login;";
		
			sqlText.executeQuery(sql);


		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
		
}

