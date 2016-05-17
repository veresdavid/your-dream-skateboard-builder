package businesslogic;

import models.Order;

public class OrderValidator {
	
	private SkateboardValidator skateboardValidator;

	public OrderValidator() {
		
		skateboardValidator = new SkateboardValidator();
		
	}
	
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
	
	public boolean isNotNullOrEmptyString(String string){
		
		if(string==null || string.length()==0){
			return false;
		}else{
			return true;
		}
		
	}

}
