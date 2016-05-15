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
	
	private PriceCalculator priceCalculator;
	private SkateboardValidator skateboardValidator;
	
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
	private Label price;
	
	@FXML
	private void initialize(){
		System.out.println("SkateboardEditorController initialize");
		
		// üres gördeszka létrehozása
		skateboard = new Skateboard();
		
		priceCalculator = new PriceCalculator();
		skateboardValidator = new SkateboardValidator();
		
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
	
	private void updateBearingLabel(){
		if(skateboard.getBearing()!=null){
			bearing.setText(skateboard.getBearing().readableToString());
		}else{
			bearing.setText("-");
		}
	}
	
	private void updateTruckLabel(){
		if(skateboard.getTruck()!=null){
			truck.setText(skateboard.getTruck().readableToString());
		}else{
			truck.setText("-");
		}
	}
	
	private void updateWheelLabel(){
		if(skateboard.getWheel()!=null){
			wheel.setText(skateboard.getWheel().readableToString());
		}else{
			wheel.setText("-");
		}
	}
	
	private void updateDeckLabel(){
		if(skateboard.getDeck()!=null){
			deck.setText(skateboard.getDeck().readableToString());
		}else{
			deck.setText("-");
		}
	}
	
	private void updateGriptapeLabel(){
		if(skateboard.getGriptape()!=null){
			griptape.setText(skateboard.getGriptape().readableToString());
		}else{
			griptape.setText("-");
		}
	}
	
	private void updatePriceLabel(){
		price.setText("Ár: " + priceCalculator.calculateSkateboardPrice(skateboard) + "Ft");
	}
	
	public void updateScene(){
		
		updateBearingLabel();
		updateDeckLabel();
		updateGriptapeLabel();
		updateTruckLabel();
		updateWheelLabel();
		updatePriceLabel();
		
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
