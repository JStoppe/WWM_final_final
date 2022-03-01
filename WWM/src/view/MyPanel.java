package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
	
	public MyPanel() {
		
		JPanel leftPanel = new LeftPanel();
		JPanel basePanel = new RightPanel();
		
		this.setLayout(new BorderLayout());
		
		this.setBackground(Color.white);
	    this.add(leftPanel, BorderLayout.WEST);
	    this.add(basePanel, BorderLayout.CENTER);
	}
}
