public class ChessFields {
    private char name = '@';
    private int position;
    private String outerRingMatrix;

    private Player chessPiece = new Player("");




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

    public void setOuterRingMatrix(String outerRingMatrix) {
        this.outerRingMatrix = outerRingMatrix;
    }

    public void setChessPiece(Player chessPiece) {
        this.chessPiece = chessPiece;
    }

    // Getter ----------------------------------
    public char getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getOuterRingMatrix() {
        return outerRingMatrix;
    }

    public Player getChessPiece() {
        return chessPiece;
    }
}
