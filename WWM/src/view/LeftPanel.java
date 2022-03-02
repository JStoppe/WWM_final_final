package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class LeftPanel extends JPanel {
	
	RightPanel trp;
	Image img;
	JLabel level = new JLabel();
	Image scaledImage;
	
	public LeftPanel(RightPanel trp) {
		this.trp = trp;
		
		this.setLayout(new BorderLayout());
	    this.setPreferredSize(new Dimension(250, 650));
	    this.setBackground(Color.white);
	    
	    level.setBounds(0,0,250,590);
////	basePanel.setPreferredSize(new Dimension(250,620));
		img = new ImageIcon(this.getClass().getResource("/Gewinnstufe0.png")).getImage();
		scaledImage = img.getScaledInstance(level.getWidth(),level.getHeight(),Image.SCALE_SMOOTH);
		level.setIcon(new ImageIcon(scaledImage));
		this.add(level);
	}
	
	public void changePic() {
		Image img = new ImageIcon(this.getClass().getResource("/Gewinnstufe" + (trp.getCurrentQLevel()-1) + ".png")).getImage();
		scaledImage = img.getScaledInstance(level.getWidth(),level.getHeight(),Image.SCALE_SMOOTH);
		level.setIcon(new ImageIcon(scaledImage));
	}
}
