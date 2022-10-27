import java.util.Objects;
import java.util.Scanner;

// Methods for all bricks to move, conditions for when taken and not able to take
public class GameLogic extends Board {
    Scanner in = new Scanner(System.in);




    // Behaviors (Methods) ------------------------------------
    protected void pawnBlackMove2(int row, int col) {
        System.out.println("Where to?");
        int rowMove = getRowPos();
        int colMove = getColumnPos();

        if (!Objects.equals(chessBoards[colMove][row].getChessPiece().getColor(),
                chessBoards[col][row].getChessPiece().getColor()) && Math.abs(colMove - col) < 4 &&
                    chessBoards[colMove][row].getOuterRingMatrix() != null) {

                    chessBoards[colMove][row].setOuterRingMatrix(null);
                    chessBoards[colMove][row].setChessPiece(chessBoards[col][row].getChessPiece());
                    chessBoards[col][row].setOuterRingMatrix("   ");
        }

        if (!Objects.equals(chessBoards[colMove][row].getChessPiece().getColor(),
                chessBoards[col][row].getChessPiece().getColor()) && (chessBoards[col][row].getPosition() == 7 ||
                    chessBoards[col][row].getPosition() == 2) && Math.abs(colMove - col) == 4 &&
                    chessBoards[colMove][row].getOuterRingMatrix() != null) {

                    chessBoards[colMove][row].setOuterRingMatrix(null);
                    chessBoards[colMove][row].setChessPiece(chessBoards[col][row].getChessPiece());
                    chessBoards[col][row].setOuterRingMatrix("   ");

        } else {

            System.out.println("You can't make that move!");
        }

    }


    protected void pawnBlackMove() {
        System.out.print("Please enter number position: ");
        int position = in.nextInt();
        in.nextLine();                  // Scanner Bug
        System.out.print(" And which letter: ");
        char name = in.next().charAt(0);

        for (int i = 1; i < chessBoards.length - 1; i++) {
            for (int j = 1; j < chessBoards[i].length - 1; j++) {
                // Conditions for being allowed to move and finding the i and j position:
                if (chessBoards[i][j].getPosition() == position &&
                        chessBoards[i][j].getName() == name &&
                        findFieldPosition(position, name) &&
                        checkChessBrick(position, name) == ChessBricks.PAWN) {

                    // Initiating move condition
                    System.out.print("Where do you want to move your " + ChessBricks.PAWN + " ?: ");
                    System.out.print("Number: ");
                    int movePosition = in.nextInt();
                    in.nextLine();              // Scanner Bug
                    System.out.print("Letter: ");
                    char moveName = in.next().charAt(0);

                    // Predefine options of PAWN movement - if conditions are met, move is acceptable
                    if (chessBoards[i - 2][j].getPosition() == movePosition &&
                            chessBoards[i - 2][j].getName() == moveName &&
                            chessBoards[i - 2][j].getOuterRingMatrix() != null &&
                            !Objects.equals(chessBoards[i - 2][j].getChessPiece().getColor(),
                                    chessBoards[i][j].getChessPiece().getColor())) {

                        // Moving player brick, and setting former field to null (removing brick)
                        chessBoards[i - 2][j].setOuterRingMatrix(null);
                        chessBoards[i - 2][j].setChessPiece(chessBoards[i][j].getChessPiece());
                        chessBoards[i][j].setOuterRingMatrix("   ");
                    }

                    // Attempt to attack enemy diagonally-RIGHT and kill them.
                    if (chessBoards[i - 2][j + 1].getPosition() == movePosition &&
                            chessBoards[i - 2][j + 1].getName() == moveName &&
                            chessBoards[i - 2][j + 1].getOuterRingMatrix() == null) {

                        // Moving player brick, and killing enemy Pawn
                        chessBoards[i - 2][j + 1].setChessPiece(chessBoards[i][j].getChessPiece());
                        chessBoards[i][j].setOuterRingMatrix("   ");
                    }

                    // Attempt to attack enemy diagonally-LEFT and kill them.
                    if (chessBoards[i - 2][j - 1].getPosition() == movePosition &&
                            chessBoards[i - 2][j - 1].getName() == moveName &&
                            chessBoards[i - 2][j - 1].getOuterRingMatrix() == null) {

                        // Moving player brick, and killing enemy Pawn
                        chessBoards[i - 2][j - 1].setChessPiece(chessBoards[i][j].getChessPiece());
                        chessBoards[i][j].setOuterRingMatrix("   ");
                    }
                    break;
                }
            }   // Row loop end
        }   // Col loop end
    }   // Method end


