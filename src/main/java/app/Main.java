package app;

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
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
		Main.stage = stage;
		
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
		
		Scene scene = new Scene(root, 320, 240);
		
		stage.setTitle("Your Dream Skateboard Builder");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		
	}
	
	public static void closeStage(){
		stage.close();
	}

}
