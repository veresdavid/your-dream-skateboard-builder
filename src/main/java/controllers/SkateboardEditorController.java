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
	
	private static final String DECKCHOOSER = "/fxml/DeckChooser.fxml";
	private static final String BEARINGCHOOSER = "/fxml/BearingChooser.fxml";
	private static final String TRUCKCHOOSER = "/fxml/TruckChooser.fxml";
	private static final String WHEELCHOOSER = "/fxml/WheelChooser.fxml";
	private static final String GRIPTAPECHOOSER = "/fxml/GriptapeChooser.fxml";
	
	private static Skateboard skateboard;
	
	@FXML
	private void initialize(){
		System.out.println("SkateboardEditorController initialize");
		
		// üres gördeszka létrehozása
		skateboard = new Skateboard();
		
	}
	
	@FXML
	private void chooseDeck(){
		loadAccessoryChooser(DECKCHOOSER, "Lapok");
	}
	
	@FXML
	private void chooseBearing(){
		loadAccessoryChooser(BEARINGCHOOSER, "Csapágyak");
	}
	
	@FXML
	private void chooseTruck(){
		loadAccessoryChooser(TRUCKCHOOSER, "Felfüggesztések");
	}
	
	@FXML
	private void chooseWheel(){
		loadAccessoryChooser(WHEELCHOOSER, "Kerekek");
	}
	
	@FXML
	private void chooseGriptape(){
		loadAccessoryChooser(GRIPTAPECHOOSER, "Smirglik");
	}
	
	@FXML
	private void validate(){
		
		// TODO: gördezska ellenőrző függvény lesz
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
	
	private void loadAccessoryChooser(String fxml, String title){
		
		try {
			
			Stage stage = new Stage();
			
			Parent root = FXMLLoader.load(getClass().getResource(fxml));
			
			Scene scene = new Scene(root, 640, 480);
			
			stage.setScene(scene);
			stage.setTitle(title);
			stage.setResizable(false);
			stage.initModality(Modality.WINDOW_MODAL);
			stage.showAndWait();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
