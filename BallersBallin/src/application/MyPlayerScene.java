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

public class MyPlayerScene {
	private Main UI;
	private Scene playerScene;
	private Text title;
	private Player player;

	public MyPlayerScene(Main UI,int width, int height) {
		this.UI = UI;
		setUpPlayerScene(width, height);
	}
	private void setUpPlayerScene(int width, int height) {
		VBox root = new VBox();
		playerScene = new Scene(root,width, height);
		playerScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		HBox navBar = new HBox();
		HBox statBox = new HBox();
		// set up back button
		Image backImage = new Image("backImage.png", 20, 20, false, false, false);
		ImageView backImageView = new ImageView(backImage);
		Button backButton = new Button();
		backButton.setGraphic(backImageView);
		Button transferButton = new Button("transfer");
		Button viewdetailButton = new Button("view detail");
		Text nameText = new Text(player.getName());
		Text teamText = new Text(player.getNBLTeamName());
		Text priceText = new Text(String.valueOf(player.getPrice()));
		Text pointsText = new Text(String.valueOf(player.getHistoricalPoints()));
		Text scoreText = new Text(String.valueOf(player.getHistoricalPlayerScore()));
		title = new Text("Player");
		navBar.getChildren().addAll(backButton,title);
		statBox.getChildren().addAll(priceText,pointsText,scoreText);
		backButton.setOnMouseClicked(event -> {

			UI.goBack();
		});
		
		transferButton.setOnMouseClicked(event -> {

		});
			
		// set nodes to root
		root.getChildren().addAll(navBar, nameText,teamText,statBox);
	}
	

	public Scene getPlayerScene() {
		return playerScene;
	}

	public void setPlayerScene(Scene leagueScene) {
		this.playerScene = leagueScene;
	}

}
