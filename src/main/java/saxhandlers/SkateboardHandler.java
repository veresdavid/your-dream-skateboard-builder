package saxhandlers;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import dao.impl.BearingDAOXMLImpl;
import dao.impl.DeckDAOXMLImpl;
import dao.impl.GriptapeDAOXMLImpl;
import dao.impl.TruckDAOXMLImpl;
import dao.impl.WheelDAOXMLImpl;
import models.Bearing;
import models.Deck;
import models.Griptape;
import models.Skateboard;
import models.Truck;
import models.Wheel;

/**
 * A gördeszkákat {@link models.Skateboard} tartalmazó XML állomány feldolgozását segítő
 * osztály.
 */
public class SkateboardHandler extends DefaultHandler {
	
	/**
	 * A felsorolásban található elemek jelzik, hogy a gördeszkákat tartalmazó XML
	 * feldolgozása során milyen elemekre futhatunk rá.
	 */
	public static enum Status { NOTHING, NAME, BEARINGID, DECKID, GRIPTAPEID, TRUCKID, WHEELID };
	
	/**
	 * Jelzi, hogy az XML feldolgozás során éppen milyen elemre futottunk rá.
	 */
	private Status status = Status.NOTHING;
	
	/**
	 * Egy gördeszka, amit az XML feldolgozás során éppen kiolvasunk.
	 */
	private Skateboard skateboard;
	/**
	 * Egy lista, ami tartalmazza az XML-ből kiolvasott gördeszkákat.
	 */
	private List<Skateboard> skateboards;

	/**
	 * Kiolvassuk annak az elemnek az értékét, amin éppen állunk, ez egy gördeszka
	 * alkatrésznek az azonosítója. Lekérjük az adatbázisból az ezzel az azonosítóval
	 * rendelkező megfelelő alkatrészt, és hozzáadjuk a gördeszkához.
	 * 
	 * @param ch a karakterek tömbje
	 * @param start a kezdőpozíció a karaktertömbön belül
	 * @param length azon karakterek száma, amennyit fel akarunk használni a karaktertömbből
	 * @throws SAXException bármilyen SAX-os kivétel
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		if(status==Status.NAME){
			skateboard.setName(new String(ch, start, length));
		}else if(status==Status.BEARINGID){
			String bearingId = new String(ch, start, length);
			BearingDAOXMLImpl bdxi = new BearingDAOXMLImpl();
			Bearing bearing = bdxi.getBearingById(bearingId);
			skateboard.setBearing(bearing);
		}else if(status==Status.DECKID){
			String deckId = new String(ch, start, length);
			DeckDAOXMLImpl ddxi = new DeckDAOXMLImpl();
			Deck deck = ddxi.getDeckById(deckId);
			skateboard.setDeck(deck);
		}else if(status==Status.GRIPTAPEID){
			String griptapeId = new String(ch, start, length);
			GriptapeDAOXMLImpl gdxi = new GriptapeDAOXMLImpl();
			Griptape griptape = gdxi.getGriptapeById(griptapeId);
			skateboard.setGriptape(griptape);
		}else if(status==Status.TRUCKID){
			String truckId = new String(ch, start, length);
			TruckDAOXMLImpl tdxi = new TruckDAOXMLImpl();
			Truck truck = tdxi.getTruckById(truckId);
			skateboard.setTruck(truck);
		}else if(status==Status.WHEELID){
			String wheelId = new String(ch, start, length);
			WheelDAOXMLImpl wdxi = new WheelDAOXMLImpl();
			Wheel wheel = wdxi.getWheelById(wheelId);
			skateboard.setWheel(wheel);
		}
		
		status = Status.NOTHING;
		
	}

	/**
	 * Hozzáadjuk az éppen kiolvasott gördeszkát a már kiolvasott gördeszkák listájához,
	 * ha ráfutottunk a gördeszka záróelemére.
	 * 
	 * @param uri a névtér URI, vagy üres sztring
	 * @param localName lokális név, vagy üres sztring
	 * @param qName a záró elem neve
	 * @throws SAXException bármilyen SAX-os kivétel
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		if(qName.equalsIgnoreCase("skateboard")){
			skateboards.add(skateboard);
		}
		
	}

	/**
	 * Egy kezdőelemre ráfutva elvégezzük a megfelelő műveleteket, például módosítjuk
	 * a {@code status} változót, vagy a létrehozunk egy üres gördeszka objektumot, vagy
	 * létrehozzuk a gördeszkák listáját.
	 * 
	 * @param uri a névtér URI, vagy üres sztring
	 * @param localName lokális név, vagy üres sztring
	 * @param qName a kezdő elem neve
	 * @param attributes az elem attribútumait tartalmazó objektum
	 * @throws SAXException bármilyen SAX-os kivétel
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		if(qName.equalsIgnoreCase("skateboard")){
			skateboard = new Skateboard();
			
			if(skateboards==null){
				skateboards = new ArrayList<Skateboard>();
			}
		}else if(qName.equalsIgnoreCase("name")){
			status = Status.NAME;
		}else if(qName.equalsIgnoreCase("bearingId")){
			status = Status.BEARINGID;
		}else if(qName.equalsIgnoreCase("deckId")){
			status = Status.DECKID;
		}else if(qName.equalsIgnoreCase("griptapeId")){
			status = Status.GRIPTAPEID;
		}else if(qName.equalsIgnoreCase("truckId")){
			status = Status.TRUCKID;
		}else if(qName.equalsIgnoreCase("wheelId")){
			status = Status.WHEELID;
		}
		
	}

	/**
	 * Visszaad egy listát, ami tartalmazza az összes, XML-ből kiolvasott gördeszkát.
	 * 
	 * @return az XML-ből kiolvasott gördeszkákat tartalmazó lista
	 */
	public List<Skateboard> getSkateboards() {
		return skateboards;
	}

}
