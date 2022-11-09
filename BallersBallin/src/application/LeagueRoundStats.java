package application;

import java.util.ArrayList;
/**
 * 
 * @author Ballers Ballin
 * @version 1
 * <p>
 * Takes the teams total score over a gameweek/round
 */
public class LeagueRoundStats {
	private ArrayList<TeamRoundStats> teamsStats = new ArrayList<TeamRoundStats>();
	private int week;
	
	
	/**
	 * 
	 * @param teamsStats takes totalled team stats and the gameweek/round number is preset to 0.
	 */
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