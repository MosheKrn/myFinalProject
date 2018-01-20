package da;


import java.util.List;
import model.Parent;


public interface parentdal {
	
	
	//CRUD-Create
	public void addParent(Parent parent);

	//CRUD-Read
	public List <Parent> getAllParents();
	public Parent getParentByID(int ParentID);
	
	//CRUD-Update
	public void updateParent(Parent parent);
	
	//CRUD-Delete
	public void deleteParent(int ParentID);

	

	
	
	
	
}
