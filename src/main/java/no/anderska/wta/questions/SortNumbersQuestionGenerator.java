package no.anderska.wta.questions;

import static no.anderska.wta.questions.AbstractQuestionGenerator.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import no.anderska.wta.game.QuestionGenerator;
import no.anderska.wta.game.QuestionSet;

public abstract class SortNumbersQuestionGenerator implements QuestionGenerator {

	@Override
	public QuestionSet generateQuestionSet(String playerid, String categoryid) {
		List<Integer> question = generateQuestion();
		return new QuestionSet(toNumbers(question), toNumbers(generateAnswers(question)), this, categoryid);
	}

	abstract NumberSolver getNumberSolver();

	private List<String> toNumbers(List<Integer> numbers) {
		NumberSolver solver = getNumberSolver();
		ArrayList<String> result = new ArrayList<>();
		for (Integer number : numbers) {
			result.add(solver.toNumber(number));
		}
		return result;
	}

	private List<Integer> generateQuestion() {
		List<Integer> question = new ArrayList<>();
		for (int i = 0; i < random.nextInt(100) + 10; i++) {
			question.add(random.nextInt(3999) + 1);
		}
		return question;
	}

	List<Integer> generateAnswers(List<Integer> question) {
		List<Integer> answer = new ArrayList<>(question);
		Collections.sort(answer);
		return answer;
	}

}