    protected void knightBlackMove() {

        System.out.print("Please enter number position: ");
        int position = in.nextInt();
        in.nextLine();                  // Scanner Bug
        System.out.print(" And which letter: ");
        char name = in.next().charAt(0);

        for (int i = 1; i < chessBoards.length - 1; i++) {
            for (int j = 1; j < chessBoards[i].length - 1; j++) {
                // Conditions for being allowed to move and finding the i and j position:
                if (chessBoards[i][j].getPosition() == position &&
                        chessBoards[i][j].getName() == name &&
                        findFieldPosition(position, name) &&
                        checkChessBrick(position, name) == ChessBricks.KNIGHT) {

                    // Initiating move condition
                    System.out.print("Where do you want to move your " + ChessBricks.KNIGHT + " ?: ");
                    System.out.print("Number: ");
                    int movePosition = in.nextInt();
                    in.nextLine();              // Scanner Bug
                    System.out.print("Letter: ");
                    char moveName = in.next().charAt(0);

                    // Predefine options of PAWN movement - if conditions are met, move is acceptable
                    if (chessBoards[i - 4][j + 1].getPosition() == movePosition &&
                            chessBoards[i - 4][j + 1].getName() == moveName &&
                            chessBoards[i - 4][j + 1].getOuterRingMatrix() != null) {

                        // Moving player brick, and setting former field to null (removing brick)
                        chessBoards[i - 4][j + 1].setOuterRingMatrix(null);
                        chessBoards[i - 4][j + 1].setChessPiece(chessBoards[i][j].getChessPiece());
                        chessBoards[i][j].setOuterRingMatrix("   ");
                    }

                    // Move horse 2 up and one left.
                    if (chessBoards[i - 4][j - 1].getPosition() == movePosition &&
                            chessBoards[i - 4][j - 1].getName() == moveName &&
                            chessBoards[i - 4][j - 1].getOuterRingMatrix() != null) {

                        // Moving player brick, and setting former field to null (removing brick)
                        chessBoards[i - 4][j - 1].setOuterRingMatrix(null);
                        chessBoards[i - 4][j - 1].setChessPiece(chessBoards[i][j].getChessPiece());
                        chessBoards[i][j].setOuterRingMatrix("   ");
                    }

                    // Attempt to attack enemy diagonally-RIGHT and kill them.
                    if (chessBoards[i - 4][j + 1].getPosition() == movePosition &&
                            chessBoards[i - 4][j + 1].getName() == moveName &&
                            chessBoards[i - 4][j + 1].getOuterRingMatrix() == null) {

                        // Moving player brick, and killing enemy Pawn
                        chessBoards[i - 4][j + 1].setChessPiece(chessBoards[i][j].getChessPiece());
                        chessBoards[i][j].setOuterRingMatrix("   ");
                    }

                    // Attempt to attack enemy diagonally-LEFT and kill them.
                    if (chessBoards[i - 4][j - 1].getPosition() == movePosition &&
                            chessBoards[i - 4][j - 1].getName() == moveName &&
                            chessBoards[i - 4][j - 1].getOuterRingMatrix() == null) {

                        // Moving player brick, and killing enemy Pawn
                        chessBoards[i - 4][j - 1].setChessPiece(chessBoards[i][j].getChessPiece());
                        chessBoards[i][j].setOuterRingMatrix("   ");
                    }
                    break;
                }
            }   // Row loop end
        }

    }

    public void bishopMove() {

    }

    public void rookMove() {

    }

    public void queenMove() {

    }

    public void kingMove() {

    }



    // Get ROWS AND COLUMNS! --------------------------------

    // Rows ....... A -> H
    protected int getRowPos() {
        System.out.println("Type letter");
        return in.next().toUpperCase().charAt(0) - 64;
    }


    // Column ..... 1 - 8
    protected int getColumnPos() {
        boolean keeprunning = true;
        int column = 0;
        System.out.println("Type position");
        do {
            if (in.hasNextInt()) {
                column = in.nextInt();

                if (column > 1 && column < 9) {
                    return column * 2;
                }
            } else {
                System.out.println("A POSITION PLEASE!");
                in.nextLine();
            }
        } while (keeprunning);
        in.nextLine();
        return column * 2;
    }



}
