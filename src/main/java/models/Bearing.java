package models;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Egy csapágyat renprezentáló osztály.
 */
public class Bearing {
	
	/**
	 * A csapágy azonosítója.
	 */
	private String id;
	/**
	 * A csapágy gyárójának neve.
	 */
	private String brand;
	/**
	 * A csapágy neve.
	 */
	private String name;
	/**
	 * A csapágy kategóriája.
	 */
	private String category;
	/**
	 * A csapágy ára forintban.
	 */
	private int price;
	/**
	 * A csapágyat ábrázoló kép neve.
	 */
	private String image;
	
	/**
	 * Visszaadja a csapágy azonosítóját.
	 * 
	 * @return a csapágy azonosítója
	 */
	public String getId() {
		return id;
	}

	/**
	 * Módosítja a csapágy azonosítóját.
	 * 
	 * @param id az a {@code String}, ami a csapágy azonosítója lesz
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Visszaadja a csapágy gyártójának nevét.
	 * 
	 * @return a csapágy gyártójának neve
	 */
	public String getBrand() {
		return brand;
	}
	
	/**
	 * Módosítja a csapágy gyártójának nevét.
	 * 
	 * @param brand az a {@code String}, ami a csapágy gyártójának neve lesz
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * Visszaadja a csapágy nevét.
	 * 
	 * @return a csapágy neve
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Beállítja a csapágy nevét.
	 * 
	 * @param name az a {@code String}, ami a csapágy neve lesz
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Visszaadja a csapágy kategóriáját.
	 * 
	 * @return a csapágy kategóriája
	 */
	public String getCategory() {
		return category;
	}
	
	/**
	 * Beállítja a csapágy kategóriáját.
	 * 
	 * @param category az a {@code String}, ami a csapágy kategóriája lesz
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	
	/**
	 * Visszaadja a csapágy árát forintban.
	 * 
	 * @return a csapágy ára forintban
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * Beállítja a csapágy árát.
	 * 
	 * @param price az az {@code int} érték forintban, ami a csapágy ára lesz
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	/**
	 * Visszadja a csapágyat ábrázoló kép nevét.
	 * 
	 * @return a csapágyat ábrázoló kép neve
	 */
	public String getImage() {
		return image;
	}
	
	/**
	 * Beállítja a csapágyat ábrázoló kép nevét.
	 * 
	 * @param image az a {@code String}, ami a csapágyat ábrázoló kép neve lesz
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
	/**
	 * A csapágy sztring reprezentációját adja vissza.
	 * 
	 * @return a csapágy sztring reprezentációja
	 */
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
	/**
	 * Egy ember számára olvasható sztringet ad vissza, ami a csapágy azonosítóján
	 * és képének nevén kívül minden más adatot tartalmaz.
	 * 
	 * @return a csapágy sztring reprezentációja
	 */
	public String readableToString(){
		return brand + ", " + name + ", " + category + ", " + price + "Ft"; 
	}

}
