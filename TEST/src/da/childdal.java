package da;

	import java.util.List;
    import model.Child;
    

	public interface childdal {
	
	
	//CRUD-Create
	public void addChild(Child child);

	//CRUD-Read
	public List <Child> getAllChildren();
	public Child getChildByID(int ChildID);
	
	//CRUD-Update
	public void updateChild(Child child);
	
	//CRUD-Delete
	public void deleteChild(int ChildID);

	

	
	
	
	
	}

