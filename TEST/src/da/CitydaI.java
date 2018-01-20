package da;

import java.util.List;
import model.city;

public interface CitydaI {
	
	//CRUD-Create
	public void addCity(city city);
	
	//CRUstD-Read
	public List<city> getAllcitys();
	public city getCityByID(int cityid);
	
	//CRUstD-Update
	public void updateCity(city city);
	
	//CRUstD-Delete
	public void deleteCity(int cityid);
	
	

}
