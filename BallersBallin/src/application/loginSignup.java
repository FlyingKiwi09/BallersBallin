package application;

import java.util.ArrayList;
/**
 * Class to confirm verification of a user.
 * <p>
 * @author Ballers Ballin
 * @version 1 
 * 
 * 
 */
public class loginSignup {

	public loginSignup() {
		
	}
	
	
	/**
	 * 
	 * @param model takes a fantasy league model object which stores a global list of users.
	 * @param username takes the users username.
	 * @param password takes the users password.
	 * @return the user object if correct, otherwise returns a null user.
	 */
	public User loginValidation(FantasyLeagueModel model, String username, String password) {
		
		User user = null;
		ArrayList<User> userlist = model.getUsers();
		
		for(User u:userlist) {
			String storedUsername = u.getUsername();
			String storedPassword = u.getPassword();
			if(storedUsername.equals(username)&&storedPassword.equals(password)) {
				System.out.println("login successful");
				user = u;
				break;
			}
		}
		
		return user;
		
	}
	
	

	
	
	
	
	
}
