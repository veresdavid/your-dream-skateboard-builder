// CHECKSTYLE:OFF

package controllers;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	
	private static Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@FXML
	private void newSkateboard(){
		logger.info("Gördeszka szerkesztő ablak megnyitása...");
		loadMenuPoint(SKATEBOARDEDITOR, "Gördeszka szerkesztő");
	}
	
	@FXML
	private void order(){
		logger.info("Rendelés készítő ablak megnyitása...");
		loadMenuPoint(ORDER, "Rendelés");
	}
	
	@FXML
	private void help(){
		logger.info("Súgó ablak megnyitása...");
		loadMenuPoint(HELP, "Súgó");
	}
	
	@FXML
	private void exit(){
		logger.info("Az alkalmazás bezárása.");
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
			logger.error("Kivétel: ", e);
		}
		
	}

}
