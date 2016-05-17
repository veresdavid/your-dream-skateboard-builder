package saxhandlers;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import dao.impl.BearingDAOXMLImpl;
import dao.impl.DeckDAOXMLImpl;
import dao.impl.GriptapeDAOXMLImpl;
import dao.impl.TruckDAOXMLImpl;
import dao.impl.WheelDAOXMLImpl;
import models.Bearing;
import models.Deck;
import models.Griptape;
import models.Skateboard;
import models.Truck;
import models.Wheel;

public class SkateboardHandler extends DefaultHandler {
	
	public static enum Status { NOTHING, NAME, BEARINGID, DECKID, GRIPTAPEID, TRUCKID, WHEELID };
	
	private Status status = Status.NOTHING;
	
	private Skateboard skateboard;
	private List<Skateboard> skateboards;

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		if(status==Status.NAME){
			skateboard.setName(new String(ch, start, length));
		}else if(status==Status.BEARINGID){
			String bearingId = new String(ch, start, length);
			BearingDAOXMLImpl bdxi = new BearingDAOXMLImpl();
			Bearing bearing = bdxi.getBearingById(bearingId);
			skateboard.setBearing(bearing);
		}else if(status==Status.DECKID){
			String deckId = new String(ch, start, length);
			DeckDAOXMLImpl ddxi = new DeckDAOXMLImpl();
			Deck deck = ddxi.getDeckById(deckId);
			skateboard.setDeck(deck);
		}else if(status==Status.GRIPTAPEID){
			String griptapeId = new String(ch, start, length);
			GriptapeDAOXMLImpl gdxi = new GriptapeDAOXMLImpl();
			Griptape griptape = gdxi.getGriptapeById(griptapeId);
			skateboard.setGriptape(griptape);
		}else if(status==Status.TRUCKID){
			String truckId = new String(ch, start, length);
			TruckDAOXMLImpl tdxi = new TruckDAOXMLImpl();
			Truck truck = tdxi.getTruckById(truckId);
			skateboard.setTruck(truck);
		}else if(status==Status.WHEELID){
			String wheelId = new String(ch, start, length);
			WheelDAOXMLImpl wdxi = new WheelDAOXMLImpl();
			Wheel wheel = wdxi.getWheelById(wheelId);
			skateboard.setWheel(wheel);
		}
		
		status = Status.NOTHING;
		
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		if(qName.equalsIgnoreCase("skateboard")){
			skateboards.add(skateboard);
		}
		
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		if(qName.equalsIgnoreCase("skateboard")){
			skateboard = new Skateboard();
			
			if(skateboards==null){
				skateboards = new ArrayList<Skateboard>();
			}
		}else if(qName.equalsIgnoreCase("name")){
			status = Status.NAME;
		}else if(qName.equalsIgnoreCase("bearingId")){
			status = Status.BEARINGID;
		}else if(qName.equalsIgnoreCase("deckId")){
			status = Status.DECKID;
		}else if(qName.equalsIgnoreCase("griptapeId")){
			status = Status.GRIPTAPEID;
		}else if(qName.equalsIgnoreCase("truckId")){
			status = Status.TRUCKID;
		}else if(qName.equalsIgnoreCase("wheelId")){
			status = Status.WHEELID;
		}
		
	}

	public List<Skateboard> getSkateboards() {
		return skateboards;
	}

}
