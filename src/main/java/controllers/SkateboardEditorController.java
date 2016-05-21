package controllers;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import businesslogic.PriceCalculator;
import businesslogic.SkateboardValidator;
import dao.impl.SkateboardDAOXMLImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
	private static final String VALIDATIONREPORT = "/fxml/ValidationReport.fxml";
	
	private static Logger logger = LoggerFactory.getLogger(SkateboardEditorController.class);
	
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
		
		skateboard = new Skateboard();
		
		priceCalculator = new PriceCalculator();
		skateboardValidator = new SkateboardValidator();
		
		logger.info("Gördeszka szerkesztő ablak megnyitva!");
		
	}
	
	@FXML
	private void chooseDeck(){
		
		logger.info("Lap választó ablak megnyitása...");
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource(DECKCHOOSER));
			Parent root = (Parent) loader.load();
			
			DeckChooserController controller = loader.getController();
			controller.setSEC(this);
			
			loadAccessoryChooser(root, "Lapok");
			
		} catch (IOException e) {
			logger.error("Kivétel: ", e);
		}
		
	}
	
	@FXML
	private void chooseBearing(){
		
		logger.info("Csapágy választó ablak megnyitása...");
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource(BEARINGCHOOSER));
			Parent root = (Parent) loader.load();
			
			BearingChooserController controller = loader.getController();
			controller.setSEC(this);
			
			loadAccessoryChooser(root, "Csapágyak");
			
		} catch (IOException e) {
			logger.error("Kivétel: ", e);
		}
		
	}
	
	@FXML
	private void chooseTruck(){
		
		logger.info("Felfüggesztés választó ablak megnyitása...");
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource(TRUCKCHOOSER));
			Parent root = (Parent) loader.load();
			
			TruckChooserController controller = loader.getController();
			controller.setSEC(this);
			
			loadAccessoryChooser(root, "Felfüggesztések");
			
		} catch (IOException e) {
			logger.error("Kivétel: ", e);
		}
		
	}
	
	@FXML
	private void chooseWheel(){
		
		logger.info("Kerék választó ablak megnyitása...");
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource(WHEELCHOOSER));
			Parent root = (Parent) loader.load();
			
			WheelChooserController controller = loader.getController();
			controller.setSEC(this);
			
			loadAccessoryChooser(root, "Kerekek");
			
		} catch (IOException e) {
			logger.error("Kivétel: ", e);
		}
		
	}
	
	@FXML
	private void chooseGriptape(){
		
		logger.info("Smirgli választó ablak megnyitása...");
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource(GRIPTAPECHOOSER));
			Parent root = (Parent) loader.load();
			
			GriptapeChooserController controller = loader.getController();
			controller.setSEC(this);
			
			loadAccessoryChooser(root, "Smirglik");
			
		} catch (IOException e) {
			logger.error("Kivétel: ", e);
		}
		
	}
	
	@FXML
	private void validate(){
		
		logger.info("Érvényességi jelentés készítése...");
		
		collectData();
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource(VALIDATIONREPORT));
			Parent root = (Parent) loader.load();
			
			ValidationReportController controller = loader.getController();
			controller.setSkateboard(skateboard);
			controller.validationReport();
			
			Stage stage = new Stage();
			
			Scene scene = new Scene(root, 400, 200);
			
			stage.setScene(scene);
			stage.setTitle("Érvényességi jelentés");
			stage.setResizable(false);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.showAndWait();
			
		} catch (IOException e) {
			logger.error("Kivétel: ", e);
		}
		
	}
	
	@FXML
	private void save(){
		
		collectData();
		
		SkateboardDAOXMLImpl sdxi = new SkateboardDAOXMLImpl();
		
		if(skateboardValidator.isValidSkateboard(skateboard)){
			
			sdxi.insert(skateboard);
			
			saveSuccess();
			
			logger.info("A gördeszka mentése sikeres volt!");
			
			closeStage();
			
		}else{
			
			saveFail();
			
			logger.warn("A gördeszkát nem tudtuk menteni, az összeállítás nem érvényes!");
			
		}
		
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
	
	private void collectData(){
		skateboard.setName(name.getText());
	}
	
	private void closeStage(){
		Stage stage = (Stage) name.getScene().getWindow();
		stage.close();
	}
	
	private void saveSuccess(){
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Sikeres mentés");
		alert.setHeaderText(null);
		alert.setContentText("Az összeállított gördeszkát sikeresen elmentettük!");
		
		alert.showAndWait();
		
	}
	
	private void saveFail(){
		
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Hiba");
		alert.setHeaderText("A gördeszka hibásan lett összeállítva!");
		alert.setContentText("Nyomj az Ellenőrzés gombra részletesebb információkért!");
		
		alert.showAndWait();
		
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
