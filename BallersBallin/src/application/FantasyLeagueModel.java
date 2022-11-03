package application;

public class FantasyLeagueModel {

	//fields
	private ArrayList<User> 		users;
	private ArrayList<Player> 		players;
	private ArrayList<League> 		leagues;
	
	
	//constructor
	public FantasyLeagueModel() {
		
	}

	//getter, setter methods
	public ArrayList<User> getUsers() 					{	return users;		}
	public void setUsers(ArrayList<User> users) 		{	this.users = users;	}

	public ArrayList<Player> getPlayers() 				{	return players;			}
	public void setPlayers(ArrayList<Player> players) 	{	this.players = players;	}

	public ArrayList<League> getLeagues() 				{	return leagues;			}
	public void setLeagues(ArrayList<League> leagues) 	{	this.leagues = leagues;	}
	
	

	
	
}
