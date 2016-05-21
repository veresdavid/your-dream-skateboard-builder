package dao;

import java.util.List;

import models.Skateboard;

/**
 * A gördeszkák ({@link models.Skateboard}) kezeléséhez használható függvényeket tartalmazó
 * interfész.
 */
public interface SkateboardDAO {
	
	/**
	 * Visszaad egy listát, ami az összes rendelkezésre álló gördeszkát tartalmazza.
	 * 
	 * @return az összes gördeszkát tartalmazó lista
	 */
	public List<Skateboard> getAllSkateboards();
	
	/**
	 * Egy új gördeszka felvétele az adatbázisba.
	 * 
	 * @param skateboard az a gördeszka, amit fel akarunk venni az adatbázisba
	 */
	public void insert(Skateboard skateboard);

}
