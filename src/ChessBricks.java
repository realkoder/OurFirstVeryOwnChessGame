public enum ChessBricks {
    ROOK("RO"),
    KNIGHT("KN"),
    BISHOP("BI"),
    QUEEN("QU"),
    KING("KI"),
    PAWN("PA");


    private final String name;

    public String getName() {
        return name;
    }

    ChessBricks(String name) {
        this.name = name;

    }

}
