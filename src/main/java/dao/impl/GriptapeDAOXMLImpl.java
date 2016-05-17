package dao.impl;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import dao.GriptapeDAO;
import models.Griptape;
import saxhandlers.GriptapeHandler;

public class GriptapeDAOXMLImpl implements GriptapeDAO {

	public List<Griptape> getAllGriptapes() {
		
		SAXParserFactory spf = SAXParserFactory.newInstance();
		
		try {
			
			SAXParser parser = spf.newSAXParser();
			
			GriptapeHandler handler = new GriptapeHandler();
			
			parser.parse(getClass().getResourceAsStream("/xml/griptapes.xml"), handler);
			
			return handler.getGriptapes();
			
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

	@Override
	public Griptape getGriptapeById(String id) {
		for (Griptape griptape : getAllGriptapes()) {
			if(griptape.getId().equals(id))
				return griptape;
		}
		
		return null;
	}

}
