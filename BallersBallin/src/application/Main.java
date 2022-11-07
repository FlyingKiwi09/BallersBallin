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
	private User testUser;

	//test
	//test2
	private final int WIDTH = 390;
	private final int HEIGHT = 550;

	
//	// controller
//	private FantasyLeagueController controller;
	

	
	private Stage primaryStage;
	private Scene loginScene;
	private MyLeaguesScene myLeaguesScene;
	private LeagueScene leagueScene;
	private Scene teamScene;
	private Scene playerScene;
	private Scene transferScene;
	
	private Stack<Scene> historyForGoingBack = new Stack<Scene>();

	
	@Override
	public void start(Stage primaryStage) {
		
		
		// store the primaryStage to the UI so the scene can be changed on different button clicks
		this.primaryStage = primaryStage;

		try {
			//set up the test user
			setUpTestUser();
			
			// set up all the scenes
			setUpLoginScene();
			myLeaguesScene = new MyLeaguesScene(this, WIDTH, HEIGHT);
			leagueScene = new LeagueScene(this, WIDTH, HEIGHT);
			setUpTeamScene();
			setUpPlayerScene();
			setUpTransferScene();
			
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
		
		//maincontroller.scanData();
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
		User userOne = new User();
		FantasyLeagueAdministrator userTwo = new FantasyLeagueAdministrator();
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
		
		
		// set up pasword input
		HBox passwordHB = new HBox();
		Text passwordLabel = new Text("Password");
		TextField passwordTF = new TextField();
		passwordHB.getChildren().addAll(passwordLabel, passwordTF);
		
		// set up buttons
		HBox buttonsHB = new HBox();
		Button loginButton = new Button("Login");
		Button registerButton = new Button("Register");
		buttonsHB.getChildren().addAll(loginButton, registerButton);
		
		// set up on click listeners for buttons
		loginButton.setOnMouseClicked(event -> {
			// TODO: send name and password to controller for validation
			// controller will then reply with method call to show error message or homepage 
			// for now homepage method call is here....
			String name = nameTF.getText();
			String password = passwordTF.getText();
			
			// push login scene before changing scenes
			this.historyForGoingBack.push(loginScene);
			showMyLeaguesScene(testUser);
		});
		
		// add to root
		root.getChildren().addAll(title, nameHB, passwordHB, buttonsHB);
		root.setMargin(title, new Insets(20));
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


		// update leagues list
		myLeaguesScene.updateLeaguesList(user.getLeagues());

		// hard coded leagues for UI demo

		// update leagues list
		myLeaguesScene.updateLeaguesList(maincontroller.getLeagues());

		
		// set myLeaguesScene to primary stage
		this.primaryStage.setScene(myLeaguesScene.getMyLeaguesScene());
	}
	
	public void showLeagueScene(League targetLeague) {
		// update teams list
		leagueScene.updateTeamsList(targetLeague);
		
		
		
		// set leagueScene to primary stage
		this.primaryStage.setScene(leagueScene.getLeagueScene());
	
		
	}
	
	public void goBack() {
		this.primaryStage.setScene(this.historyForGoingBack.pop());
	}
	
	private void setUpTestUser() {
		
		
//		//players
//		ArrayList<Player> myPlayers = new ArrayList<Player>();
//		myPlayers.add(new Player(Position.CENTER, "JP", "Wellington", 1, 100000));
//		myPlayers.add(new Player(Position.POINT_GUARD, "Jessie", "Wellington", 3, 200000));
//		myPlayers.add(new Player(Position.POWER_FORWARD, "Tom", "Wellington", 5, 150000));
//		myPlayers.add(new Player(Position.SMALL_FORWARD, "Harry", "Wellington", 7, 170000));
//		myPlayers.add(new Player(Position.CENTER, "Keifer", "Wellington", 9, 220000));
//		myPlayers.add(new Player(Position.SHOOTING_GUARD, "Alina", "Wellington", 11, 90000));
//		
//		
//		ArrayList<Player> friendsPlayers = new ArrayList<Player>();
//		friendsPlayers.add(new Player(Position.CENTER, "Josh", "Auckland", 2, 600000));
//		friendsPlayers.add(new Player(Position.SHOOTING_GUARD, "Deb", "Christchurch", 4, 700000));
//		friendsPlayers.add(new Player(Position.SHOOTING_GUARD, "Jude", "Wellington", 6, 300000));
//		friendsPlayers.add(new Player(Position.POINT_GUARD, "Sarah", "Wellington", 8,320000));
//		friendsPlayers.add(new Player(Position.SMALL_FORWARD, "Ali", "Wellington", 10, 1000000));
//		friendsPlayers.add(new Player(Position.POWER_FORWARD, "Miro", "Wellington", 12, 230000));
//		
//		//round histories
//		ArrayList<TeamRoundStats> myRoundsHistory = new ArrayList<TeamRoundStats>();
//		
//		ArrayList<TeamRoundStats> friendsRoundsHistory = new ArrayList<TeamRoundStats>();
//		
//		//test user team
//		Team testUserTeam = new Team("My Team", myPlayers, myRoundsHistory);
//		
//		// other team
//		Team friendsTeam = new Team("Friends Team", friendsPlayers, friendsRoundsHistory);
//		
//		// teams array
//		ArrayList<Team> teams = new ArrayList<Team>();
//		teams.add(testUserTeam);
//		teams.add(friendsTeam);
//		
//		// admin and weekly league stats for league constructor
//		FantasyLeagueAdministrator admin = new FantasyLeagueAdministrator();
//		
//		ArrayList<LeagueRoundStats> weeklyLeagueStats = new ArrayList<LeagueRoundStats>();
//		
//		// league
//		League globalLeague = new League("Global League", teams, weeklyLeagueStats, admin);
//		
//		League anotherLeague = new League("Another League", teams, weeklyLeagueStats, admin);
//		
//		// arraylist of leagues
//		ArrayList<League> leagues = new ArrayList<League>();
//		leagues.add(globalLeague);
//		leagues.add(anotherLeague);
//		
//		// test user
//		testUser = new User();
//		testUser.setID(1);
//		testUser.setUsername("Test User");
//		testUser.setTeam(testUserTeam);
//		testUser.setLeagues(leagues);
		
	
	}
}

