package dao;

import models.Order;

/**
 * A rendelések ({@link models.Order}) kezeléséhez használható függvényeket tartalmazó
 * interfész.
 */
public interface OrderDAO {
	
	/**
	 * Elmenti a paraméterként megadott rendelést.
	 * 
	 * @param order az a rendelés, amit el szeretnénk menteni
	 */
	public void saveOrder(Order order);

}
