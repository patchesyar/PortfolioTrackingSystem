/**
 * CashAccount.java
 */

import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 * A class representing cash in a money market account
 * 
 * @author This team saved Olympic dreams with their beam routine
 *
 */
public class CashAccount extends Holding{

	private Calendar DateCreated = Calendar.getInstance();

	/**
	 * 
	 * @param n - name
	 * @param v - value
	 */
	public CashAccount(String Name, double Value, String LitDate) {
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
	
	public String getDateCreatedStr(){
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String formatted = format1.format(this.DateCreated.getTime());
		return formatted;
	}
	
	@Override
	public String log(){
		return "HOLDING," + "MMAccount" + ",\"" + super.getName() + "\"," + super.getValue() + getDateCreatedStr();
	}

}
