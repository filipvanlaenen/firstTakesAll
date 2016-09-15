package no.anderska.wta.questions;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class MayanNumberQuestionGeneratorTest {
	private final MayanNumberSolver solver = new MayanNumberSolver();

	@Test
	public void zeroIsShell() throws Exception {
		assertThat(solver.toNumber(0)).isEqualTo("Ø");
	}

	@Test
	public void oneIsDot() throws Exception {
		assertThat(solver.toNumber(1)).isEqualTo(".");
	}

	@Test
	public void twoIsDotDot() throws Exception {
		assertThat(solver.toNumber(2)).isEqualTo("..");
	}

	@Test
	public void fourIsFourDots() throws Exception {
		assertThat(solver.toNumber(4)).isEqualTo("....");
	}

	@Test
	public void fiveIsPipe() throws Exception {
		assertThat(solver.toNumber(5)).isEqualTo("|");
	}

	@Test
	public void sixIsDotPipe() throws Exception {
		assertThat(solver.toNumber(6)).isEqualTo(".|");
	}

	@Test
	public void sevenIsDotDotPipe() throws Exception {
		assertThat(solver.toNumber(7)).isEqualTo("..|");
	}

	@Test
	public void nineIsDotDotDotDotPipe() throws Exception {
		assertThat(solver.toNumber(9)).isEqualTo("....|");
	}

	@Test
	public void tenIsPipePipe() throws Exception {
		assertThat(solver.toNumber(10)).isEqualTo("||");
	}

	@Test
	public void elevenIsDotPipePipe() throws Exception {
		assertThat(solver.toNumber(11)).isEqualTo(".||");
	}

	@Test
	public void nineteenIsDotDotDotDotPipePipePipe() throws Exception {
		assertThat(solver.toNumber(19)).isEqualTo("....|||");
	}

	@Test
	public void twentyIsDotSeparatorShell() throws Exception {
		assertThat(solver.toNumber(20)).isEqualTo(".,Ø");
	}

	@Test
	public void twentyOneIsDotSeparatorDot() throws Exception {
		assertThat(solver.toNumber(21)).isEqualTo(".,.");
	}

	@Test
	public void threehundrerninetynineIsDotDotDotDotPipePipePipeSeparatorDotDotDotDotPipePipePipe() throws Exception {
		assertThat(solver.toNumber(399)).isEqualTo("....|||,....|||");
	}

	@Test
	public void fourhundredIsDotSeparatorShellSeparatorShell() throws Exception {
		assertThat(solver.toNumber(400)).isEqualTo(".,Ø,Ø");
	}

	@Test
	public void fourhundredOneIsDotSeparatorShellSeparatorDot() throws Exception {
		assertThat(solver.toNumber(401)).isEqualTo(".,Ø,.");
	}

	@Test
	public void sixteenthousandhundredtwentyfiveIsDotDotSeparatorShellSeparatorDotPipeSeparatorPipe() throws Exception {
		assertThat(solver.toNumber(16125)).isEqualTo("..,Ø,.|,|");
	}
}
