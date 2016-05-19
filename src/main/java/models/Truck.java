package models;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Egy felfüggesztést reprezentáló osztály.
 */
public class Truck {
	
	/**
	 * A felfüggesztés azonosítója.
	 */
	private String id;
	/**
	 * A felfüggesztés gyártójának neve.
	 */
	private String brand;
	/**
	 * A felfüggesztés neve.
	 */
	private String name;
	/**
	 * A felfüggesztés modellszáma.
	 */
	private int model;
	/**
	 * A felfüggesztés ára forintban.
	 */
	private int price;
	/**
	 * A felfüggesztést ábrázoló kép neve.
	 */
	private String image;
	
	/**
	 * Visszaadja a felfüggesztés azonosítóját.
	 * 
	 * @return a felfüggesztés azonosítója
	 */
	public String getId() {
		return id;
	}

	/**
	 * Beállítja a felfüggesztés azonosítóját.
	 * 
	 * @param id az a {@code String}, ami a felfüggesztés azonosítója lesz
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Vissaadja a felfüggesztés gyártójának nevét.
	 * 
	 * @return a felfüggesztés gyártójának neve
	 */
	public String getBrand() {
		return brand;
	}
	
	/**
	 * Beállítja a felfüggesztés gyártójának nevét.
	 * 
	 * @param brand az a {@code String}, ami a felfüggesztés gyártójának neve lesz
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * Visszaadja a felfüggesztés nevét.
	 * 
	 * @return a felfüggesztés neve
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Beállítja a felfüggesztés nevét.
	 * 
	 * @param name az a {@code String}, ami a felfüggesztés neve lesz.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Visszaadja a felfüggesztés modellszámát.
	 * 
	 * @return a felfüggesztés modellszáma
	 */
	public int getModel() {
		return model;
	}

	/**
	 * Beállítja a felfüggesztés modellszámát.
	 * 
	 * @param model az az {@code int} érték, ami a felfüggesztés modellszáma lesz
	 */
	public void setModel(int model) {
		this.model = model;
	}

	/**
	 * Visszaadja a felfüggesztés árát forintban.
	 * 
	 * @return a felfüggesztés ára forintban
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * Beállítja a felfüggesztés árát.
	 * 
	 * @param price az az {@code int} érték, ami a felfüggesztés ára lesz
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	/**
	 * Visszaadja a felfüggesztést ábrázoló kép nevét.
	 * 
	 * @return a felfüggesztést ábrázoló kép neve
	 */
	public String getImage() {
		return image;
	}
	
	/**
	 * Beállítja a felfüggesztést ábrázoló kép nevét.
	 * 
	 * @param image az a {@code String}, ami a felfüggesztést ábrázoló kép neve lesz
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
	/**
	 * A felfüggesztés sztring reprezentációját adja vissza.
	 * 
	 * @return a felfüggesztés sztring reprezentációja
	 */
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	/**
	 * Egy ember számára olvasható sztringet ad vissza, ami a felfüggesztés azonosítóján
	 * és képének nevén kívül minden más adatot tartalmaz.
	 * 
	 * @return a felfüggesztés sztring reprezentációja
	 */
	public String readableToString() {
		return brand + ", " + name + ", " + model + ", " + price + "Ft";
	}

}
