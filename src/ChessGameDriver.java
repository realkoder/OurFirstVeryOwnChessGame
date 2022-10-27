public class ChessGameDriver {
    public void run(){
        Board board = new Board();
        GameLogic game = new GameLogic();

        board.print();



        System.out.println(Board.chessBoards[12][1].getName());
        System.out.println(Board.chessBoards[12][1].getPosition());
        //System.out.println(Board.chessBoards[11][1].getChessPiece()[0].getChessBricks());
    }
    public static void main(String[]  args){
        new ChessGameDriver().run();
    }
}
