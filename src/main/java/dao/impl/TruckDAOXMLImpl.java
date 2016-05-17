package dao.impl;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import dao.TruckDAO;
import models.Truck;
import saxhandlers.TruckHandler;

public class TruckDAOXMLImpl implements TruckDAO {

	public List<Truck> getAllTrucks() {
		
		SAXParserFactory spf = SAXParserFactory.newInstance();
		
		try {
			
			SAXParser parser = spf.newSAXParser();
			
			TruckHandler handler = new TruckHandler();
			
			parser.parse(getClass().getResourceAsStream("/xml/trucks.xml"), handler);
			
			return handler.getTrucks();
			
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
	public Truck getTruckById(String id) {
		for (Truck truck : getAllTrucks()) {
			if(truck.getId().equals(id))
				return truck;
		}
		
		return null;
	}

}
