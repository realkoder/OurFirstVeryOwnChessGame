public class Menu extends GameLogic {
    //printer text for user and reads choice
    protected final String[] menuOptions = {"1: Move PAWN", "2:", "3: Fjern Ordre",
            "4: Afslut Ordre", "5: Se næste ordre", "6: Se alle aktive ordre", "7: Se alle afsluttede ordre",
            "8: Tæl kassen op", "9: Afslut program"};


    public void getBrickToMove() {
        int i = getRowPos();
        int j = getColumnPos();

        switch (chessBoards[i][j].getChessPiece().getChessBricks()) {
            case PAWN:
                pawnBlackMove2(i, j);
                break;

            case ROOK:

                break;

            case KNIGHT:

                break;

            case BISHOP:

                break;

            case KING:

                break;

            case QUEEN:

                break;

            default:
                System.out.println("Wrong inputs");
        }
    }
}
