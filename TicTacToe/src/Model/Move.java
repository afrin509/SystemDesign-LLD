package Model;

public class Move {
    public int row;
    public int column;
    public PeiceType piece;
    public boolean success;

    public Move(int row, int column, PeiceType piece, boolean success) {
        this.row = row;
        this.column = column;
        this.piece = piece;
        this.success = success;
    }
}


