// CHECKSTYLE:OFF

package app;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static Stage stage;
	
	private static Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage){
		
		Main.stage = stage;
		
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
			
			Scene scene = new Scene(root, 320, 240);
			
			stage.setTitle("Főmenü");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
			
		} catch (IOException e) {
			logger.error("Kivétel: ", e);
		}
		
	}
	
	public static void closeStage(){
		stage.close();
	}

}
