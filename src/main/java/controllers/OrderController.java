// CHECKSTYLE:OFF

package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import businesslogic.OrderValidator;
import dao.impl.OrderDAOXMLImpl;
import dao.impl.SkateboardDAOXMLImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Order;
import models.Skateboard;

public class OrderController {
	
	private static final String SKATEBOARDFXML = "/fxml/Skateboard.fxml";
	
	private Order order;
	
	private OrderValidator orderValidator;
	
	private static Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@FXML
	private ComboBox<Skateboard> skateboardsComboBox;
	@FXML
	private TextField name;
	@FXML
	private TextField address;
	@FXML
	private TextField phone;
	@FXML
	private TextField email;
	@FXML
	private TextArea comment;
	
	@FXML
	private void showSkateboard(){
		
		Skateboard skateboard = skateboardsComboBox.getSelectionModel().getSelectedItem();
		
		if(skateboard!=null){
			
			logger.info("Gördeszka megtekintése: {}", skateboard);
			
			try {
				
				logger.info("Gördeszka megtekintő ablak megnyitása...");
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource(SKATEBOARDFXML));
				Parent root = (Parent) loader.load();
				
				SkateboardController controller = loader.getController();
				controller.setSkateboard(skateboard);
				controller.showSkateboard();
				
				Stage stage = new Stage();
				
				Scene scene = new Scene(root, 640, 480);
				
				stage.setScene(scene);
				stage.setTitle("Gördeszka");
				stage.setResizable(false);
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.showAndWait();
				
			} catch (IOException e) {
				logger.error("Kivétel: ", e);
			}
			
		}
		
	}
	
	@FXML
	private void order(){
		
		collectData();
		
		if(orderValidator.isValidOrder(order)){
			
			OrderDAOXMLImpl odxi = new OrderDAOXMLImpl();
			
			odxi.saveOrder(order);
			
			orderSuccess();
			
			logger.info("A rendelést sikeresen leadtuk!");
			
			closeStage();
			
		}else{
			
			orderFail();
			
			logger.warn("Nem sikerült leadni a rendelést!");
			
		}
		
	}
	
	@FXML
	private void initialize(){
		
		order = new Order();
		
		orderValidator = new OrderValidator();
		
		List<Skateboard> skateboards;
		SkateboardDAOXMLImpl sdxi = new SkateboardDAOXMLImpl();
		skateboards = sdxi.getAllSkateboards();
		
		if(skateboards==null){
			skateboards = new ArrayList<>();
		}
		
		ObservableList<Skateboard> list = FXCollections.observableArrayList(skateboards);
		
		skateboardsComboBox.setItems(list);
		
		logger.info("Rendelés készítő ablak megnyitva!");
		
	}
	
	private void collectData(){
		
		order.setSkateboard(skateboardsComboBox.getSelectionModel().getSelectedItem());
		order.setCustomerName(name.getText());
		order.setCustomerAddress(address.getText());
		order.setCustomerPhone(phone.getText());
		order.setCustomerEmail(email.getText());
		order.setCustomerComment(comment.getText());
		
	}
	
	private void closeStage(){
		
		Stage stage = (Stage) skateboardsComboBox.getScene().getWindow();
		stage.close();
		
	}
	
	private void orderSuccess(){
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Elküldve");
		alert.setHeaderText(null);
		alert.setContentText("A rendelést elküldtük!");
		
		alert.showAndWait();
		
	}
	
	private void orderFail(){
		
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Hiba");
		alert.setHeaderText("Nem tudtuk elküldeni a rendelést!");
		alert.setContentText("Ellenőrizd, hogy minden mezőt kitöltöttél!");
		
		alert.showAndWait();
		
	}

}
