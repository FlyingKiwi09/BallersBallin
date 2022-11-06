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

public class teamScene {

	private Main UI;
	private Scene teamScene;
	private TableView<Player> teamsPlayerTableView;
	private Text title;

	public teamScene(Main UI, int width, int height) {
		this.UI = UI;
		setUpTeamScene(width, height);
	}

	private void setUpTeamScene(int width, int height) {
		VBox root = new VBox();
		teamScene = new Scene(root, width, height);
		teamScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

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
		title.getStyleClass().add("title");
		// create tableview
		teamsPlayerTableView = new TableView<Player>();

		// set nodes to root
		root.getChildren().addAll(navBar, title, teamsPlayerTableView);
	}
	public void updatePlayerList(Team targetTeam) {
		// clear previous list
		teamsPlayerTableView.getItems().clear();
		
		// set title
		this.title.setText(targetTeam.getName());
		
		// get team list to set as observable list for tableview
		ObservableList<Player> teamList = FXCollections.observableArrayList(targetTeam.getPlayers());
		
		// set columns
//		TableColumn<Team,String> position = new TableColumn<Team,String>("Pos"); couldn't set the Cell Value Factory for this 
		TableColumn<Player,String> playerName = new TableColumn<Player,String>("Player");
		TableColumn<Player,Integer> weekPoints = new TableColumn<Player,Integer>("Weekly points");
		TableColumn<Player,Integer> seasonAverage = new TableColumn<Player,Integer>("Season Total");
		
		teamsPlayerTableView.getColumns().addAll(playerName, weekPoints, seasonAverage);
		
		// set value factories
		playerName.setCellValueFactory(new PropertyValueFactory<Player,String>("name"));
		weekPoints.setCellValueFactory(new PropertyValueFactory<Player,Integer>("totalscore"));
		seasonAverage.setCellValueFactory(new PropertyValueFactory<Player,Integer>("roundScore"));
		
		
		// sort table by position column
		teamsPlayerTableView.getSortOrder().add(seasonAverage);
		
		// set the items of the table view to the observable list
		teamsPlayerTableView.setItems(teamList);
		
		// set on click event for the table view
		teamsPlayerTableView.setOnMouseClicked(event -> {

		System.out.println(this.teamsPlayerTableView.getSelectionModel().getSelectedCells()); // test
		
		// get where the table is currently selected (table position)
		ObservableList<TablePosition> tablePosition = this.teamsPlayerTableView.getSelectionModel().getSelectedCells();
		
		System.out.println(tablePosition.get(0).getRow()); // test
		
		// get the team associated with where the table is currently selected
		//Team targetTeam = teamList.get(tablePosition.get(0).getRow());
		
		System.out.println(targetTeam.getName()); // test
		
		// tell the UI to display the teamScene for the team associated with where the table is currently selected
//			UI.showTeamScene(targetTeam);
		});
		
	}
}
