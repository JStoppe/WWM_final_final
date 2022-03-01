package control;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ReadCSV {

	public static void main(String[] args) {
		/**
		 * ./Material/WWM.csv
		 */
		File file = new File("./resources/WWM.csv");
		System.out.println(file.exists());
		System.out.println(file.isDirectory());
		System.out.println(file.isFile());

		List<Question> questions = new ArrayList<>();

		/**
		 * Lesen der Daten aus der Datei
		 */
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			while (br.ready()) {
				String zeile = br.readLine();

				String[] datas = zeile.split(";");
				Question q = new Question();
				if (datas.length >= 3) {
					q.setLevel(Integer.parseInt(datas[0]));
					q.setText(datas[1]);
					q.setRightAnswer(datas[2]);
				} else {
					System.out.println(zeile);
				}
				questions.add(q);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Collections.sort(questions);
		assignAnswersToQuestions(questions);

		System.out.println(questions.get(1));
		System.out.println(questions.get(911));

		// Was erwarten wir in der Ausgabe?
	}

	/**
	 * Jeder Frage in allen Kategorien werden falsche Antworten von Fragen der
	 * selben Kategorie zugeordnet.
	 * 
	 */
	private static void assignAnswersToQuestions(List<Question> questions) {
		for (int category = 1; category < questions.get(questions.size() - 1).getLevel(); category++) {
			List<String> categoryAnswers = determineAnswersFromCategory(questions, category);
			List<Question> categoryQuestions = determineQuestionsFromCategory(questions, category);
			assignWrongAnswers(categoryQuestions, categoryAnswers);
		}

	}

	/**
	 * Zuweisen falscher Antworten zu einer Frage. Antworten per zufall von Fragen
	 * der selben Kategorie
	 */
	private static void assignWrongAnswers(List<Question> questions, List<String> answers) {
		for (int i = 0; i < questions.size(); i++) {
			for (int j = 0; j < 3; j++) {
				Random rand = new Random();
				String answer = answers.get(rand.nextInt(answers.size()));
				if (questions.get(i).getWrongAnswers().contains(answer)
						|| questions.get(i).getRightAnswer().equalsIgnoreCase(answer)) {
					j--;
				} else {
					questions.get(i).getWrongAnswers().add(answer);
				}
			}
		}

	}

	private static List<Question> determineQuestionsFromCategory(List<Question> questions, int category) {
		List<Question> resultQuestions = new ArrayList<>();
		for (Question question : questions) {
			if (question.getLevel() == category) {
				resultQuestions.add(question);
			}
		}
		return resultQuestions;
	}

	/**
	 * Ermitteln aller Antworten einer Kategorie
	 */
	private static List<String> determineAnswersFromCategory(List<Question> questions, int category) {

		List<String> answers = new ArrayList<>();
		for (int i = 0; i < questions.size(); i++) {

			if (questions.get(i).getLevel() == category) {
				answers.add(questions.get(i).getRightAnswer());
			}
		}
		return answers;
	}

}