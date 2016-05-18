package tests.businesslogic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import businesslogic.SkateboardValidator;
import models.Bearing;
import models.Deck;
import models.Griptape;
import models.Skateboard;
import models.Truck;
import models.Wheel;

public class SkateboardValidatorTest {

	private SkateboardValidator skateboardValidator;
	
	@Before
	public void setUp(){
		skateboardValidator = new SkateboardValidator();
	}
	
	@Test
	public void testIsCorrectName(){
		
		Skateboard skateboard = new Skateboard();
		assertFalse(skateboardValidator.isCorrectName(skateboard.getName()));
		
		skateboard.setName("");
		assertFalse(skateboardValidator.isCorrectName(skateboard.getName()));
		
		skateboard.setName("JUnit Skateboard");
		assertTrue(skateboardValidator.isCorrectName(skateboard.getName()));
		
	}
	
	@Test
	public void testIsEveryAccessorySet(){
		
		Skateboard skateboard = new Skateboard();
		assertFalse(skateboardValidator.isEveryAccessorySet(skateboard));
		
		skateboard.setBearing(new Bearing());
		assertFalse(skateboardValidator.isEveryAccessorySet(skateboard));
		
		skateboard.setDeck(new Deck());
		assertFalse(skateboardValidator.isEveryAccessorySet(skateboard));
		
		skateboard.setGriptape(new Griptape());
		assertFalse(skateboardValidator.isEveryAccessorySet(skateboard));
		
		skateboard.setTruck(new Truck());
		assertFalse(skateboardValidator.isEveryAccessorySet(skateboard));
		
		skateboard.setWheel(new Wheel());
		assertTrue(skateboardValidator.isEveryAccessorySet(skateboard));
		
	}
	
	@Test
	public void testIsDeckFitsWithGriptape(){
		
		Deck deck = null;
		Griptape griptape = null;
		assertFalse(skateboardValidator.isDeckFitsWithGriptape(deck, griptape));
		
		deck = new Deck();
		assertFalse(skateboardValidator.isDeckFitsWithGriptape(deck, griptape));
		
		deck = null;
		griptape = new Griptape();
		assertFalse(skateboardValidator.isDeckFitsWithGriptape(deck, griptape));
		
		deck = new Deck();
		deck.setSize(8.0);
		griptape.setSize(7.9);
		assertFalse(skateboardValidator.isDeckFitsWithGriptape(deck, griptape));
		
		griptape.setSize(8.0);
		assertTrue(skateboardValidator.isDeckFitsWithGriptape(deck, griptape));
		
	}
	
	@Test
	public void testIsDeckFitsWithTruck(){
		
		Deck deck = null;
		Truck truck = null;
		assertFalse(skateboardValidator.isDeckFitsWithTruck(deck, truck));
		
		deck = new Deck();
		assertFalse(skateboardValidator.isDeckFitsWithTruck(deck, truck));
		
		deck = null;
		truck = new Truck();
		assertFalse(skateboardValidator.isDeckFitsWithTruck(deck, truck));
		
		deck = new Deck();
		
		truck.setModel(139);
		deck.setSize(7.7);
		assertFalse(skateboardValidator.isDeckFitsWithTruck(deck, truck));
		deck.setSize(8.3);
		assertFalse(skateboardValidator.isDeckFitsWithTruck(deck, truck));
		deck.setSize(7.8);
		assertTrue(skateboardValidator.isDeckFitsWithTruck(deck, truck));
		deck.setSize(8.2);
		assertTrue(skateboardValidator.isDeckFitsWithTruck(deck, truck));
		
		truck.setModel(149);
		deck.setSize(8.1);
		assertFalse(skateboardValidator.isDeckFitsWithTruck(deck, truck));
		deck.setSize(8.8);
		assertFalse(skateboardValidator.isDeckFitsWithTruck(deck, truck));
		deck.setSize(8.2);
		assertTrue(skateboardValidator.isDeckFitsWithTruck(deck, truck));
		deck.setSize(8.7);
		assertTrue(skateboardValidator.isDeckFitsWithTruck(deck, truck));
		
		truck.setModel(159);
		deck.setSize(8.5);
		assertFalse(skateboardValidator.isDeckFitsWithTruck(deck, truck));
		deck.setSize(9.1);
		assertFalse(skateboardValidator.isDeckFitsWithTruck(deck, truck));
		deck.setSize(8.6);
		assertTrue(skateboardValidator.isDeckFitsWithTruck(deck, truck));
		deck.setSize(9.0);
		assertTrue(skateboardValidator.isDeckFitsWithTruck(deck, truck));
		
	}
	
	@Test
	public void testIsValidSkateboard(){
		
		Skateboard skateboard = null;
		assertFalse(skateboardValidator.isValidSkateboard(skateboard));
		
		skateboard = new Skateboard();
		assertFalse(skateboardValidator.isValidSkateboard(skateboard));
		
		skateboard.setName("JUnit Skateboard");
		assertFalse(skateboardValidator.isValidSkateboard(skateboard));
		
		skateboard.setBearing(new Bearing());
		skateboard.setDeck(new Deck());
		skateboard.setGriptape(new Griptape());
		skateboard.setTruck(new Truck());
		skateboard.setWheel(new Wheel());
		assertFalse(skateboardValidator.isValidSkateboard(skateboard));
		
		skateboard.getDeck().setSize(8.25);
		skateboard.getGriptape().setSize(8.0);
		assertFalse(skateboardValidator.isValidSkateboard(skateboard));
		
		skateboard.getDeck().setSize(8.0);
		assertFalse(skateboardValidator.isValidSkateboard(skateboard));
		
		skateboard.getTruck().setModel(149);
		assertFalse(skateboardValidator.isValidSkateboard(skateboard));
		
		skateboard.getTruck().setModel(139);
		assertTrue(skateboardValidator.isValidSkateboard(skateboard));
		
	}

}
