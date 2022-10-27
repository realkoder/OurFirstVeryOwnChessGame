import java.util.Scanner;

// Methods for all bricks to move, conditions for when taken and not able to take
public class GameLogic extends Board {
    Scanner in = new Scanner(System.in);


    public void pawnMove() {
        System.out.print("Please enter number position: ");
        int position = in.nextInt();
        System.out.print(" And which letter: ");
        in.nextLine();                  // Scanner Bug
        char name = in.next().charAt(0);

        for (int i = 1; i < chessBoards.length - 1; i++) {
            for (int j = 1; j < chessBoards[i].length - 1; j++) {
                // Conditions for being allowed to move and finding the i and j position:
                if (chessBoards[i][j].getPosition() == position &&
                        chessBoards[i][j].getName() == name &&
                        findFieldPosition(position, name) &&
                        checkChessBrick(position, name) == ChessBricks.PAWN) {

                    // Initiating move condition
                    System.out.print("Where do you want to move your " + ChessBricks.PAWN+ " ?: ");
                    int movePosition = in.nextInt();
                    in.nextLine();              // Scanner Bug
                    char moveName = in.next().charAt(0);

                    // Predefine options of PAWN movement - if conditions are met, move is acceptable

                        // Moving player brick, and setting former field to null (removing brick)
                        chessBoards[i-2][j].setChessPiece(chessBoards[i][j].getChessPiece());

                        chessBoards[i][j].setOuterRingMatrix("   ");


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
