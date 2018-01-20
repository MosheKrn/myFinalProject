package model;

public class Child {

	
private  int ChildID;
private String ChildName;
private  int ChildGrade;

public  int getChildID() {
	return ChildID;
}
public void setChildID(int ChildID) {
	this.ChildID = ChildID;
}

public  int getChildGrade() {
	return ChildGrade;
}
public void setChildGrade(int ChildGrade) {
	this.ChildGrade = ChildGrade;
}

public String getChildName() {
	return ChildName;
}
public void setChildName(String childName) {
	this.ChildName = childName;
}

@Override
public String toString() {
    return "Child [ChildID=" + ChildID + ", ChildName=" + ChildName + "]";
}

}
