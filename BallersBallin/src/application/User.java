package application;

import java.util.ArrayList;



/**
 * Creates a user that will use the fantasyleague application. Each user requires a username and password.
 *  Each user can only have one team but can be in multiple leagues.
 * <P>
 * 
 * @author Ballers Ballin
 * @version 1
 *
 */
public class User {

	
	private String 				username,
								password;
	private Team 				team;
	private ArrayList<League> 	leagues;
	private static int			IDCount;
	private int					ID;
	
	
	/**
	 * 
	 * @param username takes the users username
	 * @param password tales the users password
	 */
	User(String username, String password){
		setUsername(username);
		setPassword(password);
		setID(getIDCount());
		iterateIDCount();
		leagues = new ArrayList<League>();
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

	public void iterateIDCount() {
		int idcount = getIDCount();
		idcount++;
		setIDCount(idcount);
	}	
	
	/*
	 * This method should enter a user's team into an existing league
	 */	
	public void enterNewLeague() {
		
	}

	
	
	
	
	
}
