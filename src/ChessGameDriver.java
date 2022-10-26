public class ChessGameDriver {
    public void run(){
        Board board = new Board();
        board.print();
        System.out.println(board.chessBoards[14][1].getName());
        System.out.println(board.chessBoards[14][1].getPosition());
        System.out.println(board.chessBoards[14][1].getChessPiece()[0].getChessBricks());
    }
    public static void main(String[]  args){
        new ChessGameDriver().run();
    }
}
