package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
	JPanel rightPanel;
	
	public MyPanel() {
		
		JPanel leftPanel = new LeftPanel();
		rightPanel = new RightPanel();
		
		this.setLayout(new BorderLayout());
		
		this.setBackground(Color.white);
	    this.add(leftPanel, BorderLayout.WEST);
	    this.add(rightPanel, BorderLayout.CENTER);
	}
	
	JPanel getRightPanel() {
		return rightPanel;
	}
	
}
