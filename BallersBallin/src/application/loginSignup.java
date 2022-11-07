package application;

import java.util.ArrayList;

public class loginSignup {

	public loginSignup() {
		
	}
	
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
