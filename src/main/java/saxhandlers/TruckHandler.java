package saxhandlers;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import models.Truck;

public class TruckHandler extends DefaultHandler {
	
	public static enum Status { NOTHING, BRAND, NAME, MODEL, PRICE, IMAGE };
	
	private Status status = Status.NOTHING;
	
	private Truck truck;
	private List<Truck> trucks;

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		if(status==Status.BRAND){
			truck.setBrand(new String(ch, start, length));
		}else if(status==Status.NAME){
			truck.setName(new String(ch, start, length));
		}else if(status==Status.MODEL){
			truck.setModel(Integer.parseInt(new String(ch, start, length)));
		}else if(status==Status.PRICE){
			truck.setPrice(Integer.parseInt(new String(ch, start, length)));
		}else if(status==Status.IMAGE){
			truck.setImage(new String(ch, start, length));
		}
		
		status = Status.NOTHING;
		
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		if(qName.equalsIgnoreCase("truck")){
			trucks.add(truck);
		}
		
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		if(qName.equalsIgnoreCase("truck")){
			truck = new Truck();
			
			truck.setId(attributes.getValue("id"));
			
			if(trucks==null){
				trucks = new ArrayList<Truck>();
			}
		}else if(qName.equalsIgnoreCase("brand")){
			status = Status.BRAND;
		}else if(qName.equalsIgnoreCase("name")){
			status = Status.NAME;
		}else if(qName.equalsIgnoreCase("model")){
			status = Status.MODEL;
		}else if(qName.equalsIgnoreCase("price")){
			status = Status.PRICE;
		}else if(qName.equalsIgnoreCase("image")){
			status = Status.IMAGE;
		}
		
	}

	public List<Truck> getTrucks() {
		return trucks;
	}

}
