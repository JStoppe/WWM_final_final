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
//		c.insets = new Insets(5,0,5,0);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == fifty) {
			System.out.println("fifty pressed");
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
//			fifty.setText("<html><font color = red>50/50</font></html>");
//			fifty.setEnabled(false);
		}
		if(e.getSource() == publikum) {
			publikum.setBackground(Color.LIGHT_GRAY);
			publikum.setForeground(Color.RED);
			publikum.removeActionListener(this);
		}
		if(e.getSource() == telefon) {
			telefon.setBackground(Color.LIGHT_GRAY);
			telefon.setForeground(Color.RED);
			telefon.removeActionListener(this);
		}
	}
	
}
