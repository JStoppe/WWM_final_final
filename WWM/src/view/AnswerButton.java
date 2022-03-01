package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class AnswerButton extends JPanel implements ActionListener {
	
	JButton answerA = new JButton();
	JButton answerB = new JButton();
	JButton answerC = new JButton();
	JButton answerD = new JButton();
	
	
	public AnswerButton() {

		
		this.setLayout(new GridLayout(2,2));
		this.setPreferredSize(new Dimension(Integer.MAX_VALUE,200));
		this.add(answerA);
		this.add(answerB);
		this.add(answerC);
		this.add(answerD);
	}
	
	

	public JButton getAnswerA() {
		return answerA;
	}



	public void setAnswerA(JButton answerA) {
		this.answerA = answerA;
	}



	public JButton getAnswerB() {
		return answerB;
	}



	public void setAnswerB(JButton answerB) {
		this.answerB = answerB;
	}



	public JButton getAnswerC() {
		return answerC;
	}



	public void setAnswerC(JButton answerC) {
		this.answerC = answerC;
	}



	public JButton getAnswerD() {
		return answerD;
	}



	public void setAnswerD(JButton answerD) {
		this.answerD = answerD;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
