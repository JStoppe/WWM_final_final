package wwm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

//import control.MyActionListener;


public class GUI extends JFrame implements ActionListener {

	// items
	
	JFrame frame = new JFrame();
	
	JPanel mainPanel = new JPanel();
	JPanel basePanel = new JPanel();
	JPanel leftPanel = new JPanel();	
	JPanel rightTop = new JPanel();
	JPanel rightBottom = new JPanel();
	
	JMenuBar menu = new JMenuBar();
	JMenu start = new JMenu("Start");
	JMenu options = new JMenu("Optionen");
	JMenu quick = new JMenu("Schnelles Spiel");
	JMenu take = new JMenu("Gewinn nehmen");
	
	JMenuItem newGame = new JMenuItem("Neues Spiel");
	JMenuItem highscore = new JMenuItem("Highscore anzeigen");
	JMenuItem loadGame = new JMenuItem("Spiel laden");
	JMenuItem exitGame = new JMenuItem("Spiel beenden");
	
	JLabel level = new JLabel();
	
	JLabel player = new JLabel();
	JLabel konto = new JLabel();
	JLabel empty = new JLabel();
	JLabel playerName = new JLabel("", SwingConstants.CENTER);
	
	JLabel question = new JLabel();
	
	JPanel joker = new JPanel();
	JButton fifty = new JButton("50/50");
	JButton publikum = new JButton("Publikum");
	JButton telefon = new JButton("Telefon");
	
	JPanel buttonsAns = new JPanel();
	JButton answerA = new JButton();
	JButton answerB = new JButton();
	JButton answerC = new JButton();
	JButton answerD = new JButton();
	
	JDialog jd = new JDialog();
	JTextField enterName = new JTextField();
	JButton ok = new JButton("OK");
	JButton cancel = new JButton("Abbrechen");
	
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	// functions

	public String storeName = "";
		
	public GUI() {
		
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(820,650);
	
	frame.setFont(new Font("System", Font.PLAIN, 14));
	Font f = frame.getFont();
	FontMetrics fm = frame.getFontMetrics(f);
	int x = fm.stringWidth("Hello Center");
	int y = fm.stringWidth(" ");
	int z = frame.getWidth()/2 - (x/2);
	int w = z/y;
	String pad ="";
	//for (int i=0; i!=w; i++) pad +=" "; 
	pad = String.format("%"+w+"s", pad);
	frame.setTitle(pad+"Java Quiz Master 2022");
	
	
	frame.getContentPane().setBackground(new Color(255,255,255));
//	frame.setLayout(null);
//	frame.setResizable(false);
	frame.setJMenuBar(menu);
	

	
	
	mainPanel.setLayout(new BorderLayout());
	
	menu.add(start);
	menu.add(options);
	menu.add(quick);
	menu.add(take);
	
	start.add(newGame);
	start.add(highscore);
	start.add(loadGame);
	start.add(exitGame);
	
	menu.add(Box.createHorizontalGlue());
	menu.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT); 
	
	newGame.addActionListener(this);
	
	leftPanel.setLayout(new BorderLayout());
    leftPanel.setPreferredSize(new Dimension(250, 650));
    leftPanel.setBackground(Color.white);
    
    
	level.setBounds(0,0,250,584);
//	basePanel.setPreferredSize(new Dimension(250,620));
	Image img = new ImageIcon(this.getClass().getResource("/Gewinnstufe0.png")).getImage();
	Image scaledImage = img.getScaledInstance(level.getWidth(),level.getHeight(),Image.SCALE_SMOOTH);
	level.setIcon(new ImageIcon(scaledImage));
	leftPanel.add(level);
	
	player.setLayout(new GridLayout (1,3));
	player.setPreferredSize(new Dimension(Integer.MAX_VALUE,25));
	player.add(konto);
	player.add(empty);
	player.add(playerName);

	konto.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
	empty.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
	playerName.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
	
	
	question.setPreferredSize(new Dimension(Integer.MAX_VALUE,100));
	question.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
	
	joker.setLayout(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	c.fill = GridBagConstraints.HORIZONTAL;

	c.ipady = 20;
//	c.insets = new Insets(5,0,5,0);
	c.weightx = 0.5;
	c.gridx = 0;
	c.gridy = 0;
	joker.add(fifty, c);
	fifty.addActionListener(this);

	c.gridx = 1;
	c.gridy = 0;
	joker.add(publikum, c);
	publikum.addActionListener(this);

	c.gridx = 2;
	c.gridy = 0;
	joker.add(telefon, c);
	telefon.addActionListener(this);
		
	buttonsAns.setLayout(new GridLayout(2,2));
	buttonsAns.setPreferredSize(new Dimension(Integer.MAX_VALUE,200));
	buttonsAns.add(answerA);
	buttonsAns.add(answerB);
	buttonsAns.add(answerC);
	buttonsAns.add(answerD);
	
	rightTop.setLayout(new BorderLayout());
	rightTop.add(player, BorderLayout.NORTH);
	rightTop.add(question, BorderLayout.CENTER);
	
	rightBottom.setLayout(new BorderLayout());
	rightBottom.add(joker, BorderLayout.NORTH);
	rightBottom.add(buttonsAns, BorderLayout.CENTER);
    
	rightTop.setPreferredSize(new Dimension(Integer.MAX_VALUE, 300));

    basePanel.setLayout(new BorderLayout());
    basePanel.add(rightTop, BorderLayout.NORTH);
    basePanel.add(rightBottom, BorderLayout.CENTER);

    mainPanel.setBackground(Color.white);
    mainPanel.add(leftPanel, BorderLayout.WEST);
    mainPanel.add(basePanel, BorderLayout.CENTER);
	
	frame.setContentPane(mainPanel);
	frame.setVisible(true);
	frame.setLocationRelativeTo(null);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newGame) {
			JPanel jp = new JPanel();
			ok.addActionListener(this);
			
			jd.setLayout(new BorderLayout());
			jd.add(enterName, BorderLayout.PAGE_START);
			jp.setLayout(new BoxLayout(jp, BoxLayout.LINE_AXIS));
			jp.add(Box.createHorizontalGlue());
			jp.add(ok);
			jp.add(cancel);
			jd.add(jp);
			jd.setSize(350, 100);
			jd.setTitle("Bitte geben Sie Ihren Namen ein");
			jd.setLocationRelativeTo(null);
			jd.setVisible(true);
		}
			if(e.getSource() == ok) {
				String storeName = enterName.getText();
				playerName.setText(storeName);
				jd.setVisible(false);
//				String frage = "Frage 1: Hier steht nun die erste Frage?";
//				question.setText(frage);
		}
			if(e.getSource() == cancel) {
				jd.dispose();
				jd.setVisible(false);
		} 
			if(e.getSource() == fifty) {
				fifty.setBackground(Color.gray);
			}
			if(e.getSource() == publikum) {
				publikum.setBackground(Color.gray);
			}
			if(e.getSource() == telefon) {
				telefon.setBackground(Color.gray);
			}
	}
}