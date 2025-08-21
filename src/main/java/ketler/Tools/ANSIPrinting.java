package ketler.Tools;

import CheckersObjects.Board;
import CheckersObjects.Piece;

public class ANSIPrinting {
    // Defining ANSI color constants
    private static final byte BLACK_BACKGROUND = 100;
    private static final byte YELLOW_BACKGROUND = 43;
    private static final byte WHITE_BACKGROUND = 107;
    private static final byte RED_PIECE = 91;
    private static final byte GREEN_PIECE = 92;
    private static final byte WHITE_PIECE = 97;
    private static final String RESET_ANSI = "\u001B[0m";
    private static final String ANSI_CODE_BASE = "\u001B[";
    private static final String ANSI_CODE_CLOSURE = "m";
    
    // dictionary
    private static final String PAWN = "O";
    private static final String QUEEN = "@";
    private static final String BLANK_SPACE = " ";
    
    public static byte getYellowBackground() {
        return YELLOW_BACKGROUND;
    }
    
    public static String getResetAnsi() {
        return RESET_ANSI;
    }
    
    public static String getBlankSpace() {
        return BLANK_SPACE;
    }
    
    /**
     * Format the character based on coordinates and kind of piece
     * @param character the character to be printed
     * @param xCoordinate the horizontal coordinate
     * @param yCoordinate the vertical coordinate
     * @return the String rightly formated
     */
    public static String formatSquareAndPieceToPrint(Piece character, int yCoordinate, int xCoordinate) {
        // define the background color code
        StringBuilder code = new StringBuilder(String.valueOf(defineBackground(yCoordinate, xCoordinate)));
        
        // define the piece color code
        if (character != null) {
            code.append(";").append(String.valueOf(character.getIsWhitePiece() ? WHITE_PIECE : RED_PIECE));
        }
        
        // encapsule the code
        code.replace(0, code.length(), formatANSICode(code.toString()));
        
        // check if character exists and decides char
        return code.append(character != null ? (!character.getIsQueen() ? PAWN : QUEEN) : BLANK_SPACE).append(RESET_ANSI).toString();
    }
    
    /**
     * Format the character based on coordinates and kind of piece
     * Pieceless version
     * @param xCoordinate the horizontal coordinate
     * @param yCoordinate the vertical coordinate
     * @return the String rightly formated
     */
    private static String formatSquareAndPieceToPrint(int yCoordinate, int xCoordinate) {
        return formatSquareAndPieceToPrint(null, yCoordinate, xCoordinate);
    }
    
    /**
     * Encapsules the code in ANSICode
     * @param code code to be encapsuled
     * @return the whole String
     */
    public static String formatANSICode(String code) {
        // code append
        return ANSI_CODE_BASE + code + ANSI_CODE_CLOSURE;
    }
    
    /**
     * Returns the ANSI code for the background based on coordinates
     * @param xCoordinate the horizontal coordinate
     * @param yCoordinate the vertical coordinate
     * @return the ANSI code for the square
     */
    private static byte defineBackground(int yCoordinate, int xCoordinate) {
        // if true black square
        return Board.isBlackSquare(yCoordinate, xCoordinate) ? BLACK_BACKGROUND : WHITE_BACKGROUND;
    }
}
