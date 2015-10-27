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
	private Logger log;
	
	
	/**
	 * Constructor to create a portfolio, value is initially 0 and hList empty.
	 * 
	 * @param uObj - The user that owns the portfolio
	 */
	public Portfolio(User uObj){
		String tempS = uObj.getId();
		totalValue = 0;
		associatedID = tempS;
		this.log = new Logger(associatedID);
	}
	/**
	 * A simple getter function
	 * 
	 * @param hObj - The holding to add to the portfolio
	 */
	public void addHoldings(Holding hObj){
		hList.add(hObj);
		this.log.addLog(hObj.log());
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
	
	private void updateTotalValue(){
		double tempValue = 0;
		for(Holding a : this.hList){
			tempValue += a.getValue();
		}
		this.totalValue = tempValue;
	}
	
	public double getValue(){
		updateTotalValue();
		return this.totalValue;
	}
	
	
	
	/*
	 * Getter and Setter functions, used uniquely by the Undo/Redo
	 */
	
	public void setAssociatedID(String associatedID) {
		this.associatedID = associatedID;
	}
	public void sethList(ArrayList<Holding> hList) {
		this.hList = hList;
	}
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	public void setLog(Logger log) {
		this.log = log;
	}
	
	public String getAssociatedID() {
		return associatedID;
	}
	public ArrayList<Holding> gethList() {
		return hList;
	}
	public double getTotalValue() {
		return totalValue;
	}
	public Logger getLog() {
		return log;
	}
	
}
