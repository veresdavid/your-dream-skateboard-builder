package saxhandlers;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import models.Bearing;

public class BearingHandler extends DefaultHandler {
	
	public static enum Status { NOTHING, BRAND, NAME, CATEGORY, PRICE, IMAGE };
	
	private Status status = Status.NOTHING;
	
	private Bearing bearing;
	private List<Bearing> bearings;

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		if(status==Status.BRAND){
			bearing.setBrand(new String(ch, start, length));
		}else if(status==Status.NAME){
			bearing.setName(new String(ch, start, length));
		}else if(status==Status.CATEGORY){
			bearing.setCategory(new String(ch, start, length));
		}else if(status==Status.PRICE){
			bearing.setPrice(Integer.parseInt(new String(ch, start, length)));
		}else if(status==Status.IMAGE){
			bearing.setImage(new String(ch, start, length));
		}
		
		status = Status.NOTHING;
		
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		if(qName.equalsIgnoreCase("bearing")){
			bearings.add(bearing);
		}
		
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		if(qName.equalsIgnoreCase("bearing")){
			bearing = new Bearing();
			
			bearing.setId(attributes.getValue("id"));
			
			if(bearings==null){
				bearings = new ArrayList<Bearing>();
			}
		}else if(qName.equalsIgnoreCase("brand")){
			status = Status.BRAND;
		}else if(qName.equalsIgnoreCase("name")){
			status = Status.NAME;
		}else if(qName.equalsIgnoreCase("category")){
			status = Status.CATEGORY;
		}else if(qName.equalsIgnoreCase("price")){
			status = Status.PRICE;
		}else if(qName.equalsIgnoreCase("image")){
			status = Status.IMAGE;
		}
		
	}

	public List<Bearing> getBearings() {
		return bearings;
	}

}
