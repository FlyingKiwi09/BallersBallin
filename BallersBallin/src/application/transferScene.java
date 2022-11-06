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

public class transferScene {
	private Main UI;
	private Scene transferScene;
	private TableView<Player> playersTransferTableView;
	private Text title;

	public transferScene(Main UI, int width, int height) {
		this.UI = UI;
		setUpTeamScene(width, height);
	}

	private void setUpTeamScene(int width, int height) {
		VBox root = new VBox();
		transferScene = new Scene(root, width, height);
		transferScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

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
		playersTransferTableView = new TableView<Player>();

		// set nodes to root
		root.getChildren().addAll(navBar, title, playersTransferTableView);
	}
	public void updatePlayerList(Player transferPLayer) {
		// clear previous list
		playersTransferTableView.getItems().clear();
		
		// set title
		this.title.setText(transferPLayer.getName());
		
		// get team list to set as observable list for tableview
		ObservableList<Player> teamList = FXCollections.observableArrayList(transferPLayer);
		
		// set columns
//		TableColumn<Team,String> position = new TableColumn<Team,String>("Pos"); couldn't set the Cell Value Factory for this 
		TableColumn<Player,String> playerName = new TableColumn<Player,String>("Player");
		TableColumn<Player,Integer> weekPoints = new TableColumn<Player,Integer>("Week points");
		TableColumn<Player,Integer> seasonAverage = new TableColumn<Player,Integer>("Season Total");
		
		playersTransferTableView.getColumns().addAll(playerName, weekPoints, seasonAverage);
		
		// set value factories
		playerName.setCellValueFactory(new PropertyValueFactory<Player,String>("name"));
		weekPoints.setCellValueFactory(new PropertyValueFactory<Player,Integer>("totalscore"));
		seasonAverage.setCellValueFactory(new PropertyValueFactory<Player,Integer>("roundScore"));
		
		
		// sort table by position column
		playersTransferTableView.getSortOrder().add(seasonAverage);
		
		// set the items of the table view to the observable list
		
		/*
		 * if (transferPLayer.position == clicked.targetTeam.position) {
		 * playersTransferTableView.setItems(teamList); }
		 */
		// set on click event for the table view
		playersTransferTableView.setOnMouseClicked(event -> {

		System.out.println(this.playersTransferTableView.getSelectionModel().getSelectedCells()); // test
		
		// get where the table is currently selected (table position)
		ObservableList<TablePosition> tablePosition = this.playersTransferTableView.getSelectionModel().getSelectedCells();
		
		System.out.println(tablePosition.get(0).getRow()); // test
		
		// get the team associated with where the table is currently selected
		//Team targetTeam = teamList.get(tablePosition.get(0).getRow());
		
		System.out.println(transferPLayer.getName()); // test
		
		// tell the UI to display the teamScene for the team associated with where the table is currently selected
//			UI.showTeamScene(targetTeam);
		});
		
	}
}
