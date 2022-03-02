package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class MainPanel extends JPanel {
	RightPanel rightPanel;
	
	public MainPanel() {
		
		
		rightPanel = new RightPanel();
		LeftPanel leftPanel = new LeftPanel(rightPanel);
		rightPanel.setLPanel(leftPanel);
		
		this.setLayout(new BorderLayout());
		
		this.setBackground(Color.white);
	    this.add(leftPanel, BorderLayout.WEST);
	    this.add(rightPanel, BorderLayout.CENTER);
	}
	
	JPanel getRightPanel() {
		return rightPanel;
	}
	
}
