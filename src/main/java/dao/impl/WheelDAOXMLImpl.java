package dao.impl;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import dao.WheelDAO;
import models.Wheel;
import saxhandlers.WheelHandler;

/**
 * A {@link dao.WheelDAO} interfésznek egy XML feldolgozással történő megvalósítása.
 * Az XML beolvasás SAX-al történik, ehhez segítségül hívjuk a {@link saxhandlers.BearingHandler}
 * osztályt.
 */
public class WheelDAOXMLImpl implements WheelDAO {
	
	/**
	 * A naplózáshoz használt objektum.
	 */
	private static Logger logger = LoggerFactory.getLogger(WheelDAOXMLImpl.class);

	/**
	 * A kerekeket tartalmazó XML állományt kiolvasva visszaad egy listát, ami az
	 * összes kereket tartalmazza. Bármilyen fellépő hiba esetén a függvény {@code null}
	 * értéket ad vissza.
	 * 
	 * @return az összes kereket tartalmazó lista, vagy {@code null} érték
	 */
	public List<Wheel> getAllWheels() {
		
		SAXParserFactory spf = SAXParserFactory.newInstance();
		
		try {
			
			SAXParser parser = spf.newSAXParser();
			
			WheelHandler handler = new WheelHandler();
			
			parser.parse(getClass().getResourceAsStream("/xml/wheels.xml"), handler);
			
			return handler.getWheels();
			
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
	 * A {@link #getAllWheels()} függvény által adott listából visszaadja azt a
	 * kereket, aminek az azonosítója megegyezik a paraméterként kapott
	 * azonosítóval. Ha nincs ilyen kerék, akkor {@code null} értéket ad vissza a
	 * függvény. 
	 * 
	 * @param id annak a keréknek az azonosítója, amit meg szeretnénk kapni
	 * @return a választott azonosítóval rendelkező kerék, vagy {@code null} érték
	 */
	public Wheel getWheelById(String id) {
		for (Wheel wheel : getAllWheels()) {
			if(wheel.getId().equals(id))
				return wheel;
		}
		
		return null;
	}

}
