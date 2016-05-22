// CHECKSTYLE:OFF

package controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.impl.TruckDAOXMLImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import models.Truck;

public class TruckChooserController {
	
	private SkateboardEditorController sec;
	
	private static Logger logger = LoggerFactory.getLogger(TruckChooserController.class);
	
	@FXML
	private TableView<Truck> table;
	
	@FXML
	private TableColumn<Truck, String> brand;
	
	@FXML
	private TableColumn<Truck, String> name;
	
	@FXML
	private TableColumn<Truck, Integer> model;
	
	@FXML
	private TableColumn<Truck, Integer> price;
	
	@FXML
	private TableColumn<Truck, String> image;
	
	@FXML
	private void initialize(){
		
		// a táblázatunk oszlopainak beállítása
		brand.setCellValueFactory(new PropertyValueFactory<Truck, String>("brand"));
		name.setCellValueFactory(new PropertyValueFactory<Truck, String>("name"));
		model.setCellValueFactory(new PropertyValueFactory<Truck, Integer>("model"));
		price.setCellValueFactory(new PropertyValueFactory<Truck, Integer>("price"));
		
		image.setCellValueFactory(new PropertyValueFactory<Truck, String>("image"));
		image.setCellFactory(new Callback<TableColumn<Truck,String>, TableCell<Truck,String>>() {
			
			public TableCell<Truck, String> call(TableColumn<Truck, String> param) {
				
				TableCell<Truck, String> cell = new TableCell<Truck, String>(){

					@Override
					protected void updateItem(String arg0, boolean arg1) {
						
						if(arg0!=null){
							
							// a táblázatban megjelenő kép
							ImageView img = new ImageView(new Image(getClass().getResourceAsStream("/images/trucks/" + arg0)));
							img.setFitWidth(180);
							img.setPreserveRatio(true);
							
							// tooltipként megjelenő, nagyobb kép
							Tooltip ttp = new Tooltip();
							ImageView ttpimg = new ImageView(new Image(getClass().getResourceAsStream("/images/trucks/" + arg0)));
							ttpimg.setFitWidth(360);
							ttpimg.setPreserveRatio(true);
							ttp.setGraphic(ttpimg);
							Tooltip.install(this, ttp);
							
							setGraphic(img);
							
						}
						
					}
					
				};
				
				return cell;
			}
			
		});
		
		// a duplakattintás eseménye
		table.setOnMousePressed(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent event) {
				
				if(event.isPrimaryButtonDown() && event.getClickCount()==2){
					
					// a kiválasztott felfüggesztés
					Truck truck = table.getSelectionModel().getSelectedItem();
					
					// kiírjuk
					logger.info("Új felfüggesztés kiválasztva: {}", truck);
					
					// hozzáadjuk a "kosárhoz"
					sec.setTruck(truck);
					
					sec.updateScene();
					
					// ablak bezárása
					closeStage();
					
				}
				
			}
		});
		
		// adatok lekérése
		ObservableList<Truck> list = FXCollections.observableArrayList(new TruckDAOXMLImpl().getAllTrucks());
		
		// táblázat tartalmának beállítása
		table.setItems(list);
		
		logger.info("Felfüggesztésválasztó ablak megnyitva!");
		
	}
	
	public void setSEC(SkateboardEditorController sec){
		this.sec = sec;
	}
	
	private void closeStage(){
		
		Stage stage = (Stage) table.getScene().getWindow();
		stage.close();
		
	}

}
