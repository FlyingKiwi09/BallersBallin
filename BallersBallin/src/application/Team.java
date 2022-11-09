package application;

import java.util.ArrayList;

/**
 * 
 * @author Ballers Ballin
 * @version 1 
 * A team consists of a group of players the user has selected for their fantasy league team.
 *
 */
public class Team {
	private ArrayList<TeamRoundStats> teamRoundHistory  = new ArrayList<TeamRoundStats>();
	private ArrayList<Player> players = new ArrayList<Player>();
	//can't create getter and setter due to player class not existing
	private int roundScore;
	private String name;
	private int totalscore;
	private int budget;
	private int spending;
	
	
	/**
	 * 
	 * @param name takes the name of the team you want to create.
	 */
	public Team(String name) {
		this.setName(name);
		this.budget = 50;
		this.spending = 0;
		this.roundScore = 0;
		this.totalscore = 0;
	}
	
	public void calculateWeeklyScore() {
		
	}
	
	
	public void transfer(Player toBeRemoved, Player toBeAdded) {
		
		
		for (int i =0; i<players.size();i++) {
			
			Player temp = players.get(i);
		if (toBeRemoved.getName().equals(temp.getName())){
			players.remove(temp);
			players.add(toBeAdded);
			break;
		}
	}
	}
	
	
	
	/**
	 * 
	 * @param p takes the player that will be added to the team
	 */
	public void addPlayer(Player p) {
		this.getPlayers().add(p);
	}

	ArrayList<TeamRoundStats> getTeamRoundHistory() {
		return teamRoundHistory;
	}

	void setTeamRoundHistory(ArrayList<TeamRoundStats> teamRoundHistory) {
		this.teamRoundHistory = teamRoundHistory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public int getRoundScore() {
		return roundScore;
	}

	public void setRoundScore(int roundScore) {
		this.roundScore = roundScore;
	}

	public int getTotalscore() {
		return totalscore;
	}

	public void setTotalscore(int totalscore) {
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
