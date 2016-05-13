package models;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Truck {
	
	private String id;
	private String brand;
	private String name;
	private int model;
	private int price;
	private String image;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getModel() {
		return model;
	}

	public void setModel(int model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
