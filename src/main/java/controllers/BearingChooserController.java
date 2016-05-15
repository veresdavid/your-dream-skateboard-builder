package controllers;

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
	
	@FXML
	TableView<Bearing> table;
	
	@FXML
	TableColumn<Bearing, String> brand;
	
	@FXML
	TableColumn<Bearing, String> name;
	
	@FXML
	TableColumn<Bearing, String> category;
	
	@FXML
	TableColumn<Bearing, Integer> price;
	
	@FXML
	TableColumn<Bearing, String> image;
	
	@FXML
	public void initialize(){
		
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
		
		// TODO: a duplakattintás eseménye
		table.setOnMousePressed(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				
				if(event.isPrimaryButtonDown() && event.getClickCount()==2){
					
					// a kiválasztott csapágy
					Bearing bearing = table.getSelectionModel().getSelectedItem();
					
					// TODO: kiírjuk melyik deszkát választottuk ki
					System.out.println(bearing);
					
					// TODO: hozzáadjuk a "kosárhoz" a választott lapot
					// SkateboardEditorController.setBearing(table.getSelectionModel().getSelectedItem());
					sec.setBearing(bearing);
					sec.setBearingLabel(bearing.readableToString());
					
					// TODO: ablak bezárása
					Stage stage = (Stage) table.getScene().getWindow();
					stage.close();
					
				}
				
			}
		});
		
		// adatok lekérése
		ObservableList<Bearing> list = FXCollections.observableArrayList(new BearingDAOXMLImpl().getAllBearings());
		
		// táblázat tartalmának beállítása
		table.setItems(list);
		
	}
	
	public void setSEC(SkateboardEditorController sec){
		this.sec = sec;
	}

}
