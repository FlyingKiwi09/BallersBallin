package application;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MyLeaguesScene {

	private Scene myLeaguesScene;
	private ListView<String> myLeaguesList;
	
	public MyLeaguesScene() {
		setUpMyLeaguesScene();
	}
	
	private void setUpMyLeaguesScene() {
		VBox root = new VBox();
		myLeaguesScene = new Scene(root,200,400);
		myLeaguesScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		HBox navBar = new HBox();
		Text title = new Text("My Leagues");
		
		myLeaguesList = new ListView<String>();
		root.getChildren().addAll(navBar, title, myLeaguesList);
	}
	
	public void updateLeaguesList(ArrayList<League> list) {
		// clear previous list
		myLeaguesList.getItems().clear();
		
		
		
		// add list items passed in
		for (League s: list) {
			myLeaguesList.getItems().add(s.getLeagueName());
		}
		
		
	}
	

	public Scene getMyLeaguesScene() {
		return myLeaguesScene;
	}

	public void setMyLeaguesScene(Scene myLeaguesScene) {
		this.myLeaguesScene = myLeaguesScene;
	}
	
	
	
}
