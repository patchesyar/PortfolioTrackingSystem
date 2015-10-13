import java.text.SimpleDateFormat;

/**
 * BankAccount.java
 */

import java.util.Calendar;

/**
 * A class representing a bank account.
 * 
 * @author This team saved Olympic dreams with their beam routine
 *
 */
public class BankAccount extends Holding {
	
	private Calendar DateCreated = Calendar.getInstance();
	
	/**
	 * 
	 * @param n - name
	 * @param v - value
	 */
	public BankAccount(String Name, double Value, String LitDate) {
		super(Name, Value);
		
		SimpleDateFormat format1 = new SimpleDateFormat("YYYY-MM-DD");
		try{
			this.DateCreated.setTime(format1.parse(LitDate));
		} catch (Exception e){
			System.out.println("Unable to set Date");
		}
	}
	
	/**
	 * Deposit funds into the account
	 * 
	 * @param amount - The given sum of funds 
	 */
	
	public void deposit(double Amount){
		super.addToValue(Amount);
	}
	
	/**
	 * Withdraw an amount of funds from the account
	 * 
	 * @param amount - The given amount of funds to be withdrawn from the account
	 */
	
	public void withdraw(double Amount){
		super.takeFromValue(Amount);
	}
}
