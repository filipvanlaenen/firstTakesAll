package no.anderska.wta.questions;

import no.anderska.wta.Validate;
import no.anderska.wta.game.Question;

class FromMayanNumberQuestionGenerator extends AbstractQuestionGenerator {

	private final MayanNumberSolver solver = new MayanNumberSolver();

	protected FromMayanNumberQuestionGenerator(long maxNumber, int numberOfQuestions, String description) {
		super(numberOfQuestions, description);
		this.maxNumber = Validate.numberInRange(maxNumber, "maxNumber", 1, 999999L);
	}

	public FromMayanNumberQuestionGenerator() {
		this(999999L, 30, "Compute the value of a given Mayan number. E.g. '...' = '3', '..,.|' = '46' or '..,Ø,|' = '805'");
	}

	@Override
	protected Question createQuestion() {
		long number = (random.nextLong() % maxNumber) + 1;
		return new Question(solver.toNumber(number), "" + number);
	}

	private final long maxNumber;

	static class Small extends FromMayanNumberQuestionGenerator {
		public Small() {
			super(19, 10, "Compute the value of a Mayan number under 20. E.g. '...' = '3' or '....|||' = '19'");
		}
	}
}
