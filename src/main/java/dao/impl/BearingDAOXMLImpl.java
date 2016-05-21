package dao.impl;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import dao.BearingDAO;
import models.Bearing;
import saxhandlers.BearingHandler;

/**
 * A {@link dao.BearingDAO} interfésznek egy XML feldolgozással történő megvalósítása.
 * Az XML beolvasás SAX-al történik, ehhez segítségül hívjuk a {@link saxhandlers.BearingHandler}
 * osztályt.
 */
public class BearingDAOXMLImpl implements BearingDAO {
	
	/**
	 * A naplózáshoz használt objektum.
	 */
	private static Logger logger = LoggerFactory.getLogger(BearingDAOXMLImpl.class);

	/**
	 * A csapágyakat tartalmazó XML állományt kiolvasva visszaad egy listát, ami az
	 * összes csapágyat tartalmazza. Bármilyen fellépő hiba esetén a függvény {@code null}
	 * értéket ad vissza.
	 * 
	 * @return az összes csapágyat tartalmazó lista, vagy {@code null} érték
	 */
	public List<Bearing> getAllBearings() {
		
		SAXParserFactory spf = SAXParserFactory.newInstance();
		
		try {
			
			SAXParser parser = spf.newSAXParser();
			
			BearingHandler handler = new BearingHandler();
			
			parser.parse(getClass().getResourceAsStream("/xml/bearings.xml"), handler);
			
			return handler.getBearings();
			
		} catch (ParserConfigurationException e) {
			logger.error("Kivétel: ", e);
			return null;
		} catch (SAXException e) {
			logger.error("Kivétel: ", e);
			return null;
		} catch (IOException e) {
			logger.error("Kivétel: ", e);
			return null;
		}
		
	}

	/**
	 * A {@link #getAllBearings()} függvény által adott listából visszaadja azt a
	 * csapágyat, aminek az azonosítója megegyezik a paraméterként kapott
	 * azonosítóval. Ha nincs ilyen csapágy, akkor {@code null} értéket ad vissza a
	 * függvény. 
	 * 
	 * @param id annak a csapágynak az azonosítója, amit meg szeretnénk kapni
	 * @return a választott azonosítóval rendelkező csapágy, vagy {@code null} érték
	 */
	public Bearing getBearingById(String id) {
		for (Bearing bearing : getAllBearings()) {
			if(bearing.getId().equals(id))
				return bearing;
		}
		
		return null;
	}

}
