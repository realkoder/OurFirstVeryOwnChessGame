public class ChessGameDriver {
    public void run(){
        Board board = new Board();
        board.makeChessPiecesForPlayers();
        System.out.println(board.blackBricks[1].getPlayer().getColor());
    }
    public static void main(String[]  args){
        new ChessGameDriver().run();
    }
}
