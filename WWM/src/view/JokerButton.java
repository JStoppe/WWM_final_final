package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;


public class JokerButton extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	JButton fifty = new JButton("50/50");
	JButton publikum = new JButton("Publikum");
	JButton telefon = new JButton("Telefon");
	RightPanel rp;
	AnswerButton ab;
	JButton answerA;
	JButton answerB;
	JButton answerC;
	JButton answerD;
	Random rand = new Random();
	
	public JokerButton(RightPanel rp, AnswerButton ab) {
		this.rp = rp;
		this.ab = ab;
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		c.ipady = 20;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		this.add(fifty, c);
		fifty.addActionListener(this);

		c.gridx = 1;
		c.gridy = 0;
		this.add(publikum, c);
		publikum.addActionListener(this);

		c.gridx = 2;
		c.gridy = 0;
		this.add(telefon, c);
		telefon.addActionListener(this);
		
		answerA = ab.getAnswerA();
		answerB = ab.getAnswerB();
		answerC = ab.getAnswerC();
		answerD = ab.getAnswerD();
	}
	
	public void jokerReset() {
		fifty.setBackground(null);
		publikum.setBackground(null);
		telefon.setBackground(null);
		fifty.setForeground(null);
		publikum.setForeground(null);
		telefon.setForeground(null);
		fifty.addActionListener(this);
		publikum.addActionListener(this);
		telefon.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == fifty) {
			fifty.setBackground(Color.LIGHT_GRAY);
			fifty.setForeground(Color.RED);
			fifty.removeActionListener(this);
			int temp;
			int temp2;
			while(true) {
				int randomNumber = rand.nextInt(4);
				if(randomNumber != rp.getRightAnswer()) {
					temp = randomNumber;
					break;
				}
			}
			while(true) {
				int randomNumber = rand.nextInt(4);
				if(randomNumber != rp.getRightAnswer() && randomNumber != temp) {
					temp2 = randomNumber;
					break;
				}
			}
		
			for(int i = 0; i < 2; i++) {
				int temporary;
				if(i == 0) {
					temporary = temp;
				} else {
					temporary = temp2;
				}
				switch(temporary) {
				case 0: rp.answerBtns.answerA.setBackground(Color.LIGHT_GRAY);
						rp.answerBtns.answerA.setEnabled(false);
				break;
				case 1: rp.answerBtns.answerB.setBackground(Color.LIGHT_GRAY);
						rp.answerBtns.answerB.setEnabled(false);
				break;
				case 2: rp.answerBtns.answerC.setBackground(Color.LIGHT_GRAY);
						rp.answerBtns.answerC.setEnabled(false);
				break;
				case 3: rp.answerBtns.answerD.setBackground(Color.LIGHT_GRAY);
						rp.answerBtns.answerD.setEnabled(false);
				break;
				}				
			}

		}
		if(e.getSource() == publikum) {
			publikum.setBackground(Color.LIGHT_GRAY);
			publikum.setForeground(Color.RED);
			publikum.removeActionListener(this);
			
			Random r = new Random();
			int winner = rand.nextInt(80);
			int b = rand.nextInt(100-winner);
			int c = rand.nextInt(100-winner-b);
			int d = rand.nextInt(100-winner-b-c);
			int rightBnt = rp.getRightAnswer();
			
			
			if(rand.nextInt(11)<9) {
				switch(rightBnt) {
				case 0: rp.answerBtns.answerA.setBackground(Color.cyan);
						rp.answerBtns.answerA.setText(answerA.getText() + " " + winner + "%");
						rp.answerBtns.answerB.setText(answerB.getText() + " " + b + "%");
						rp.answerBtns.answerC.setText(answerC.getText() + " " + c + "%");
						rp.answerBtns.answerD.setText(answerD.getText() + " " + d + "%");
				break;
				case 1: rp.answerBtns.answerB.setBackground(Color.cyan);
						rp.answerBtns.answerB.setText(answerB.getText() + " " + winner + "%");
						rp.answerBtns.answerA.setText(answerA.getText() + " " + b + "%");
						rp.answerBtns.answerC.setText(answerC.getText() + " " + c + "%");
						rp.answerBtns.answerD.setText(answerD.getText() + " " + d + "%");
				break;
				case 2:	rp.answerBtns.answerC.setBackground(Color.cyan); 
						rp.answerBtns.answerC.setText(answerC.getText() + " " + winner + "%");
						rp.answerBtns.answerB.setText(answerB.getText() + " " + b + "%");
						rp.answerBtns.answerA.setText(answerA.getText() + " " + c + "%");
						rp.answerBtns.answerD.setText(answerD.getText() + " " + d + "%");
				break;
				case 3: rp.answerBtns.answerD.setBackground(Color.cyan);
						rp.answerBtns.answerD.setText(answerD.getText() + " " + winner + "%");
						rp.answerBtns.answerB.setText(answerB.getText() + " " + b + "%");
						rp.answerBtns.answerC.setText(answerC.getText() + " " + c + "%");
						rp.answerBtns.answerA.setText(answerA.getText() + " " + d + "%");
				break;
				}
			}
			else {
				switch(rightBnt) {
				case 2: rp.answerBtns.answerA.setBackground(Color.cyan);
						rp.answerBtns.answerA.setText(answerA.getText() + " " + winner + "%");
						rp.answerBtns.answerB.setText(answerB.getText() + " " + b + "%");
						rp.answerBtns.answerC.setText(answerC.getText() + " " + c + "%");
						rp.answerBtns.answerD.setText(answerD.getText() + " " + d + "%");
				break;
				case 0: rp.answerBtns.answerB.setBackground(Color.cyan);
						rp.answerBtns.answerB.setText(answerB.getText() + " " + winner + "%");
						rp.answerBtns.answerA.setText(answerA.getText() + " " + b + "%");
						rp.answerBtns.answerC.setText(answerC.getText() + " " + c + "%");
						rp.answerBtns.answerD.setText(answerD.getText() + " " + d + "%");
				break;
				case 3:	rp.answerBtns.answerC.setBackground(Color.cyan); 
						rp.answerBtns.answerC.setText(answerC.getText() + " " + winner + "%");
						rp.answerBtns.answerB.setText(answerB.getText() + " " + b + "%");
						rp.answerBtns.answerA.setText(answerA.getText() + " " + c + "%");
						rp.answerBtns.answerD.setText(answerD.getText() + " " + d + "%");
				break;
				case 1: rp.answerBtns.answerD.setBackground(Color.cyan);
						rp.answerBtns.answerD.setText(answerD.getText() + " " + winner + "%");
						rp.answerBtns.answerB.setText(answerB.getText() + " " + b + "%");
						rp.answerBtns.answerC.setText(answerC.getText() + " " + c + "%");
						rp.answerBtns.answerA.setText(answerA.getText() + " " + d + "%");
				break;
				}
			}
					
		}
		
		
		if(e.getSource() == telefon) {
			telefon.setBackground(Color.LIGHT_GRAY);
			telefon.setForeground(Color.RED);
			telefon.removeActionListener(this);
			int randRight = rand.nextInt(2);
			int randBtn = rand.nextInt(4);
			
			if(randRight == 1) {
				switch(randBtn) {
				case 0: rp.answerBtns.answerA.setBackground(Color.cyan);
				break;
				case 1: rp.answerBtns.answerB.setBackground(Color.cyan);
				break;
				case 2:	rp.answerBtns.answerC.setBackground(Color.cyan); 
				break;
				case 3: rp.answerBtns.answerD.setBackground(Color.cyan);
				break;
				}	
			}
			else {
				int rightAnswer = rp.getRightAnswer();
				switch(rightAnswer) {
				case 0: rp.answerBtns.answerA.setBackground(Color.cyan);
				break;
				case 1: rp.answerBtns.answerB.setBackground(Color.cyan);
				break;
				case 2:	rp.answerBtns.answerC.setBackground(Color.cyan); 
				break;
				case 3: rp.answerBtns.answerD.setBackground(Color.cyan);
				break;
				}
			}
						
		}
	}
	
}
