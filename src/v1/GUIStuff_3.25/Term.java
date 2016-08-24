package v1;

import java.util.ArrayList;

public class Term {
	
	private String myTerm;
	private ArrayList<Section> sections;

	public Term(String myTerm){
		this.myTerm = myTerm;
		ArrayList<Section> sections = new ArrayList<Section>();
	}
	
	public void addSection(Section section){
		sections.add(section);
	}
	
	public ArrayList<Section> getSections(){
		return sections;
	}
	
	public void addSections(ArrayList<Section> sections){
		this.sections = sections;
	}
	
	public ArrayList<Section> getDepartmentSections(Department dept){
		ArrayList<Section> departmentSections = new ArrayList<Section>();
		for (Section section : departmentSections){
			if (section.getCourse().getDepartment().equals(dept)){
				departmentSections.add(section);
			}
		}
		return departmentSections;
	} // end getDepartmentSections
}
