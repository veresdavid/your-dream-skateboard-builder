package controllers;

import dao.impl.GriptapeDAOXMLImpl;
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
import models.Griptape;

public class GriptapeChooserController {
	
	private SkateboardEditorController sec;
	
	@FXML
	TableView<Griptape> table;
	
	@FXML
	TableColumn<Griptape, String> brand;
	
	@FXML
	TableColumn<Griptape, String> name;
	
	@FXML
	TableColumn<Griptape, Double> size;
	
	@FXML
	TableColumn<Griptape, Integer> price;
	
	@FXML
	TableColumn<Griptape, String> image;
	
	@FXML
	public void initialize(){
		
		// a táblázatunk oszlopainak beállítása
		brand.setCellValueFactory(new PropertyValueFactory<Griptape, String>("brand"));
		name.setCellValueFactory(new PropertyValueFactory<Griptape, String>("name"));
		size.setCellValueFactory(new PropertyValueFactory<Griptape, Double>("size"));
		price.setCellValueFactory(new PropertyValueFactory<Griptape, Integer>("price"));
		
		image.setCellValueFactory(new PropertyValueFactory<Griptape, String>("image"));
		image.setCellFactory(new Callback<TableColumn<Griptape,String>, TableCell<Griptape,String>>() {
			
			public TableCell<Griptape, String> call(TableColumn<Griptape, String> param) {
				
				TableCell<Griptape, String> cell = new TableCell<Griptape, String>(){

					@Override
					protected void updateItem(String arg0, boolean arg1) {
						
						if(arg0!=null){
							
							// a táblázatban megjelenő kép
							ImageView img = new ImageView(new Image(getClass().getResourceAsStream("/images/griptapes/" + arg0)));
							img.setFitWidth(180);
							img.setPreserveRatio(true);
							
							// tooltipként megjelenő, nagyobb kép
							Tooltip ttp = new Tooltip();
							ImageView ttpimg = new ImageView(new Image(getClass().getResourceAsStream("/images/griptapes/" + arg0)));
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
					
					// a kiválasztott smirgli
					Griptape griptape = table.getSelectionModel().getSelectedItem();
					
					// TODO: kiírjuk melyik deszkát választottuk ki
					System.out.println(griptape);
					
					// TODO: hozzáadjuk a "kosárhoz" a választott lapot
					// SkateboardEditorController.setGriptape(table.getSelectionModel().getSelectedItem());
					sec.setGriptape(griptape);
					
					sec.updateScene();
					
					// TODO: ablak bezárása
					Stage stage = (Stage) table.getScene().getWindow();
					stage.close();
					
				}
				
			}
		});
		
		// adatok lekérése
		ObservableList<Griptape> list = FXCollections.observableArrayList(new GriptapeDAOXMLImpl().getAllGriptapes());
		
		// táblázat tartalmának beállítása
		table.setItems(list);
		
	}
	
	public void setSEC(SkateboardEditorController sec){
		this.sec = sec;
	}

}
