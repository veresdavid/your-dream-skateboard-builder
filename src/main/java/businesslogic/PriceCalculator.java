package businesslogic;

import models.Bearing;
import models.Deck;
import models.Griptape;
import models.Skateboard;
import models.Truck;
import models.Wheel;

public class PriceCalculator {

	public PriceCalculator() {
	}
	
	public int calculateBearingPrice(Bearing bearing){
		
		if(bearing!=null){
			return bearing.getPrice();
		}else{
			return 0;
		}
		
	}
	
	public int calculateDeckPrice(Deck deck){
		
		if(deck!=null){
			return deck.getPrice();
		}else{
			return 0;
		}
		
	}
	
	public int calculateGriptapePrice(Griptape griptape){
		
		if(griptape!=null){
			return griptape.getPrice();
		}else{
			return 0;
		}
		
	}
	
	public int calculateTruckPrice(Truck truck){
		
		if(truck!=null){
			return truck.getPrice();
		}else{
			return 0;
		}
		
	}
	
	public int calculateWheelPrice(Wheel wheel){
		
		if(wheel!=null){
			return wheel.getPrice();
		}else{
			return 0;
		}
		
	}
	
	public int calculateSkateboardPrice(Skateboard skateboard){
		
		if(skateboard!=null){
			return calculateBearingPrice(skateboard.getBearing())
					+ calculateDeckPrice(skateboard.getDeck())
					+ calculateGriptapePrice(skateboard.getGriptape())
					+ calculateTruckPrice(skateboard.getTruck())
					+ calculateWheelPrice(skateboard.getWheel());
		}else{
			return 0;
		}
		
	}

}
