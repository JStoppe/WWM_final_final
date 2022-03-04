package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public void createAndShowGUI() {

    	JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(850,650);
		frame.setTitle("Java Quiz Master 2022");
		frame.getContentPane().setBackground(new Color(255,255,255));
		
		JPanel mainPanel = new MainPanel();
		frame.setContentPane(mainPanel);
			
		MainMenu menu = new MainMenu();
		frame.setJMenuBar(menu);
			
		menu.setNamelabel(((MainPanel) mainPanel).getRightPanel());

	    frame.addComponentListener(new ComponentAdapter() {
	    	@Override
	        public void componentResized(ComponentEvent e) {
	    		titleAlign(frame);
	            }
	        });

	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
    }
    
	    private void titleAlign(JFrame frame) {

	        Font font = frame.getFont();

	        String currentTitle = frame.getTitle().trim();
	        FontMetrics fm = frame.getFontMetrics(font);
	        int frameWidth = frame.getWidth();
	        int titleWidth = fm.stringWidth(currentTitle);
	        int spaceWidth = fm.stringWidth(" ");
	        int centerPos = (frameWidth / 2) - (titleWidth / 2);
	        int spaceCount = centerPos / spaceWidth;
	        String pad = "";
	        pad = String.format("%" + (spaceCount - 14) + "s", pad);
	        frame.setTitle(pad + currentTitle);

	    }
	}
