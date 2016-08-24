package v1;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SectionTallyGUI extends JFrame{

	private ArrayList<Section> sections;
	JComboBox<Section> dropdown;
	
	public SectionTallyGUI(Term term, Student student){
		
		super("Banner Self-Service for "+student.lastName);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.sections = term.getSections();
		setSize(1200, 120);
		setLayout(new BorderLayout());

		//Section[] sectionsArray = new Section[sections.size()];
		//sections.toArray(sectionsArray);
		Department[] depts = {Department.Art, Department.Biology, Department.Chemistry,
				Department.Computer_Science, Department.Economics, Department.English, Department.History, 
				Department.Music, Department.Mathematics, Department.Philosophy, Department.Physics, 
				Department.Psychology};
		DropdownPanel ddPanel = new DropdownPanel(depts);
		add(ddPanel, BorderLayout.NORTH);
		
		FeedbackPanel fbPanel = new FeedbackPanel();
		add(fbPanel, BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
	} // end constructor
	
} // end SectionTallyGUI

//Must not add a section if user selects no on the JOptionPane
//timeslots are totally random