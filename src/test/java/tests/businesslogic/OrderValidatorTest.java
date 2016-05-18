package tests.businesslogic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import businesslogic.OrderValidator;
import models.Bearing;
import models.Deck;
import models.Griptape;
import models.Order;
import models.Skateboard;
import models.Truck;
import models.Wheel;

public class OrderValidatorTest {

	private OrderValidator orderValidator;
	
	@Before
	public void setUp(){
		orderValidator = new OrderValidator();
	}
	
	@Test
	public void testIsNotNullOrEmptyString(){
		
		String string = null;
		assertFalse(orderValidator.isNotNullOrEmptyString(string));
		
		string = new String("");
		assertFalse(orderValidator.isNotNullOrEmptyString(string));
		
		string = new String("String");
		assertTrue(orderValidator.isNotNullOrEmptyString(string));
		
	}
	
	@Test
	public void testIsValidOrder(){
		
		Order order = null;
		assertFalse(orderValidator.isValidOrder(order));
		
		order = new Order();
		assertFalse(orderValidator.isValidOrder(order));
		
		order.setSkateboard(new Skateboard());
		order.getSkateboard().setName("JUnit Skateboard");
		order.getSkateboard().setBearing(new Bearing());
		order.getSkateboard().setDeck(new Deck());
		order.getSkateboard().getDeck().setSize(8.0);
		order.getSkateboard().setGriptape(new Griptape());
		order.getSkateboard().getGriptape().setSize(8.0);
		order.getSkateboard().setTruck(new Truck());
		order.getSkateboard().getTruck().setModel(139);
		order.getSkateboard().setWheel(new Wheel());
		assertFalse(orderValidator.isValidOrder(order));
		
		order.setCustomerName("Customer");
		assertFalse(orderValidator.isValidOrder(order));
		
		order.setCustomerAddress("Address");
		assertFalse(orderValidator.isValidOrder(order));
		
		order.setCustomerPhone("Phone");
		assertFalse(orderValidator.isValidOrder(order));
		
		order.setCustomerEmail("Email");
		assertFalse(orderValidator.isValidOrder(order));
		
		order.setCustomerComment(new String());
		assertTrue(orderValidator.isValidOrder(order));
		
		order.setCustomerComment("Comment");
		assertTrue(orderValidator.isValidOrder(order));
		
	}

}
