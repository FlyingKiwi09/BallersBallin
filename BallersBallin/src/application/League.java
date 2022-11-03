package application;

import java.util.ArrayList;

public class League {
	private ArrayList<Team> teams = new ArrayList<Team>();
	ArrayList<LeagueRoundStats> weeklyLeagueStats = new ArrayList<LeagueRoundStats>();
	FantasyLeagueAdministrator Administrator;
	//cant create getter and setter due to the above classes not existing
	
	
	public League(ArrayList<Team> teams, ArrayList<LeagueRoundStats> weeklyLeagueStats,FantasyLeagueAdministrator Administrator ) {
		this.teams = teams;
		this.weeklyLeagueStats = weeklyLeagueStats;
		this.Administrator = Administrator;
	}

	ArrayList<Team> getTeams() {
		return teams;
	}

	void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}
	
}
