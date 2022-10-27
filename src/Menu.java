public class Menu extends GameLogic {
    //printer text for user and reads choice


    public void getBrickToMove() {
        boolean keepRunning = true;
        do {
            print();
            System.out.println("Please make your move! ");
            int rows = getRowPos();
            int columns = getColumnPos();

            if (chessBoards[columns][rows].getChessPiece().getChessBricks() != null) {

                switch (chessBoards[columns][rows].getChessPiece().getChessBricks().getName()) {
                    case "PA":
                        pawnMove(rows, columns);
                        System.out.println("Player " + chessBoards[columns][rows].getChessPiece().getColor() +
                                " moved a - PAWN");
                        break;

                    case "RO":

                        break;

                    case "KN":
                        knightMove(rows, columns);
                        System.out.println("Player " + chessBoards[columns][rows].getChessPiece().getColor() +
                                " moved a - KNIGHT");
                        break;

                    case "BI":

                        break;

                    case "KI":

                        break;

                    case "QU":

                        break;

                    default:
                        System.out.println("Wrong inputs");
                }

            }

            else {

                System.out.println("No brick available!");
            }

        } while (keepRunning);
    }

}
