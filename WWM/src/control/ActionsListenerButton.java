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

import view.RightPanel;

public class ActionsListenerButton implements ActionListener{

	RightPanel rp;
	int buttonNumber;
	
	JDialog jd = new JDialog();
	JLabel showWin = new JLabel();
	JButton playAgain = new JButton("nochmal spielen");
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
			
			jd.setLayout(new BorderLayout());
			showWin.setText(Integer.toString(rp.getFinalScore()));
			jd.add(showWin, BorderLayout.PAGE_START);
			jp.setLayout(new BoxLayout(jp, BoxLayout.LINE_AXIS));
			jp.add(Box.createHorizontalGlue());
			jp.add(playAgain);
			jp.add(cancel);
			jd.add(jp);
			jd.setSize(350, 100);
			jd.setTitle("Du hast verloren!");
			jd.setLocationRelativeTo(null);
			jd.setResizable(false);
			jd.setVisible(true);
		}
		if(e.getSource() == playAgain) {
			String storeName = showWin.getText();
			rp.resetGame();
//			playerName.setText(storeName);
//			rightPanel.getPlayerName().setText(storeName);
			jd.setVisible(false);
//			String frage = "Frage 1: Hier steht nun die erste Frage?";
//			question.setText(frage);
	}
		if(e.getSource() == cancel) {
//			jd.dispose();
//			jd.setVisible(false);
	} 	
	}

}
