package application;

import java.util.ArrayList;

public class TeamRoundStats {
	ArrayList<PlayerGameStats> playersStats = new ArrayList<PlayerGameStats>();
	private int teamWeeklyScore;
	private Team team;
	
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


