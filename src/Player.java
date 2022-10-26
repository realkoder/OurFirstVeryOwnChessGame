// The player class holds a name, color and a chess brick.
public class Player {

    private String name;
    private String color;

    private ChessBricks chessBricks;


    // Getter -------------------------------
    public ChessBricks getChessBricks() {
        return chessBricks;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    // Setter ---------------------------------

    public void setName(String name) {
        this.name = name;
    }
    public void setChessBricks(ChessBricks chessBricks) {
        this.chessBricks = chessBricks;
    }

    public void setColor(String name) {
        this.color = name;
    }

    // Constructor -----------------------------
    Player(String color) {
        setColor(color);
    }


}
