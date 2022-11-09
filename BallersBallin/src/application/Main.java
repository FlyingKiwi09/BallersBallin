package application;
	
import java.awt.Label;
import java.util.ArrayList;
import java.util.Stack;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

//test branch
public class Main extends Application {
//	FantasyLeagueModel fantasyLeagueModel = new FantasyLeagueModel();
	FantasyLeagueController maincontroller = new FantasyLeagueController();

	//test user for testing the UI until it gets connected to the controller
	private User testuser;

	//test
	//test2
	private final int WIDTH = 390;
	private final int HEIGHT = 550;

	
	// controller
	private FantasyLeagueController controller;
	

	
	private Stage primaryStage;
	private Scene loginScene;
	private MyLeaguesScene myLeaguesScene;
	private LeagueScene leagueScene;
	private teamScene teamScene;
	private MyPlayerScene playerScene;
	private transferScene transferScene;
	
	private Stack<Scene> historyForGoingBack = new Stack<Scene>();

	
	@Override
	public void start(Stage primaryStage) {
		
		
		// store the primaryStage to the UI so the scene can be changed on different button clicks
		this.primaryStage = primaryStage;

		try {
			//set up the test user
			/* setUpTestUser(); */
			
			// set up all the scenes
			setUpLoginScene();
			myLeaguesScene = new MyLeaguesScene(this, WIDTH, HEIGHT);
			leagueScene = new LeagueScene(this, WIDTH, HEIGHT);
			teamScene = new teamScene(this, WIDTH, HEIGHT);
			playerScene = new MyPlayerScene(this, WIDTH, HEIGHT);
			transferScene = new transferScene(this, WIDTH, HEIGHT);
	
			// start by showing the login scene
			primaryStage.setScene(loginScene);
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	/*PRIVATE METHODS SET UP THE DIFFERENT SCENES OF THE UI*/

	private void setUpLoginScene() {
		//creating a model and a controller.
		
		maincontroller.scanData();
		
		//load JPs hardcoded testdata
	    TestUser testuser = new TestUser(maincontroller);
		testuser.addTestUser();
		
		
		maincontroller.updatePlayerStats();
		maincontroller.printPlayerTest();
		

		//scans the hardcoded players in with their current weekly points.
		
		
		//populating hardcoded teams from the list of players in the fantasty league model.
//		Team a = new Team("Team A");
//		for (Player p : maincontroller.getPlayers()) {
//			
//			a.addPlayer(p);
//		}
//		
//		
//		Team b = new Team("Team B");
//		b.addPlayer(maincontroller.getPlayers().get(0));
//		b.addPlayer(maincontroller.getPlayers().get(1));
//		b.addPlayer(maincontroller.getPlayers().get(2));
//		
		//creating hardcoded users 
//		User userOne = new User();
//		FantasyLeagueAdministrator userTwo = new FantasyLeagueAdministrator();
//		
//		
//		//creating two leagues, adding teams to the league and adding to the model.
//		League leagueOne = new League(userTwo, "LeagueOne");
//		League leagueTwo = new League(userTwo, "LeagueTwo");
//		
//		leagueOne.addTeams(a);
//		leagueOne.addTeams(b);
//		leagueTwo.addTeams(a);
//		maincontroller.getLeagues().add(leagueOne);
//		maincontroller.getLeagues().add(leagueTwo);
		
		
		VBox root = new VBox();
		loginScene = new Scene(root,WIDTH,HEIGHT);
		loginScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		root.getStyleClass().add("root-center");
		
		
		Text title = new Text("Login");
		title.getStyleClass().add("title");
		
		
		// set up username input
		HBox nameHB = new HBox();
		Text nameLabel = new Text("Name");
		TextField nameTF = new TextField();
		nameHB.getChildren().addAll(nameLabel, nameTF);
		nameHB.getStyleClass().add("center-hbox");
		
		
		// set up pasword input
		HBox passwordHB = new HBox();
		Text passwordLabel = new Text("Password");
		TextField passwordTF = new TextField();
		passwordHB.getChildren().addAll(passwordLabel, passwordTF);
		passwordHB.getStyleClass().add("center-hbox");
		
		// set up buttons
		HBox buttonsHB = new HBox();
		Button loginButton = new Button("Login");
		Button registerButton = new Button("Register");
		buttonsHB.getChildren().addAll(loginButton, registerButton);
		buttonsHB.getStyleClass().add("center-hbox");
		
		// set up on click listeners for buttons
		loginButton.setOnMouseClicked(event -> {
			// TODO: send name and password to controller for validation
			// controller will then reply with method call to show error message or homepage 
			// for now homepage method call is here....
			String name = nameTF.getText();
			String password = passwordTF.getText();
			
			// push login scene before changing scenes
			this.historyForGoingBack.push(loginScene);
			showMyLeaguesScene(maincontroller.loginCheck(name, password));
		});
		
		// add to root
		root.getChildren().addAll(title, nameHB, passwordHB, buttonsHB);
		root.setMargin(title, new Insets(100,20,20,20));
		root.setMargin(nameHB, new Insets(10));
		root.setMargin(passwordHB, new Insets(10));
		root.setMargin(buttonsHB, new Insets(10));
		buttonsHB.setMargin(loginButton, new Insets(0,10,0,0));
		passwordHB.setMargin(passwordLabel, new Insets(0,10,0,0));
		nameHB.setMargin(nameLabel, new Insets(0,10,0,0));
	}
	
	
	
	
	
	public Stack<Scene> getHistoryForGoingBack() {
		return historyForGoingBack;
	}

	public void setHistoryForGoingBack(Stack<Scene> historyForGoingBack) {
		this.historyForGoingBack = historyForGoingBack;
	}

	private void setUpLeagueScene() {
		
	}
	
	private void setUpTeamScene() {
		
	}
	
	private void setUpPlayerScene() {
		
	}
	
	private void setUpTransferScene() {
		
	}
	
	

	
	/*PUBLIC METHODS CAN BE CALLED FRON THE CONTROLLER TO SEND BACK DATA FOR SCENE UPDATES WHEN SWITCHING BETWEEN SCENES*/
	
	/*SHOW HOME SCENE*/
	// after validating user input, a system can call this method to display home page (myLeaguesScene)
	// TODO: update method to accept a User from the controller
	// update method to update the myLeaguesScene based on user recieved back from controller
	// for now myLeaguesScene is shown directly from the loginButton...
	public void showMyLeaguesScene(User user) {

		for(League league: user.getLeagues()) {
			System.out.println(league.getLeagueName());
		}
		// update leagues list
		myLeaguesScene.updateLeaguesList(user.getLeagues());
		
		
		// hard coded leagues for UI demo

//		// update leagues list
//		myLeaguesScene.updateLeaguesList(maincontroller.getLeagues());

		
		// set myLeaguesScene to primary stage
		this.primaryStage.setScene(myLeaguesScene.getMyLeaguesScene());
	}
	
	public void showLeagueScene(League targetLeague) {
		// update teams list
		leagueScene.updateTeamsList(targetLeague);
		
		
		
		// set leagueScene to primary stage
		this.primaryStage.setScene(leagueScene.getLeagueScene());
	
		
	}
	
	public void showTeamScene(Team targetTeam) {
		teamScene.updatePlayerList(targetTeam);
		
		this.primaryStage.setScene(teamScene.getTeamScene());
	}
	
	public void showPlayerScene(Player targetPlayer) {
		playerScene.updatePlayerScene(targetPlayer);
		
		this.primaryStage.setScene(playerScene.getPlayerScene());
	}
	
	public void showTransferScene(Player leavingPlayer) {
		ArrayList<Player> possibleTransfers = maincontroller.getPossibleTransfers(leavingPlayer.getPosition());
		
		transferScene.updatePlayerList(leavingPlayer, possibleTransfers);
		
		this.primaryStage.setScene(transferScene.getTransferScene());
	}
	
	public void updateTeamScene(Player leavingPlayer, Player transferPlayer) {
		ArrayList<Player> currentPlayers = teamScene.getCurrentPlayerList();
		
		for (int i = 0; i < currentPlayers.size(); i++) {
			if (leavingPlayer.equals(currentPlayers.get(i))){
				currentPlayers.set(i, transferPlayer);
			}
		}
		
		this.primaryStage.setScene(teamScene.getTeamScene());
	}
	
	public void goBack() {
		this.primaryStage.setScene(this.historyForGoingBack.pop());
	}
	
/*	private void setUpTestUser() {
		
		
//		//players
	ArrayList<Player> myPlayers = new ArrayList<Player>();
	myPlayers.add(new Player(Position.CENTRE, "JP", "Wellington", 1));
		myPlayers.add(new Player(Position.GUARD, "Jessie", "Wellington", 3));
	myPlayers.add(new Player(Position.FORWARD, "Tom", "Wellington", 5));
	myPlayers.add(new Player(Position.FORWARD, "Harry", "Wellington", 7));
	myPlayers.add(new Player(Position.CENTRE, "Keifer", "Wellington", 9));		
	myPlayers.add(new Player(Position.GUARD, "Alina", "Wellington", 11));
		
//		
	ArrayList<Player> friendsPlayers = new ArrayList<Player>();
	friendsPlayers.add(new Player(Position.CENTRE, "Josh", "Auckland", 2));
		friendsPlayers.add(new Player(Position.GUARD, "Deb", "Christchurch", 4));
		friendsPlayers.add(new Player(Position.GUARD, "Jude", "Wellington", 6));
		friendsPlayers.add(new Player(Position.GUARD, "Sarah", "Wellington", 8));
		friendsPlayers.add(new Player(Position.FORWARD, "Ali", "Wellington", 10));
		friendsPlayers.add(new Player(Position.FORWARD, "Miro", "Wellington", 12));
		
//		//round histories
		ArrayList<TeamRoundStats> myRoundsHistory = new ArrayList<TeamRoundStats>();
//		
		ArrayList<TeamRoundStats> friendsRoundsHistory = new ArrayList<TeamRoundStats>();
//		
//		//test user team
		Team testUserTeam = new Team("My Team");
//		
//		// other team
		Team friendsTeam = new Team("Friends Team");
//		
//		// teams array
		ArrayList<Team> teams = new ArrayList<Team>();
		teams.add(testUserTeam);
		teams.add(friendsTeam);
//		
//		// admin and weekly league stats for league constructor
		FantasyLeagueAdministrator admin = new FantasyLeagueAdministrator();
//		
		ArrayList<LeagueRoundStats> weeklyLeagueStats = new ArrayList<LeagueRoundStats>();
//		
//		// league
		League globalLeague = new League("Global League", teams, weeklyLeagueStats, admin);
//		
		League anotherLeague = new League("Another League", teams, weeklyLeagueStats, admin);
//		
//		// arraylist of leagues
		ArrayList<League> leagues = new ArrayList<League>();
		leagues.add(globalLeague);
		leagues.add(anotherLeague);
//		
//		// test user
	testUser = new User();
	testUser.setID(1);
	testUser.setUsername("Test User");
	testUser.setTeam(testUserTeam);
//	testUser.setLeagues(leagues);
		
	*/
	
}

