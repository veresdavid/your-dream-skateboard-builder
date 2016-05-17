package dao;

import java.util.List;

import models.Skateboard;

public interface SkateboardDAO {
	
	public List<Skateboard> getAllSkateboards();
	
	public void insert(Skateboard skateboard);

}
