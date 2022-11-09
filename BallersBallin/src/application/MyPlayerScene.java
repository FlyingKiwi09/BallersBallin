package application;

import java.awt.Font;

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
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
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
	
	/**
	 * build up the original player scene,including name,team and detail
	 * @param width 
	 * @param height
	 */
	
	private void setUpPlayerScene(int width, int height) {
		VBox root = new VBox();
		playerScene = new Scene(root,width, height);
		playerScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		VBox statBox = new VBox();
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
		statBox.getChildren().addAll(priceText,pointsText,scoreText);
		backButton.setOnMouseClicked(event -> {

			UI.goBack();
		});
		
		
		nameText = new Text();
		teamText = new Text();
		// set nodes to root
		root.getChildren().addAll(backButton,title, nameText,teamText,statBox, viewdetailButton, transferButton);
	}
	
	/**
	 * get the new name, team, detail updated and show it on the scene 
	 * @param player
	 */
	public void updatePlayerScene(Player player) {
	    nameText.setText("Name : "+player.getName());
		teamText.setText("Teamname : "+player.getNBLTeamName());
		priceText.setText("Price : "+String.valueOf(player.getPrice()));
		pointsText.setText("Points : "+String.valueOf(player.getHistoricalPoints()));
		scoreText.setText("Score : "+String.valueOf(player.getHistoricalPlayerScore()));
		title.setText("Player");
		title.setFont(javafx.scene.text.Font.font("Verdana", FontWeight.NORMAL, 15));
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
