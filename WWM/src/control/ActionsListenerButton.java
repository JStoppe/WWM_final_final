package control;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import view.RightPanel;

public class ActionsListenerButton implements ActionListener{

	RightPanel rp;
	int buttonNumber;
	
	JDialog jd = new JDialog();
	JDialog jdWin = new JDialog();
	JLabel showWin = new JLabel("", SwingConstants.CENTER);
	JButton playAgain = new JButton("Erneut spielen");
	JButton cancel = new JButton("Abbrechen");
	
	public ActionsListenerButton(RightPanel rp, int buttonNumber) {
		this.rp = rp;
		this.buttonNumber = buttonNumber;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {		
		if(rp.getRightAnswer() == buttonNumber && rp.isFirstQ()) {
			rp.increaseScore();
			rp.displayNextQuestion();
		}
		else if(rp.isFirstQ()){
			JPanel jp = new JPanel();
			playAgain.addActionListener(this);
			cancel.addActionListener(this);
			
			jd.setLayout(new BorderLayout());
			showWin.setText("Dein Gewinn beträgt: " + Integer.toString(rp.getLastScore()));
			jd.add(showWin, BorderLayout.PAGE_START);
			jp.setLayout(new BoxLayout(jp, BoxLayout.LINE_AXIS));
			jp.add(playAgain);
			jp.add(cancel);
			jp.add(Box.createHorizontalGlue());
			jd.add(jp);
			jd.setSize(350, 100);
			jd.setTitle("Du hast verloren!");
//			jd.setModal(true);
			jd.getRootPane().setDefaultButton(playAgain);
			jd.setLocationRelativeTo(null);
			jd.setResizable(false);
			jd.setVisible(true);
		}
		if(e.getSource() == playAgain) {
			rp.resetGame();
			jd.setVisible(false);
			jdWin.setVisible(false);
		}
		if(e.getSource() == cancel) {
			jd.dispose();
			jdWin.dispose();
		} 	
//		if(rp.getRightAnswer() == buttonNumber && rp.isWinQ()) 9
		if (rp.getCurrentQLevel() == 16 || rp.getScore() == 1000000 || rp.isWinQ()){
			JPanel jpWin = new JPanel();
			playAgain.addActionListener(this);
			cancel.addActionListener(this);
			
			jdWin.setLayout(new BorderLayout());
			showWin.setText("Dein Gewinn beträgt: " + Integer.toString(rp.getLastScore()));
			jdWin.add(showWin, BorderLayout.PAGE_START);
			jpWin.setLayout(new BoxLayout(jpWin, BoxLayout.LINE_AXIS));
			jpWin.add(playAgain);
			jpWin.add(cancel);
			jpWin.add(Box.createHorizontalGlue());
			jdWin.add(jpWin);
			jdWin.setSize(350, 100);
			jdWin.setTitle("Herzlichen Glückwunsch!");
			jdWin.setModal(true);
			jdWin.getRootPane().setDefaultButton(playAgain);
			jdWin.setLocationRelativeTo(null);
			jdWin.setResizable(false);
			jdWin.setVisible(true);
		}
	}

}
