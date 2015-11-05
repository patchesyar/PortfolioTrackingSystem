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
	private ArrayList<Holding> hList = new ArrayList<Holding>();
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

        public void sellEquity(Equity eObj, int shares){
            int count = 0;
            for(Holding H : hList){
                if(H.getName().equals(eObj.getName())){
                count = eObj.getShares();
                    if(shares>count){
                        System.out.println("not enough shares");
                    }
                    else{
                        double num = shares * eObj.getValue();
                        totalValue += num;
                        eObj.loseShares(shares);
                        }
                    if(eObj.getShares() == 0){
                        hList.remove(H);
                    }
                        this.log.addLog(eObj.log());
                    }
                }
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
	 * Functions for Buying and Selling Equities
         */

	public void buyEquity(TrackingSystem tSys, String tickerSymbol, int amount){
		Equity e = (new Finder()).findEquityByTicker(tSys, tickerSymbol);
		double total = amount * e.getValue() ;
		Holding bankAccount = null;
		for(int x=0; x < this.hList.size(); x++){
			if(this.hList.get(x).getType()=='B'){
				bankAccount = this.hList.get(x) ;
			}
		}
		if(bankAccount == null){
			System.out.println("Unable to find bank account") ;
			return ;
		}else if(total > bankAccount.getValue()){
			System.out.println("Insufficient funds") ;
			return ;
		}
		//By this point, you have a bank account with enough funds.
		bankAccount.takeFromValue(total) ;
		for(int x=0; x<amount; x++){
			this.addHoldings(e) ;
		}
		this.updateTotalValue() ;

	}

	/*public void sellEquity(TrackingSystem tSys, String tickerSymbol,int amount){
		Equity e = (new Finder()).findEquityByTicker(tSys, tickerSymbol) ;
		int count_equities = 0 ;
		for(int x=0; x<this.hList.size(); x++){
			if(this.hList.get(x).getName().equals(e.getName())){
				count_equities++ ;
			}
		}
		if(count_equities < amount){
			System.out.println("You do not have enough equities to do that.") ;
		}
		int total_value = amount * e.getValue() ;
	}
	*/
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
