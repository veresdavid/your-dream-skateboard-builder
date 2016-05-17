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
	
	private static final String SKATEBOARDEDITOR = "/fxml/SkateboardEditor.fxml";
	private static final String ORDER = "/fxml/Order.fxml";
	private static final String HELP = "/fxml/Help.fxml";
	
	@FXML
	private void newSkateboard(){
		System.out.println("új deszka");
		loadMenuPoint(SKATEBOARDEDITOR, "Gördeszka szerkesztő");
	}
	
	@FXML
	private void order(){
		System.out.println("LEADTÁK A RENDELÉST");
		loadMenuPoint(ORDER, "Rendelés");
	}
	
	@FXML
	private void help(){
		System.out.println("SEGÍTSETEK!");
		loadMenuPoint(HELP, "Súgó");
	}
	
	@FXML
	private void exit(){
		System.out.println("kilépés");
		Main.closeStage();
	}
	
	private void loadMenuPoint(String fxml, String title){
		
		try {
			
			Stage stage = new Stage();
			
			Parent root = FXMLLoader.load(getClass().getResource(fxml));
			
			Scene scene = new Scene(root, 640, 480);
			
			stage.setScene(scene);
			stage.setTitle(title);
			stage.setResizable(false);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.showAndWait();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
