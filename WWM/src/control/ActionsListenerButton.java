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
	JPanel jp = new JPanel();
	JPanel jpWin = new JPanel();
	
	public ActionsListenerButton(RightPanel rp, int buttonNumber) {
		this.rp = rp;
		this.buttonNumber = buttonNumber;
		
		jd.setLayout(new BorderLayout());
		jd.setTitle("Du hast leider verloren!");
		showWin.setText("Dein Gewinn beträgt: " + Integer.toString(rp.getLastScore()));

		jp.setLayout(new BoxLayout(jp, BoxLayout.LINE_AXIS));

		jd.add(jp);
		
		playAgain.addActionListener(this);
		cancel.addActionListener(this);
		
		jdWin.setLayout(new BorderLayout());
		jdWin.setTitle("Herzlichen Glückwunsch!");
		jpWin.setLayout(new BoxLayout(jpWin, BoxLayout.LINE_AXIS));
		jdWin.add(jpWin);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {		
		if(rp.getRightAnswer() == buttonNumber && rp.isFirstQ()) {
			rp.increaseScore();
			rp.displayNextQuestion();
		}
		else{
			jd.setSize(350, 100);
			showWin.setText("Dein Gewinn beträgt: " + Integer.toString(rp.getLastScore()));
			jd.add(showWin, BorderLayout.PAGE_START);
			jp.add(Box.createHorizontalGlue());
			jp.add(playAgain);
			jp.add(cancel);
			jd.setModal(true);
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
		if (rp.getCurrentQLevel() == 16 || rp.getScore() == 500000 || rp.isWinQ()){			
			jdWin.setSize(350, 100);
			showWin.setText("Dein Gewinn beträgt: 1000000");
			jdWin.add(showWin, BorderLayout.PAGE_START);
			jpWin.add(Box.createHorizontalGlue());
			jpWin.add(playAgain);
			jpWin.add(cancel);
			jdWin.setModal(true);
			jdWin.getRootPane().setDefaultButton(playAgain);
			jdWin.setLocationRelativeTo(null);
			jdWin.setResizable(false);
			jdWin.setVisible(true);
		}
	}

}
