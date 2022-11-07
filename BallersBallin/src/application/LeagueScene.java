package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class LeagueScene {
	
	private Main UI;
	private Scene leagueScene;
	private TableView<Team> leagueTeamsTableView;
	private Text title;

	public LeagueScene(Main UI,int width, int height) {
		this.UI = UI;
		setUpLeagueScene(width, height);
	}
	
	private void setUpLeagueScene(int width, int height) {
		VBox root = new VBox();
		leagueScene = new Scene(root,width, height);
		leagueScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		HBox navBar = new HBox();
		// set up back button
		Image backImage = new Image("backImage.png", 20, 20, false, false, false);
		ImageView backImageView = new ImageView(backImage);
		Button backButton = new Button();
		backButton.setGraphic(backImageView);
		
		backButton.setOnMouseClicked(event -> {

			UI.goBack();
		});
		
		navBar.getChildren().add(backButton);
		
		title = new Text("");
		
		// create tableview
		leagueTeamsTableView = new TableView<Team>();
		
		
		// set nodes to root
		root.getChildren().addAll(navBar, title, leagueTeamsTableView);
	}
	
	
	public void updateTeamsList(League targetLeague) {
		// clear previous list
		leagueTeamsTableView.getItems().clear();
		
		// set title
		this.title.setText(targetLeague.getLeagueName());
		
		// get team list to set as observable list for tableview
		ObservableList<Team> teamList = FXCollections.observableArrayList(targetLeague.getTeams());
		
		// set columns
//		TableColumn<Team,String> position = new TableColumn<Team,String>("Pos"); couldn't set the Cell Value Factory for this 
		TableColumn<Team,String> teamName = new TableColumn<Team,String>("Team");
		TableColumn<Team,Integer> roundPoints = new TableColumn<Team,Integer>("Round Points");
		TableColumn<Team,Integer> totalScore = new TableColumn<Team,Integer>("Total");
		
		leagueTeamsTableView.getColumns().addAll(teamName, roundPoints, totalScore);
		
		// set value factories
		teamName.setCellValueFactory(new PropertyValueFactory<Team,String>("name"));
		totalScore.setCellValueFactory(new PropertyValueFactory<Team,Integer>("totalscore"));
		roundPoints.setCellValueFactory(new PropertyValueFactory<Team,Integer>("roundScore"));
		
		
		// sort table by position column
		leagueTeamsTableView.getSortOrder().add(totalScore);
		
		// set the items of the table view to the observable list
		leagueTeamsTableView.setItems(teamList);
		
		// set on click event for the table view
		leagueTeamsTableView.setOnMouseClicked(event -> {

		System.out.println(this.leagueTeamsTableView.getSelectionModel().getSelectedCells()); // test
		
		// get where the table is currently selected (table position)
		ObservableList<TablePosition> tablePosition = this.leagueTeamsTableView.getSelectionModel().getSelectedCells();
		
		System.out.println(tablePosition.get(0).getRow()); // test
		
		// get the team associated with where the table is currently selected
		Team targetTeam = teamList.get(tablePosition.get(0).getRow());
		
		System.out.println(targetTeam.getName()); // test
		
		// tell the UI to display the teamScene for the team associated with where the table is currently selected
			UI.showTeamScene(targetTeam);
		});
		
	}

	public Scene getLeagueScene() {
		return leagueScene;
	}

	public void setLeagueScene(Scene leagueScene) {
		this.leagueScene = leagueScene;
	}
	
	

}
