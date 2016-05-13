
import dao.impl.DeckDAOXMLImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import models.Deck;

public class DeckChooserController {
	
	@FXML
	TableView<Deck> table;
	
	@FXML
	TableColumn<Deck, String> name;
	
	@FXML
	TableColumn<Deck, String> image;
	
	@FXML
	public void initialize(){
		
		table.setOnMousePressed(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				
				if(event.isPrimaryButtonDown() && event.getClickCount()==2){
					
					System.out.println(table.getSelectionModel().getSelectedItem());
					
				}
				
			}
		});
		
		name.setCellValueFactory(new PropertyValueFactory<Deck, String>("name"));
		
		image.setCellValueFactory(new PropertyValueFactory<Deck, String>("image"));
		image.setCellFactory(new Callback<TableColumn<Deck,String>, TableCell<Deck,String>>() {
			
			public TableCell<Deck, String> call(TableColumn<Deck, String> param) {
				
				TableCell<Deck, String> cell = new TableCell<Deck, String>(){

					@Override
					protected void updateItem(String arg0, boolean arg1) {
						
						if(arg0!=null){
							
							ImageView img = new ImageView(new Image(getClass().getResourceAsStream("images/decks/" + arg0)));
							img.setFitWidth(440);
							img.setPreserveRatio(true);
							
							setGraphic(img);
							
						}
						
					}
					
				};
				
				return cell;
			}
			
		});
		
		ObservableList<Deck> list = FXCollections.observableArrayList(new DeckDAOXMLImpl().getAllDecks());
		
		table.setItems(list);
		
	}

}
