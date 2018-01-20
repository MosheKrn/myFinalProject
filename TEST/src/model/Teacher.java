package model;

public class Teacher {
	
	private  int teacherID;
	private String teacherName;


	public  int getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}

	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	@Override
	public String toString() {
	    return "Teacher [teacherID=" + teacherID + ", teacherName=" + teacherName + "]";
	}

	}



