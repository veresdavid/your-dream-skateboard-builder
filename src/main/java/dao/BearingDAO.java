package dao;
import java.util.List;

import models.Bearing;

public interface BearingDAO {
	
	public List<Bearing> getAllBearings();
	
	public Bearing getBearingById(String id);

}
