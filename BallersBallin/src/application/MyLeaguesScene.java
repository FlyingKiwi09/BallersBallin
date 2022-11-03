package application;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MyLeaguesScene {

	private Scene myLeaguesScene;
	private TableView<League> myLeaguesTableView;
	private Main UI;
	
	public MyLeaguesScene(Main UI) {
		this.UI = UI;
		setUpMyLeaguesScene();
	}
	
	private void setUpMyLeaguesScene() {
		VBox root = new VBox();
		myLeaguesScene = new Scene(root,200,400);
		myLeaguesScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		HBox navBar = new HBox();
		Text title = new Text("My Leagues");
		
		// create tableview
		myLeaguesTableView = new TableView<League>();
		
		
		// set nodes to root
		root.getChildren().addAll(navBar, title, myLeaguesTableView);
	}
	
	
	public void updateLeaguesList(ArrayList<League> list) {
		// clear previous list
		myLeaguesTableView.getItems().clear();
		
		ObservableList<League> leagueList = FXCollections.observableArrayList(list);
		
		
		TableColumn<League,String> leagueName = new TableColumn<League,String>("League Name");
		TableColumn<League,String> view = new TableColumn<League,String>("League Ranking");
		
		myLeaguesTableView.getColumns().addAll(leagueName, view);
		
		leagueName.setCellValueFactory(new PropertyValueFactory<League,String>("name"));
		
		// set the items of the table view to the observable list
		myLeaguesTableView.setItems(leagueList);
		
		// set on click event for the table view
		myLeaguesTableView.setOnMouseClicked(event -> {

			//System.out.println(this.myLeaguesTableView.getSelectionModel().getSelectedCells());
			
			ObservableList<TablePosition> tablePosition = this.myLeaguesTableView.getSelectionModel().getSelectedCells();
			
			//System.out.println(tablePosition.get(0).getRow());
			
			League targetLeague = leagueList.get(tablePosition.get(0).getRow());
			
			//System.out.println(targetLeague.name);
			
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

