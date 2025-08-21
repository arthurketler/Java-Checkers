package CheckersObjects;

public class Piece {
    private boolean isWhitePiece;
    private boolean isQueen;
    
    public Piece(boolean isWhitePiece) {
        this.isWhitePiece = isWhitePiece;
        isQueen = false;
    }
    
    public boolean getIsWhitePiece() {
        return this.isWhitePiece;
    }
    
    public boolean getIsQueen() {
        return this.isQueen;
    }
}
