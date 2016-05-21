package models;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Egy gördeszka lapot reprezentáló osztály.
 */
public class Deck {
	
	/**
	 * A lap azonosítója.
	 */
	private String id;
	/**
	 * A lap gyártójának neve.
	 */
	private String brand;
	/**
	 * A lap neve.
	 */
	private String name;
	/**
	 * A lap mérete inchben.
	 */
	private double size;
	/**
	 * A lap ára forintban.
	 */
	private int price;
	/**
	 * A lapot ábrázoló kép neve.
	 */
	private String image;

	/**
	 * Visszaadja a lap azonosítóját.
	 * 
	 * @return a lap azonosítója
	 */
	public String getId() {
		return id;
	}

	/**
	 * Beállítja a csapágy azonosítóját.
	 * 
	 * @param id az a {@code String}, ami a lap azonosítója lesz
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Visszaadja a lap gyártójának nevét.
	 * 
	 * @return a lap gyártójának neve
	 */
	public String getBrand() {
		return brand;
	}
	
	/**
	 * Beállítja a lap gyártójának nevét.
	 * 
	 * @param brand az a {@code String}, ami a lapt gyártójának neve lesz
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * Visszaadja a lap nevét.
	 * 
	 * @return a lap neve
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Beállítja a lap nevét.
	 * 
	 * @param name az a {@code String}, ami a lap neve lesz
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Visszaadja a lap méretét inchben.
	 * 
	 * @return a lap mérete inchben
	 */
	public double getSize() {
		return size;
	}
	
	/**
	 * Beállítja a lap méretét.
	 * 
	 * @param size az a {@code double} érték inchben, ami a lap mérete lesz
	 */
	public void setSize(double size) {
		this.size = size;
	}
	
	/**
	 * Visszaadja a lap árát forintban.
	 * 
	 * @return a lap ára forintban
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * Beállítja a lap árát.
	 * 
	 * @param price az az {@code int} érték forintban, ami a lap ára lesz
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	/**
	 * Visszaadja a lapot ábrázoló kép nevét.
	 * 
	 * @return a lapot ábrázoló kép neve
	 */
	public String getImage() {
		return image;
	}
	
	/**
	 * Beállítja a lapot ábrázoló kép nevét.
	 * 
	 * @param image az a {@code String}, ami a lapot ábrázoló kép neve lesz
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * A lap sztring reprezentációját adja vissza. Ennek előállításához az 
	 * {@code org.apache.commons.lang3.builder.ReflectionToStringBuilder} osztályt
	 * használjuk fel.
	 * 
	 * @return a lap sztring reprezentációja
	 */
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	/**
	 * Egy ember számára olvasható sztringet ad vissza, ami a lap azonosítóján
	 * és képének nevén kívül minden más adatot tartalmaz.
	 * 
	 * @return a lap sztring reprezentációja
	 */
	public String readableToString() {
		return brand + ", " + name + ", " + size + "\", " + price + "Ft";
	}

}
