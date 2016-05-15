package businesslogic;

import models.Deck;
import models.Griptape;
import models.Skateboard;
import models.Truck;

public class SkateboardValidator {

	public SkateboardValidator() {
	}
	
	public boolean isValidSkateboard(Skateboard skateboard){
		
		if(skateboard!=null){
			
			if(isCorrectName(skateboard.getName())
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
	
	public boolean isCorrectName(String name){
		
		if(name==null || name==""){
			return false;
		}else{
			return true;
		}
		
	}
	
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
