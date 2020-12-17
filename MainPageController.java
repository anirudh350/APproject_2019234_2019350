package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.animation.*;

public class MainPageController<NewProjectController> {
	@FXML 
	private AnchorPane mainPane;
	
	public void startGame (ActionEvent event) throws IOException
	{
	
		AnchorPane play = (AnchorPane)FXMLLoader.load(getClass().getResource("PlayGame.fxml"));
		FXMLLoader loader = new FXMLLoader(getClass().getResource("PlayGame.fxml"));
		Scene playGameScene = new Scene (play,630,1000);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(playGameScene);
		window.show();
	
	}
	
	public void resumeGame (ActionEvent event) throws IOException
	{
	
		AnchorPane resume = (AnchorPane)FXMLLoader.load(getClass().getResource("SavedGames.fxml"));
		FXMLLoader loader = new FXMLLoader(getClass().getResource("PlayGame.fxml"));
		Scene resumeGameScene = new Scene (resume);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(resumeGameScene);
		window.show();
	
	}
	
	public void exitButton (ActionEvent event) throws IOException
	{
		System.exit(0);
	}
	
	
}