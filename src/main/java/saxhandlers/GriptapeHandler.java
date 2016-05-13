package saxhandlers;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import models.Griptape;

public class GriptapeHandler extends DefaultHandler {
	
	public static enum Status { NOTHING, BRAND, NAME, SIZE, PRICE, IMAGE };
	
	private Status status = Status.NOTHING;
	
	private Griptape griptape;
	private List<Griptape> griptapes;

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		if(status==Status.BRAND){
			griptape.setBrand(new String(ch, start, length));
		}else if(status==Status.NAME){
			griptape.setName(new String(ch, start, length));
		}else if(status==Status.SIZE){
			griptape.setSize(Double.parseDouble(new String(ch, start, length)));
		}else if(status==Status.PRICE){
			griptape.setPrice(Integer.parseInt(new String(ch, start, length)));
		}else if(status==Status.IMAGE){
			griptape.setImage(new String(ch, start, length));
		}
		
		status = Status.NOTHING;
		
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		if(qName.equalsIgnoreCase("griptape")){
			griptapes.add(griptape);
		}
		
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		if(qName.equalsIgnoreCase("griptape")){
			griptape = new Griptape();
			
			griptape.setId(attributes.getValue("id"));
			
			if(griptapes==null){
				griptapes = new ArrayList<Griptape>();
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

	public List<Griptape> getGriptapes() {
		return griptapes;
	}

}
