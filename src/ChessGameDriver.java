public class ChessGameDriver {
    public void run(){
        Board board = new Board();
        board.makeChessPiecesForPlayers();
        board.createChessBoards();
        board.print();
    }
    public static void main(String[]  args){
        new ChessGameDriver().run();
    }
}
