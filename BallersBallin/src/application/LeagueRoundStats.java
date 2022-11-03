package application;

import java.util.ArrayList;

public class LeagueRoundStats {
	private ArrayList<TeamRoundStats> teamsStats = new ArrayList<TeamRoundStats>();
	private int week;
	
	public LeagueRoundStats(ArrayList<TeamRoundStats> teamsStats) {
		this.week = 0;
		this.teamsStats = teamsStats;
		
		
	}

	int getWeek() {
		return week;
	}

	void setWeek(int week) {
		this.week = week;
	}

	ArrayList<TeamRoundStats> getTeamsStats() {
		return teamsStats;
	}

	void setTeamsStats(ArrayList<TeamRoundStats> teamsStats) {
		this.teamsStats = teamsStats;
	}
}