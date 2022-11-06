package application;

import java.util.ArrayList;


public class Team {
	private ArrayList<TeamRoundStats> teamRoundHistory  = new ArrayList<TeamRoundStats>();
	private ArrayList<Player> players = new ArrayList<Player>();
	//can't create getter and setter due to player class not existing
	private String name;
	private int totalscore;
	private int budget;
	private int spending;
	
	
	
	public Team(String name) {
		this.setName(name);
		this.budget = 50;
		this.spending = 0;
		this.totalscore = 0;
	}
	
	public void calculateWeeklyScore() {
		
	}
	
	public void transfer(Player p, Position po) {
		
	}
	
	public void addPlayer(Player p) {
		this.getPlayers().add(p);
	}

	ArrayList<TeamRoundStats> getTeamRoundHistory() {
		return teamRoundHistory;
	}

	void setTeamRoundHistory(ArrayList<TeamRoundStats> teamRoundHistory) {
		this.teamRoundHistory = teamRoundHistory;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	int getTotalscore() {
		return totalscore;
	}

	void setTotalscore(int totalscore) {
		this.totalscore = totalscore;
	}

	int getBudget() {
		return budget;
	}

	void setBudget(int budget) {
		this.budget = budget;
	}

	int getSpending() {
		return spending;
	}

	void setSpending(int spending) {
		this.spending = spending;
	}

	ArrayList<Player> getPlayers() {
		return players;
	}

	void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

}
