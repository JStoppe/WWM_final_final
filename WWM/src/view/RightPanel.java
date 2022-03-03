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
	LeftPanel lp = new LeftPanel(this);
	
	JLabel player = new JLabel();
	JLabel konto = new JLabel("", SwingConstants.CENTER);
	JLabel empty = new JLabel();
	JLabel playerName = new JLabel("", SwingConstants.CENTER);
	
	JLabel questionL = new JLabel("", SwingConstants.CENTER);
	AnswerButton answerBtns = new AnswerButton(this);
	JokerButton jokerBtns = new JokerButton(this, answerBtns);
	
	List<Question> questions = new ReadCSV().readCSVFile();
	private int currentQLevel = 1;
	private int rightAnswer;
	private int score = 0;
	private boolean firstQ = false;
	
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
	
	public int getCurrentQLevel() {
		return currentQLevel;
	}

	public void setCurrentQLevel(int currentQLevel) {
		this.currentQLevel = currentQLevel;
	}

	public boolean isFirstQ() {
		return firstQ;
	}

	public void setFirstQ(boolean firstQ) {
		this.firstQ = firstQ;
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

	public void setLPanel(LeftPanel lp){
		this.lp = lp;	
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
		currentQLevel++;
		if(!firstQ) {
			firstQ = true;
		}
	}
	
	public void resetGame() {
		currentQLevel = 1;
		questionL.setText("");
		answerBtns.getAnswerA().setText("");
		answerBtns.getAnswerB().setText("");
		answerBtns.getAnswerC().setText("");
		answerBtns.getAnswerD().setText("");
		this.displayNextQuestion();
		score = 0;
		displayScore();
	}
	
	public void increaseScore() {
		if(score == 0) {
			score = 50;
		}
		else if(score == 200) {
			score = 300;
		}
		else if(score == 300) {
			score = 500;
		}
		else if(score == 64000) {
			score = 125000;
		}
		else if(score == 125000) {
			score = 500000;
		}
		else {
			score = score * 2;
		}
		displayScore();
	}
	
	public void displayScore() {
		konto.setText(Integer.toString(score));
		lp.changePic();
	}
	
	public int getFinalScore() {
		if(score == 1000000) {
			return 1000000;
		}
		else if(score >= 16000) {
			return 16000;
		}
		else if(score >= 500) {
			return 500;
		}
		else {
			return 0;
		}
	}

	
}


