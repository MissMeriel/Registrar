package v1;

import java.awt.*;
import javax.swing.*;

public class FeedbackPanel extends JPanel{
	
	JLabel feedback;
	
	public FeedbackPanel(){
		setLayout(new FlowLayout());
		setBackground(Color.GRAY);
		feedback = new JLabel("");
		add(feedback);
	}
	
	public void changeFeedback(String feedbackText){
		feedback.setText(feedbackText);
	}

}