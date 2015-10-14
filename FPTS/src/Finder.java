import java.util.ArrayList;

/**
 * Finder.java
 */

/**
 * Uses the TrackingSystem to find various system models using different methods
 * 
 * @author This team saved Olympic dreams with their beam routine
 *
 */
public class Finder {

	public Finder(){
		
	}

	/**
	 * Finds a User given a system that holds all users and a str 
	 *    that matches a User's id
	 * 
	 * @param tSys - The tracking system that holds the list of Users
	 * @param str - A string, assumed to be a user id.
	 * @return The User whose Id matches str, or null if no such User exists
	 */
	public User findUser(TrackingSystem tSys, String str){
		User ret = null;
		ArrayList<User> uList = tSys.getUsers();
		
		for(int i = 0; i < uList.size(); i++){
			if(uList.get(i).getId().equals(str)){
				ret = uList.get(i);
				break;
			}
		}
		
		return ret;
	}
	
	/**
	 * Finds a portfolio using it's associatedUID field
	 *    Perhaps a redundant method, since portfolios can be
	 *    found given a User's ID.
	 * 
	 * @param tSys - The Tracking system
	 * @param str - Str represents associated UID
	 * @return The portfolio that matches the Str, or null
	 */
	public Portfolio findPortfolio(TrackingSystem tSys, String str){
		Portfolio ret = null;
		ArrayList<Portfolio> pList = tSys.getPortfolios();
		
		for(int i = 0; i < pList.size(); i++){
			if(pList.get(i).getOwnerID().equals(str)){
				ret = pList.get(i);
				break;
			}
		}
		
		return ret;
	}
	
	/**
	 * Finds an equity using it's ticker field. Not as restrictive a
	 *    finder as the ones for Portfolios or Users
	 * 
	 * @param tSys - Tracking System, holds the equities
	 * @param str - String
	 * @return - The equity or Null
	 */
	public Equity findEquityByTicker(TrackingSystem tSys, String str){
		Equity ret = null;
		ArrayList<Equity> eList = tSys.getEquities();
		
		for(int i = 0; i < eList.size(); i++){
			if(eList.get(i).getTicker().contains(str)){
				ret = eList.get(i);
				break;
			}
		}
		
		return ret;
	}
	
	/**
	 * Finds an equity using it's index field. Not as restrictive a
	 *    finder as the ones for Portfolios or Users
	 * 
	 * @param tSys - Tracking System, holds the equities
	 * @param str - String
	 * @return - The equity or Null
	 */
	public Equity findEquityByIndex(TrackingSystem tSys, String str){
		Equity ret = null;
		ArrayList<Equity> eList = tSys.getEquities();
		
		for(int i = 0; i < eList.size(); i++){
			if(eList.get(i).getIndex().contains(str)){
				ret = eList.get(i);
				break;
			}
		}
		
		return ret;
	}
	
	/**
	 * Finds an equity using it's name field. Not as restrictive a
	 *    finder as the ones for Portfolios or Users
	 * 
	 * @param tSys - Tracking System, holds the equities
	 * @param str - String
	 * @return - The equity or Null
	 */
	public Equity findEquityByName(TrackingSystem tSys, String str){
		Equity ret = null;
		ArrayList<Equity> eList = tSys.getEquities();
		
		for(int i = 0; i < eList.size(); i++){
			if(eList.get(i).getName().contains(str)){
				ret = eList.get(i);
				break;
			}
		}
		
		return ret;
	}
}
