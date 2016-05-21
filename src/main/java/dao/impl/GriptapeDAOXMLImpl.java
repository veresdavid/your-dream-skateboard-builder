package dao.impl;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import dao.GriptapeDAO;
import models.Griptape;
import saxhandlers.GriptapeHandler;

/**
 * A {@link dao.GriptapeDAO} interfésznek egy XML feldolgozással történő megvalósítása.
 * Az XML beolvasás SAX-al történik, ehhez segítségül hívjuk a {@link saxhandlers.BearingHandler}
 * osztályt.
 */
public class GriptapeDAOXMLImpl implements GriptapeDAO {
	
	/**
	 * A naplózáshoz használt objektum.
	 */
	private static Logger logger = LoggerFactory.getLogger(GriptapeDAOXMLImpl.class);

	/**
	 * A smirgliket tartalmazó XML állományt kiolvasva visszaad egy listát, ami az
	 * összes smirglit tartalmazza. Bármilyen fellépő hiba esetén a függvény {@code null}
	 * értéket ad vissza.
	 * 
	 * @return az összes smirglit tartalmazó lista, vagy {@code null} érték
	 */
	public List<Griptape> getAllGriptapes() {
		
		SAXParserFactory spf = SAXParserFactory.newInstance();
		
		try {
			
			SAXParser parser = spf.newSAXParser();
			
			GriptapeHandler handler = new GriptapeHandler();
			
			parser.parse(getClass().getResourceAsStream("/xml/griptapes.xml"), handler);
			
			return handler.getGriptapes();
			
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
	 * A {@link #getAllGriptapes()} függvény által adott listából visszaadja azt a
	 * smirglit, aminek az azonosítója megegyezik a paraméterként kapott
	 * azonosítóval. Ha nincs ilyen smirgli, akkor {@code null} értéket ad vissza a
	 * függvény. 
	 * 
	 * @param id annak a smirglinek az azonosítója, amit meg szeretnénk kapni
	 * @return a választott azonosítóval rendelkező smirgli, vagy {@code null} érték
	 */
	public Griptape getGriptapeById(String id) {
		for (Griptape griptape : getAllGriptapes()) {
			if(griptape.getId().equals(id))
				return griptape;
		}
		
		return null;
	}

}
