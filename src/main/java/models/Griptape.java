package models;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Egy smirglipapírt reprezentáló osztály.
 */
public class Griptape {
	
	/**
	 * A smirgli azonosítója.
	 */
	private String id;
	/**
	 * A smirgli gyártójának neve.
	 */
	private String brand;
	/**
	 * A smirgli neve.
	 */
	private String name;
	/**
	 * A smirgli mérete inchben.
	 */
	private double size;
	/**
	 * A smirgli ára forintban.
	 */
	private int price;
	/**
	 * A smirglit ábrázoló kép neve.
	 */
	private String image;
	
	/**
	 * Visszaadja a smirgli azonosítóját.
	 * 
	 * @return a smirgli azonosítója
	 */
	public String getId() {
		return id;
	}

	/**
	 * Beállítja a smirgli azonosítóját.
	 * 
	 * @param id az a {@code String}, ami a smirgli azonosítója lesz
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Visszaadja a smirgli gyártójának nevét.
	 * 
	 * @return a smirgli gyártójának neve
	 */
	public String getBrand() {
		return brand;
	}
	
	/**
	 * Beállítja a smirgli gyártójának nevét.
	 * 
	 * @param brand az a {@code String}, ami a smirgli gyártójának neve lesz
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * Visszaadja a smirgli nevét.
	 * 
	 * @return a smirgli neve
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Beállítja a smirgli nevét.
	 * 
	 * @param name az a {@code String}, ami a smirgli neve lesz
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Visszaadja a smirgli méretének nevét inchben.
	 * 
	 * @return a smirgli mérete inchben
	 */
	public double getSize() {
		return size;
	}
	
	/**
	 * Beállítja a smirgli méretét.
	 * 
	 * @param size az a {@code double} érték inchben, ami a smirgli mérete lesz
	 */
	public void setSize(double size) {
		this.size = size;
	}
	
	/**
	 * Visszaadja a smirgli árát forintban.
	 * 
	 * @return a smirgli ára forintban
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * Beállítja a smirgli árát.
	 * 
	 * @param price az a {@code int} érték forintban, ami a smirgli ára lesz
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	/**
	 * Visszaadja a smirglit ábrázoló kép nevét.
	 * 
	 * @return a smirglit ábrázoló kép neve
	 */
	public String getImage() {
		return image;
	}
	
	/**
	 * Beállítja a smirglit ábrázoló kép nevét.
	 * 
	 * @param image az a {@code String}, ami a smirglit ábrázoló kép neve lesz
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * A smirgli sztring reprezentációját adja vissza.
	 * 
	 * @return a smirgli sztring reprezentációja
	 */
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	/**
	 * Egy ember számára olvasható sztringet ad vissza, ami a smirgli azonosítóján
	 * és képének nevén kívül minden más adatot tartalmaz.
	 * 
	 * @return a smirgli sztring reprezentációja
	 */
	public String readableToString() {
		return brand + ", " + name + ", " + size + "\", " + price + "Ft";
	}

}
