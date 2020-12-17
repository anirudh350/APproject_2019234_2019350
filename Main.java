package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private MediaPlayer mediaPlayer;
	@Override
	public void start(Stage primaryStage) {
		try {
			
			addMusic();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("MainPage.fxml"));
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("COLOR SWITCH"); 
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void addMusic() {
		
        Media sound = new Media(getClass().getResource("assets/Color Switch - Game Theme Music.mp3").toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(50));
        mediaPlayer.play();
    }
	public static void main(String[] args) {
		launch(args);
	}
}
