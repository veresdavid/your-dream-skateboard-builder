package saxhandlers;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import models.Wheel;

/**
 * A kerekeket {@link models.Wheel} tartalmazó XML állomány feldolgozását segítő
 * osztály.
 */
public class WheelHandler extends DefaultHandler {
	
	/**
	 * A felsorolásban található elemek jelzik, hogy a kerekeket tartalmazó XML
	 * feldolgozása során milyen elemekre futhatunk rá.
	 */
	public static enum Status { NOTHING, BRAND, NAME, SIZE, PRICE, IMAGE };
	
	/**
	 * Jelzi, hogy az XML feldolgozás során éppen milyen elemre futottunk rá.
	 */
	private Status status = Status.NOTHING;
	
	/**
	 * Egy kerék, amit az XML feldolgozás során éppen kiolvasunk.
	 */
	private Wheel wheel;
	/**
	 * Egy lista, ami tartalmazza az XML-ből kiolvasott kereket.
	 */
	private List<Wheel> wheels;

	/**
	 * Kiolvassuk annak az elemnek az értékét, amin éppen állunk, és a készülő kerék
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
			wheel.setBrand(new String(ch, start, length));
		}else if(status==Status.NAME){
			wheel.setName(new String(ch, start, length));
		}else if(status==Status.SIZE){
			wheel.setSize(Integer.parseInt(new String(ch, start, length)));
		}else if(status==Status.PRICE){
			wheel.setPrice(Integer.parseInt(new String(ch, start, length)));
		}else if(status==Status.IMAGE){
			wheel.setImage(new String(ch, start, length));
		}
		
		status = Status.NOTHING;
		
	}

	/**
	 * Hozzáadjuk az éppen kiolvasott kereket a már kiolvasott kerekek listájához,
	 * ha ráfutottunk a kerék záróelemére.
	 * 
	 * @param uri a névtér URI, vagy üres sztring
	 * @param localName lokális név, vagy üres sztring
	 * @param qName a záró elem neve
	 * @throws SAXException bármilyen SAX-os kivétel
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		if(qName.equalsIgnoreCase("wheel")){
			wheels.add(wheel);
		}
		
	}

	/**
	 * Egy kezdőelemre ráfutva elvégezzük a megfelelő műveleteket, például módosítjuk
	 * a {@code status} változót, vagy a létrehozunk egy üres kerék objektumot, vagy
	 * létrehozzuk a kerekek listáját.
	 * 
	 * @param uri a névtér URI, vagy üres sztring
	 * @param localName lokális név, vagy üres sztring
	 * @param qName a kezdő elem neve
	 * @param attributes az elem attribútumait tartalmazó objektum
	 * @throws SAXException bármilyen SAX-os kivétel
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		if(qName.equalsIgnoreCase("wheel")){
			wheel = new Wheel();
			
			wheel.setId(attributes.getValue("id"));
			
			if(wheels==null){
				wheels = new ArrayList<Wheel>();
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
	 * Visszaad egy listát, ami tartalmazza az összes, XML-ből kiolvasott kereket.
	 * 
	 * @return az XML-ből kiolvasott kerekeket tartalmazó lista
	 */
	public List<Wheel> getWheels() {
		return wheels;
	}

}
