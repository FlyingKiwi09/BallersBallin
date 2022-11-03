package application;

import java.util.ArrayList;

public class User {

	//Class fields
	private String 				username,
								password;
	private Team 				team;
	private ArrayList<League> 	leagues;
	private static int			IDCount;
	private int					ID;
	
	
	//Constructor
	User(){
		
	}
	
	//Getter, setter methods
	public String getUsername() 						{	return username;			}
	public void setUsername(String username) 			{	this.username = username;	}

	public String getPassword() 						{	return password;			}
	public void setPassword(String password) 			{	this.password = password;	}

	public Team getTeam() 								{	return team;		}
	public void setTeam(Team team) 						{	this.team = team;	}

	public ArrayList<League> getLeagues() 				{	return leagues;			}
	public void setLeagues(ArrayList<League> leagues) 	{	this.leagues = leagues;	}

	public static int getIDCount() 						{	return IDCount;		}
	public static void setIDCount(int iDCount) 			{	IDCount = iDCount;	}

	public int getID() 									{	return ID;		}
	public void setID(int iD) 							{	ID = iD;		}

	
	/*
	 * This method should enter a user's team into an existing league
	 */	
	public void enterNewLeague() {
		
	}

	
	
	
	
	
}
