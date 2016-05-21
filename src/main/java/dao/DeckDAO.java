package dao;
import java.util.List;

import models.Deck;

/**
 * A lapok ({@link models.Deck}) kezeléséhez használható függvényeket tartalmazó interfész.
 */
public interface DeckDAO {
	
	/**
	 * Visszaad egy listát, ami az összes rendelkezésre álló lapot tartalmazza.
	 * 
	 * @return az összes lapot tartalmazó lista
	 */
	public List<Deck> getAllDecks();
	
	/**
	 * Visszaadja az általunk választott azonosítóval rendelkező lapot.
	 * 
	 * @param id annak a lapnak az azonosítója, amit meg szeretnénk kapni
	 * @return a választott azonosítóval rendelkező lap
	 */
	public Deck getDeckById(String id);

}
