package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class AnswerButton extends JPanel implements ActionListener {
	
	public AnswerButton() {

		JButton answerA = new JButton();
		JButton answerB = new JButton();
		JButton answerC = new JButton();
		JButton answerD = new JButton();
		
		this.setLayout(new GridLayout(2,2));
		this.setPreferredSize(new Dimension(Integer.MAX_VALUE,200));
		this.add(answerA);
		this.add(answerB);
		this.add(answerC);
		this.add(answerD);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
