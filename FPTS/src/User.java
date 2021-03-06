import java.lang.String;
import java.util.ArrayList;

/**
 * User.java
 */


/**
 * The representation of a human user of the FTPS system
 * 
 * @author This team saved Olympic dreams with their beam routine
 */
public class User {

	private String id;
	private String pWord;
	private Portfolio porto = null;
	private int key; //A key used to check the password
	private ArrayList<Equity> watchList;
	
	/**
	 * A constructor for the User class
	 * 
	 * @param userName - A given name for the new User
	 * @param passWord - A given plaintext password for the new User
	 */
	public User(String userName, String passWord){
		String tempN = userName;
		String tempP = passWord;
		
		key = tempP.length();
		id = tempN;
		pWord = hidePassword(tempP);
	}
	
	/**
	 * A method for adding a portfolio to the User
	 * 
	 * @param pObj - A given Portfolio object
	 */
	public void addPortfolio(Portfolio pObj){
		porto = pObj;
	}
        
        public void setPortfolio(Portfolio pObj){
		this.porto = pObj;
	}
	
	/**
	 * A method for validating an input as the given user password
	 * 
	 * @param pInput - A plain text phrase given as an assumed password
	 * @return - True if the given plain text password is the same as the 
	 *     previously hidden password
	 */
	public boolean checkPassword(String pInput){
		char cArray[] = pInput.toCharArray();
		String pCheck;
		boolean ret;
		
		for(int i = 0; i < cArray.length; i++){
			cArray[i] = (char) (cArray[i] * key);
			if(cArray[i] == '\0'){
				cArray[i]++;
			}
		}
		
		pCheck = cArray.toString();
		if(pCheck.equals(pWord)){
			ret = true;	
		}
		else{
			ret = false;
		}
		return ret;
	}
	
	/**
	 * Simple getter function
	 * 
	 * @return - user id
	 */
	public String getId(){
		String ret = id;
		return ret;
	}
	
	/**
	 * Simple getter function
	 * 
	 * @return - User's portfolios
	 */
	public Portfolio getPortfolios(){
		return this.porto;
	}
	
	
	
	/**
	 * A method to be called in the constructor to hide the user's password
	 *     as something other than plaintext based on the established key
	 * 
	 * @param pWord - The given password string
	 * @return - A manipulated string different than what was given
	 */
	private String hidePassword(String pWord){
		String ret;
		char cArray[] = pWord.toCharArray();
		
		for(int i = 0; i < cArray.length; i++){
			cArray[i] = (char) (cArray[i] * key);
			if(cArray[i] == '\0'){
				cArray[i]++;
			}
		}
		ret = cArray.toString();
		
		return ret;
	}
	
	/**
	 * Adds an equity to the watchlist.
	 * 
	 * @param e - The equity
	 */
	public void addToWatchList(Equity e){
		watchList.add(e);
	}
	
	/**
	 * Removes an equity from the watchlist.
	 * 
	 * @param e - The equity
	 */
	public void removeFromWatchList(Equity e){
		if(watchList.contains(e)){
		    watchList.remove(e);	
		}
	}
	
	/**
	 * Gets the watchList 
	 * 
	 * @return - this.watchList
	 */
	public ArrayList<Equity> getWatchList(){
		ArrayList<Equity> ret = watchList;
		return ret;
	}
}
