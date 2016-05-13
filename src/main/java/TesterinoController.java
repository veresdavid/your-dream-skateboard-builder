
import dao.impl.DeckDAOXMLImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import models.Deck;

public class TesterinoController {
	
	@FXML
	MenuItem close;
	
	@FXML
	Button button;
	
	@FXML
	TableView<Deck> table;
	
	@FXML
	public void closeThisShit(){
		System.out.println("kakálások vannak kecc");
	}
	
	@FXML
	public void doSomethingPls(){
		
		System.out.println("Lapok betöltése");
		
		DeckDAOXMLImpl ddxi = new DeckDAOXMLImpl();
		
		ObservableList<Deck> list = FXCollections.observableArrayList(ddxi.getAllDecks());
		
		TableColumn<Deck, String> brand = new TableColumn<Deck, String>("Márka");
		brand.setCellValueFactory(new PropertyValueFactory<Deck, String>("brand"));
		
		TableColumn<Deck, String> name = new TableColumn<Deck, String>("Név");
		name.setCellValueFactory(new PropertyValueFactory<Deck, String>("name"));
		
		TableColumn<Deck, String> image = new TableColumn<Deck, String>("Kép");
		image.setCellValueFactory(new PropertyValueFactory<Deck, String>("image"));
		image.setCellFactory(new Callback<TableColumn<Deck,String>, TableCell<Deck,String>>() {

			public TableCell<Deck, String> call(TableColumn<Deck, String> param) {
				
				TableCell<Deck, String> cell = new TableCell<Deck, String>(){

					@Override
					protected void updateItem(String item, boolean empty) {
						
						if(item!=null){
						
							ImageView img = new ImageView();
							img.setImage(new Image(getClass().getResourceAsStream("/images/decks/" + item)));
							img.setFitWidth(400);
							img.setPreserveRatio(true);
							
							setGraphic(img);
						
						}
						
					}
					
				};
				
				return cell;
			}
			
		});
		
		table.getColumns().addAll(brand, name, image);
		table.setItems(list);
		
	}

}
