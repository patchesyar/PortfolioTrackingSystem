/**
 * Holding.java
 */

/**
 * A financial holding which can be represented as a mutual fund,
 *     cash in money market accounts, or an equity. 
 * 
 * @author kbb8134
 *
 */
public abstract class Holding {
	
	String name;
	int value;
	
	Holding(String n, int v) {
		int val = v;
		String myname = name;
		this.name = myname;
		this.value = val;
	}
	
}
