package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SaveGameController {
	
	public void exitButton (ActionEvent event) throws IOException
	{
		AnchorPane Main = (AnchorPane)FXMLLoader.load(getClass().getResource("MainPage.fxml"));
		Scene MainMenu = new Scene (Main);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(MainMenu);
		
		window.show();
	}
}
