package view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame {
	
	public MyFrame() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(820,650);
		this.getContentPane().setBackground(new Color(255,255,255));

		JPanel mainPanel = new MainPanel();
		this.setContentPane(mainPanel);
		
		MainMenu menu = new MainMenu();
		this.setJMenuBar(menu);
		
		menu.setNamelabel(((MainPanel) mainPanel).getRightPanel());
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
}
