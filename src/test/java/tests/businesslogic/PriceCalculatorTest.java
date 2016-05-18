package tests.businesslogic;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import businesslogic.PriceCalculator;
import models.Bearing;
import models.Deck;
import models.Griptape;
import models.Skateboard;
import models.Truck;
import models.Wheel;

public class PriceCalculatorTest {

	private PriceCalculator priceCalculator;
	
	@Before
	public void setUp(){
		priceCalculator = new PriceCalculator();
	}
	
	@Test
	public void testCalculateBearingPrice(){
		
		Bearing bearing = null;
		assertEquals(0, priceCalculator.calculateBearingPrice(bearing));
		
		bearing = new Bearing();
		bearing.setPrice(1000);
		assertEquals(1000, priceCalculator.calculateBearingPrice(bearing));
		
	}
	
	@Test
	public void testCalculateDeckPrice(){
		
		Deck deck = null;
		assertEquals(0, priceCalculator.calculateDeckPrice(deck));
		
		deck = new Deck();
		deck.setPrice(2000);
		assertEquals(2000, priceCalculator.calculateDeckPrice(deck));
		
	}
	
	@Test
	public void testCalculateGriptapePrice(){
		
		Griptape griptape = null;
		assertEquals(0, priceCalculator.calculateGriptapePrice(griptape));
		
		griptape = new Griptape();
		griptape.setPrice(1000);
		assertEquals(1000, priceCalculator.calculateGriptapePrice(griptape));
		
	}
	
	@Test
	public void testCalculateTruckPrice(){
		
		Truck truck = null;
		assertEquals(0, priceCalculator.calculateTruckPrice(truck));
		
		truck = new Truck();
		truck.setPrice(2000);
		assertEquals(2000, priceCalculator.calculateTruckPrice(truck));
		
	}
	
	@Test
	public void testCalculateWheelPrice(){
		
		Wheel wheel = null;
		assertEquals(0, priceCalculator.calculateWheelPrice(wheel));
		
		wheel = new Wheel();
		wheel.setPrice(1000);
		assertEquals(1000, priceCalculator.calculateWheelPrice(wheel));
		
	}
	
	@Test
	public void testCalculateSkateboardPrice(){
		
		Skateboard skateboard = null;
		assertEquals(0, priceCalculator.calculateSkateboardPrice(skateboard));
		
		skateboard = new Skateboard();
		skateboard.setBearing(new Bearing());
		skateboard.getBearing().setPrice(1000);
		skateboard.setDeck(new Deck());
		skateboard.getDeck().setPrice(1000);
		skateboard.setGriptape(new Griptape());
		skateboard.getGriptape().setPrice(1000);
		skateboard.setTruck(new Truck());
		skateboard.getTruck().setPrice(1000);
		skateboard.setWheel(new Wheel());
		skateboard.getWheel().setPrice(1000);
		assertEquals(5000, priceCalculator.calculateSkateboardPrice(skateboard));
		
	}

}
