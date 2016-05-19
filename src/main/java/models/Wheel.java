package models;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Egy kereket reprezentáló osztály.
 */
public class Wheel {
	
	/**
	 * A kerék azonosítója.
	 */
	private String id;
	/**
	 * A kerék gyártójának neve.
	 */
	private String brand;
	/**
	 * A kerék neve.
	 */
	private String name;
	/**
	 * A kerék ára forintban.
	 */
	private int size;
	/**
	 * A kerék mérete milliméterben.
	 */
	private int price;
	/**
	 * A kereket ábrázoló kép neve.
	 */
	private String image;
	
	/**
	 * Visszaadja a kerék azonosítóját.
	 * 
	 * @return a kerék azonosítója
	 */
	public String getId() {
		return id;
	}

	/**
	 * Beállítja a kerék azonosítóját.
	 * 
	 * @param id az a {@code String}, ami a kerék azonosítója lesz
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Visszaadja a kerék gyártójának nevét.
	 * 
	 * @return a kerék gyártójának neve
	 */
	public String getBrand() {
		return brand;
	}
	
	/**
	 * Beállítja a kerék gyártójának nevét.
	 * 
	 * @param brand az a {@code String}, ami a kerék azonosítójának neve lesz
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * Visszaadja a kerék nevét.
	 * 
	 * @return a kerék neve
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Beállítja a kerék nevét.
	 * 
	 * @param name az a {@code String}, ami a kerék neve lesz
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Visszaadja a kerék méretét milliméterben.
	 * 
	 * @return a kerék mérete milliméterben
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Beállítja a kerék méretét.
	 * 
	 * @param size az az {@code int} érték milliméterben, ami a kerék mérete lesz
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Visszaadja a kerék árát forintban.
	 * 
	 * @return a kerék ára forintban
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * Beállítja a kerék árát.
	 * 
	 * @param price az az {@code int} érték forintban, ami a kerék ára lesz
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	/**
	 * Visszaadja a kereket ábrázoló kép nevét.
	 * 
	 * @return a kereket ábrázoló kép neve
	 */
	public String getImage() {
		return image;
	}
	
	/**
	 * Beállítja a kereket ábrázoló kép nevét.
	 * 
	 * @param image az a {@code String}, ami a kereket ábrázoló kép neve lesz
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
	/**
	 * A kerék sztring reprezentációját adja vissza.
	 * 
	 * @return a kerék sztring reprezentációja
	 */
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	/**
	 * Egy ember számára olvasható sztringet ad vissza, ami a kerék azonosítóján
	 * és képének nevén kívül minden más adatot tartalmaz.
	 * 
	 * @return a kerék sztring reprezentációja
	 */
	public String readableToString() {
		return brand + ", " + name + ", " + size + "mm, " + price + "Ft";
	}

}
