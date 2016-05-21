package controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.impl.BearingDAOXMLImpl;
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
import models.Bearing;

public class BearingChooserController {
	
	private SkateboardEditorController sec;
	
	private static Logger logger = LoggerFactory.getLogger(BearingChooserController.class);
	
	@FXML
	private TableView<Bearing> table;
	
	@FXML
	private TableColumn<Bearing, String> brand;
	
	@FXML
	private TableColumn<Bearing, String> name;
	
	@FXML
	private TableColumn<Bearing, String> category;
	
	@FXML
	private TableColumn<Bearing, Integer> price;
	
	@FXML
	private TableColumn<Bearing, String> image;
	
	@FXML
	private void initialize(){
		
		// a táblázatunk oszlopainak beállítása
		brand.setCellValueFactory(new PropertyValueFactory<Bearing, String>("brand"));
		name.setCellValueFactory(new PropertyValueFactory<Bearing, String>("name"));
		category.setCellValueFactory(new PropertyValueFactory<Bearing, String>("category"));
		price.setCellValueFactory(new PropertyValueFactory<Bearing, Integer>("price"));
		
		image.setCellValueFactory(new PropertyValueFactory<Bearing, String>("image"));
		image.setCellFactory(new Callback<TableColumn<Bearing,String>, TableCell<Bearing,String>>() {
			
			public TableCell<Bearing, String> call(TableColumn<Bearing, String> param) {
				
				TableCell<Bearing, String> cell = new TableCell<Bearing, String>(){

					@Override
					protected void updateItem(String arg0, boolean arg1) {
						
						if(arg0!=null){
							
							// a táblázatban megjelenő kép
							ImageView img = new ImageView(new Image(getClass().getResourceAsStream("/images/bearings/" + arg0)));
							img.setFitWidth(180);
							img.setPreserveRatio(true);
							
							// tooltipként megjelenő, nagyobb kép
							Tooltip ttp = new Tooltip();
							ImageView ttpimg = new ImageView(new Image(getClass().getResourceAsStream("/images/bearings/" + arg0)));
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
					
					// a kiválasztott csapágy
					Bearing bearing = table.getSelectionModel().getSelectedItem();
					
					// kiírjuk
					logger.info("Új csapágy kiválasztva: {}", bearing);
					
					// hozzáadjuk a "kosárhoz"
					sec.setBearing(bearing);
					
					sec.updateScene();
					
					// ablak bezárása
					closeStage();
					
				}
				
			}
		});
		
		// adatok lekérése
		ObservableList<Bearing> list = FXCollections.observableArrayList(new BearingDAOXMLImpl().getAllBearings());
		
		// táblázat tartalmának beállítása
		table.setItems(list);
		
		logger.info("Csapágyválasztó ablak megnyitva!");
		
	}
	
	public void setSEC(SkateboardEditorController sec){
		this.sec = sec;
	}
	
	private void closeStage(){
		
		Stage stage = (Stage) table.getScene().getWindow();
		stage.close();
		
	}

}
