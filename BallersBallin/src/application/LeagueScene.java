package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class LeagueScene {
	
	private Main UI;
	private Scene leagueScene;
	private TableView<Team> leagueTeamsTableView;
	private Text title;

	public LeagueScene(Main UI) {
		this.UI = UI;
		setUpLeagueScene();
	}
	
	private void setUpLeagueScene() {
		VBox root = new VBox();
		leagueScene = new Scene(root,200,400);
		leagueScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		HBox navBar = new HBox();
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
		this.title.setText(targetLeague.getName());
		
		// get team list to set as observable list for tableview
		ObservableList<Team> teamList = FXCollections.observableArrayList(targetLeague.getTeams());
		
		// set columns
		TableColumn<Team,String> positions = new TableColumn<Team,String>("Pos");
		TableColumn<Team,String> teamName = new TableColumn<Team,String>("Team");
		TableColumn<Team,String> roundPoints = new TableColumn<Team,String>("Round Points");
		TableColumn<Team,String> totalPoints = new TableColumn<Team,String>("Total");
		
		leagueTeamsTableView.getColumns().addAll(positions, teamName, roundPoints, totalPoints);
		
		// set value factories
		// TODO: set value facoties for the other columns???
		teamName.setCellValueFactory(new PropertyValueFactory<Team,String>("name"));
		
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
//			UI.showTeamScene(targetTeam);
		});
		
	}

	public Scene getLeagueScene() {
		return leagueScene;
	}

	public void setLeagueScene(Scene leagueScene) {
		this.leagueScene = leagueScene;
	}
	
	

}
