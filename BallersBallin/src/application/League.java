package application;

import java.util.ArrayList;
/**
 * 
 * @author Ballers Ballin
 * @version 1
 * Class used to create a league. Each league should have a name and a list
 of teams that play in the league. Each league will need at least one administrator.
 *
 */
public class League {
	private String leagueName;
	private ArrayList<Team> teams = new ArrayList<Team>();
	
	ArrayList<LeagueRoundStats> weeklyLeagueStats = new ArrayList<LeagueRoundStats>();
	FantasyLeagueAdministrator Administrator;
	//cant create getter and setter due to the above classes not existing
	
	
	/**
	 * 
	 * @param Administrator takes the administrator who runs the league. 
	 * @param leagueName takes the name of the league you want to create
	 */
	public League(FantasyLeagueAdministrator Administrator, String leagueName ) {
		this.leagueName = leagueName;
		this.Administrator = Administrator;
	}
	

	
	public ArrayList<Team> getTeams() {
		return teams;
	}

	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}
	
	
	public void addTeams(Team team) {
		this.teams.add(team);
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	
	
}
