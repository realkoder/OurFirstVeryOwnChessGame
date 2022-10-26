public class ChessGameDriver {
    public void run(){
        Board board = new Board();
        board.makeBlackChessPlayer();
        board.makeWhiteChessPlayer();
        board.createChessBoards();
        board.createOuterBoardRing();
        board.addChessPiecesToBoard();
        board.print();
    }
    public static void main(String[]  args){
        new ChessGameDriver().run();
    }
}
