package controllers;

import businesslogic.PriceCalculator;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.Bearing;
import models.Deck;
import models.Griptape;
import models.Skateboard;
import models.Truck;
import models.Wheel;

public class SkateboardController {
	
	private PriceCalculator priceCalculator;
	private Skateboard skateboard;
	
	@FXML
	private Label name;
	@FXML
	private Label deckText;
	@FXML
	private Label griptapeText;
	@FXML
	private Label truckText;
	@FXML
	private Label bearingText;
	@FXML
	private Label wheelText;
	@FXML
	private ImageView deckImage;
	@FXML
	private ImageView griptapeImage;
	@FXML
	private ImageView truckImage;
	@FXML
	private ImageView bearingImage;
	@FXML
	private ImageView wheelImage;
	@FXML
	private Label price;
	
	@FXML
	private void initialize(){
		
		priceCalculator = new PriceCalculator();
		
		skateboard = new Skateboard();
		
	}
	
	public void setSkateboard(Skateboard skateboard){
		this.skateboard = skateboard;
	}
	
	public void showSkateboard(){
		System.out.println("muti");
		
		showName();
		showDeck();
		showGriptape();
		showTruck();
		showBearing();
		showWheel();
		showPrice();
		
	}
	
	private void showName(){
		
		String skateboardName = skateboard.getName();
		
		if(skateboardName==null){
			name.setText("");
		}else{
			name.setText(skateboard.getName());
		}
		
	}
	
	private void showDeck(){
		
		Deck deck = skateboard.getDeck();
		
		if(deck!=null){
			
			deckText.setText(deck.readableToString());
			
			Image image = new Image(getClass().getResourceAsStream("/images/decks/" + deck.getImage()));
			
			deckImage.setImage(image);
			deckImage.setFitHeight(65);
			deckImage.setPreserveRatio(true);
			
		}
		
	}
	
	private void showGriptape(){
		
		Griptape griptape = skateboard.getGriptape();
		
		if(griptape!=null){
			
			griptapeText.setText(griptape.readableToString());
			
			Image image = new Image(getClass().getResourceAsStream("/images/griptapes/" + griptape.getImage()));
			
			griptapeImage.setImage(image);
			griptapeImage.setFitHeight(65);
			griptapeImage.setPreserveRatio(true);
			
		}
		
	}
	
	private void showTruck(){
		
		Truck truck = skateboard.getTruck();
		
		if(truck!=null){
			
			truckText.setText(truck.readableToString());
			
			Image image = new Image(getClass().getResourceAsStream("/images/trucks/" + truck.getImage()));
			
			truckImage.setImage(image);
			truckImage.setFitHeight(65);
			truckImage.setPreserveRatio(true);
			
		}
		
	}
	
	private void showBearing(){
		
		Bearing bearing = skateboard.getBearing();
		
		if(bearing!=null){
			
			bearingText.setText(bearing.readableToString());
			
			Image image = new Image(getClass().getResourceAsStream("/images/bearings/" + bearing.getImage()));
			
			bearingImage.setImage(image);
			bearingImage.setFitHeight(65);
			bearingImage.setPreserveRatio(true);
			
		}
		
	}
	
	private void showWheel(){
		
		Wheel wheel = skateboard.getWheel();
		
		if(wheel!=null){
			
			wheelText.setText(wheel.readableToString());
			
			Image image = new Image(getClass().getResourceAsStream("/images/wheels/" + wheel.getImage()));
			
			wheelImage.setImage(image);
			wheelImage.setFitHeight(65);
			wheelImage.setPreserveRatio(true);
			
		}
		
	}
	
	private void showPrice(){
		
		int skateboardPrice = priceCalculator.calculateSkateboardPrice(skateboard);
		
		price.setText("Ár: " + skateboardPrice + "Ft");
		
	}

}
