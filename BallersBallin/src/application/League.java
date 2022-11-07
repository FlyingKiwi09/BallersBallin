package application;

import java.util.ArrayList;

public class League {
	private String leagueName;
	private ArrayList<Team> teams = new ArrayList<Team>();
	
	ArrayList<LeagueRoundStats> weeklyLeagueStats = new ArrayList<LeagueRoundStats>();
	FantasyLeagueAdministrator Administrator;
	//cant create getter and setter due to the above classes not existing
	
	
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
