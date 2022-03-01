package view;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyMenu extends JMenuBar implements ActionListener {
	
	JMenu start = new JMenu("Start");
	JMenu options = new JMenu("Optionen");
	JMenu quick = new JMenu("Schnelles Spiel");
	JMenu take = new JMenu("Gewinn nehmen");
	
	JMenuItem newGame = new JMenuItem("Neues Spiel");
	JMenuItem highscore = new JMenuItem("Highscore anzeigen");
	JMenuItem loadGame = new JMenuItem("Spiel laden");
	JMenuItem exitGame = new JMenuItem("Spiel beenden");
	
	JDialog jd = new JDialog();
	JTextField enterName = new JTextField();
	JButton ok = new JButton("OK");
	JButton cancel = new JButton("Abbrechen");
	
	public MyMenu() {
		
		this.add(start);
		this.add(options);
		this.add(quick);
		this.add(take);
		
		start.add(newGame);
		start.add(highscore);
		start.add(loadGame);
		start.add(exitGame);
		
		this.add(Box.createHorizontalGlue());
		this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		newGame.addActionListener(this);

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
//				playerName.setText(storeName);
//				rightPanel.getPlayerName().setText(storeName);
				jd.setVisible(false);
//				String frage = "Frage 1: Hier steht nun die erste Frage?";
//				question.setText(frage);
		}
			if(e.getSource() == cancel) {
				jd.dispose();
				jd.setVisible(false);
		} 		
	}

}
