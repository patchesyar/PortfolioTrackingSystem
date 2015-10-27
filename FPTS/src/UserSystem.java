/**
 * UserSystem.java
 */

/**
 * A system that handles important functions related to the User class
 *    exists to also block unathenticated users 
 * 
 * @author This team saved Olympic dreams with their beam routine
 */
public class UserSystem {
	private boolean authenticatedSession = false; 
	private static User activeUser = null;
	
	public UserSystem(){
		
	}
	
	/**
	 * Logs a user into the system
	 * 
	 * @param uName - a name string
	 * @param pWord - A password string
	 * @param tSys - Tracking system
	 */
	public void Login(String uName, String pWord, TrackingSystem tSys){
		Finder f = new Finder();
		
		User tempU = f.findUser(tSys, uName);
		if(tempU != null){
			if(tempU.checkPassword(pWord) == true){
				activeUser = tempU;
				authenticatedSession = true;
			}
		}
	}
	
	/**
	 * Logs a user out of the system
	 * 
	 */
	public void Logout(){
		authenticatedSession = false;
		activeUser = null;
	}
	
	/**
	 * Simple getter function
	 * 
	 * @return 
	 */
	public static User getActiveUser(){
		return activeUser;
	}
	
	/**
	 * Simple getter function
	 * 
	 * @return
	 */
	public boolean getAuthenticationState(){
		return authenticatedSession;
	}
	
	/**
	 * Creates a User, adding an empty portfolio to them
	 * 
	 * @param uName - User name
	 * @param pWord - User password
	 * @param tSys - Tracking system
	 */
	public void createUser(String uName, String pWord, TrackingSystem tSys){
		User u = new User(uName, pWord);
		Portfolio p = new Portfolio(u);
		tSys.addUser(u);
		tSys.addPortfolio(p);
	}
	
}
