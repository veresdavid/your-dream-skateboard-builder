package dao;
import java.util.List;

import models.Griptape;

public interface GriptapeDAO {
	
	public List<Griptape> getAllGriptapes();
	
	public Griptape getGriptapeById(String id);

}
