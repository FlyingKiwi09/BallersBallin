package application;

import java.util.ArrayList;
/**
 * 
 * @author Ballers Ballin
 * @version 1
 * 
 * Calculates the team round total stats based on the all the players in the team's game stats.
 *
 */
public class TeamRoundStats {
	ArrayList<PlayerGameStats> playersStats = new ArrayList<PlayerGameStats>();
	private int teamWeeklyScore;
	private Team team;
	
	
	
	/**
	 * 
	 * @param team takes a team and sets the weekly score as a preset 0.
	 */
	public TeamRoundStats(Team team) {
		
		this.setTeamWeeklyScore(0);
		this.setTeam(team);
	}


	int getTeamWeeklyScore() {
		return teamWeeklyScore;
	}


	void setTeamWeeklyScore(int teamWeeklyScore) {
		this.teamWeeklyScore = teamWeeklyScore;
	}


	public Team getTeam() {
		return team;
	}


	public void setTeam(Team team) {
		this.team = team;
	}
	
	public void generateTeamScore() {
		
	}
}


