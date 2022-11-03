package application;

import java.util.ArrayList;


public class Team {
	private ArrayList<TeamRoundStats> teamRoundHistory  = new ArrayList<TeamRoundStats>();
	ArrayList<Player> players = new ArrayList<Player>();
	//can't create getter and setter due to player class not existing
	private String name;
	private int totalscore;
	private int budget;
	private int spending;
	
	
	
	public Team(String name, ArrayList<Player> players, ArrayList<TeamRoundStats> teamRoundHistory) {
		this.setName(name);
		this.budget = 50;
		this.spending = 0;
		this.totalscore = 0;
		this.players = players;
		this.teamRoundHistory = teamRoundHistory;
		
	}
	
	public void calculateWeeklyScore() {
		
	}
	
	public void transfer(Player p, Position po) {
		
	}
	
	public void addPlayer(Position p) {
		
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

}