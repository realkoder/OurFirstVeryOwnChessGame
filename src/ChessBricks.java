public enum ChessBricks {
    ROOK("RO", new Player()),
    KNIGHT("KN", new Player()),
    BISHOP("BI", new Player()),
    QUEEN("QU", new Player()),
    KING("KI", new Player()),
    PAWN("PA", new Player());


    private final String name;
    private final Player player;

    public String getName() {
        return name;
    }

    public Player getPlayer() {
        return player;
    }

    ChessBricks(String name, Player player) {
        this.name = name;
        this.player = player;

    }
}
