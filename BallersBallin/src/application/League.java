package application;

import java.util.ArrayList;

public class League {
	private ArrayList<Team> teams = new ArrayList<Team>();
	String name;
	ArrayList<LeagueRoundStats> weeklyLeagueStats = new ArrayList<LeagueRoundStats>();
	FantasyLeagueAdministrator Administrator;
	//cant create getter and setter due to the above classes not existing
	
	
	public League(String name, ArrayList<Team> teams, ArrayList<LeagueRoundStats> weeklyLeagueStats,FantasyLeagueAdministrator Administrator ) {
		this.teams = teams;
		this.weeklyLeagueStats = weeklyLeagueStats;
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
	
}
