package no.anderska.wta.questions;

import no.anderska.wta.questions.RomanNumberSolver;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class RomanNumberQuestionGeneratorTest {

    private final RomanNumberSolver solver = new RomanNumberSolver();

    @Test
    public void oneIsI() throws Exception {
        assertThat(solver.toNumber(1)).isEqualTo("I");
    }

    @Test
    public void twoIsII() throws Exception {
        assertThat(solver.toNumber(2)).isEqualTo("II");
    }

    @Test
    public void threeIsIII() throws Exception {
        assertThat(solver.toNumber(3)).isEqualTo("III");
    }

    @Test
    public void fourIsIV() throws Exception {
        assertThat(solver.toNumber(4)).isEqualTo("IV");
    }

    @Test
    public void fiveIsV() throws Exception {
        assertThat(solver.toNumber(5)).isEqualTo("V");
    }

    @Test
    public void shouldMatch() throws Exception {
        assertThat(solver.toNumber(9)).isEqualTo("IX");
        assertThat(solver.toNumber(10)).isEqualTo("X");
        assertThat(solver.toNumber(30)).isEqualTo("XXX");
        assertThat(solver.toNumber(40)).isEqualTo("XL");
        assertThat(solver.toNumber(42)).isEqualTo("XLII");
        assertThat(solver.toNumber(50)).isEqualTo("L");
        assertThat(solver.toNumber(56)).isEqualTo("LVI");
        assertThat(solver.toNumber(99)).isEqualTo("XCIX");
        assertThat(solver.toNumber(200)).isEqualTo("CC");
        assertThat(solver.toNumber(400)).isEqualTo("CD");
        assertThat(solver.toNumber(500)).isEqualTo("D");
        assertThat(solver.toNumber(744)).isEqualTo("DCCXLIV");
        assertThat(solver.toNumber(999)).isEqualTo("CMXCIX");
    }

}
