package application;
	
import java.awt.Label;
import java.util.ArrayList;
import java.util.Stack;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class Main extends Application {
	FantasyLeagueModel fantasyLeagueModel = new FantasyLeagueModel();
	FantasyLeagueController maincontroller = new FantasyLeagueController(fantasyLeagueModel);
	
	private final int WIDTH = 200;
	private final int HEIGHT = 400;
	
	private Stage primaryStage;
	
	private Scene loginScene;
	private MyLeaguesScene myLeaguesScene;
	private Scene leagueScene;
	private Scene teamScene;
	private Scene playerScene;
	private Scene transferScene;
	
	private Stack<Scene> historyForGoingBack = new Stack<Scene>();

	
	@Override
	public void start(Stage primaryStage) {
		// store the primaryStage to the UI so the scene can be changed on different button clicks
		this.primaryStage = primaryStage;

		try {
			// set up all the scenes
			setUpLoginScene();
			myLeaguesScene = new MyLeaguesScene();
			setUpLeagueScene();
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

		//scans the hardcoded players in with their current weekly points.
		maincontroller.scanData();
		
		//populating hardcoded teams from the list of players in the fantasty league model.
		Team a = new Team("Team A");
		for (Player p : fantasyLeagueModel.getPlayers()) {
			
			a.addPlayer(p);
		}
		
		
		Team b = new Team("Team B");
		b.addPlayer(fantasyLeagueModel.getPlayers().get(0));
		b.addPlayer(fantasyLeagueModel.getPlayers().get(1));
		b.addPlayer(fantasyLeagueModel.getPlayers().get(2));
		
		//creating hardcoded users 
		User userOne = new User();
		FantasyLeagueAdministrator userTwo = new FantasyLeagueAdministrator();
		
		
		//creating two leagues, adding teams to the league and adding to the model.
		League leagueOne = new League(userTwo, "LeagueOne");
		League leagueTwo = new League(userTwo, "LeagueTwo");
		
		leagueOne.addTeams(a);
		leagueOne.addTeams(b);
		leagueTwo.addTeams(a);
		fantasyLeagueModel.getLeagues().add(leagueOne);
		fantasyLeagueModel.getLeagues().add(leagueTwo);
		
		
		VBox root = new VBox();
		loginScene = new Scene(root,WIDTH,HEIGHT);
		loginScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		Text title = new Text("Login");
		
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
			
			showMyLeaguesScene();
		});
		
		// add to root
		root.getChildren().addAll(title, nameHB, passwordHB, buttonsHB);
		
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
	public void showMyLeaguesScene() {

		// hard coded leagues for UI demo

		// update leagues list
		myLeaguesScene.updateLeaguesList(fantasyLeagueModel.getLeagues());
		
		// set myLeaguesScene to primary stage
		this.primaryStage.setScene(myLeaguesScene.getMyLeaguesScene());
	}
	
}
