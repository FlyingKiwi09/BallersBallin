package application;

import java.util.ArrayList;
/**
 * 
 * User's that have ownership of a league.
 * @author Ballers Ballin
 * @version 1.0
 * 
 */
public class FantasyLeagueAdministrator extends User{

	//Class fields
	private ArrayList<League> 	leaguesIControl;
	
	//constructor
	/**
	 * Constructor for the fantasyLeague administrator. Administrators are in control of specific leagues and
	 * have the ability to remove and add users from the league.
	 * @param takes the username stored username for the user
	 * @param takes the password stored password for the user
	 */
	FantasyLeagueAdministrator(String username, String password){
		super(username, password);
	}
	
		
	//Getter, setter methods
	public ArrayList<League> getLeaguesIControl() 						{	return leaguesIControl;					}
	public void setLeaguesIControl(ArrayList<League> leaguesIControl) 	{	this.leaguesIControl = leaguesIControl;	}


	/* 
	 * This method adds a user and their team to a league I control 
	 */
	public void addUser(){
		
	}
	
	/*
	 * This method removes a user and their team from a league I control 
	 */
	public void removeUser() {
		
	}
	
	/*
	 * This method allows me to edit fields in a player object if the user is in a
	 * league that I control
	 */
	public void editUser() {
		
	}
	
	
	
}
