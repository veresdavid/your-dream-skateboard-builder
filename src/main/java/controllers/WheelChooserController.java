package controllers;

import dao.impl.WheelDAOXMLImpl;
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
import models.Wheel;

public class WheelChooserController {
	
	private SkateboardEditorController sec;
	
	@FXML
	TableView<Wheel> table;
	
	@FXML
	TableColumn<Wheel, String> brand;
	
	@FXML
	TableColumn<Wheel, String> name;
	
	@FXML
	TableColumn<Wheel, Integer> size;
	
	@FXML
	TableColumn<Wheel, Integer> price;
	
	@FXML
	TableColumn<Wheel, String> image;
	
	@FXML
	public void initialize(){
		
		// a táblázatunk oszlopainak beállítása
		brand.setCellValueFactory(new PropertyValueFactory<Wheel, String>("brand"));
		name.setCellValueFactory(new PropertyValueFactory<Wheel, String>("name"));
		size.setCellValueFactory(new PropertyValueFactory<Wheel, Integer>("size"));
		price.setCellValueFactory(new PropertyValueFactory<Wheel, Integer>("price"));
		
		image.setCellValueFactory(new PropertyValueFactory<Wheel, String>("image"));
		image.setCellFactory(new Callback<TableColumn<Wheel,String>, TableCell<Wheel,String>>() {
			
			public TableCell<Wheel, String> call(TableColumn<Wheel, String> param) {
				
				TableCell<Wheel, String> cell = new TableCell<Wheel, String>(){

					@Override
					protected void updateItem(String arg0, boolean arg1) {
						
						if(arg0!=null){
							
							// a táblázatban megjelenő kép
							ImageView img = new ImageView(new Image(getClass().getResourceAsStream("/images/wheels/" + arg0)));
							img.setFitWidth(180);
							img.setPreserveRatio(true);
							
							// tooltipként megjelenő, nagyobb kép
							Tooltip ttp = new Tooltip();
							ImageView ttpimg = new ImageView(new Image(getClass().getResourceAsStream("/images/wheels/" + arg0)));
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
					
					// a kiválasztott kerék
					Wheel wheel = table.getSelectionModel().getSelectedItem();
					
					// TODO: kiírjuk melyik deszkát választottuk ki
					System.out.println(wheel);
					
					// TODO: hozzáadjuk a "kosárhoz" a választott lapot
					// SkateboardEditorController.setWheel(table.getSelectionModel().getSelectedItem());
					sec.setWheel(wheel);
					
					sec.updateScene();
					
					// TODO: ablak bezárása
					Stage stage = (Stage) table.getScene().getWindow();
					stage.close();
					
				}
				
			}
		});
		
		// adatok lekérése
		ObservableList<Wheel> list = FXCollections.observableArrayList(new WheelDAOXMLImpl().getAllWheels());
		
		// táblázat tartalmának beállítása
		table.setItems(list);
		
	}
	
	public void setSEC(SkateboardEditorController sec){
		this.sec = sec;
	}

}