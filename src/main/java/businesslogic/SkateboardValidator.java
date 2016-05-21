package businesslogic;

import models.Deck;
import models.Griptape;
import models.Skateboard;
import models.Truck;

/**
 * Az osztály segít megállapítani, hogy egy gördeszkát helyesen állítottunk-e össze.
 */
public class SkateboardValidator {
	
	/**
	 * Ellenőrzi, hogy a paraméterként kapott gördeszka helyesen lett-e összeállítva.
	 * Ha a paraméter {@code null}, a függvény {@code false} értéket ad vissza.
	 * 
	 * @param skateboard egy gördeszka
	 * @return helyesen összeállított gördeszka esetén {@code true}, minden más esetben {@code false}
	 */
	public boolean isValidSkateboard(Skateboard skateboard){
		
		if(skateboard!=null){
			
			if(isCorrectName(skateboard.getName())
					&& isEveryAccessorySet(skateboard)
					&& isDeckFitsWithGriptape(skateboard.getDeck(), skateboard.getGriptape())
					&& isDeckFitsWithTruck(skateboard.getDeck(), skateboard.getTruck())){
				return true;
			}else{
				return false;
			}
			
		}else{
			return false;
		}
		
	}
	
	/**
	 * Ellenőrzi, hogy a paraméterként kapott gördeszka név megfelelő-e. Ez akkor
	 * teljesül, ha a gördeszka neve nem {@code null} vagy üres sztring.
	 * 
	 * @param name a gördeszka neve
	 * @return helyes név esetén {@code true}, minden más esetben {@code false}
	 */
	public boolean isCorrectName(String name){
		
		if(name==null || name.length()==0){
			return false;
		}else{
			return true;
		}
		
	}
	
	/**
	 * Ellenőrzi, hogy a paraméterként kapott gördeszka minden alkatrészét
	 * beállítottuk-e már.
	 * 
	 * @param skateboard a gördeszka, amit ellenőrizni akarunk
	 * @return {@code true}, ha minden alkatrészt beállítottunk, minden más esetben {@code false}
	 */
	public boolean isEveryAccessorySet(Skateboard skateboard){
		
		if(skateboard.getBearing()!=null
				&& skateboard.getDeck()!=null
				&& skateboard.getGriptape()!=null
				&& skateboard.getTruck()!=null
				&& skateboard.getWheel()!=null){
			return true;
		}else{
			return false;
		}
		
	}
	
	/**
	 * Ellenőrzi, hogy a paraméterként kapott lap és smirgli összeillenek-e. Ez akkor
	 * teljesül, ha a smirgli mérete nagyobb vagy egyenlő mint a lap mérete. Ha bármelyik
	 * paraméter {@code null}, a függvény {@code false} értéket ad vissza.
	 * 
	 * @param deck egy lap
	 * @param griptape egy smirgli
	 * @return {@code true}, ha a lap és smirgli összeillenek, minden más esetben {@code false}
	 */
	public boolean isDeckFitsWithGriptape(Deck deck, Griptape griptape){
		
		if(deck==null || griptape==null){
			return false;
		}else{
			if(griptape.getSize() >= deck.getSize()){
				return true;
			}else{
				return false;
			}
		}
		
	}
	
	/**
	 * Ellenőrzi, hogy a paraméterként kapott lap és felfüggesztés összeillenek-e. Ennek
	 * teljesüléséről az alábbi táblázat ad bővebb információt:
	 * <table summary="Összeillő felfüggesztésmodellek és lapméretek">
	 * <tr>
	 * <td><b>Felfüggesztésmodell</b></td>
	 * <td><b>Lapméret</b></td>
	 * </tr>
	 * <tr>
	 * <td>139</td>
	 * <td>7.8" - 8.2"</td>
	 * </tr>
	 * <tr>
	 * <td>149</td>
	 * <td>8.2" - 8.7"</td>
	 * </tr>
	 * <tr>
	 * <td>159</td>
	 * <td>8.6" - 9.0"</td>
	 * </tr>
	 * </table>
	 * Ha bármelyik paraméter {@code null}, a függvény {@code false} értéket ad vissza.
	 * 
	 * @param deck egy lap
	 * @param truck egy felfüggesztés
	 * @return {@code true}, ha a lap és felfüggesztés összeillenek, minden más esetben {@code false}
	 */
	public boolean isDeckFitsWithTruck(Deck deck, Truck truck){
		
		if(deck==null || truck==null){
			return false;
		}else{
			
			if(truck.getModel()==139 && (deck.getSize()>=7.8 && deck.getSize()<=8.2)){
				return true;
			}else if(truck.getModel()==149 && (deck.getSize()>=8.2 && deck.getSize()<=8.7)){
				return true;
			}else if(truck.getModel()==159 && (deck.getSize()>=8.6 && deck.getSize()<=9.0)){
				return true;
			}else{
				return false;
			}
			
		}
		
	}

}
