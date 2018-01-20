package da;

import java.util.List;

import model.Teacher;


public interface teacherdal {
	//CRUD-Create
		public void addTeacher(Teacher teacher);

		//CRUD-Read
		public List <Teacher> getAllTeachers();
		public Teacher getTeacherByID(int Teacher);
		
		//CRUD-Update
		public void updateTeacher(Teacher teacher);
		
		//CRUD-Delete
		public void deleteTeacher(int TeacherID);


}
