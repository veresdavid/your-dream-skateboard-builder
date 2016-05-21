package dao;
import java.util.List;

import models.Bearing;

/**
 * A csapágyak ({@link models.Bearing}) kezeléséhez használható függvényeket tartalmazó interfész.
 */
public interface BearingDAO {
	
	/**
	 * Visszaad egy listát, ami az összes rendelkezésre álló csapágyat tartalmazza.
	 * 
	 * @return az összes csapágyat tartalmazó lista
	 */
	public List<Bearing> getAllBearings();
	
	/**
	 * Visszaadja az általunk választott azonosítóval rendelkező csapágyat.
	 * 
	 * @param id annak a csapágynak az azonosítója, amit meg szeretnénk kapni
	 * @return a választott azonosítóval rendelkező csapágy
	 */
	public Bearing getBearingById(String id);

}
