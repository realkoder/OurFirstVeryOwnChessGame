public class ChessFields {
    private char name = '@';
    private int position;

    private ChessBricks[] chessPiece = new ChessBricks[1];




    // Constructor ----------------------------
    ChessFields() {
    }

    // Setter ---------------------------------
    public void setName(int j) {
        this.name += j;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    // Getter ----------------------------------
    public char getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
