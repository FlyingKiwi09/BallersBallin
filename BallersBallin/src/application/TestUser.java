package application;

import java.util.ArrayList;

public class TestUser {

	FantasyLeagueController controller;
	
	//Constructor
	TestUser(FantasyLeagueController Controller){
		this.controller = Controller;
		
	}
	
	public void addTestUser(){
		
		//constructs a new user,team, admin, league
		User testuser = new User("Testuser","password");
		Team testteam = new Team("Testteam");
		FantasyLeagueAdministrator testadmin = new FantasyLeagueAdministrator("Admin","password");
		League testleague = new League(testadmin,"Testleague");
		
		//adds user, admin, league to model
		controller.fantasyLeagueModel.getUsers().add(testuser);
		controller.fantasyLeagueModel.getUsers().add(testadmin);
		controller.fantasyLeagueModel.getLeagues().add(testleague);		
		
		//adds leagues/teams/users to each other as needed
		testleague.addTeams(testteam);
		testuser.getLeagues().add(testleague);
		testuser.setTeam(testteam);
		
		//constructs new players
		Player p1 = new Player	(	Position.FORWARD,"Taane Samuel","Wellington Saints",2	);
		Player p2 = new Player	(	Position.GUARD,"Jaylen Gerrand","Southland Sharks",6	);
		Player p3 = new Player	(	Position.FORWARD,"Aidan Tonge","Canturbury Rams",1		);
		Player p4 = new Player	(	Position.FORWARD,"Maxwell Darling","Canturbury Rams",12	);
		Player p5 = new Player	(	Position.GUARD,"Daishon Knight","Southland Sharks",5	);
		Player p6 = new Player	(	Position.FORWARD,"Kainoa Lepou","Auckland Tuatara",9	);
		Player p7 = new Player	(	Position.FORWARD,"Zach Mckenzie","Franklin Bulls",8		);
		Player p8 = new Player	(	Position.GUARD,"Joseph Ahie","Otago Nuggets",11			);
		Player p9 = new Player	(	Position.GUARD,"Isaac Davidson","Franklin Bulls",12		);
		Player p10 = new Player	(	Position.GUARD,"Quake Webster","Southland Sharks",10	);
		Player p11 = new Player	(	Position.CENTRE,"Jack Salt","Hawkes Bay Hawks",33		);
		Player p12 = new Player	(	Position.FORWARD,"Xavier Cooks","Wellington Saints",10	);
		Player p13 = new Player	(	Position.GUARD,"Anthony Hilliard","Taranaki Airs",18	);
		Player p14 = new Player	(	Position.GUARD,"Jarrod West","Nelson Giants",23			);
		Player p15 = new Player	(	Position.CENTRE,"Samuel Timmins","Otago Nuggets",33		);
		
		//adds player to model
		controller.fantasyLeagueModel.getPlayers().add(p1);
		controller.fantasyLeagueModel.getPlayers().add(p2);
		controller.fantasyLeagueModel.getPlayers().add(p3);
		controller.fantasyLeagueModel.getPlayers().add(p4);
		controller.fantasyLeagueModel.getPlayers().add(p5);
		controller.fantasyLeagueModel.getPlayers().add(p6);
		controller.fantasyLeagueModel.getPlayers().add(p7);
		controller.fantasyLeagueModel.getPlayers().add(p8);
		controller.fantasyLeagueModel.getPlayers().add(p9);
		controller.fantasyLeagueModel.getPlayers().add(p10);
		controller.fantasyLeagueModel.getPlayers().add(p11);
		controller.fantasyLeagueModel.getPlayers().add(p12);
		controller.fantasyLeagueModel.getPlayers().add(p13);
		controller.fantasyLeagueModel.getPlayers().add(p14);
		controller.fantasyLeagueModel.getPlayers().add(p15);		
		
		//adds players to the team
		testteam.addPlayer(p1);
		testteam.addPlayer(p2);
		testteam.addPlayer(p3);
		testteam.addPlayer(p4);
		testteam.addPlayer(p5);
		testteam.addPlayer(p6);
		testteam.addPlayer(p7);
		testteam.addPlayer(p8);
		testteam.addPlayer(p9);
		testteam.addPlayer(p10);
		testteam.addPlayer(p11);
		testteam.addPlayer(p12);
		testteam.addPlayer(p13);
		testteam.addPlayer(p14);
		testteam.addPlayer(p15);

		//creates new pss
		PlayerSeasonStats pss1 = new PlayerSeasonStats(2022);
		PlayerSeasonStats pss2 = new PlayerSeasonStats(2022);
		PlayerSeasonStats pss3 = new PlayerSeasonStats(2022);
		PlayerSeasonStats pss4 = new PlayerSeasonStats(2022);
		PlayerSeasonStats pss5 = new PlayerSeasonStats(2022);
		PlayerSeasonStats pss6 = new PlayerSeasonStats(2022);
		PlayerSeasonStats pss7 = new PlayerSeasonStats(2022);
		PlayerSeasonStats pss8 = new PlayerSeasonStats(2022);
		PlayerSeasonStats pss9 = new PlayerSeasonStats(2022);
		PlayerSeasonStats pss10 = new PlayerSeasonStats(2022);
		PlayerSeasonStats pss11 = new PlayerSeasonStats(2022);
		PlayerSeasonStats pss12 = new PlayerSeasonStats(2022);
		PlayerSeasonStats pss13 = new PlayerSeasonStats(2022);
		PlayerSeasonStats pss14 = new PlayerSeasonStats(2022);
		PlayerSeasonStats pss15 = new PlayerSeasonStats(2022);
		
		//adds pss to players
		p1.addSeasonStats(pss1);
		p2.addSeasonStats(pss2);
		p3.addSeasonStats(pss3);
		p4.addSeasonStats(pss4);
		p5.addSeasonStats(pss5);
		p6.addSeasonStats(pss6);
		p7.addSeasonStats(pss7);
		p8.addSeasonStats(pss8);
		p9.addSeasonStats(pss9);
		p10.addSeasonStats(pss10);
		p11.addSeasonStats(pss11);
		p12.addSeasonStats(pss12);
		p13.addSeasonStats(pss13);
		p14.addSeasonStats(pss14);
		p15.addSeasonStats(pss15);
		
		//creates new pgs
		PlayerGameStats pgs1 = new PlayerGameStats(10,3,4,1492,2);
		PlayerGameStats pgs2 = new PlayerGameStats(14,2,10,623,2);
		PlayerGameStats pgs3 = new PlayerGameStats(4,0,10,532,2);
		PlayerGameStats pgs4 = new PlayerGameStats(1,9,8,301,2);
		PlayerGameStats pgs5 = new PlayerGameStats(13,1,1,1018,2);
		PlayerGameStats pgs6 = new PlayerGameStats(12,10,10,1542,2);
		PlayerGameStats pgs7 = new PlayerGameStats(13,3,0,337,2);
		PlayerGameStats pgs8 = new PlayerGameStats(14,9,5,1184,2);
		PlayerGameStats pgs9 = new PlayerGameStats(4,5,9,509,2);
		PlayerGameStats pgs10 = new PlayerGameStats(0,0,3,1072,2);
		PlayerGameStats pgs11 = new PlayerGameStats(2,3,7,1643,2);
		PlayerGameStats pgs12 = new PlayerGameStats(2,7,6,1759,2);
		PlayerGameStats pgs13 = new PlayerGameStats(9,10,10,1768,2);
		PlayerGameStats pgs14 = new PlayerGameStats(3,1,2,1076,2);
		PlayerGameStats pgs15 = new PlayerGameStats(13,6,3,1390,2);
		
		//adds pgs to pss
		pss1.addGameStats(pgs1);
		pss1.addGameStats(pgs2);
		pss1.addGameStats(pgs3);
		pss1.addGameStats(pgs4);
		pss1.addGameStats(pgs5);
		pss1.addGameStats(pgs6);
		pss1.addGameStats(pgs7);
		pss1.addGameStats(pgs8);
		pss1.addGameStats(pgs9);
		pss1.addGameStats(pgs10);
		pss1.addGameStats(pgs11);
		pss1.addGameStats(pgs12);
		pss1.addGameStats(pgs13);
		pss1.addGameStats(pgs14);
		pss1.addGameStats(pgs15);
		
	}

	
}

