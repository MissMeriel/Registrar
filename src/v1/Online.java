package v1;

public class Online extends Section{

	//Has no meeting times, so no timeslots
	
	public Online(Course course, Instructor instructor){
		super(course, instructor);
		crn = setCRN();
	}
	
	public int setCRN(){
		return crn + getSectionCount(); 
	}
}
