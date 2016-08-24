package v1;

import java.util.HashMap;

public class Student extends Person {

	private String major;
	private HashMap<Integer, Section> currentSections;

	public Student(String firstName, String middleName, String lastName, String email, String ssn, Integer age,
			Integer id, String major) {
		super(firstName, middleName, lastName, email, ssn, age, id);
		this.major = major;
	}
	
	public Student(int id, String lastName){
		super(id, lastName);
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	// calls on the parent classes' display method and then prints out the
	// Student's major
	public void display() {
		super.display();
		System.out.println(major);
	}

	@SuppressWarnings("finally")
	public boolean add(Section section) {
		try{
			currentSections.put(section.getCrn(), section);
			return true;
		}
		finally{
			return false;
		}
	} // end add

	@SuppressWarnings("finally")
	public boolean drop(Section section) {
		try{
			currentSections.remove(section.getCrn());
			return true;
		}
		finally{
			return false;
		}
	} // end drop

} // end Student class
