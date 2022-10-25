public class ChessGameDriver {
    public void run(){
        Board board = new Board();
        board.createChessBoard();
        board.print();
        board.makePawn();
        System.out.println();
        System.out.println();
        board.print();
    }
    public static void main(String[]  args){
        new ChessGameDriver().run();
    }
}
