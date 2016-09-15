package no.anderska.wta.questions;

import no.anderska.wta.Validate;
import no.anderska.wta.game.Question;

class ToMayanQuestionGenerator extends AbstractQuestionGenerator {

	private final MayanNumberSolver solver = new MayanNumberSolver();

	protected ToMayanQuestionGenerator(long maxNumber, int numberOfQuestions, String description) {
		super(numberOfQuestions, description);
		this.maxNumber = Validate.numberInRange(maxNumber, "maxNumber", 1, 999999L);
	}

	public ToMayanQuestionGenerator() {
		this(999999L, 30,
				"Compute the Mayan number of a given number. E.g. '3' = '...', '46' = '..,.|' or '805' = '..,Ø,|'");
	}

	private final long maxNumber;

	@Override
	protected Question createQuestion() {
		long pickedNumber = (random.nextLong() % maxNumber) + 1;
		return new Question("" + pickedNumber, solver.toNumber(pickedNumber));
	}

	static class Small extends ToMayanQuestionGenerator {

		public Small() {
			super(39, 10, "Compute the Roman number of a number under 40. E.g. '3' = '...' or '19'='....|||'");
		}
	}
}
