package controllers;

import java.io.IOException;

import app.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController {
	
	@FXML
	private void newSkateboard(){
		System.out.println("új deszka");
		
		try {
			
			Stage newSkateboardStage = new Stage();
			
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/SkateboardEditor.fxml"));
			
			Scene scene = new Scene(root, 640, 480);
			
			newSkateboardStage.setScene(scene);
			newSkateboardStage.setTitle("Gördeszka szerkesztő");
			newSkateboardStage.setResizable(false);
			newSkateboardStage.initModality(Modality.APPLICATION_MODAL);
			newSkateboardStage.showAndWait();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private void showSkateboards(){
		System.out.println("deszkák");
	}
	
	@FXML
	private void order(){
		System.out.println("LEADTÁK A RENDELÉST");
	}
	
	@FXML
	private void exit(){
		System.out.println("kilépés");
		Main.closeStage();
	}

}
