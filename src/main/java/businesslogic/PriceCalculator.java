package businesslogic;

import models.Bearing;
import models.Deck;
import models.Griptape;
import models.Skateboard;
import models.Truck;
import models.Wheel;

/**
 * Az egyes alkatrészek, és egy komplett gördeszka árának meghatározásához használt
 * osztály. Az árakat forintban kell érteni.
 */
public class PriceCalculator {
	
	/**
	 * Meghatározza a paraméterként megkapott csapágy árát. Ha {@code null} értéket
	 * kap a függvény, az ár 0 forint lesz.
	 * 
	 * @param bearing az a csapágy, aminek meg akarjuk határozni az árát
	 * @return a csapágy ára forintban
	 */
	public int calculateBearingPrice(Bearing bearing){
		
		if(bearing!=null){
			return bearing.getPrice();
		}else{
			return 0;
		}
		
	}
	
	/**
	 * Meghatározza a paraméterként megkapott lap árát. Ha {@code null} értéket
	 * kap a függvény, az ár 0 forint lesz.
	 * 
	 * @param deck az a lap, aminek meg akarjuk határozni az árát
	 * @return a lap ára forintban
	 */
	public int calculateDeckPrice(Deck deck){
		
		if(deck!=null){
			return deck.getPrice();
		}else{
			return 0;
		}
		
	}
	
	/**
	 * Meghatározza a paraméterként megkapott smirgli árát. Ha {@code null} értéket
	 * kap a függvény, az ár 0 forint lesz.
	 * 
	 * @param griptape az a smirgli, aminek meg akarjuk határozni az árát
	 * @return a smirgli ára forintban
	 */
	public int calculateGriptapePrice(Griptape griptape){
		
		if(griptape!=null){
			return griptape.getPrice();
		}else{
			return 0;
		}
		
	}
	
	/**
	 * Meghatározza a paraméterként megkapott felfüggesztés árát. Ha {@code null} értéket
	 * kap a függvény, az ár 0 forint lesz.
	 * 
	 * @param truck az a felfüggesztés, aminek meg akarjuk határozni az árát
	 * @return a felfüggesztés ára forintban
	 */
	public int calculateTruckPrice(Truck truck){
		
		if(truck!=null){
			return truck.getPrice();
		}else{
			return 0;
		}
		
	}
	
	/**
	 * Meghatározza a paraméterként megkapott kerék árát. Ha {@code null} értéket
	 * kap a függvény, az ár 0 forint lesz.
	 * 
	 * @param wheel az a kerék, aminek meg akarjuk határozni az árát
	 * @return a kerék ára forintban
	 */
	public int calculateWheelPrice(Wheel wheel){
		
		if(wheel!=null){
			return wheel.getPrice();
		}else{
			return 0;
		}
		
	}
	
	/**
	 * Meghatározza a paraméterként megkapott gördeszka árát. Ehhez összeadjuk a
	 * gördeszka minden alkatrészének árát. Ha {@code null} értéket kap a függvény,
	 * az ár 0 forint lesz.
	 * 
	 * @param skateboard az a gördeszka, aminek meg akarjuk határozni az árát
	 * @return a gördeszka ára forintban
	 */
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
