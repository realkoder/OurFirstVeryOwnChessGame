public class ChessFields {
    private char name = '@';
    private int position;
    private String outerRingMatrix;

    public Player[] chessPiece = new Player[1];




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
}
