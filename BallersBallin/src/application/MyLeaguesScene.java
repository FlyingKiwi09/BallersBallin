package application;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MyLeaguesScene {

	private Scene myLeaguesScene;
	private TableView<League> myLeaguesTableView;
	private Main UI;
	
	public MyLeaguesScene(Main UI, int width, int height) {
		this.UI = UI;
		setUpMyLeaguesScene(width, height);
	}
	
	private void setUpMyLeaguesScene(int width, int height) {
		VBox root = new VBox();
		myLeaguesScene = new Scene(root,width, height);
		myLeaguesScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		root.getStyleClass().add("root-center");
		
		//set up nav bar
		HBox navBar = new HBox();
		Image backImage = new Image("backImage.png", 20, 20, false, false, false);
		ImageView backImageView = new ImageView(backImage);
		Button backButton = new Button();
		backButton.setGraphic(backImageView);
		
		Text title = new Text("My Leagues");
		title.getStyleClass().add("title");
		
		navBar.getChildren().add(backButton);
		
		// create tableview
		myLeaguesTableView = new TableView<League>();
		
		// set up columns in tableView
		TableColumn<League,String> leagueName = new TableColumn<League,String>("League Name");
//		TableColumn<League,String> view = new TableColumn<League,String>("League Ranking");
		
		myLeaguesTableView.getColumns().addAll(leagueName);
		
		leagueName.setCellValueFactory(new PropertyValueFactory<League,String>("leagueName"));
		
		myLeaguesTableView.setMaxWidth(200);
		leagueName.setMinWidth(200);
		
		// set nodes to root
		root.getChildren().addAll(navBar, title, myLeaguesTableView);
		root.setMargin(myLeaguesTableView, new Insets(10));
		
		// back method
		backButton.setOnMouseClicked(event -> {	
			UI.goBack();
		});
	}
	
	
	public void updateLeaguesList(ArrayList<League> list) {
		// clear previous list
		myLeaguesTableView.getItems().clear();
		
		ObservableList<League> leagueList = FXCollections.observableArrayList(list);
		
		


//		for (League league : list) {
//			myLeaguesTableView.getItems().add(league);
//		}

		// set the items of the table view to the observable list
		myLeaguesTableView.setItems(leagueList);

		
		// set on click event for the table view
		myLeaguesTableView.setOnMouseClicked(event -> {

			//System.out.println(this.myLeaguesTableView.getSelectionModel().getSelectedCells());
			
			ObservableList<TablePosition> tablePosition = this.myLeaguesTableView.getSelectionModel().getSelectedCells();
			
			//System.out.println(tablePosition.get(0).getRow());
			
			League targetLeague = leagueList.get(tablePosition.get(0).getRow());
			
			// save this scene to the history in the UI before switching to the next scene
			UI.getHistoryForGoingBack().push(this.myLeaguesScene);
			
			// clear the selection of item in the tableview
			myLeaguesTableView.getSelectionModel().clearSelection();
			
			UI.showLeagueScene(targetLeague);
		});
	}
	
	
	
	

	public Scene getMyLeaguesScene() {
		return myLeaguesScene;
	}

	public void setMyLeaguesScene(Scene myLeaguesScene) {
		this.myLeaguesScene = myLeaguesScene;
	}
	
	
	
}

