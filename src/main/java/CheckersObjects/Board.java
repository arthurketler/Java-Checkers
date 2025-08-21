package CheckersObjects;

import ketler.Tools.ANSIPrinting;

public class Board {
    //Matrix of spaces to place the pieces
    private Piece[][] matrix = new Piece[BOARD_SIZE][BOARD_SIZE]; // KEEP PRIVATE
    
    // amount of squares in the board
    private static final byte BOARD_SIZE = 10; // KEEP PRIVATE
    
    // conversion from char to coordinate
    private static final byte CHAR_CONVERSION_RATE = 97;
    
    public Board() {
        this.populateMatrix();
    }
    
    /**
     * Prints the board using ANSI formatting
     */
    public void printBoard() {
        // prints the upper tabulation
        Board.printUpperTabulation();
        
        // iterates through the lines
        for (int lineCoordinate = 0; lineCoordinate < Board.BOARD_SIZE; lineCoordinate++) {
            
            // prints the lines left tabulation
            System.out.print(ANSIPrinting.formatANSICode(String.valueOf(ANSIPrinting.getYellowBackground())) +
                    String.valueOf(lineCoordinate).charAt(String.valueOf(lineCoordinate).length() - 1) // gets the last number of the coordinate
                    + ANSIPrinting.getResetAnsi());
            
            // iterates through the columns
            for (int columnCoordinate = 0; columnCoordinate < Board.BOARD_SIZE; columnCoordinate++) {
                System.out.print(ANSIPrinting.formatSquareAndPieceToPrint(this.matrix[lineCoordinate][columnCoordinate], lineCoordinate, columnCoordinate));
            }
            System.out.println();
        }
    }
    
    /**
     * Used in instancing the matrix
     */
    private void populateMatrix() {
        // iterates through the lines
        for (int lineCoordinate = 0; lineCoordinate < Board.BOARD_SIZE; lineCoordinate++) {
            
            // checks lines
            byte topMiddleIndex = (BOARD_SIZE / 2);
            byte bottomMiddleIndex = (byte) (topMiddleIndex - 1);
            if (lineCoordinate <= bottomMiddleIndex - 1 || lineCoordinate >= topMiddleIndex + 1) {
            
                // iterates through the columns
                for (int columnCoordinate = 0; columnCoordinate < Board.BOARD_SIZE; columnCoordinate++) {
                
                    // check column
                    if (Board.isBlackSquare(lineCoordinate, columnCoordinate)) {
                        this.matrix[lineCoordinate][columnCoordinate] = new Piece(lineCoordinate < BOARD_SIZE / 2);
                    }
                }
            }
        }
    }
    
    /**
     * Returns true if the square should be black(populated and played ones)
     * @param xCoordinate the horizontal coordinate
     * @param yCoordinate the vertical coordinate
     * @return true if black square
     */
    public static boolean isBlackSquare(int yCoordinate, int xCoordinate) { // KEEPS ALWAYS PRIVATE
        // if even add 1 to intercalate
        if (yCoordinate % 2 == 0) xCoordinate += 1;
        
        // if even black else white
        return xCoordinate % 2 == 0;
    }
    
    /**
     * Prints the top tabulation
     */
    private static void printUpperTabulation() {
        for (int i = -1; i < BOARD_SIZE; i++) {
            System.out.print(ANSIPrinting.formatANSICode(String.valueOf(ANSIPrinting.getYellowBackground())) +
                    String.valueOf(i == -1 ? String.valueOf(ANSIPrinting.getBlankSpace()) : coordinatesNumberToChar(i))
                    + ANSIPrinting.getResetAnsi());
        }
        System.out.println();
    }
    
    /**
     * Converts the coordinates
     * @param number input in index + 1
     * @return equivalent char
     */
    private static char coordinatesNumberToChar(int number) {
        return (char) (number + CHAR_CONVERSION_RATE);
    }
    
    /**
     * Converts the coordenates
     * @param character input as char
     * @return equivalent coordinate in index + 1
     */
    private static int coordinatesCharToNumber(char character) {
        return ((int) character) - CHAR_CONVERSION_RATE;
    }
}
