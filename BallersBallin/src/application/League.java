package application;

import java.util.ArrayList;

public class League {
	private String leagueName;
	private ArrayList<Team> teams = new ArrayList<Team>();
	String name;
	ArrayList<LeagueRoundStats> weeklyLeagueStats = new ArrayList<LeagueRoundStats>();
	FantasyLeagueAdministrator Administrator;
	//cant create getter and setter due to the above classes not existing
	
	
	public League(FantasyLeagueAdministrator Administrator, String leagueName ) {
		this.setLeagueName(leagueName);
		this.Administrator = Administrator;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	ArrayList<Team> getTeams() {
		return teams;
	}

	void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}
	
	
	public void addTeams(Team team) {
		this.teams.add(team);
	}

	String getLeagueName() {
		return leagueName;
	}

	void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	
	
}
