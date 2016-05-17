package dao;
import java.util.List;

import models.Truck;

public interface TruckDAO {
	
	public List<Truck> getAllTrucks();
	
	public Truck getTruckById(String id);

}
