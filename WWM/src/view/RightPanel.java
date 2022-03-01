package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;


public class RightPanel extends JPanel {
		
	JPanel rightTop = new JPanel();
	JPanel rightBottom = new JPanel();
	
	JLabel player = new JLabel();
	JLabel konto = new JLabel();
	JLabel empty = new JLabel();
	JLabel playerName = new JLabel("", SwingConstants.CENTER);
	
	JLabel question = new JLabel();
	JokerButton jokerBtns = new JokerButton();
	AnswerButton answerBtns = new AnswerButton();
	
//	Question q = new Question();
		
	public RightPanel() {
		
		this.setLayout(new BorderLayout());
		
		rightTop.setLayout(new BorderLayout());
		
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
		
		rightTop.add(player, BorderLayout.NORTH);
		rightTop.add(question, BorderLayout.CENTER);
		rightTop.setPreferredSize(new Dimension(Integer.MAX_VALUE, 300));

		rightBottom.setLayout(new BorderLayout());
		
		rightBottom.add(jokerBtns, BorderLayout.NORTH);
		rightBottom.add(answerBtns, BorderLayout.CENTER);
		
		
	    this.add(rightTop, BorderLayout.NORTH);
	    this.add(rightBottom, BorderLayout.CENTER);
	}
}
