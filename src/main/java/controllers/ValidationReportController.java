// CHECKSTYLE:OFF

package controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import businesslogic.SkateboardValidator;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.Skateboard;

public class ValidationReportController {
	
	private SkateboardValidator skateboardValidator;
	private Skateboard skateboard;
	
	private Image yes;
	private Image no;
	
	private static Logger logger = LoggerFactory.getLogger(ValidationReportController.class);
	
	@FXML
	private ImageView validName;
	@FXML
	private ImageView validAccessories;
	@FXML
	private ImageView validDeckAndGriptape;
	@FXML
	private ImageView validDeckAndTruck;
	
	@FXML
	private void initialize(){
		
		skateboardValidator = new SkateboardValidator();
		skateboard = new Skateboard();
		
		loadImages();
		
		logger.info("Érvényességi jelentés ablaka megnyitva!");
		
	}
	
	@FXML
	private void closeStage(){
		
		Stage stage = (Stage) validName.getScene().getWindow();
		stage.close();
		
	}
	
	public void setSkateboard(Skateboard skateboard){
		this.skateboard = skateboard;
	}
	
	private void loadImages(){
		
		yes = new Image(getClass().getResourceAsStream("/images/icons/yes.png"));
		no = new Image(getClass().getResourceAsStream("/images/icons/no.png"));
		
	}
	
	public void validationReport(){
		
		if(skateboardValidator.isCorrectName(skateboard.getName())){
			validName.setImage(yes);
		}else{
			validName.setImage(no);
		}
		
		if(skateboardValidator.isEveryAccessorySet(skateboard)){
			validAccessories.setImage(yes);
		}else{
			validAccessories.setImage(no);
		}
		
		if(skateboardValidator.isDeckFitsWithGriptape(skateboard.getDeck(), skateboard.getGriptape())){
			validDeckAndGriptape.setImage(yes);
		}else{
			validDeckAndGriptape.setImage(no);
		}
		
		if(skateboardValidator.isDeckFitsWithTruck(skateboard.getDeck(), skateboard.getTruck())){
			validDeckAndTruck.setImage(yes);
		}else{
			validDeckAndTruck.setImage(no);
		}
		
		logger.info("Érvényességi jelentés elkészült!");
		
	}

}
