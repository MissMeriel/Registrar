package v1;

import java.util.ArrayList;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class SectionPanel extends JPanel{

	private static ArrayList<Section> departmentSections;
	private JLabel crn, courseNum, title, instructor, schedule;
	
	private SectionPanel(){
		this.setToBlank();
	}
	
	public void setSections(Department dept, Term term){
		departmentSections = term.getDepartmentSections(dept);
		setLayout(new GridLayout(departmentSections.size()+1, 5));
		for (Section section : departmentSections){
			
		}
	}
	
	private void setToBlank(){
		setSize(1200, 120);
		departmentSections = null;
		setLayout(new GridLayout(1, 5));
	} // end setToBlank
}
