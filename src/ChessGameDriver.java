public class ChessGameDriver {
    public void run(){
        GameLogic game = new GameLogic();

        game.print();
        game.pawnBlackMove2(game.getRowPos(), game.getColumnPos());
        game.print();
        game.pawnBlackMove2(game.getRowPos(), game.getColumnPos());
        game.print();
        game.pawnBlackMove2(game.getRowPos(), game.getColumnPos());
        game.print();
        game.pawnBlackMove2(game.getRowPos(), game.getColumnPos());
        game.print();
        game.pawnBlackMove2(game.getRowPos(), game.getColumnPos());
        game.print();
    }
    public static void main(String[]  args){
        new ChessGameDriver().run();
    }
}
