package dao.impl;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import dao.DeckDAO;
import models.Deck;
import saxhandlers.DeckHandler;

/**
 * A {@link dao.DeckDAO} interfésznek egy XML feldolgozással történő megvalósítása.
 * Az XML beolvasás SAX-al történik, ehhez segítségül hívjuk a {@link saxhandlers.BearingHandler}
 * osztályt.
 */
public class DeckDAOXMLImpl implements DeckDAO {
	
	/**
	 * A naplózáshoz használt objektum.
	 */
	private static Logger logger = LoggerFactory.getLogger(DeckDAOXMLImpl.class);

	/**
	 * A lapokat tartalmazó XML állományt kiolvasva visszaad egy listát, ami az
	 * összes lapot tartalmazza. Bármilyen fellépő hiba esetén a függvény {@code null}
	 * értéket ad vissza.
	 * 
	 * @return az összes lapot tartalmazó lista, vagy {@code null} érték
	 */
	public List<Deck> getAllDecks() {
		
		SAXParserFactory spf = SAXParserFactory.newInstance();
		
		try {
			
			SAXParser parser = spf.newSAXParser();
			
			DeckHandler handler = new DeckHandler();
			
			parser.parse(getClass().getResourceAsStream("/xml/decks.xml"), handler);
			
			return handler.getDecks();
			
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
	 * A {@link #getAllDecks()} függvény által adott listából visszaadja azt a
	 * lapot, aminek az azonosítója megegyezik a paraméterként kapott
	 * azonosítóval. Ha nincs ilyen lap, akkor {@code null} értéket ad vissza a
	 * függvény. 
	 * 
	 * @param id annak a lapnak az azonosítója, amit meg szeretnénk kapni
	 * @return a választott azonosítóval rendelkező lap, vagy {@code null} érték
	 */
	public Deck getDeckById(String id) {
		for (Deck deck : getAllDecks()) {
			if(deck.getId().equals(id))
				return deck;
		}
		
		return null;
	}

}
