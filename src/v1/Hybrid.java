package v1;

public class Hybrid extends Section{

	// Holds one meeting time
	Timeslot[] timeslots;
	
	public Hybrid(Course course, Instructor instructor, Timeslot[] timeslots){
		super(course, instructor);
		this.timeslots = timeslots;
		crn = setCRN();
	}
	
	public Timeslot[] getTimeslots(){
		return timeslots;
	}
	
	public void setTimeslots(Timeslot[] timeslots){
		this.timeslots = timeslots;
	}
	
	public int setCRN(){
		return crn + getSectionCount(); 
	}
}
