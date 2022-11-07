package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class FantasyLeagueController {
	
	FantasyLeagueModel fantasyLeagueModel;
	loginSignup loginSignupChecker;

	//Class fields
	//None as of 02.11.22	
	
	//Constructor
	public FantasyLeagueController(){
		this.fantasyLeagueModel = new FantasyLeagueModel();
		this.loginSignupChecker = new loginSignup();
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
		
		System.out.print("scan being called");
		
//		boolean NewPlayer = true;
//		Player play;

		JFileChooser j = new JFileChooser();
		int returnVal = j.showOpenDialog(null);
		
		File f = j.getSelectedFile();
		System.out.print(f.getName() + " selected");
		
		
		try {
			
			Scanner scan2 = new Scanner(f);
			System.out.print("made 1st scanner");
			
			
			
			while (scan2.hasNext()) {
				
//				Scanner scan = new Scanner(scan2.nextLine());
//				System.out.print("made 2nd scanner");
//				scan.useDelimiter(","); //comma and space needed?
			
				int seasonYear = scan2.nextInt();
				int game = scan2.nextInt();
				
				scan2.useDelimiter(",");
				System.out.print(seasonYear + " " + game);
				
				while (scan2.hasNext()) {
				
				String fullname = scan2.next();
				String team = scan2.next();
				int jersey = scan2.nextInt();
				String position = scan2.next();
				int points = scan2.nextInt();
				int rebounds = scan2.nextInt();
				int assists = scan2.nextInt();
				int min = scan2.nextInt();
				
				System.out.print(fullname+team+jersey+position+points+rebounds+assists+min);
				
				Player player = null;
				
				boolean playerExist = false;
				for(Player p : this.getPlayers()) {
					if (p.getName().equalsIgnoreCase(fullname)){
						if(p.getNBLTeamName().equalsIgnoreCase(team)) {
							if(p.getJerseyNumber() == jersey) {
								playerExist = true;
								player = p;
							}
						}
					}
				}
				
				
				if(!playerExist) {
					System.out.print("detected player not exist");
					Position pos = null;
					if (position.equalsIgnoreCase("CENTRE")) {
						pos = Position.CENTRE;
					}
					else if (position.equalsIgnoreCase("GUARD")) {
						pos = Position.GUARD;
					}
					else if (position.equalsIgnoreCase("FORWARD")) {
						pos = Position.FORWARD;
					}
					
					System.out.println(pos);
					
					Player pl = new Player(pos, fullname, team, jersey);
					System.out.println(pl.myToString());
					player = pl; 
					fantasyLeagueModel.getPlayers().add(player);
					System.out.println("adding new player");
				}
				
				PlayerSeasonStats thisSeason = null;
				boolean seasonExist = false;
				for(PlayerSeasonStats s : player.getSeasonStats()) {
					if(s.getYear() == seasonYear) {
						seasonExist = true;
						thisSeason = s;
					}
				}
				
				if(!seasonExist) {
					thisSeason = new PlayerSeasonStats(seasonYear);
					System.out.print("adding new season");
					player.addSeasonStats(thisSeason);
					
					System.out.print("adding season to player");
				}
				
				PlayerGameStats round = new PlayerGameStats(points, assists, rebounds, min, game);
				thisSeason.addGameStats(round);
				System.out.print("adding game to season");
				
				
				
				
//				
//				if (position.equals("CENTRE")) {
//			Player player = new Player(Position.CENTRE, fullname, team, jersey);
//			fantasyLeagueModel.getPlayers().add(player);
//			PlayerGameStats round = new PlayerGameStats(player, points, assists, rebounds, min, 1);
//			fantasyLeagueModel.getGamestats().add(round);
//			PlayerSeasonStats season = new PlayerSeasonStats(player);
//			season.addGameStats(round);
//			
//				}
//				else if (position.equals("GUARD")) {
//					Player player = new Player(Position.GUARD, fullname, team, jersey);
//					fantasyLeagueModel.getPlayers().add(player);
//					PlayerGameStats round = new PlayerGameStats(player, points, assists, rebounds, min, 1);
//					fantasyLeagueModel.getGamestats().add(round);
//					PlayerSeasonStats season = new PlayerSeasonStats(player);
//					season.addGameStats(round);
//				}
//				else if (position.equals("FORWARD")) {
//					Player player = new Player(Position.FORWARD, fullname, team, jersey);
//					fantasyLeagueModel.getPlayers().add(player);
//					PlayerGameStats round = new PlayerGameStats(player, points, assists, rebounds, min, 1);
//					fantasyLeagueModel.getGamestats().add(round);
//					PlayerSeasonStats season = new PlayerSeasonStats(player);
//					season.addGameStats(round);
//				}
//				}
				}
		}
		}
		
		catch(Exception e) {
			
		}
		
//		for (PlayerGameStats p : fantasyLeagueModel.getGamestats()) {
//			
//			if (p.player.getName().equals("Isaac Morrison")) {
//				//System.out.print(p.getPoints());
//			}
//		}
	}
	
	
	public void printPlayerTest() {
		for(Player p : this.getPlayers()) {
			for(PlayerSeasonStats s : p.getSeasonStats()) {
				for(PlayerGameStats g : s.getGameStatistics()) {
					System.out.print(p.getName() + " played " + s.getYear() + " game " + g.getRound() + " getting the following stats: ");
					System.out.print("points: " + g.getPoints() + " assists " + g.getAssists() + " rebounds: " + g.getRebounds() + " seconds: " + g.getTimePlayed());
				}
			}
		}
	}
	
	public ArrayList<Player> getPossibleTransfers(Position currentPlayerPosition){
		ArrayList<Player> possibleTransfers = new ArrayList<Player>();
		
		for (Player player : fantasyLeagueModel.getPlayers()) {
			if (player.getPosition().equals(currentPlayerPosition)) {
				possibleTransfers.add(player);
			}
		}

		return possibleTransfers;
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
		this.scanData();
		for(Player p : fantasyLeagueModel.getPlayers()) {
			p.updatePrice();
			System.out.print(p.getName() + " price: " + p.getPrice());
		}
		this.scanData();
		for(Player p : fantasyLeagueModel.getPlayers()) {
			p.updatePrice();
			System.out.print(p.getName() + " price: " + p.getPrice());
		}
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
	
	public User loginCheck(String username, String password) {
		return loginSignupChecker.loginValidation(fantasyLeagueModel, username, password);
	}
	
	
}
