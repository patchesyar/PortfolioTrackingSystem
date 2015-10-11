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
	
	private String name;
	private int value;
	
	/**
	 * Constructor to set a Holding name and value
	 * 
	 * @param n - Name
	 * @param v - Value
	 */
	public Holding(String n, int v) {
		int tempV = v;
		String tempN = n;
		name = tempN;
		value = tempV;
	}
	
	/**
	 * A simple getter function
	 * 
	 * @return - Name of the Holding
	 */
	public String getName(){
		String temp = name;
		return temp;
	}
	
	/**
	 * A simple getter function
	 * 
	 * @return - Value of holding
	 */
	public int getValue(){
		int temp = value;
		return temp;
	}
}
