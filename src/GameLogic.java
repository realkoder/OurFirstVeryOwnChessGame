import java.util.Scanner;

// Methods for all bricks to move, conditions for when taken and not able to take
public class GameLogic {
    Scanner in = new Scanner(System.in);


    public void pawnMove(Board field, ChessBricks brick) {
        System.out.print("Please enter number position, then which letter: ");
        int position = in.nextInt();
        in.nextLine();                  // Scanner Bug
        char name = in.nextLine().charAt(0);

        for (int i = 1; i < field.chessBoards.length - 1; i++) {
            for (int j = 1; j < field.chessBoards[i].length - 1; j++) {
                if (field.chessBoards[i][j].getPosition() == position &&
                        field.chessBoards[i][j].getName() == name &&
                        field.findFieldPosition(position, name) &&
                        field.checkChessBrick(position, name) == ChessBricks.PAWN) {

                    

                }
            }
        }
    }

    public void KnightMove() {

    }

    public void bishopMove() {

    }

    public void rookMove() {

    }

    public void queenMove() {

    }

    public void kingMove() {

    }
}
