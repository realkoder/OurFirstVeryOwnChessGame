import java.util.Objects;
import java.util.Scanner;

// Methods for all bricks to move, conditions for when taken and not able to take
public class GameLogic extends Board {
    Scanner in = new Scanner(System.in);




    // Behaviors (Methods) ------------------------------------
    protected void pawnMove(int row, int col) {
        System.out.println("Where to?");
        int rowMove = getRowPos();
        int colMove = getColumnPos();

        // Vertical Movements -----------------------
        if (!Objects.equals(chessBoards[colMove][row].getChessPiece().getColor(),
                chessBoards[col][row].getChessPiece().getColor()) && Math.abs(colMove - col) < 4 &&
                    chessBoards[colMove][row].getOuterRingMatrix() != null ) {

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

        }

        // Diagonally Attacks ----------------------
        if (!Objects.equals(chessBoards[colMove][rowMove].getChessPiece().getColor(),
                chessBoards[col][row].getChessPiece().getColor()) && Math.abs(colMove - col) < 4 &&
                (Math.abs(rowMove - row) == 1 && chessBoards[colMove][rowMove].getOuterRingMatrix() == null)) {

            chessBoards[colMove][rowMove].setOuterRingMatrix(null);
            chessBoards[colMove][rowMove].setChessPiece(chessBoards[col][row].getChessPiece());
            chessBoards[col][row].setOuterRingMatrix("   ");

        }

        else {

            System.out.println("You can't make that move!");
        }

    }

    protected void knightMove(int row, int col) {
        System.out.println("Where to?");
        int rowMove = getRowPos();
        int colMove = getColumnPos();

        if (!Objects.equals(chessBoards[colMove][rowMove].getChessPiece().getColor(),
                chessBoards[col][row].getChessPiece().getColor()) && Math.abs(colMove - col) < 5 &&
                Math.abs(rowMove-row) < 3 && !(Math.abs(colMove - col) == 2 && Math.abs(rowMove - row) == 1) &&
                !(Math.abs(colMove - col) == 0 && Math.abs(rowMove - row) == 1) && !(Math.abs(colMove - col) > 4 &&
                Math.abs(rowMove - row) > 2) && chessBoards[colMove][rowMove].getOuterRingMatrix() != null) {

            chessBoards[colMove][rowMove].setOuterRingMatrix(null);
            chessBoards[colMove][rowMove].setChessPiece(chessBoards[col][row].getChessPiece());
            chessBoards[col][row].setOuterRingMatrix("   ");

        }

        else {

            System.out.println("You can't make that move!");
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
                } else if (column == 1) {
                    return column + 1;
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
