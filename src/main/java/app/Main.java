package app;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static Stage stage;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage){
		// TODO Auto-generated method stub
		
		Main.stage = stage;
		
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
			
			Scene scene = new Scene(root, 320, 240);
			
			stage.setTitle("Főmenü");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void closeStage(){
		stage.close();
	}

}
