package application;

import java.util.ArrayList;

public class Player {
	
	static int IDCount = 0;
	
	ArrayList<PlayerSeasonStats> seasonStats;
	
	Position position;
	private String name;
	String NBLTeamName;
	int jerseyNumber;
	int Id;
	double price;
	
	
	int historicalPoints;
	int historicalAssists;
	int historicalRebounds;
	int historicalTimePlayed;
	int historicalPlayerScore;
	
	public Player(Position p, String n, String tn, int jn) {
		
		this.seasonStats = new ArrayList<PlayerSeasonStats>();
		
		this.name = n;
		this.NBLTeamName= tn;
		this.jerseyNumber = jn;
		this.position = p;
		
		IDCount++;
		this.Id = IDCount;
		
		this.historicalPoints = 0;
		this.historicalAssists = 0;
		this.historicalRebounds  = 0;
		this.historicalTimePlayed = 0;
		
		this.historicalPlayerScore = 0;
		
	}
	
	public void addSeasonStats(PlayerSeasonStats pss) {
		
		seasonStats.add(pss);
		
		this.historicalPoints += pss.getTotalPoints();
		this.historicalAssists += pss.getTotalAssists();
		this.historicalRebounds += pss.getTotalRebounds();
		this.historicalTimePlayed += pss.getTotalTimePlayed();
		
		this.historicalPlayerScore += pss.getPlayerSeasonScore();
		
	}
	
	
	public ArrayList<PlayerSeasonStats> getSeasonStats() {
		return seasonStats;
	}
	public void setSeasonStats(ArrayList<PlayerSeasonStats> seasonStats) {
		this.seasonStats = seasonStats;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNBLTeamName() {
		return NBLTeamName;
	}
	public void setNBLTeamName(String nBLTeamName) {
		NBLTeamName = nBLTeamName;
	}
	public int getJerseyNumber() {
		return jerseyNumber;
	}
	public void setJerseyNumber(int jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}
	public int getID() {
		return Id;
	}
	public void setID(int iD) {
		Id = iD;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getHistoricalPoints() {
		return historicalPoints;
	}

	public void setHistoricalPoints(int historicalPoints) {
		this.historicalPoints = historicalPoints;
	}

	public int getHistoricalAssists() {
		return historicalAssists;
	}

	public void setHistoricalAssists(int historicalAssists) {
		this.historicalAssists = historicalAssists;
	}

	public int getHistoricalRebounds() {
		return historicalRebounds;
	}

	public void setHistoricalRebounds(int historicalRebounds) {
		this.historicalRebounds = historicalRebounds;
	}

	public int getHistoricalTimePlayed() {
		return historicalTimePlayed;
	}

	public void setHistoricalTimePlayed(int historicalTimePlayed) {
		this.historicalTimePlayed = historicalTimePlayed;
	}

	public int getHistoricalPlayerScore() {
		return historicalPlayerScore;
	}

	public void setHistoricalPlayerScore(int historicalPlayerScore) {
		this.historicalPlayerScore = historicalPlayerScore;
	}
	
	public String toString() {
		return this.getName() + " " + this.getPosition().name() + " " + this.getNBLTeamName();
	}
	
	
}
