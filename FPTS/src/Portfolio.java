import java.util.ArrayList;

/**
 * Portfolio.java
 */

/**
 * A financial folder that stores all of a user's holdings.
 * 
 * @author This team saved Olympic dreams with their beam routine
 *
 */
public class Portfolio {

	private String associatedID;
	private ArrayList<Holding> hList;
	private double totalValue;
	
	/**
	 * Constructor to create a portfolio, value is initially 0 and hList empty.
	 * 
	 * @param uObj - The user that owns the portfolio
	 */
	public Portfolio(User uObj){
		String tempS = uObj.getId();
		totalValue = 0;
		associatedID = tempS;
	}
	/**
	 * A simple getter function
	 * 
	 * @param hObj - The holding to add to the portfolio
	 */
	public void addHoldings(Holding hObj){
		hList.add(hObj);
		totalValue += hObj.getValue();
	}
	
	/**
	 * A simple getter function
	 * 
	 * @return - Owner's User ID
	 */
	public String getOwnerID(){
		String temp = associatedID;
		return temp;
	}
	
	/**
	 *  A simple getter function
	 * 
	 * @return - List of holdings
	 */
	public ArrayList<Holding> getHoldings(){
		return hList;
	}
	
	/**
	 *  A simple getter function
	 * 
	 * @return - Total Value of all Holdings in the Portfolio
	 */
	public double getValue(){
		double temp = totalValue;
		return temp;
	}
	
	
}
