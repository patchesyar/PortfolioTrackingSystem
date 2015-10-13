/**
 * Holding.java
 */

/**
 * A financial holding which can be represented as a mutual fund,
 *     cash in money market accounts, or an equity. 
 * 
 * @author This team saved Olympic dreams with their beam routine
 *
 */
public abstract class Holding {
	
	private String Name;
	private double Value;
	
	/**
	 * Constructor to set a Holding name and value
	 * 
	 * @param n - Name
	 * @param v - Value
	 */
	public Holding(String Name, double Value) {
		this.Name = Name;
		this.Value = Value;
	}
	
	/**
	 * A simple getter function
	 * 
	 * @return - Name of the Holding
	 */
	public String getName(){
		return this.Name;
	}
	
	/**
	 * A simple getter function
	 * 
	 * @return - Value of holding
	 */
	public double getValue(){
		return this.Value;
	}
	
	public void setValue(double Value){
		this.Value = Value;
	}
	
	public void addToValue(double Value){
		this.Value += Value;
	}
	
	public void takeFromValue(double Value){
		this.Value -= Value;
	}
	
}
