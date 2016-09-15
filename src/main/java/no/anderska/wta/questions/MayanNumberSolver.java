package no.anderska.wta.questions;

public class MayanNumberSolver implements NumberSolver {
	private static final char SHELL = 'Ø';
	private static final char PIPE = '|';
	private static final char DOT = '.';
	private static final char SEPARATOR = ',';

	public String toNumber(long decimal) {
		StringBuilder mayan = new StringBuilder();
		if (decimal > 19) {
			mayan.append(toNumber(decimal / 20));
			mayan.append(SEPARATOR);
		}
		mayan.append(mayanDigit(decimal % 20)); 
		return mayan.toString();
	}

	private String mayanDigit(long decimal) {
		StringBuilder mayan = new StringBuilder();
		long remainder = decimal;
		if (remainder == 0) {
			mayan.append(SHELL);
		}
		while (remainder >= 5) {
			mayan.append(PIPE);
			remainder -= 5;
		}
		while (remainder > 0) {
			mayan.insert(0, DOT);
			remainder -= 1;
		}
		return mayan.toString();
	}

}
