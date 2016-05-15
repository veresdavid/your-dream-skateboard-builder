package controllers;

import dao.impl.DeckDAOXMLImpl;
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
import models.Deck;

public class DeckChooserController {
	
	private SkateboardEditorController sec;
	
	@FXML
	TableView<Deck> table;
	
	@FXML
	TableColumn<Deck, String> brand;
	
	@FXML
	TableColumn<Deck, String> name;
	
	@FXML
	TableColumn<Deck, Double> size;
	
	@FXML
	TableColumn<Deck, Integer> price;
	
	@FXML
	TableColumn<Deck, String> image;
	
	@FXML
	public void initialize(){
		
		// a táblázatunk oszlopainak beállítása
		brand.setCellValueFactory(new PropertyValueFactory<Deck, String>("brand"));
		name.setCellValueFactory(new PropertyValueFactory<Deck, String>("name"));
		size.setCellValueFactory(new PropertyValueFactory<Deck, Double>("size"));
		price.setCellValueFactory(new PropertyValueFactory<Deck, Integer>("price"));
		
		image.setCellValueFactory(new PropertyValueFactory<Deck, String>("image"));
		image.setCellFactory(new Callback<TableColumn<Deck,String>, TableCell<Deck,String>>() {
			
			public TableCell<Deck, String> call(TableColumn<Deck, String> param) {
				
				TableCell<Deck, String> cell = new TableCell<Deck, String>(){

					@Override
					protected void updateItem(String arg0, boolean arg1) {
						
						if(arg0!=null){
							
							// a táblázatban megjelenő kép
							ImageView img = new ImageView(new Image(getClass().getResourceAsStream("/images/decks/" + arg0)));
							img.setFitWidth(180);
							img.setPreserveRatio(true);
							
							// tooltipként megjelenő, nagyobb kép
							Tooltip ttp = new Tooltip();
							ImageView ttpimg = new ImageView(new Image(getClass().getResourceAsStream("/images/decks/" + arg0)));
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
					
					// a kiválasztott deszka
					Deck deck = table.getSelectionModel().getSelectedItem();
					
					// TODO: kiírjuk melyik deszkát választottuk ki
					System.out.println(deck);
					
					// TODO: hozzáadjuk a "kosárhoz" a választott lapot
					// SkateboardEditorController.setDeck(table.getSelectionModel().getSelectedItem());
					sec.setDeck(deck);
					sec.setDeckLabel(deck.readableToString());
					
					// TODO: ablak bezárása
					Stage stage = (Stage) table.getScene().getWindow();
					stage.close();
					
				}
				
			}
		});
		
		// adatok lekérése
		ObservableList<Deck> list = FXCollections.observableArrayList(new DeckDAOXMLImpl().getAllDecks());
		
		// táblázat tartalmának beállítása
		table.setItems(list);
		
	}
	
	public void setSEC(SkateboardEditorController sec){
		this.sec = sec;
	}

}
