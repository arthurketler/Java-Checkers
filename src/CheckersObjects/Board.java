package CheckersObjects;

import java.awt.*;

public class Board {
    // deletar
    public static void main(String[] args) {
        printBoard();
    }
    // deletar

    //Matrix of spaces to place the pieces
    private Pieces[][] matrix = new Pieces[8][8];

    private static final int squareSize = 1;
    private static final int squareAmmount = 8;
    private static final char square = '■';
    private static final char pawn = '♟';
    private static final char suamae = '♕';

    private static void printBoard() {
        // top boundaries
        Board.printBoundaries();

        // loop for horizontal square
        for (int i = 0; i < Board.squareAmmount; i++) {
            // separation horizontal lines
            //if (i != 0) Board.boardHorizontalLine();

            // -------- lines itself
            // left border
            String line = Board.boardSingleLineBorder();

            // middle part
            for (int j = 0; j < Board.squareAmmount; j++) {
                // interLine
                //line += j == 0 ? "" : square;

                // pieces
                line += String.valueOf('a').repeat(Board.squareSize);
            }

            // right border
            line += Board.boardSingleLineBorder();

            // repeats the line
            String finalLine = line;
            for (int j = 0; j < Board.squareSize - 1; j++) {
                finalLine += String.format("%n%s", line);
            }

            System.out.println(finalLine);

        }

        // bottom boundaries
        Board.printBoundaries();
    }

    private static String boardSingleLineBorder() {
        return String.valueOf(square).repeat(Board.squareSize);
    }

    private static void boardHorizontalLine() {
        int boardSize = (Board.squareAmmount + 2); // gets the square ammount
        boardSize *= Board.squareSize; // multiplies the ammount
        boardSize += Board.squareAmmount - 1; // Adding lines


        System.out.println(String.valueOf(Board.square).repeat(boardSize));
    }

    private static void printBoundaries() {
        for (int i = 0; i < squareSize; i++) {
            boardHorizontalLine();
        }
    }
}
