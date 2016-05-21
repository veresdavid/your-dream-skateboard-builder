package saxhandlers;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import models.Truck;

/**
 * A felfüggesztéseket {@link models.Truck} tartalmazó XML állomány feldolgozását segítő
 * osztály.
 */
public class TruckHandler extends DefaultHandler {
	
	/**
	 * A felsorolásban található elemek jelzik, hogy a felfüggesztéseket tartalmazó XML
	 * feldolgozása során milyen elemekre futhatunk rá.
	 */
	public static enum Status { NOTHING, BRAND, NAME, MODEL, PRICE, IMAGE };
	
	/**
	 * Jelzi, hogy az XML feldolgozás során éppen milyen elemre futottunk rá.
	 */
	private Status status = Status.NOTHING;
	
	/**
	 * Egy felfüggesztés, amit az XML feldolgozás során éppen kiolvasunk.
	 */
	private Truck truck;
	/**
	 * Egy lista, ami tartalmazza az XML-ből kiolvasott felfüggesztéseket.
	 */
	private List<Truck> trucks;

	/**
	 * Kiolvassuk annak az elemnek az értékét, amin éppen állunk, és a készülő felfüggesztés
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
			truck.setBrand(new String(ch, start, length));
		}else if(status==Status.NAME){
			truck.setName(new String(ch, start, length));
		}else if(status==Status.MODEL){
			truck.setModel(Integer.parseInt(new String(ch, start, length)));
		}else if(status==Status.PRICE){
			truck.setPrice(Integer.parseInt(new String(ch, start, length)));
		}else if(status==Status.IMAGE){
			truck.setImage(new String(ch, start, length));
		}
		
		status = Status.NOTHING;
		
	}

	/**
	 * Hozzáadjuk az éppen kiolvasott felfüggesztést a már kiolvasott felfüggesztések
	 * listájához, ha ráfutottunk a felfüggesztés záróelemére.
	 * 
	 * @param uri a névtér URI, vagy üres sztring
	 * @param localName lokális név, vagy üres sztring
	 * @param qName a záró elem neve
	 * @throws SAXException bármilyen SAX-os kivétel
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		if(qName.equalsIgnoreCase("truck")){
			trucks.add(truck);
		}
		
	}

	/**
	 * Egy kezdőelemre ráfutva elvégezzük a megfelelő műveleteket, például módosítjuk
	 * a {@code status} változót, vagy a létrehozunk egy üres felfüggesztés objektumot,
	 * vagy létrehozzuk a felfüggesztések listáját.
	 * 
	 * @param uri a névtér URI, vagy üres sztring
	 * @param localName lokális név, vagy üres sztring
	 * @param qName a kezdő elem neve
	 * @param attributes az elem attribútumait tartalmazó objektum
	 * @throws SAXException bármilyen SAX-os kivétel
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		if(qName.equalsIgnoreCase("truck")){
			truck = new Truck();
			
			truck.setId(attributes.getValue("id"));
			
			if(trucks==null){
				trucks = new ArrayList<Truck>();
			}
		}else if(qName.equalsIgnoreCase("brand")){
			status = Status.BRAND;
		}else if(qName.equalsIgnoreCase("name")){
			status = Status.NAME;
		}else if(qName.equalsIgnoreCase("model")){
			status = Status.MODEL;
		}else if(qName.equalsIgnoreCase("price")){
			status = Status.PRICE;
		}else if(qName.equalsIgnoreCase("image")){
			status = Status.IMAGE;
		}
		
	}

	/**
	 * Visszaad egy listát, ami tartalmazza az összes, XML-ből kiolvasott felfüggesztést.
	 * 
	 * @return az XML-ből kiolvasott felfüggesztéseket tartalmazó lista
	 */
	public List<Truck> getTrucks() {
		return trucks;
	}

}
