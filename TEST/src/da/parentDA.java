package da;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Parent;
import util.dbUtil;

public class parentDA  implements parentdal {

	private Connection conn;
	
	public parentDA(){
	
	conn=dbUtil.getConnection();
	
	}
	
	
	@Override
	public void addParent(Parent parent) {
	try{
	String query="INSERT INTO public.parent (parent_id, parent_name, parent_grade) VALUES (?,?,?)";
	PreparedStatement preparedStatement = conn.prepareStatement(query);
	
	preparedStatement.setInt(1, parent.getParentID());
	preparedStatement.setString(2, parent.getParentName());
	preparedStatement.setInt(3, parent.getParentGrade());
	
	preparedStatement.executeUpdate();
	preparedStatement.close();
	}
	catch(SQLException e)
	{
	System.out.println(e.getMessage());
	}

	}

	@Override
	public List<Parent> getAllParents() {
	List<Parent> Parents = new ArrayList<Parent>();
	
	try
	{
	String query = "SELECT * FROM public.parent";	
	Statement statement = conn.createStatement();
	
	ResultSet ParentsTable = statement.executeQuery(query);
	
	while(ParentsTable.next()){
	Parent pa = new Parent();
	pa.setParentID(ParentsTable.getInt("parent_id"));
	pa.setParentName(ParentsTable.getString("parent_name"));
	pa.setParentGrade(ParentsTable.getInt("parent_grade"));
	
	Parents.add(pa);
	}
	}
	catch (SQLException e) 
	{
	System.out.println(e.getMessage()); 
	}
	return Parents;
	}

	
	
	
	
	@Override
	public Parent getParentByID(int parentID) {
	
	Parent newParent = new Parent();
	
	try
	{
	String query = "SELECT * FROM public.parent WHERE Parent_id='"+parentID+"'";	
	
	Statement statement = conn.createStatement();
	
	ResultSet parentsStatement = statement.executeQuery(query);
	
	
	while(parentsStatement.next()){
	newParent.setParentID(parentsStatement.getInt("parent_id"));
	newParent.setParentName(parentsStatement.getString("parent_name"));
	newParent.setParentGrade(parentsStatement.getInt("parent_grade"));
	
	}
	
	}
	catch (SQLException e) 
	{
	System.out.println(e.getMessage()); 
	}
	
	
	return newParent;
	
	}

	
	
	@Override
	public void updateParent (Parent parent) {
	
	try
	{
	String query = "UPDATE  public.parent SET parent_name= ? parent_grade= ? where parent_id=?";
	
        PreparedStatement preparedStatement = conn.prepareStatement(query);
	
	
	preparedStatement.setString(1,parent.getParentName());
	preparedStatement.setInt(2,parent.getParentGrade());
	preparedStatement.setInt(3,parent.getParentID());
	
	preparedStatement.executeUpdate();
	preparedStatement.close();
	
	}
	catch (SQLException e) 
	{
	System.out.println(e.getMessage()); 
	}
	
	

	}

	@Override
	public void deleteParent(int ParentID) {
	
	try
	{
	String query = "DELETE FROM public.parent WHERE parent_id= ? ";	
	
	PreparedStatement preparedStatement = conn.prepareStatement(query);
	
	preparedStatement.setInt(1,ParentID );
	
	preparedStatement.executeUpdate();
	
	}
	catch (SQLException e) 
	{
	System.out.println(e.getMessage()); 
	}
	
	}


	
}
