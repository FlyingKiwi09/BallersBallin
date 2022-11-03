package application;

import java.io.File;
import java.util.Scanner;

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
		
		FantasyLeagueModel fantasyLeagueModel = new FantasyLeagueModel();
		boolean NewPlayer = true;
		Player play;

		
		String filename = "BallersBallin_sampledata_set2.txt";
		
		try {
			
			Scanner scan = new Scanner(new File(filename));
			while (scan.hasNext()) {
				
				scan.useDelimiter(",");
			
				String fullname = scan.next();
				String team = scan.next();
				int jersey = scan.nextInt();
				String position = scan.next();
				System.out.println(position + "next");
				String a = scan.nextLine();
			}
//				for (int i =0; i<fantasyLeagueModel.getPlayers().size();i++) {
//					
//					Player p = fantasyLeagueModel.getPlayers().get(i);
//					
//					if (p.getName().equalsIgnoreCase(fullname)) {
//						
//						
//						if (p.getNBLTeamName().equalsIgnoreCase(teamName)) {
//						
//						NewPlayer = false;
//						play = p;
//						}
//						
//					}
//					
//				}
//				
//				if (NewPlayer == true) {
//					
//					for (Position p : Position.values()) {
//						
//						if (p.toString().equalsIgnoreCase(position)) {
//							
//					Player player = new Player(p, fullname, teamName, jerseyNumber);
//					PlayerGameStats roundone = new PlayerGameStats (1,1,1,1);
//					player.getSeasonStats().get(player.getSeasonStats().size()-1).addGameStats(roundone);
//						}
//					}
//				}
//				
//			}
		}
		
		catch(Exception e) {
			
		}
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
