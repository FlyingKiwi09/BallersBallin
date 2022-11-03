package application;

import java.util.ArrayList;

public class TeamRoundStats {
	ArrayList<PlayerGameStats> playersStats = new ArrayList<PlayerGameStats>();
	//can't create getter and setter or contructor due to player game stats class not existing
	private int teamWeeklyScore;
	
	
	public TeamRoundStats(ArrayList<PlayerGameStats> playersStats) {
		
		this.setTeamWeeklyScore(0);
		this.playersStats =playersStats;
	}


	int getTeamWeeklyScore() {
		return teamWeeklyScore;
	}


	void setTeamWeeklyScore(int teamWeeklyScore) {
		this.teamWeeklyScore = teamWeeklyScore;
	}
}


