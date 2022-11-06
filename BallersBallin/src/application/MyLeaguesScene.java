package application;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ChangeListener;

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
		
		
		
		//if a person clicks on the league it will show the teams in that league
		myLeaguesList.setOnMouseClicked(event ->{
			
			String league = myLeaguesList.getSelectionModel().getSelectedItem();
			
			for (League s : list) {
				
				if (league.equals(s.getLeagueName())) {
					myLeaguesList.getItems().clear();
					
					
					for (Team t : s.getTeams()) {
						myLeaguesList.getItems().add(t.getName());
					}
				}
			}
			
			
			//if a person clicks on the league it will show the player roster for that team
			String teamsName = myLeaguesList.getSelectionModel().getSelectedItem();
			
			for (League l : list) {
				
				for (Team team : l.getTeams()) {
					
					if (team.getName().equals(teamsName)){
						myLeaguesList.getItems().clear();
						
						for (Player p : team.getPlayers()) {
							myLeaguesList.getItems().add(p.getName());
						}
					}
				}
			}
		});
		
		
	}
	
	
	
	

	public Scene getMyLeaguesScene() {
		return myLeaguesScene;
	}

	public void setMyLeaguesScene(Scene myLeaguesScene) {
		this.myLeaguesScene = myLeaguesScene;
	}
	
	
	
}
