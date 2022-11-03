package application;

public class PlayerGameStats {
	private int points;
	private int assists;
	private int rebounds;
	private int timePlayed;
	
	private int PlayerGameScore;
	
	public PlayerGameStats(int p, int a, int r, int tp) {
		
		this.points = p;
		this.assists = a;
		this.rebounds = r;
		this.timePlayed = tp;
		
	}
	
	
	//This method needs some thought put in. This is a place holder.
	private int calculatePlayerGameScore() {
		return this.points + this.assists + this.rebounds + this.timePlayed;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getRebounds() {
		return rebounds;
	}

	public void setRebounds(int rebounds) {
		this.rebounds = rebounds;
	}

	public int getTimePlayed() {
		return timePlayed;
	}

	public void setTimePlayed(int timePlayed) {
		this.timePlayed = timePlayed;
	}

	public int getPlayerGameScore() {
		return PlayerGameScore;
	}

	public void setPlayerGameScore(int playerGameScore) {
		PlayerGameScore = playerGameScore;
	}
	
}
