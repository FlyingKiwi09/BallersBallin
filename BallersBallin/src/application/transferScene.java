package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
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
		root.getStyleClass().add("root-center");

		HBox navBar = new HBox();
		// set up back button
		Image backImage = new Image("backImage.png", 20, 20, false, false, false);
		ImageView backImageView = new ImageView(backImage);
		Button backButton = new Button();
		
		backButton.setGraphic(backImageView);

		backButton.setOnMouseClicked(event -> {
			UI.goBack();
		});
		
		Button TransferButton = new Button();
		
		
		navBar.getChildren().addAll(backButton, TransferButton);

		title = new Text("");
		title.getStyleClass().add("title");
		// create tableview
		playersTransferTableView = new TableView<Player>();
		
		// set columns
//		TableColumn<Team,String> position = new TableColumn<Team,String>("Pos"); couldn't set the Cell Value Factory for this 
		TableColumn<Player,String> playerName = new TableColumn<Player,String>("Player");
		TableColumn<Player,String> teamName = new TableColumn<Player,String>("Team");
		TableColumn<Player,Integer> price = new TableColumn<Player,Integer>("Price");
		
		playersTransferTableView.getColumns().addAll(playerName, teamName, price);
		
		// set value factories
		playerName.setCellValueFactory(new PropertyValueFactory<Player,String>("name"));
		teamName.setCellValueFactory(new PropertyValueFactory<Player,String>("NBLTeamName"));
		price.setCellValueFactory(new PropertyValueFactory<Player,Integer>("price"));
		
		
		// sort table by position column
		playersTransferTableView.getSortOrder().add(price);

		// set nodes to root
		root.getChildren().addAll(navBar, title, playersTransferTableView);
		root.setMargin(playersTransferTableView, new Insets(10));
	}
	
	
	public void updatePlayerList(Player leavingPlayer, ArrayList<Player> possibleTransfers) {
		// clear previous list
		playersTransferTableView.getItems().clear();
		
		// set title
		this.title.setText(leavingPlayer.getName());
		
		// get team list to set as observable list for tableview
		ObservableList<Player> playerList = FXCollections.observableArrayList(possibleTransfers);
		
		
		
		// set the items of the table view to the observable list
		playersTransferTableView.setItems(playerList);
		
		// create to temp players one for the one being transfered and the replacement.
		  
		 
		// set on click event for the table view
		playersTransferTableView.setOnMouseClicked(event -> {
			
			

		System.out.println(this.playersTransferTableView.getSelectionModel().getSelectedCells()); // test
		
		// get where the table is currently selected (table position)
		ObservableList<TablePosition> tablePosition = this.playersTransferTableView.getSelectionModel().getSelectedCells();
		
		System.out.println(tablePosition.get(0).getRow()); // test
		
		// get the team associated with where the table is currently selected
		Player transferPlayer = playerList.get(tablePosition.get(0).getRow());
		
//		if (leavingPlayer.position == clicked.targetTeam.position)  {
//			  playersTransferTableView.setItems(playerList); }
		
		System.out.println(leavingPlayer.getName()); // test
		
		// clear the selection of item in the tableview
		playersTransferTableView.getSelectionModel().clearSelection();
		UI.updateTeamScene(leavingPlayer, transferPlayer);
		
		});
		
	}


	public Scene getTransferScene() {
		return transferScene;
	}


	public void setTransferScene(Scene transferScene) {
		this.transferScene = transferScene;
	}
	
	
}
