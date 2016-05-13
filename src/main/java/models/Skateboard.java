package models;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Skateboard {
	
	private String name;
	private Bearing bearing;
	private Deck deck;
	private Griptape griptape;
	private Truck truck;
	private Wheel wheel;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Bearing getBearing() {
		return bearing;
	}
	
	public void setBearing(Bearing bearing) {
		this.bearing = bearing;
	}
	
	public Deck getDeck() {
		return deck;
	}
	
	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
	public Griptape getGriptape() {
		return griptape;
	}
	
	public void setGriptape(Griptape griptape) {
		this.griptape = griptape;
	}
	
	public Truck getTruck() {
		return truck;
	}
	
	public void setTruck(Truck truck) {
		this.truck = truck;
	}
	
	public Wheel getWheel() {
		return wheel;
	}
	
	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
