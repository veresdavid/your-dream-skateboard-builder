package dao.impl;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import dao.WheelDAO;
import models.Wheel;
import saxhandlers.WheelHandler;

public class WheelDAOXMLImpl implements WheelDAO {

	public List<Wheel> getAllWheels() {
		
		SAXParserFactory spf = SAXParserFactory.newInstance();
		
		try {
			
			SAXParser parser = spf.newSAXParser();
			
			WheelHandler handler = new WheelHandler();
			
			parser.parse(getClass().getResourceAsStream("/xml/wheels.xml"), handler);
			
			return handler.getWheels();
			
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
