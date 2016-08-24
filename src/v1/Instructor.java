package v1;

public class Instructor extends Person{

	private String department;
	
	public Instructor(String firstName, String middleName, String lastName, String email, String ssn, Integer age, Integer id, String department){
		super(firstName,middleName,lastName,email,ssn,age,id);
		this.department = department;
	}

	public Instructor(int id, String lastName){
		super(id, lastName);
	}
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	// calls on the parent classes' display method and then prints out the Instructor's department
	public void display(){
		super.display();
		System.out.println(department);
	}
} // end Instructor
