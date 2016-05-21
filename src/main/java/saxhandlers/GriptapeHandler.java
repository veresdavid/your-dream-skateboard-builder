package saxhandlers;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import models.Griptape;

/**
 * A smirgliket {@link models.Griptape} tartalmazó XML állomány feldolgozását segítő
 * osztály.
 */
public class GriptapeHandler extends DefaultHandler {
	
	/**
	 * A felsorolásban található elemek jelzik, hogy a smirgliket tartalmazó XML
	 * feldolgozása során milyen elemekre futhatunk rá.
	 */
	public static enum Status { NOTHING, BRAND, NAME, SIZE, PRICE, IMAGE };
	
	/**
	 * Jelzi, hogy az XML feldolgozás során éppen milyen elemre futottunk rá.
	 */
	private Status status = Status.NOTHING;
	
	/**
	 * Egy smirgli, amit az XML feldolgozás során éppen kiolvasunk.
	 */
	private Griptape griptape;
	/**
	 * Egy lista, ami tartalmazza az XML-ből kiolvasott smirgliket.
	 */
	private List<Griptape> griptapes;

	/**
	 * Kiolvassuk annak az elemnek az értékét, amin éppen állunk, és a készülő smirgli
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
			griptape.setBrand(new String(ch, start, length));
		}else if(status==Status.NAME){
			griptape.setName(new String(ch, start, length));
		}else if(status==Status.SIZE){
			griptape.setSize(Double.parseDouble(new String(ch, start, length)));
		}else if(status==Status.PRICE){
			griptape.setPrice(Integer.parseInt(new String(ch, start, length)));
		}else if(status==Status.IMAGE){
			griptape.setImage(new String(ch, start, length));
		}
		
		status = Status.NOTHING;
		
	}

	/**
	 * Hozzáadjuk az éppen kiolvasott smirglit a már kiolvasott smirglik listájához,
	 * ha ráfutottunk a smirgli záróelemére.
	 * 
	 * @param uri a névtér URI, vagy üres sztring
	 * @param localName lokális név, vagy üres sztring
	 * @param qName a záró elem neve
	 * @throws SAXException bármilyen SAX-os kivétel
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		if(qName.equalsIgnoreCase("griptape")){
			griptapes.add(griptape);
		}
		
	}

	/**
	 * Egy kezdőelemre ráfutva elvégezzük a megfelelő műveleteket, például módosítjuk
	 * a {@code status} változót, vagy a létrehozunk egy üres smirgli objektumot, vagy
	 * létrehozzuk a smirglik listáját.
	 * 
	 * @param uri a névtér URI, vagy üres sztring
	 * @param localName lokális név, vagy üres sztring
	 * @param qName a kezdő elem neve
	 * @param attributes az elem attribútumait tartalmazó objektum
	 * @throws SAXException bármilyen SAX-os kivétel
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		if(qName.equalsIgnoreCase("griptape")){
			griptape = new Griptape();
			
			griptape.setId(attributes.getValue("id"));
			
			if(griptapes==null){
				griptapes = new ArrayList<Griptape>();
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
	 * Visszaad egy listát, ami tartalmazza az összes, XML-ből kiolvasott smirglit.
	 * 
	 * @return az XML-ből kiolvasott smirgliket tartalmazó lista
	 */
	public List<Griptape> getGriptapes() {
		return griptapes;
	}

}
