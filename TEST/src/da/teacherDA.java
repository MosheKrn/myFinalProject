package da;


	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;
    import model.Teacher;
    import util.dbUtil;

	public class teacherDA  implements teacherdal {

		private Connection conn;
		
		public teacherDA(){
		
		conn=dbUtil.getConnection();
		
		}
		
		
		@Override
		public void addTeacher(Teacher teacher) {
		try{
		String query="INSERT INTO public.teacher (teacher_id, teacher_name) VALUES (?,?)";
		PreparedStatement preparedStatement = conn.prepareStatement(query);
		
		preparedStatement.setInt(1, teacher.getTeacherID());
		preparedStatement.setString(2, teacher.getTeacherName());
		
		preparedStatement.executeUpdate();
		preparedStatement.close();
		}
		catch(SQLException e)
		{
		System.out.println(e.getMessage());
		}

		}

		@Override
		public List<Teacher> getAllTeachers() {
		List<Teacher> Teachers = new ArrayList<Teacher>();
		
		try
		{
		String query = "SELECT * FROM public.teacher";	
		Statement statement = conn.createStatement();
		
		ResultSet teachersTable = statement.executeQuery(query);
		
		while(teachersTable.next()){
		Teacher te = new Teacher();
		te.setTeacherID(teachersTable.getInt("teacher_id"));
		te.setTeacherName(teachersTable.getString("teacher_name"));
		
		Teachers.add(te);
		}
		}
		catch (SQLException e) 
		{
		System.out.println(e.getMessage()); 
		}
		return Teachers;
		}

		
		
		
		
		@Override
		public Teacher getTeacherByID(int teacherID) {
		
		Teacher newTeacher = new Teacher();
		
		try
		{
		String query = "SELECT * FROM public.teacher WHERE teacher_id='"+teacherID+"'";	
		
		Statement statement = conn.createStatement();
		
		ResultSet parentsStatement = statement.executeQuery(query);
		
		
		while(parentsStatement.next()){
		newTeacher.setTeacherID(parentsStatement.getInt("teacher_id"));
		newTeacher.setTeacherName(parentsStatement.getString("teacher_name"));
		
		}
		
		}
		catch (SQLException e) 
		{
		System.out.println(e.getMessage()); 
		}
		
		
		return newTeacher;
		
		}

		
		
		@Override
		public void updateTeacher (Teacher teacher) {
		
		try
		{
		String query = "UPDATE  public.teacher SET teacher_name= ? where teacher_id=?";
		
	    PreparedStatement preparedStatement = conn.prepareStatement(query);
		
		preparedStatement.setString(1,teacher.getTeacherName());
		preparedStatement.setInt(2,teacher.getTeacherID());
		
		preparedStatement.executeUpdate();
		preparedStatement.close();
		
		}
		catch (SQLException e) 
		{
		System.out.println(e.getMessage()); 
		}
		
		

		}

		@Override
		public void deleteTeacher(int TeacherID) {
		
		try
		{
		String query = "DELETE FROM public.teacher WHERE teacher_id= ? ";	
		
		PreparedStatement preparedStatement = conn.prepareStatement(query);
		
		preparedStatement.setInt(1,TeacherID );
		
		preparedStatement.executeUpdate();
		
		}
		catch (SQLException e) 
		{
		System.out.println(e.getMessage()); 
		}
		
		}


		


		
	}



