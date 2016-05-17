package dao;
import java.util.List;

import models.Wheel;

public interface WheelDAO {
	
	public List<Wheel> getAllWheels();
	
	public Wheel getWheelById(String id);

}
