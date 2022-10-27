public class ChessGameDriver {
    public void run(){
        GameLogic game = new GameLogic();

        game.print();
        game.pawnBlackMove();
        game.print();
        game.pawnBlackMove();
        game.print();
        game.pawnBlackMove();
        game.print();
        game.pawnBlackMove();
        game.print();
        game.pawnBlackMove();
        game.print();
        game.pawnBlackMove();
        game.print();
        game.pawnBlackMove();
        game.print();
        game.pawnBlackMove();
    }
    public static void main(String[]  args){
        new ChessGameDriver().run();
    }
}
