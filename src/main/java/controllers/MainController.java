package controllers;

import app.Main;
import javafx.fxml.FXML;

public class MainController {
	
	@FXML
	private void newSkateboard(){
		System.out.println("új deszka");
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
