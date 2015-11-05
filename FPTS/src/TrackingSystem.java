import java.util.ArrayList;

/**
 * TrackingSystem.java
 */

/**
 * TrackingSystem holds a list of all users, portfolios, and equities that the system knows about. 
 * 
 * @author This team saved Olympic dreams with their beam routine
 */
public class TrackingSystem {

	private ArrayList<User> uList;
	private ArrayList<Portfolio> pList;
	private ArrayList<Equity> eList;
	
	public TrackingSystem(){
            
            eList = new ArrayList<Equity>();
            pList = new ArrayList<Portfolio>();
            uList = new ArrayList<User>();
		
	}
	
	/**
	 * Simple adding function
	 * 
	 * @param uIn - New user
	 */
	public void addUser(User uIn){
		uList.add(uIn);
	}
	
	/**
	 * Simple adding function
	 * 
	 * @param pIn - new portfolio
	 */
	public void addPortfolio(Portfolio pIn){
		pList.add(pIn);
	}
	
	/**
	 * Simple adding function
	 * 
	 * @param eIn - new equity
	 */
	public void addEquity(Equity eIn){
		if(eList.contains(eIn) != true){
			eList.add(eIn);
		}
	}
	
	/**
	 * Simple getter
	 * 
	 * @return
	 */
	public ArrayList<User> getUsers(){
		return uList;
	}
	
	/**
	 * Simple getter
	 * 
	 * @return
	 */
	public ArrayList<Portfolio> getPortfolios(){
		return pList;
	}
	
	/**
	 * Simple getter
	 * 
	 * @return
	 */
	public ArrayList<Equity> getEquities(){
		return eList;
	}
}
