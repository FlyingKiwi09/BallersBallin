package application;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MyLeaguesScene {

	private Scene myLeaguesScene;
	private TableView<League> myLeaguesList;
	
	public MyLeaguesScene() {
		setUpMyLeaguesScene();
	}
	
	private void setUpMyLeaguesScene() {
		VBox root = new VBox();
		myLeaguesScene = new Scene(root,200,400);
		myLeaguesScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		HBox navBar = new HBox();
		Text title = new Text("My Leagues");
		
		// create tableview
		myLeaguesList = new TableView<League>();
		
		
		// set nodes to root
		root.getChildren().addAll(navBar, title, myLeaguesList);
	}
	
	
	public void updateLeaguesList(ArrayList<League> list) {
		// clear previous list
		myLeaguesList.getItems().clear();
		
		
		
		TableColumn leagueName = new TableColumn("League Name");
		TableColumn leagueRanking = new TableColumn("League Ranking");
		
		myLeaguesList.getColumns().addAll(leagueName, leagueRanking);
		
		for (League league : list) {
			myLeaguesList.getItems().add(league);
		}
		
	}
	

	public Scene getMyLeaguesScene() {
		return myLeaguesScene;
	}

	public void setMyLeaguesScene(Scene myLeaguesScene) {
		this.myLeaguesScene = myLeaguesScene;
	}
	
	
	
}
