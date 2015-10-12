import java.util.ArrayList;
import java.lang.String;

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
	private ArrayList<Portfolio> pList;
	private int key; //A key used to check the password
	
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
	 * A method for adding a portfolio to a User's list of Portfolios
	 * 
	 * @param pObj - A given Portfolio object
	 */
	public void addPortfolio(Portfolio pObj){
		if(pList.contains(pObj) == false){
			pList.add(pObj);
		}
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
		if(pCheck == pWord){
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
	public ArrayList<Portfolio> getPortfolios(){
		return this.pList;
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
	
}
