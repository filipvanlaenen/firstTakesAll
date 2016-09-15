package no.anderska.wta.questions;

public class SortRomanQuestionGenerator extends SortNumbersQuestionGenerator {

	@Override
	public String description() {
		return "Sort the values as roman numbers. E.g. X, IX, VII => VII, IX, X";
	}

	@Override
	NumberSolver getNumberSolver() {
		return new RomanNumberSolver();
	}

}
