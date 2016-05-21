package saxhandlers;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import models.Deck;

/**
 * A lapokat {@link models.Deck} tartalmazó XML állomány feldolgozását segítő
 * osztály.
 */
public class DeckHandler extends DefaultHandler {
	
	/**
	 * A felsorolásban található elemek jelzik, hogy a lapokat tartalmazó XML
	 * feldolgozása során milyen elemekre futhatunk rá.
	 */
	public static enum Status { NOTHING, BRAND, NAME, SIZE, PRICE, IMAGE };
	
	/**
	 * Jelzi, hogy az XML feldolgozás során éppen milyen elemre futottunk rá.
	 */
	private Status status = Status.NOTHING;
	
	/**
	 * Egy lap, amit az XML feldolgozás során éppen kiolvasunk.
	 */
	private Deck deck;
	/**
	 * Egy lista, ami tartalmazza az XML-ből kiolvasott lapokat.
	 */
	private List<Deck> decks;

	/**
	 * Kiolvassuk annak az elemnek az értékét, amin éppen állunk, és a készülő lap
	 * megfelelő változóját beállítjuk erre az értékre.
	 * 
	 * @param ch a karakterek tömbje
	 * @param start a kezdőpozíció a karaktertömbön belül
	 * @param length azon karakterek száma, amennyit fel akarunk használni a karaktertömbből
	 * @throws SAXException bármilyen SAX-os kivétel
	 */
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

	/**
	 * Hozzáadjuk az éppen kiolvasott lapot a már kiolvasott lapok listájához,
	 * ha ráfutottunk a lap záróelemére.
	 * 
	 * @param uri a névtér URI, vagy üres sztring
	 * @param localName lokális név, vagy üres sztring
	 * @param qName a záró elem neve
	 * @throws SAXException bármilyen SAX-os kivétel
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		if(qName.equalsIgnoreCase("deck")){
			decks.add(deck);
		}
		
	}

	/**
	 * Egy kezdőelemre ráfutva elvégezzük a megfelelő műveleteket, például módosítjuk
	 * a {@code status} változót, vagy a létrehozunk egy üres lap objektumot, vagy
	 * létrehozzuk a lapok listáját.
	 * 
	 * @param uri a névtér URI, vagy üres sztring
	 * @param localName lokális név, vagy üres sztring
	 * @param qName a kezdő elem neve
	 * @param attributes az elem attribútumait tartalmazó objektum
	 * @throws SAXException bármilyen SAX-os kivétel
	 */
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

	/**
	 * Visszaad egy listát, ami tartalmazza az összes, XML-ből kiolvasott lapot.
	 * 
	 * @return az XML-ből kiolvasott lapokat tartalmazó lista
	 */
	public List<Deck> getDecks() {
		return decks;
	}

}
