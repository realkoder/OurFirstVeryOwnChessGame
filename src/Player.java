public class Player {

    //Har et farve, og brikker
    private String color;

    private ChessBricks chessBricks;

    public ChessBricks getChessBricks() {
        return chessBricks;
    }

    public String getColor() {
        return color;
    }

    public void setChessBricks(ChessBricks chessBricks) {
        this.chessBricks = chessBricks;
    }

    public void setColor(String name) {
        this.color = name;
    }

    Player(String color) {
        setColor(color);
    }


}
