package application;

import java.util.ArrayList;

public class PlayerSeasonStats {
	
	private ArrayList<PlayerGameStats> gameStatistics;
	
	private int totalPoints;
	private int totalAssists;
	private int totalRebounds;
	private int totalTimePlayed;
	
	private int playerSeasonScore;
	
	public PlayerSeasonStats() {
		
		gameStatistics = new ArrayList<PlayerGameStats>();
		
		this.totalPoints = 0;
		this.totalAssists = 0;
		this.totalRebounds = 0;
		this.totalTimePlayed = 0;
		
		this.playerSeasonScore = 0;
		
	}
	
	public void addGameStats(PlayerGameStats pgs) {
		
		gameStatistics.add(pgs);
		
		this.totalPoints += pgs.getPoints();
		this.totalAssists += pgs.getAssists();
		this.totalRebounds += pgs.getRebounds();
		this.totalTimePlayed += pgs.getTimePlayed();
		
		this.playerSeasonScore += pgs.getPlayerGameScore();
		
	}

	public ArrayList<PlayerGameStats> getGameStatistics() {
		return gameStatistics;
	}

	public void setGameStatistics(ArrayList<PlayerGameStats> gameStatistics) {
		this.gameStatistics = gameStatistics;
	}

	public int getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}

	public int getTotalAssists() {
		return totalAssists;
	}

	public void setTotalAssists(int totalAssists) {
		this.totalAssists = totalAssists;
	}

	public int getTotalRebounds() {
		return totalRebounds;
	}

	public void setTotalRebounds(int totalRebounds) {
		this.totalRebounds = totalRebounds;
	}

	public int getTotalTimePlayed() {
		return totalTimePlayed;
	}

	public void setTotalTimePlayed(int totalTimePlayed) {
		this.totalTimePlayed = totalTimePlayed;
	}

	public int getPlayerSeasonScore() {
		return playerSeasonScore;
	}

	public void setPlayerSeasonScore(int playerSeasonScore) {
		this.playerSeasonScore = playerSeasonScore;
	}
	
	
	
}
