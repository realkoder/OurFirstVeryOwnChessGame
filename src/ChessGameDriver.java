public class ChessGameDriver {
    public void run(){
        Menu game = new Menu();

            game.print();
            game.knightMove(game.getRowPos(), game.getColumnPos());
            game.print();
            game.knightMove(game.getRowPos(), game.getColumnPos());
            game.print();
            game.knightMove(game.getRowPos(), game.getColumnPos());
            game.print();
            game.knightMove(game.getRowPos(), game.getColumnPos());
            game.print();
            game.knightMove(game.getRowPos(), game.getColumnPos());
            game.print();
            game.knightMove(game.getRowPos(), game.getColumnPos());
            game.print();
            game.knightMove(game.getRowPos(), game.getColumnPos());
            game.print();
            game.knightMove(game.getRowPos(), game.getColumnPos());
            game.print();
        game.pawnMove(game.getRowPos(), game.getColumnPos());
        game.print();
        game.pawnMove(game.getRowPos(), game.getColumnPos());
        game.print();
        game.pawnMove(game.getRowPos(), game.getColumnPos());
        game.print();
        game.pawnMove(game.getRowPos(), game.getColumnPos());
        game.print();

    }
    public static void main(String[]  args){
        new ChessGameDriver().run();
    }
}
