package saxhandlers;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import models.Bearing;

/**
 * A csapágyakat {@link models.Bearing} tartalmazó XML állomány feldolgozását segítő
 * osztály.
 */
public class BearingHandler extends DefaultHandler {
	
	/**
	 * A felsorolásban található elemek jelzik, hogy a csapágyakat tartalmazó XML
	 * feldolgozása során milyen elemekre futhatunk rá.
	 */
	public static enum Status { NOTHING, BRAND, NAME, CATEGORY, PRICE, IMAGE };
	
	/**
	 * Jelzi, hogy az XML feldolgozás során éppen milyen elemre futottunk rá.
	 */
	private Status status = Status.NOTHING;
	
	/**
	 * Egy csapágy, amit az XML feldolgozás során éppen kiolvasunk.
	 */
	private Bearing bearing;
	/**
	 * Egy lista, ami tartalmazza az XML-ből kiolvasott csapágyakat.
	 */
	private List<Bearing> bearings;

	/**
	 * Kiolvassuk annak az elemnek az értékét, amin éppen állunk, és a készülő csapágy
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
			bearing.setBrand(new String(ch, start, length));
		}else if(status==Status.NAME){
			bearing.setName(new String(ch, start, length));
		}else if(status==Status.CATEGORY){
			bearing.setCategory(new String(ch, start, length));
		}else if(status==Status.PRICE){
			bearing.setPrice(Integer.parseInt(new String(ch, start, length)));
		}else if(status==Status.IMAGE){
			bearing.setImage(new String(ch, start, length));
		}
		
		status = Status.NOTHING;
		
	}

	/**
	 * Hozzáadjuk az éppen kiolvasott csapágyat a már kiolvasott csapágyak listájához,
	 * ha ráfutottunk a csapágy záróelemére.
	 * 
	 * @param uri a névtér URI, vagy üres sztring
	 * @param localName lokális név, vagy üres sztring
	 * @param qName a záró elem neve
	 * @throws SAXException bármilyen SAX-os kivétel
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		if(qName.equalsIgnoreCase("bearing")){
			bearings.add(bearing);
		}
		
	}

	/**
	 * Egy kezdőelemre ráfutva elvégezzük a megfelelő műveleteket, például módosítjuk
	 * a {@code status} változót, vagy a létrehozunk egy üres csapágy objektumot, vagy
	 * létrehozzuk a csapágyak listáját.
	 * 
	 * @param uri a névtér URI, vagy üres sztring
	 * @param localName lokális név, vagy üres sztring
	 * @param qName a kezdő elem neve
	 * @param attributes az elem attribútumait tartalmazó objektum
	 * @throws SAXException bármilyen SAX-os kivétel
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		if(qName.equalsIgnoreCase("bearing")){
			bearing = new Bearing();
			
			bearing.setId(attributes.getValue("id"));
			
			if(bearings==null){
				bearings = new ArrayList<Bearing>();
			}
		}else if(qName.equalsIgnoreCase("brand")){
			status = Status.BRAND;
		}else if(qName.equalsIgnoreCase("name")){
			status = Status.NAME;
		}else if(qName.equalsIgnoreCase("category")){
			status = Status.CATEGORY;
		}else if(qName.equalsIgnoreCase("price")){
			status = Status.PRICE;
		}else if(qName.equalsIgnoreCase("image")){
			status = Status.IMAGE;
		}
		
	}

	/**
	 * Visszaad egy listát, ami tartalmazza az összes, XML-ből kiolvasott csapágyat.
	 * 
	 * @return az XML-ből kiolvasott csapágyakat tartalmazó lista
	 */
	public List<Bearing> getBearings() {
		return bearings;
	}

}
