package no.anderska.wta.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import no.anderska.wta.Validate;
import no.anderska.wta.game.Question;
import no.anderska.wta.game.QuestionGenerator;
import no.anderska.wta.game.QuestionSet;

class MinesweeperQuestionGenerator implements QuestionGenerator {
    private final int rows;
    private final int cols;
    private final int percentMines;
    private final int numberOfBoards;


    private MinesweeperQuestionGenerator(int rows, int cols, int percentMines, int numberOfBoards) {
        this.rows = Validate.positiveNumber(rows, "rows");
        this.cols = Validate.positiveNumber(cols, "cols");
        this.percentMines = (int) Validate.numberInRange(percentMines, "percentMines", 1, 100);
        this.numberOfBoards = Validate.positiveNumber(numberOfBoards, "numberOfBoards");
    }

    public MinesweeperQuestionGenerator() {
        this(16,16,18,10);
    }

    private int mineVal(List<String> boardlines,int row,int col) {
        if (row < 0 || row >= boardlines.size() || col < 0 || col >= boardlines.get(row).length()) {
            return 0;
        }
        return boardlines.get(row).charAt(col) == '*' ? 1 : 0;
    }

    String solve(String board) {
        List<String> boardlines=lines(board);
        StringBuilder genboard=new StringBuilder();
        for (int row=0;row<boardlines.size();row++) {
            genboard.append("[");

            String line = boardlines.get(row);

            for (int col=0;col<line.length();col++) {
                if (line.charAt(col) == '*') {
                    genboard.append("*");
                    continue;
                }
                int minecount =
                        mineVal(boardlines,row-1,col-1) +
                        mineVal(boardlines,row-1,col) +
                        mineVal(boardlines,row-1,col+1) +
                        mineVal(boardlines,row,col-1) +
                        mineVal(boardlines,row,col+1) +
                        mineVal(boardlines,row+1,col-1) +
                        mineVal(boardlines,row+1,col) +
                        mineVal(boardlines,row+1,col+1);
                genboard.append(minecount);
            }

            genboard.append("]");
        }
        return genboard.toString();
    }

    List<String> lines(String board) {
        List<String> result = new ArrayList<>();
        int pos = board.indexOf("[");
        while (pos != -1) {
            int endpos=board.indexOf("]",pos);
            result.add(board.substring(pos+1,endpos));
            pos = board.indexOf("[",pos+1);
        }
        return result;
    }

    private String generateBoard() {
        StringBuilder board = new StringBuilder();
        Random random = new Random();
        for (int row=0;row<rows;row++) {
            board.append("[");
            for (int col=0;col<cols;col++) {
                boolean mineHere = (random.nextInt(100) < percentMines);
                board.append(mineHere ? "*" : "-");
            }
            board.append("]");
        }
        return board.toString();
    }

    @Override
    public QuestionSet generateQuestionSet(String playerid, String categoryid) {
        List<Question> questions = new ArrayList<>();
        for (int i=0;i<numberOfBoards;i++) {
            String genboard = generateBoard();
            questions.add(new Question(genboard,solve(genboard)));
        }
        return new QuestionSet(questions, this, categoryid);
    }

    @Override
    public String description() {
        return "Display the number of mines on a minesweeper board with mines denoted * and empty fields denoted -. [-*-] => [1*1] and [--*][*--][---] => [12*][*21][110]";
    }

}
