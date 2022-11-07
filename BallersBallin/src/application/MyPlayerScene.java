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
	
	private Text nameText;
	private Text teamText;
	private Text priceText;
	private Text pointsText;
	private Text scoreText;  
	private Button transferButton; 

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
		transferButton = new Button("transfer");
		Button viewdetailButton = new Button("view detail");
		title = new Text();
		priceText = new Text();
		pointsText = new Text();
		scoreText = new Text();
		navBar.getChildren().addAll(backButton,title);
		statBox.getChildren().addAll(priceText,pointsText,scoreText);
		backButton.setOnMouseClicked(event -> {

			UI.goBack();
		});
		
		
		nameText = new Text();
		teamText = new Text();
		// set nodes to root
		root.getChildren().addAll(navBar, nameText,teamText,statBox, viewdetailButton, transferButton);
	}
	
	public void updatePlayerScene(Player player) {
	    nameText.setText(player.getName());
		teamText.setText(player.getNBLTeamName());
		priceText.setText(String.valueOf(player.getPrice()));
		pointsText.setText(String.valueOf(player.getHistoricalPoints()));
		scoreText.setText(String.valueOf(player.getHistoricalPlayerScore()));
		title.setText("Player");
		
		transferButton.setOnMouseClicked(event -> {
			UI.showTransferScene(player);
		});
	}
	

	public Scene getPlayerScene() {
		return playerScene;
	}

	public void setPlayerScene(Scene playerScene) {
		this.playerScene = playerScene;
	}

	
}
