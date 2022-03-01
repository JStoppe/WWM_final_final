package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import control.Question;
import control.ReadCSV;


public class RightPanel extends JPanel {
		
	JPanel rightTop = new JPanel();
	JPanel rightBottom = new JPanel();
	
	JLabel player = new JLabel();
	JLabel konto = new JLabel();
	JLabel empty = new JLabel();
	JLabel playerName = new JLabel("", SwingConstants.CENTER);
	
	JLabel questionL = new JLabel("", SwingConstants.CENTER);
	JokerButton jokerBtns = new JokerButton();
	AnswerButton answerBtns = new AnswerButton(this);
	
	List<Question> questions = new ReadCSV().readCSVFile();
	int currentQLevel = 1;
	int rightAnswer;
	
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
		
		questionL.setPreferredSize(new Dimension(Integer.MAX_VALUE,100));
		questionL.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		
		rightTop.add(player, BorderLayout.NORTH);
		rightTop.add(questionL, BorderLayout.CENTER);
		rightTop.setPreferredSize(new Dimension(Integer.MAX_VALUE, 300));

		rightBottom.setLayout(new BorderLayout());
		
		rightBottom.add(jokerBtns, BorderLayout.NORTH);
		rightBottom.add(answerBtns, BorderLayout.CENTER);
		
		
	    this.add(rightTop, BorderLayout.NORTH);
	    this.add(rightBottom, BorderLayout.CENTER);
	}
	
	void setPlayerName(String playerName){
		this.playerName.setText(playerName);
	}
	
	
	
	public int getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(int rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

	Question nextQuestion(int category) {
		Random r = new Random();
		Question q;
		while(true) {
			q = questions.get(r.nextInt(questions.size()-1));
			if(q.getLevel() == category) {
				break;
			}
		}
		return q;
	}
	
	public void displayNextQuestion() {
		Question question = this.nextQuestion(currentQLevel);
		Random r = new Random();
		rightAnswer = r.nextInt(4);
		questionL.setText(question.getText());
		switch(rightAnswer) {
			case 0: answerBtns.getAnswerA().setText(question.getRightAnswer());
			break;
			case 1: answerBtns.getAnswerB().setText(question.getRightAnswer());
			break;
			case 2: answerBtns.getAnswerC().setText(question.getRightAnswer());
			break;
			case 3: answerBtns.getAnswerD().setText(question.getRightAnswer());
			break;
		}
		int temp = 0;
		for(int i = 0; i<4; i++) {
			if(i == rightAnswer) {
				
			}
			else {
				switch(i) {
				case 0: answerBtns.getAnswerA().setText(question.getWrongAnswers().get(temp));
				break;
				case 1: answerBtns.getAnswerB().setText(question.getWrongAnswers().get(temp));
				break;
				case 2: answerBtns.getAnswerC().setText(question.getWrongAnswers().get(temp));
				break;
				case 3: answerBtns.getAnswerD().setText(question.getWrongAnswers().get(temp));
				break;
				}
				temp++;
			}
		}
		
		
	}
}
