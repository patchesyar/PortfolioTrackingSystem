/**
 * Equity.java
 */

/**
 * A class Equity that forms the represents Mutual Funds, Stocks, and Bonds
 * 
 * @author This team saved Olympic dreams with their beam routine
 *
 */
public class Equity extends Holding{

	private String equityType;
	private String tickerSymbol;
	private String marketIndex;
	private String industrySector;
	private int NumberOfShares;
	
	
	
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
	public Equity(String n, double v, String tick, String mark, String ind, String Type) {
		super(n, v);
		this.type = 'E';
		
		this.tickerSymbol = tick;
		this.marketIndex = mark;
		this.industrySector = ind;
		this.equityType = Type;
		
	}

	/**
	 * A simple getter function
	 * 
	 * @return - Ticker symbol
	 */
	public String getTicker(){
		return this.tickerSymbol;
	}
        
        public int getShares(){
		return this.NumberOfShares;
	}
        
        public void addShares(int x){
		NumberOfShares = NumberOfShares + x;
	}
	
	/**
	 * A simple getter function
	 * 
	 * @return - Market index
	 */
	public String getIndex(){
		return this.marketIndex;
	}
	
	/**
	 * A simple getter function
	 * 
	 * @return - Industry sector
	 */
	public String getSector(){
		return this.industrySector;
	}
	
	/**
	 * A simple setter function
	 *    The value of an equity changes as the market changes
	 * 
	 * @param newVal - 
	 */
	public void setValue(double newVal){
		super.setValue(newVal);
	}
	
	public double getTotalValue(){
		return (this.NumberOfShares * super.getValue());
	}
	
	
	public String toString(){
		return this.tickerSymbol + "........" + super.getValue() + "........" + this.NumberOfShares;
	}
	
	@Override
	public String log(){
		return "HOLDING," + this.equityType + ",\"" + this.tickerSymbol + "\"," + this.NumberOfShares;
	}

	@Override
	public boolean isEquity() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
