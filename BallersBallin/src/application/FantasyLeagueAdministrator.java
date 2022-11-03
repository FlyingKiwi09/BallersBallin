package application;

import java.util.ArrayList;

public class FantasyLeagueAdministrator extends User{

	//Class fields
	private ArrayList<League> 	leaguesIControl;
	
	//constructor
	FantasyLeagueAdministrator(){
		
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
