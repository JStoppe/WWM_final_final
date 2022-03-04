package view;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;


public class MainMenu extends JMenuBar implements ActionListener, MenuListener {
	
	private static final long serialVersionUID = 1L;
	
	JMenu start = new JMenu("Start");
	JMenu options = new JMenu("Optionen");
	JMenuItem quick = new JMenuItem("Schnelles Spiel");
	JMenu take = new JMenu("Gewinn nehmen");
	
	JMenuItem newGame = new JMenuItem("Neues Spiel");
	JMenuItem highscore = new JMenuItem("Highscore anzeigen");
	JMenuItem loadGame = new JMenuItem("Spiel laden");
	JMenuItem exitGame = new JMenuItem("Spiel beenden");
	
	JDialog jd = new JDialog();
	JDialog tW = new JDialog();
	JDialog eD = new JDialog();
	JPanel jp = new JPanel();
	JPanel jpE = new JPanel();
	JTextField enterName = new JTextField();
	JLabel takeScore = new JLabel("", SwingConstants.CENTER);
	JLabel exitLabel = new JLabel("Wollen Sie wirklich das Spiel verlassen?", SwingConstants.CENTER);
	JButton ok = new JButton("OK");
	JButton playAgain = new JButton("Erneut Spielen");
	JButton cancel = new JButton("Abbrechen");
	JButton exit = new JButton("Exit");
	String storeName;

	
	
	RightPanel nameLabel;
	
	public MainMenu() {
		
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
		exitGame.addActionListener(this);
		quick.addActionListener(this);
//		quick.addMenuListener(this);
		
		
		take.addMenuListener(this);
		
		ok.addActionListener(this);
		cancel.addActionListener(this);
		exit.addActionListener(this);
		
		jd.setLayout(new BorderLayout());
		jd.setTitle("Bitte geben Sie Ihren Namen ein");
		jp.setLayout(new BoxLayout(jp, BoxLayout.LINE_AXIS));
		jd.add(jp);
		
		eD.setLayout(new BorderLayout());
		eD.setTitle("Wollen Sie das Spiel verlassen?");
		eD.add(exitLabel, BorderLayout.PAGE_START);
		jpE.setLayout(new BoxLayout(jpE, BoxLayout.LINE_AXIS));
		jpE.add(Box.createHorizontalGlue());
		jpE.add(exit);
		jpE.add(cancel);
		eD.add(jpE);
	}
	
	void setNamelabel(JPanel nl){
		nameLabel = (RightPanel) nl;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newGame) {
			jd.setSize(350, 100);
			jd.add(enterName, BorderLayout.PAGE_START);
			jp.add(Box.createHorizontalGlue());
			jp.add(ok);
			jp.add(cancel);
			jd.getRootPane().setDefaultButton(ok);
			jd.setLocationRelativeTo(null);
			jd.setResizable(false);
			jd.setVisible(true);
		}
			if(e.getSource() == ok) {
				storeName = enterName.getText();
				nameLabel.setPlayerName(storeName);
				nameLabel.resetGame();
//				nameLabel.displayNextQuestion();
//				nameLabel.setScore(0);
//				nameLabel.displayScore();
				jd.setVisible(false);
		}
			if(e.getSource() == cancel) {
				jd.dispose();
				tW.dispose();
				eD.dispose();
		} 		
			if(e.getSource() == playAgain) {
				nameLabel.resetGame();
				jd.setVisible(false);
				tW.setVisible(false);
			}
			if(e.getSource() == exitGame) {
				eD.setSize(350, 100);
				eD.setTitle("Exit Game");
				eD.getRootPane().setDefaultButton(exit);
				eD.setModal(true);
				eD.setLocationRelativeTo(null);
				eD.setResizable(false);
				eD.setVisible(true);
			}
			if(e.getSource() == exit) {
				System.exit(0);
			}
			if(e.getSource() == quick && storeName != null && !storeName.isEmpty()) {
				nameLabel.resetGame();
		}
	}

	@Override
	public void menuSelected(MenuEvent e) {
//		if(e.getSource() == quick && storeName != null && !storeName.isEmpty()) {
//				nameLabel.resetGame();
//		}
		if(e.getSource() == take && storeName != null && !storeName.isEmpty()) {
			JPanel jpW = new JPanel();
			playAgain.addActionListener(this);
			cancel.addActionListener(this);
			
			tW.setLayout(new BorderLayout());
			takeScore.setText("Ihr Gewinn beträgt: " + Integer.toString(nameLabel.getScore()));
			tW.add(takeScore, BorderLayout.PAGE_START);
			jpW.setLayout(new BoxLayout(jpW, BoxLayout.LINE_AXIS));
			jpW.add(Box.createHorizontalGlue());
			jpW.add(playAgain);
			jpW.add(cancel);
			tW.add(jpW);
			tW.setSize(350, 100);
			tW.setTitle("Glückwunsch!");
			tW.getRootPane().setDefaultButton(playAgain);
			tW.setModal(true);
			tW.setLocationRelativeTo(null);
			tW.setResizable(false);
			tW.setVisible(true);
		}
	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
