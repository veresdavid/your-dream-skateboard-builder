package dao;
import java.util.List;

import models.Wheel;

/**
 * A kerekek ({@link models.Wheel}) kezeléséhez használható függvényeket tartalmazó
 * interfész.
 */
public interface WheelDAO {
	
	/**
	 * Visszaad egy listát, ami az összes rendelkezésre álló kereket tartalmazza.
	 * 
	 * @return az összes kereket tartalmazó lista
	 */
	public List<Wheel> getAllWheels();
	
	/**
	 * Visszaadja az általunk választott azonosítóval rendelkező kereket.
	 * 
	 * @param id annak a keréknek az azonosítója, amit meg szeretnénk kapni
	 * @return a választott azonosítóval rendelkező kerék
	 */
	public Wheel getWheelById(String id);

}
