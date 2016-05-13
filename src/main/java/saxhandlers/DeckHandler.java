package saxhandlers;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import models.Deck;

public class DeckHandler extends DefaultHandler {
	
	public static enum Status { NOTHING, BRAND, NAME, SIZE, PRICE, IMAGE };
	
	private Status status = Status.NOTHING;
	
	private Deck deck;
	private List<Deck> decks;

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		if(status==Status.BRAND){
			deck.setBrand(new String(ch, start, length));
		}else if(status==Status.NAME){
			deck.setName(new String(ch, start, length));
		}else if(status==Status.SIZE){
			deck.setSize(Double.parseDouble(new String(ch, start, length)));
		}else if(status==Status.PRICE){
			deck.setPrice(Integer.parseInt(new String(ch, start, length)));
		}else if(status==Status.IMAGE){
			deck.setImage(new String(ch, start, length));
		}
		
		status = Status.NOTHING;
		
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		if(qName.equalsIgnoreCase("deck")){
			decks.add(deck);
		}
		
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		if(qName.equalsIgnoreCase("deck")){
			deck = new Deck();
			
			deck.setId(attributes.getValue("id"));
			
			if(decks==null){
				decks = new ArrayList<Deck>();
			}
		}else if(qName.equalsIgnoreCase("brand")){
			status = Status.BRAND;
		}else if(qName.equalsIgnoreCase("name")){
			status = Status.NAME;
		}else if(qName.equalsIgnoreCase("size")){
			status = Status.SIZE;
		}else if(qName.equalsIgnoreCase("price")){
			status = Status.PRICE;
		}else if(qName.equalsIgnoreCase("image")){
			status = Status.IMAGE;
		}
		
	}

	public List<Deck> getDecks() {
		return decks;
	}

}
