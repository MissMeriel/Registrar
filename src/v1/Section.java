package v1;

public abstract class Section {
	
	private static int sectionCount = 0;
	protected int crn = 40001;
	protected Course course;
	protected Instructor instructor;
	
	public Section(Course course, Instructor instructor){
		crn += sectionCount;
		this.course = course;
		this.instructor = instructor;
		sectionCount ++;
	}

	public static int getSectionCount() {
		return sectionCount;
	}

	public int getCrn() {
		return crn;
	}

	public void setCrn(int crn) {
		this.crn = crn;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString(){
		return "Prof. "+ instructor.getLastName()+"'s "+course; 
	}

}
