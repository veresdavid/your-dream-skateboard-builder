package dao.impl;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import dao.DeckDAO;
import models.Deck;
import saxhandlers.DeckHandler;

public class DeckDAOXMLImpl implements DeckDAO {

	public List<Deck> getAllDecks() {
		
		SAXParserFactory spf = SAXParserFactory.newInstance();
		
		try {
			
			SAXParser parser = spf.newSAXParser();
			
			DeckHandler handler = new DeckHandler();
			
			parser.parse(getClass().getResourceAsStream("/xml/decks.xml"), handler);
			
			return handler.getDecks();
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;

	}

}
