package v1;


//N.b. java.time runs on Java 1.8

public class Timeslot {

	java.time.DayOfWeek weekday;
	java.time.LocalTime startTime;
	java.time.LocalTime endTime;

	public Timeslot(java.time.DayOfWeek weekday, java.time.LocalTime startTime, java.time.LocalTime endTime){
		this.weekday = weekday;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public java.time.DayOfWeek getWeekday() {
		return weekday;
	}

	public void setWeekday(java.time.DayOfWeek weekday) {
		this.weekday = weekday;
	}

	public java.time.LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(java.time.LocalTime startTime) {
		this.startTime = startTime;
	}

	public java.time.LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(java.time.LocalTime endTime) {
		this.endTime = endTime;
	}
	
}
