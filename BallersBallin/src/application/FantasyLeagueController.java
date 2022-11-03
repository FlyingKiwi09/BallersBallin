package application;

public class FantasyLeagueController {

	//Class fields
	//None as of 02.11.22	
	
	//Constructor
	public FantasyLeagueController(){
		
	}
	
	//Getter, setter methods
	//None as of 02.11.22
	
	
	/*
	 * This method should retrieve data (scanner?) from the NZNBL website or other
	 * source. 
	 * 
	 * If a player does not exist in our system database, this method should
	 * create a new player object with their relevant stats.
	 * 
	 * If a player has changed teams e.g. WGN->AKL, the database should change this 
	 * field in the player object
	 */
	public void scanData() {
		
	}
	

	/* 
	 * This method should use the data from the scanData method above (once per week) to calculate/update 
	 * the values in each of the fields in:
	 * 				- the PlayerGameStats object
	 * 				- the PlayerSeasonStats object
	 * 				- the Player object
	 * for each of the players in the database.
	 * 
	 */
	public void updatePlayerStats() {
		
	}
	
	
	/* 
	 * This method should use updated player data for this week to calculate/update
	 * the values in each of the fields in:
	 * 				- TeamRoundStats
	 * 				- Team
	 */
	public void generateGameWeek() {
		
	}
	
	/* 
	 * This method should use updated team data for this week to calculate/update
	 * the values in each of the fields in:
	 * 				- LeagueRoundStats
	 * 				- League
	 */
	public void updateLeagues() {
		
	}
	
	
	/* 
	 * This method is a catch-all logging method to generate trace information for the developer/sysadmin/testers.
	 * Logging can include:
	 * 			-current logged in user
	 * 			-events/actions that take place
	 * 			-any errors
	 */
	public void logging() {
		
	}
	
	
	
}
