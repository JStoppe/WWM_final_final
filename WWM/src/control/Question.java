package control;

import java.util.ArrayList;
import java.util.List;

public class Question implements Comparable<Question> {

	private int level;
	private String text;
	private String rightAnswer;
	private List<String> wrongAnswers;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

	public List<String> getWrongAnswers() {
		return wrongAnswers;
	}

	public void setWrongAnswers(List<String> wrongAnswers) {
		this.wrongAnswers = wrongAnswers;
	}

	public Question() {
		this.wrongAnswers = new ArrayList<>();
	}

//	@Override
//	public String toString() {
//		return "Question [getLevel()=" + getLevel() + ", getText()=" + getText() + ", getRightAnswer()="
//				+ getRightAnswer() + "]";
//	}

	@Override
	public String toString() {
		return "Question [getLevel()=" + getLevel() + ", getText()=" + getText() + ", getRightAnswer()="
				+ getRightAnswer() + ", getWrongAnswers()=" + getWrongAnswers() + "]";
	}

	@Override
	public int compareTo(Question other) {
		return Integer.compare(this.level, other.level);
	}

}