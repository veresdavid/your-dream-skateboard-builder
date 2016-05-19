package models;

/**
 * Egy gördeszkát reprezentáló osztály.
 */
public class Skateboard {
	
	/**
	 * A gördeszka neve.
	 */
	private String name;
	/**
	 * A gördeszka csapágya.
	 */
	private Bearing bearing;
	/**
	 * A gördeszka lapja.
	 */
	private Deck deck;
	/**
	 * A gördeszka smirglije.
	 */
	private Griptape griptape;
	/**
	 * A gördeszka felfüggesztése.
	 */
	private Truck truck;
	/**
	 * A gördeszka kereke.
	 */
	private Wheel wheel;
	
	/**
	 * Visszaadja a gördeszka nevét.
	 * 
	 * @return a gördeszka neve
	 */
	public String getName() {
		return name;
	}

	/**
	 * Beállítja a gördeszka nevét.
	 * 
	 * @param name az a {@code String}, ami a gördeszka neve lesz
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Visszaadja a gördeszka csapágyát, egy {@link models.Bearing} objektumot.
	 * 
	 * @return a gördeszka csapágya, egy {@link models.Bearing} objektum
	 */
	public Bearing getBearing() {
		return bearing;
	}
	
	/**
	 * Beállítja a gördeszka csapágyát.
	 * 
	 * @param bearing az a {@link models.Bearing} objektum, ami a gördeszk csapágya lesz
	 */
	public void setBearing(Bearing bearing) {
		this.bearing = bearing;
	}
	
	/**
	 * Visszaadja a gördeszka lapját, egy {@link models.Deck} objektumot.
	 * 
	 * @return a gördeszka lapja, egy {@link models.Deck} objektum
	 */
	public Deck getDeck() {
		return deck;
	}
	
	/**
	 * Beállítja a gördeszka lapját.
	 * 
	 * @param deck az a {@link models.Deck} objektum, ami a gördeszka lapja lesz
	 */
	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
	/**
	 * Visszaadja a gördeszka smirglijét, egy {@link models.Griptape} objektumot.
	 * 
	 * @return a gördeszka smirglije, egy {@link models.Griptape} objektum
	 */
	public Griptape getGriptape() {
		return griptape;
	}
	
	/**
	 * Beállítja a gördeszka smirglijét.
	 * 
	 * @param griptape az a {@link models.Griptape} objektum, ami a gördeszka smirglije lesz
	 */
	public void setGriptape(Griptape griptape) {
		this.griptape = griptape;
	}
	
	/**
	 * Visszaadja a gördeszka felfüggesztését, egy {@link models.Truck} objektumot.
	 * 
	 * @return a gördeszka smirglije, egy {@link models.Truck} objektum
	 */
	public Truck getTruck() {
		return truck;
	}
	
	/**
	 * Beállítja a gördeszka felfüggesztését.
	 * 
	 * @param truck az a {@link models.Truck} objektum, ami a gördeszka felfüggesztése lesz
	 */
	public void setTruck(Truck truck) {
		this.truck = truck;
	}
	
	/**
	 * Visszaadja a gördeszka kerekét, egy {@link models.Wheel} objektumot.
	 * 
	 * @return a gördeszka kereke, egy {@link models.Wheel} objektum
	 */
	public Wheel getWheel() {
		return wheel;
	}
	
	/**
	 * Beállítja a gördeszka kerekét.
	 * 
	 * @param wheel az a {@link models.Wheel} objektum, ami a gördeszka kereke lesz
	 */
	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}

	/**
	 * Visszaadja a gördeszka nevét.
	 * 
	 * @return a gördeszka neve
	 */
	@Override
	public String toString() {
		return name;
	}

}
