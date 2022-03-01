package view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame {
	
	public MyFrame() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(820,650);
		this.getContentPane().setBackground(new Color(255,255,255));

		JPanel mainPanel = new MyPanel();
		this.setContentPane(mainPanel);
		
		MyMenu menu = new MyMenu();
		this.setJMenuBar(menu);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
}
