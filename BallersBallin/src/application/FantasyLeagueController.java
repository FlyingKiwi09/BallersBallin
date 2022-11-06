package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FantasyLeagueController {
	
	FantasyLeagueModel fantasyLeagueModel;
	//Class fields
	//None as of 02.11.22	
	
	//Constructor
	public FantasyLeagueController(){
		this.fantasyLeagueModel = new FantasyLeagueModel();
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
				int points = scan.nextInt();
				int rebounds = scan.nextInt();
				int assists = scan.nextInt();
				int min = scan.nextInt();
				
				if (position.equals("CENTRE")) {
			Player player = new Player(Position.CENTRE, fullname, team, jersey);
			fantasyLeagueModel.getPlayers().add(player);
			PlayerGameStats round = new PlayerGameStats(player, points, assists, rebounds, min, 1);
			fantasyLeagueModel.getGamestats().add(round);
			PlayerSeasonStats season = new PlayerSeasonStats(player);
			season.addGameStats(round);
			
				}
				else if (position.equals("GUARD")) {
					Player player = new Player(Position.CENTRE, fullname, team, jersey);
					fantasyLeagueModel.getPlayers().add(player);
					PlayerGameStats round = new PlayerGameStats(player, points, assists, rebounds, min, 1);
					fantasyLeagueModel.getGamestats().add(round);
					PlayerSeasonStats season = new PlayerSeasonStats(player);
					season.addGameStats(round);
				}
				else if (position.equals("FORWARD")) {
					Player player = new Player(Position.FORWARD, fullname, team, jersey);
					fantasyLeagueModel.getPlayers().add(player);
					PlayerGameStats round = new PlayerGameStats(player, points, assists, rebounds, min, 1);
					fantasyLeagueModel.getGamestats().add(round);
					PlayerSeasonStats season = new PlayerSeasonStats(player);
					season.addGameStats(round);
				}
				}

		}
		
		catch(Exception e) {
			
		}
		
		for (PlayerGameStats p : fantasyLeagueModel.getGamestats()) {
			
			if (p.player.getName().equals("Isaac Morrison")) {
				//System.out.print(p.getPoints());
			}
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
	
	public ArrayList<Player> getPlayers(){
		return fantasyLeagueModel.getPlayers();
	}
	
	public ArrayList<League> getLeagues(){
		return fantasyLeagueModel.getLeagues();
	}
	
}
