package v1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DropdownPanel extends JPanel{

	private static JComboBox<Section> dropdown;
	private static JLabel departmentSelector;
	
	public DropdownPanel(Department[] depts){
		
		setLayout(new FlowLayout());
		setBackground(Color.GRAY);
		
		departmentSelector = new JLabel("Select a department: ");
		add(departmentSelector);
		
		JComboBox<Department> dropdown = new JComboBox<Department>(depts);
		dropdown.insertItemAt(null, 0);
		dropdown.addActionListener(new DropDownListener());
		add(dropdown);
		
	}
	
	public Section getSelectedSection(){
		return (Section) dropdown.getSelectedItem();
	}
	
	private class DropDownListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			Department dept = (Department) dropdown.getSelectedItem();
			if (dept == null){
				//SectionPanel is blank and set to its smallest size
				setToBlank();
			}
			else{
				//courses from selected department are added to section panel
				//static method from SectionPanel?
				SectionPanel.setDepartmentSection(section);
			}
		}
		
	} // end private inner DropDownListener
	
}
