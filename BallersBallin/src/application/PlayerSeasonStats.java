package application;

import java.util.ArrayList;

public class PlayerSeasonStats {
	
	private ArrayList<PlayerGameStats> gameStatistics;
	Player player;
	private int totalPoints;
	private int totalAssists;
	private int totalRebounds;
	private int totalTimePlayed;
	private int playerSeasonScore;
	private double pointsAverage, assistsAverage, reboundsAverage, timePlayedAverage, playerScoreAverage;
	
	
	public PlayerSeasonStats(Player player) {
		
		gameStatistics = new ArrayList<PlayerGameStats>();
		this.player = player;
		this.totalPoints = 0;
		this.totalAssists = 0;
		this.totalRebounds = 0;
		this.totalTimePlayed = 0;
		
		this.playerSeasonScore = 0;
		
		this.pointsAverage = 0;
		this.assistsAverage = 0;
		this.reboundsAverage = 0;
		this.timePlayedAverage = 0;
		this.playerScoreAverage = 0;
	}
	
	
	
	public void updateAverages() {
		
		int games = gameStatistics.size();
		
		this.pointsAverage = totalPoints/games;
		this.assistsAverage = totalAssists/games;
		this.reboundsAverage = totalRebounds/games;
		this.timePlayedAverage = totalTimePlayed/games;
		this.playerScoreAverage = playerSeasonScore/games;
		
	}
	
	public void addGameStats(PlayerGameStats pgs) {
		
		gameStatistics.add(pgs);
		
		this.totalPoints += pgs.getPoints();
		this.totalAssists += pgs.getAssists();
		this.totalRebounds += pgs.getRebounds();
		this.totalTimePlayed += pgs.getTimePlayed();
		
		this.playerSeasonScore += pgs.getPlayerGameScore();
		
		this.updateAverages();
		
	}

	public double getPointsAverage() {
		return pointsAverage;
	}



	public void setPointsAverage(double pointsAverage) {
		this.pointsAverage = pointsAverage;
	}



	public double getAssistsAverage() {
		return assistsAverage;
	}



	public void setAssistsAverage(double assistsAverage) {
		this.assistsAverage = assistsAverage;
	}



	public double getReboundsAverage() {
		return reboundsAverage;
	}



	public void setReboundsAverage(double reboundsAverage) {
		this.reboundsAverage = reboundsAverage;
	}



	public double getTimePlayedAverage() {
		return timePlayedAverage;
	}



	public void setTimePlayedAverage(double timePlayedAverage) {
		this.timePlayedAverage = timePlayedAverage;
	}



	public double getPlayerScoreAverage() {
		return playerScoreAverage;
	}



	public void setPlayerScoreAverage(double playerScoreAverage) {
		this.playerScoreAverage = playerScoreAverage;
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
