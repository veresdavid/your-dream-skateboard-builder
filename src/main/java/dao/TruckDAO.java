package dao;
import java.util.List;

import models.Truck;

/**
 * A felfüggesztések ({@link models.Truck}) kezeléséhez használható függvényeket tartalmazó
 * interfész.
 */
public interface TruckDAO {
	
	/**
	 * Visszaad egy listát, ami az összes rendelkezésre álló felfüggesztést tartalmazza.
	 * 
	 * @return az összes smirglit tartalmazó lista
	 */
	public List<Truck> getAllTrucks();
	
	/**
	 * Visszaadja az általunk választott azonosítóval rendelkező felfüggesztést.
	 * 
	 * @param id annak a felfüggesztésnek az azonosítója, amit meg szeretnénk kapni
	 * @return a választott azonosítóval rendelkező felfüggesztés
	 */
	public Truck getTruckById(String id);

}
