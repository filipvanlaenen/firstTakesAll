package no.anderska.wta.questions;

public class SortMayanQuestionGenerator extends SortNumbersQuestionGenerator {

	@Override
	public String description() {
		return "Sort the values as Mayan numbers. E.g. '||, ....|, ..|' => '..|, ....|, ||'";
	}

	@Override
	NumberSolver getNumberSolver() {
		return new MayanNumberSolver();
	}

}
