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
                        break;

                    case "RO":
                        rookMove(rows, columns);
                        break;

                    case "KN":
                        knightMove(rows, columns);
                        break;

                    case "BI":
                        bishopMover(rows, columns);

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
