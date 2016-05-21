package businesslogic;

import models.Order;

/**
 * Az osztály segít megállapítani, hogy egy rendelést helyesen állítottunk-e össze.
 */
public class OrderValidator {
	
	/**
	 * Ezzel az objektummal fogjuk ellenőrizni, hogy a rendelésben szereplő gördeszka
	 * helyesen lett-e összeállítva.
	 */
	private SkateboardValidator skateboardValidator;

	/**
	 * Egy egyszerű konstruktor, létrehozza a {@code skateboardValidator} objektumot.
	 */
	public OrderValidator() {
		
		skateboardValidator = new SkateboardValidator();
		
	}
	
	/**
	 * Ellenőrzi, hogy a paraméterként kapott rendelést helyesn állították-e össze.
	 * Ha a paraméter {@code null}, a függvény {@code false} értéket ad vissza.
	 * 
	 * @param order egy rendelés
	 * @return helyesen összeállított rendelés esetén {@code true}, minden más esetben {@code false}
	 */
	public boolean isValidOrder(Order order){
		
		if(order!=null){
			
			if(skateboardValidator.isValidSkateboard(order.getSkateboard())
					&& isNotNullOrEmptyString(order.getCustomerName())
					&& isNotNullOrEmptyString(order.getCustomerAddress())
					&& isNotNullOrEmptyString(order.getCustomerPhone())
					&& isNotNullOrEmptyString(order.getCustomerEmail())
					&& order.getCustomerComment()!=null){
				return true;
			}else{
				return false;
			}
			
		}else{
			return false;
		}
		
	}
	
	/**
	 * A függvény csak akkor tér vissza {@code true} értékkel, ha a paraméterként megkapott
	 * sztring nem {@code null} vagy nem üres.
	 * 
	 * @param string egy sztring
	 * @return {@code null} vagy üres sztring esetén {@code false}, minden más esetben {@code true}
	 */
	public boolean isNotNullOrEmptyString(String string){
		
		if(string==null || string.length()==0){
			return false;
		}else{
			return true;
		}
		
	}

}
