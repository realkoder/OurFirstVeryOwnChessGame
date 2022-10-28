import java.util.Objects;
import java.util.Scanner;

// Methods for all bricks to move, conditions for when taken and not able to take
public class GameLogic extends Board {
    Scanner in = new Scanner(System.in);


    // Behaviors (Methods) ------------------------------------
    protected void pawnMove(int row, int col) {
        System.out.println("Where to?");
        int rowMove = getRowPos();          // Scanning intended moving position based on row position
        int colMove = getColumnPos();       // Scanning intended moving position based on col position

        // Vertical Movements -----------------------
        if (!Objects.equals(chessBoards[colMove][rowMove].getChessPiece().getColor(),
                chessBoards[col][row].getChessPiece().getColor()) &&

                Math.abs(colMove - col) == 2 &&     // When PAWN move it should always minimum move 1 colum position
                row == rowMove &&                   // Only moving should change row position

                chessBoards[colMove][rowMove].getOuterRingMatrix() != null) {

            PawnNoReverseMove(row, col, rowMove, colMove);
        }

        //Vertical move to positions if PAWN is at start place --------------
        if (!Objects.equals(chessBoards[colMove][rowMove].getChessPiece().getColor(),
                chessBoards[col][row].getChessPiece().getColor()) &&

                // Verifying the difference between intended pos and original position equals starting value
                Math.abs(colMove - col) == 14 ||
                Math.abs(colMove - col) == 4 &&

                        col == 14 ||        // Verifying BLACK piece is placed at starting position
                col == 4 &&         // Verifying WHITE piece is placed at starting position

                        chessBoards[colMove][rowMove].getOuterRingMatrix() != null) {

            PawnNoReverseMove(row, col, rowMove, colMove);

        }

        // Diagonally Attacks ----------------------
        if (!Objects.equals(chessBoards[colMove][rowMove].getChessPiece().getColor(),
                chessBoards[col][row].getChessPiece().getColor()) &&
                Math.abs(colMove - col) < 4 &&  // Making sure move is valid
                Math.abs(colMove - col) >= 2 && // Move should always be minimum a position
                Math.abs(rowMove - row) == 1) { // When attack row position always differs from 1

            PawnNoReverseMove(row, col, rowMove, colMove);

        } else {

            System.out.println("You can't make that move!");
        }
    }

    private void PawnNoReverseMove(int row, int col, int rowMove, int colMove) {
        if (chessBoards[col][row].getChessPiece().getColor().equals("W") && colMove - col > 0) {

            chessBoards[colMove][rowMove].setOuterRingMatrix(null);
            chessBoards[colMove][rowMove] = chessBoards[col][row];
            chessBoards[col][row] = new ChessFields();
            chessBoards[col][row].setOuterRingMatrix("   ");
        }

        if (chessBoards[col][row].getChessPiece().getColor().equals("B") && colMove - col < 0) {
            chessBoards[colMove][rowMove].setOuterRingMatrix(null);
            chessBoards[colMove][rowMove] = chessBoards[col][row];
            chessBoards[col][row] = new ChessFields();
            chessBoards[col][row].setOuterRingMatrix("   ");
        }
    }

    protected void knightMove(int row, int col) {
        System.out.println("Where to?");
        int rowMove = getRowPos();
        int colMove = getColumnPos();

        // Move horse!
        if (!Objects.equals(chessBoards[colMove][rowMove].getChessPiece().getColor(),
                chessBoards[col][row].getChessPiece().getColor()) &&
                Math.abs(colMove - col) < 5 &&
                Math.abs(rowMove - row) < 3 &&
                !(Math.abs(colMove - col) == 2 && Math.abs(rowMove - row) == 1) &&
                !(Math.abs(colMove - col) == 0 && Math.abs(rowMove - row) == 1) &&
                !(Math.abs(colMove - col) > 4 && Math.abs(rowMove - row) > 2)) {

            chessBoards[colMove][rowMove].setOuterRingMatrix(null);
            chessBoards[colMove][rowMove] = chessBoards[col][row];
            chessBoards[col][row] = new ChessFields();
            chessBoards[col][row].setOuterRingMatrix("   ");

        } else {

            System.out.println("You can't make that move!");
        }
    }


    public void bishopMove(int row, int col) {
        System.out.println("Where to?");
        int rowMove = getRowPos();
        int colMove = getColumnPos();

        if (!Objects.equals(chessBoards[colMove][rowMove].getChessPiece().getColor(),
                chessBoards[col][row].getChessPiece().getColor()) &&
                isBishopLaneEmpty(row, col, rowMove, colMove) &&
        isBishopMoveValid(row, col, rowMove, colMove)) {

            chessBoards[colMove][rowMove].setOuterRingMatrix(null);
            chessBoards[colMove][rowMove] = chessBoards[col][row];
            chessBoards[col][row] = new ChessFields();
            chessBoards[col][row].setOuterRingMatrix("   ");

        }
    }

    public boolean isBishopMoveValid(int row, int col, int rowMove, int colMove) {
        boolean isValid = false;
        int colLanes = Math.abs((colMove / 2) - (col / 2));
        int rowLanes = Math.abs(rowMove - row);
        if (col == 1){
            colLanes = Math.abs(col - (colMove / 2));
        }
        if (Math.abs(colLanes / rowLanes) == 1){
            return isValid = true;
        }
        return isValid;
    }

    public boolean isBishopLaneEmpty(int row, int col, int rowMove, int colMove) {
        boolean validMove = true;
        if (colMove > col) { // bishop moves from low col to higher col
            if (rowMove > row) { // bishop moves from low row to higher row
                for (int i = 2; i <= (colMove / 2) - (col / 2); i += 2) {
                    if (chessBoards[col][row].getChessPiece().getColor() ==
                            chessBoards[col + i][row + 1].getChessPiece().getColor()) {
                        System.out.println("Nope not possible 1");
                        return validMove = false;
                    }
                }
            } else {// bishop moves from high row to lower row
                for (int i = 2; i <= (colMove / 2) - (col / 2); i += 2) {
                    if (chessBoards[col][row].getChessPiece().getColor() ==
                            chessBoards[col + i][row - 1].getChessPiece().getColor()) {
                        System.out.println("Nope not possible 2");
                        return validMove = false;
                    }
                }
            }
        } else if (colMove < col) {// bishop moves from high col to lower col
            if (rowMove > row) { // bishop moves from low row to higher row
                for (int i = 2; i <= (col / 2) - (colMove / 2); i += 2) {
                    if (chessBoards[col][row].getChessPiece().getColor() ==
                            chessBoards[col - i][row + 1].getChessPiece().getColor()) {
                        System.out.println("Nope not possible 3");
                        return validMove = false;
                    }
                }
            } else {// bishop moves from high row to lower row
                for (int i = 2; i <= (col / 2) - (colMove / 2); i += 2) {
                    if (chessBoards[col][row].getChessPiece().getColor() ==
                            chessBoards[col - i][row - 1].getChessPiece().getColor()) {
                        System.out.println("Nope not possible 4");
                        return validMove = false;
                    }
                }
            }
        }
        return validMove;
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
