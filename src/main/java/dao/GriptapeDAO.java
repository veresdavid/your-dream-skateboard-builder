package dao;
import java.util.List;

import models.Griptape;

/**
 * A smirglik ({@link models.Griptape}) kezeléséhez használható függvényeket tartalmazó
 * interfész.
 */
public interface GriptapeDAO {
	
	/**
	 * Visszaad egy listát, ami az összes rendelkezésre álló smirglit tartalmazza.
	 * 
	 * @return az összes smirglit tartalmazó lista
	 */
	public List<Griptape> getAllGriptapes();
	
	/**
	 * Visszaadja az általunk választott azonosítóval rendelkező smirglit.
	 * 
	 * @param id annak a smirglinek az azonosítója, amit meg szeretnénk kapni
	 * @return a választott azonosítóval rendelkező smirgli
	 */
	public Griptape getGriptapeById(String id);

}
