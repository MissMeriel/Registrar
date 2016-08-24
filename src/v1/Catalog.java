package v1;

import java.util.ArrayList;

public class Catalog {
	private ArrayList<Course> courses = new ArrayList<Course>();
	
	
	public void addCourse(Course tempInstructor){
		courses.add(tempInstructor);
	}
	
	public int size(){
		return courses.size();
	}
	
	public Course getIndex(int index){
		Course tempCourse = new Course(null, null, null);
		tempCourse = courses.get(index);
		
		return tempCourse; 
	}
	
	public ArrayList<Course> getCourses(){
		return courses;
	}
	
	public ArrayList<Course> getDepartmentCourses(Department dept){
		ArrayList<Course> departmentCourses = new ArrayList<Course>();
		for (Course course : courses){
			if (course.getDepartment().equals(dept)){
				departmentCourses.add(course);
			}
		}
		return departmentCourses;
	}
}