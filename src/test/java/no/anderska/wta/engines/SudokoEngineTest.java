package no.anderska.wta.engines;

import static org.fest.assertions.Assertions.assertThat;
import no.anderska.wta.questions.SudokoEngine;

import org.junit.Test;

public class SudokoEngineTest {

    private final SudokoEngine sudokoEngine = new SudokoEngine();

    @Test
    public void shouldParseStringToBoard() throws Exception {
        String boardStr =
                "123456789\n" +
                "234567891\n" +
                "234567891\n" +
                "234567891\n" +
                "234567891\n" +
                "234567891\n" +
                "234567891\n" +
                "---------\n" +
                "345678912\n";

        Integer [][] board = sudokoEngine.readBoard(boardStr, "\n");

        assertThat(board).hasSize(9);
        assertThat(board[0]).hasSize(9);


        assertThat(board[0][0]).isEqualTo(1);
    }

    @Test
    public void shouldHandleIllegalBoards() throws Exception {
        assertThat(sudokoEngine.readBoard(null,"\n")).isNull();
        assertThat(sudokoEngine.readBoard("","\n")).isNull();

        String boardStr =
                "123a56789\n" +
                        "234567891\n" +
                        "234567891\n" +
                        "234567891\n" +
                        "234567891\n" +
                        "234567891\n" +
                        "234567891\n" +
                        "---------\n" +
                        "345678912\n";

        assertThat(sudokoEngine.readBoard(boardStr,"\n")).isNull();

        boardStr =
                "123456789\n" +
                        "234567891\n" +
                        "234567891\n" +
                        "234567891\n" +
                        "234567891\n" +
                        "234567891\n" +
                        "---------\n" +
                        "345678912\n";

        assertThat(sudokoEngine.readBoard(boardStr,"\n")).isNull();

        boardStr =
                "12356789\n" +
                        "234567891\n" +
                        "234567891\n" +
                        "234567891\n" +
                        "234567891\n" +
                        "234567891\n" +
                        "234567891\n" +
                        "---------\n" +
                        "345678912\n";

        assertThat(sudokoEngine.readBoard(boardStr,"\n")).isNull();

    }
}
