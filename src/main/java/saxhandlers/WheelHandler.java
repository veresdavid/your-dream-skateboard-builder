package saxhandlers;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import models.Wheel;

public class WheelHandler extends DefaultHandler {
	
	public static enum Status { NOTHING, BRAND, NAME, SIZE, PRICE, IMAGE };
	
	private Status status = Status.NOTHING;
	
	private Wheel wheel;
	private List<Wheel> wheels;

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		if(status==Status.BRAND){
			wheel.setBrand(new String(ch, start, length));
		}else if(status==Status.NAME){
			wheel.setName(new String(ch, start, length));
		}else if(status==Status.SIZE){
			wheel.setSize(Integer.parseInt(new String(ch, start, length)));
		}else if(status==Status.PRICE){
			wheel.setPrice(Integer.parseInt(new String(ch, start, length)));
		}else if(status==Status.IMAGE){
			wheel.setImage(new String(ch, start, length));
		}
		
		status = Status.NOTHING;
		
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		if(qName.equalsIgnoreCase("wheel")){
			wheels.add(wheel);
		}
		
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		if(qName.equalsIgnoreCase("wheel")){
			wheel = new Wheel();
			
			wheel.setId(attributes.getValue("id"));
			
			if(wheels==null){
				wheels = new ArrayList<Wheel>();
			}
		}else if(qName.equalsIgnoreCase("brand")){
			status = Status.BRAND;
		}else if(qName.equalsIgnoreCase("name")){
			status = Status.NAME;
		}else if(qName.equalsIgnoreCase("size")){
			status = Status.SIZE;
		}else if(qName.equalsIgnoreCase("price")){
			status = Status.PRICE;
		}else if(qName.equalsIgnoreCase("image")){
			status = Status.IMAGE;
		}
		
	}

	public List<Wheel> getWheels() {
		return wheels;
	}

}
