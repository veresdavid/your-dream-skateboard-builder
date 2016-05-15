package controllers;

import java.io.IOException;

import businesslogic.PriceCalculator;
import businesslogic.SkateboardValidator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
	
	private Skateboard skateboard;
	
	@FXML
	private TextField name;
	@FXML
	private Label deck;
	@FXML
	private Label griptape;
	@FXML
	private Label truck;
	@FXML
	private Label bearing;
	@FXML
	private Label wheel;
	
	@FXML
	private void initialize(){
		System.out.println("SkateboardEditorController initialize");
		
		// üres gördeszka létrehozása
		skateboard = new Skateboard();
		
	}
	
	@FXML
	private void chooseDeck(){
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource(DECKCHOOSER));
			Parent root = (Parent) loader.load();
			
			DeckChooserController controller = loader.getController();
			controller.setSEC(this);
			
			loadAccessoryChooser(root, "Lapok");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private void chooseBearing(){
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource(BEARINGCHOOSER));
			Parent root = (Parent) loader.load();
			
			BearingChooserController controller = loader.getController();
			controller.setSEC(this);
			
			loadAccessoryChooser(root, "Csapágyak");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private void chooseTruck(){
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource(TRUCKCHOOSER));
			Parent root = (Parent) loader.load();
			
			TruckChooserController controller = loader.getController();
			controller.setSEC(this);
			
			loadAccessoryChooser(root, "Felfüggesztések");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private void chooseWheel(){
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource(WHEELCHOOSER));
			Parent root = (Parent) loader.load();
			
			WheelChooserController controller = loader.getController();
			controller.setSEC(this);
			
			loadAccessoryChooser(root, "Kerekek");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private void chooseGriptape(){
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource(GRIPTAPECHOOSER));
			Parent root = (Parent) loader.load();
			
			GriptapeChooserController controller = loader.getController();
			controller.setSEC(this);
			
			loadAccessoryChooser(root, "Smirglik");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private void validate(){
		
		// TODO: gördezska ellenőrző függvény lesz
		System.out.println("Ellenőrzés");
		
		PriceCalculator pc = new PriceCalculator();
		int p = pc.calculateSkateboardPrice(skateboard);
		System.out.println("Ár: " + p);
		
		SkateboardValidator sv = new SkateboardValidator();
		boolean iv = sv.isValidSkateboard(skateboard);
		System.out.println("Érvényes: " + iv);
		
		System.out.println(skateboard.getName());
		
	}
	
	@FXML
	private void save(){
		System.out.println("Mentés");
	}
	
	public void setBearing(Bearing bearing){
		skateboard.setBearing(bearing);
	}
	
	public void setDeck(Deck deck){
		skateboard.setDeck(deck);
	}
	
	public void setGriptape(Griptape griptape){
		skateboard.setGriptape(griptape);
	}
	
	public void setTruck(Truck truck){
		skateboard.setTruck(truck);
	}
	
	public void setWheel(Wheel wheel){
		skateboard.setWheel(wheel);
	}
	
	public void setBearingLabel(String str){
		bearing.setText(str);
	}
	
	public void setTruckLabel(String str){
		truck.setText(str);
	}
	
	public void setWheelLabel(String str){
		wheel.setText(str);
	}
	
	public void setDeckLabel(String str){
		deck.setText(str);
	}
	
	public void setGriptapeLabel(String str){
		griptape.setText(str);
	}
	
	private void loadAccessoryChooser(Parent root, String title){
		
		Stage stage = new Stage();
		
		Scene scene = new Scene(root, 640, 480);
		
		stage.setScene(scene);
		stage.setTitle(title);
		stage.setResizable(false);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.showAndWait();
		
	}

}
