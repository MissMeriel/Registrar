package v1;

import java.util.ArrayList;

public class Faculty {
	private ArrayList<Instructor> faculty = new ArrayList<Instructor>();
	
	
	public void addInstructor(Instructor instructor){
		faculty.add(instructor);
	}
	
	public Instructor testRemove(){
			
		return faculty.remove(0);	
		
	}
	
	
	public Instructor getIndex(int index){
		Instructor tmpInstr = new Instructor(0, null);
		tmpInstr = faculty.get(index);
		
		return tmpInstr; 
	}
}


