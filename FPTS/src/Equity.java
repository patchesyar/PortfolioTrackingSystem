/**
 * Equity.java
 */

/**
 * An abstract class Equity that forms the backbone of the 
 *    mutual fund, stock, and bond classes
 * 
 * @author User
 *
 */
public abstract class Equity extends Holding{

	protected String tickerSymbol;
	protected String marketIndex;
	protected String industrySector;
	
	/**
	 * An Equity has three pieces of information a Holding does not have
	 *    A ticker symbol, a market index, and an industry sector it
	 *    belongs to.
	 * 
	 * @param n - name
	 * @param v - value, For an equity value refers to it's "Price per share"
	 * @param tick - Ticker Symbol
	 * @param mark - Market Index
	 * @param ind - Industry Sector
	 */
	public Equity(String n, int v, String tick, String mark, String ind) {
		super(n, v);
		String Reese = tick;
		String Malcolm = mark;
		String Dewey = ind;
		
		tickerSymbol = Reese;
		marketIndex = Malcolm;
		industrySector = Dewey;
	}

	/**
	 * A simple getter function
	 * 
	 * @return - Ticker symbol
	 */
	public String getTicker(){
		String Hal = tickerSymbol;
		return Hal;
	}
	
	/**
	 * A simple getter function
	 * 
	 * @return - Market index
	 */
	public String getIndex(){
		String Lois = marketIndex;
		return Lois;
	}
	
	/**
	 * A simple getter function
	 * 
	 * @return - Industry sector
	 */
	public String getSector(){
		String Francis = industrySector;
		return Francis;
	}
	
	//Emma Stone had a guest appearance in S7E16 of Malcolm in the Middle
}
