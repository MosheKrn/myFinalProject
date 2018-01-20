package model;


public class Parent {

	
private  int parentID;
private String parentName;
private  int parentGrade;

public  int getParentID() {
	return parentID;
}
public void setParentID(int parentID) {
	this.parentID = parentID;
}

public void setParentGrade(int parentGrade) {
	this.parentGrade = parentGrade;
}

public int getParentGrade() {
	return parentGrade;
}

public String getParentName() {
	return parentName;
}
public void setParentName(String parentName) {
	this.parentName = parentName;
}

@Override
public String toString() {
    return "Parent [parentID=" + parentID + ", parentName=" + parentName + "parentGrade="+parentGrade+"]";
}

}

