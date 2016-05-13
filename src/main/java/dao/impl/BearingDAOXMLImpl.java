package dao.impl;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import dao.BearingDAO;
import models.Bearing;
import saxhandlers.BearingHandler;

public class BearingDAOXMLImpl implements BearingDAO {

	public List<Bearing> getAllBearings() {
		
		SAXParserFactory spf = SAXParserFactory.newInstance();
		
		try {
			
			SAXParser parser = spf.newSAXParser();
			
			BearingHandler handler = new BearingHandler();
			
			parser.parse(getClass().getResourceAsStream("/xml/bearings.xml"), handler);
			
			return handler.getBearings();
			
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
