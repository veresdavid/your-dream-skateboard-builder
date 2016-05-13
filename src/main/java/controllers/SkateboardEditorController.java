package controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Bearing;
import models.Deck;
import models.Griptape;
import models.Skateboard;
import models.Truck;
import models.Wheel;

public class SkateboardEditorController {
	
	private static Skateboard skateboard;
	
	@FXML
	private void initialize(){
		System.out.println("csá");
		
		skateboard = new Skateboard();
		
	}
	
	@FXML
	private void chooseDeck(){
		
		try {
			
			Stage stage = new Stage();
			
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/DeckChooser.fxml"));
			
			Scene scene = new Scene(root, 640, 480);
			
			stage.setScene(scene);
			stage.initModality(Modality.WINDOW_MODAL);
			stage.showAndWait();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private void validate(){
		
		System.out.println(skateboard);
		
	}
	
	public static void setBearing(Bearing bearing){
		skateboard.setBearing(bearing);
	}
	
	public static void setDeck(Deck deck){
		skateboard.setDeck(deck);
	}
	
	public static void setGriptape(Griptape griptape){
		skateboard.setGriptape(griptape);
	}
	
	public static void setTruck(Truck truck){
		skateboard.setTruck(truck);
	}
	
	public static void setWheel(Wheel wheel){
		skateboard.setWheel(wheel);
	}

}
