import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SkateboardBuildingSceneController {
	
	@FXML
	public Label deckLabel;
	
	@FXML
	public void showDecks(){
		
		System.out.println("YO");
		
		Stage stage = new Stage();
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("fxml/DeckChooser.fxml"));
			
			Scene scene = new Scene(root, 640, 480);
			
			stage.setScene(scene);
			stage.setTitle("kaki");
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.showAndWait();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
