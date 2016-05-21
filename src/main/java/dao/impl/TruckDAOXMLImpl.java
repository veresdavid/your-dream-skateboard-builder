package dao.impl;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import dao.TruckDAO;
import models.Truck;
import saxhandlers.TruckHandler;

/**
 * A {@link dao.TruckDAO} interfésznek egy XML feldolgozással történő megvalósítása.
 * Az XML beolvasás SAX-al történik, ehhez segítségül hívjuk a {@link saxhandlers.BearingHandler}
 * osztályt.
 */
public class TruckDAOXMLImpl implements TruckDAO {
	
	/**
	 * A naplózáshoz használt objektum.
	 */
	private static Logger logger = LoggerFactory.getLogger(TruckDAOXMLImpl.class);

	/**
	 * A felfüggesztéseket tartalmazó XML állományt kiolvasva visszaad egy listát, ami az
	 * összes felfüggesztést tartalmazza. Bármilyen fellépő hiba esetén a függvény {@code null}
	 * értéket ad vissza.
	 * 
	 * @return az összes felfüggesztést tartalmazó lista, vagy {@code null} érték
	 */
	public List<Truck> getAllTrucks() {
		
		SAXParserFactory spf = SAXParserFactory.newInstance();
		
		try {
			
			SAXParser parser = spf.newSAXParser();
			
			TruckHandler handler = new TruckHandler();
			
			parser.parse(getClass().getResourceAsStream("/xml/trucks.xml"), handler);
			
			return handler.getTrucks();
			
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
	 * A {@link #getAllTrucks()} függvény által adott listából visszaadja azt a
	 * felfüggesztést, aminek az azonosítója megegyezik a paraméterként kapott
	 * azonosítóval. Ha nincs ilyen felfüggesztés, akkor {@code null} értéket ad vissza a
	 * függvény. 
	 * 
	 * @param id annak a felfüggesztésnek az azonosítója, amit meg szeretnénk kapni
	 * @return a választott azonosítóval rendelkező felfüggesztés, vagy {@code null} érték
	 */
	public Truck getTruckById(String id) {
		for (Truck truck : getAllTrucks()) {
			if(truck.getId().equals(id))
				return truck;
		}
		
		return null;
	}

}
