package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameOverController implements Initializable {
	
	public void exitButton (ActionEvent event) throws IOException
	{
		AnchorPane Main = (AnchorPane)FXMLLoader.load(getClass().getResource("MainPage.fxml"));
		Scene MainMenu = new Scene (Main);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(MainMenu);
		
		window.show();
	}
	
	public void playGame (ActionEvent event) throws IOException
	{
		AnchorPane play = (AnchorPane)FXMLLoader.load(getClass().getResource("PlayGame.fxml"));
		Scene playGameScene = new Scene (play,630,1000);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(playGameScene);
		window.show();
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
