public class Board {

    public Player[] whiteBricks = new Player[6];
    public Player[] blackBricks = new Player[6];

    public ChessFields[][] chessBoards = new ChessFields[18][10];



    // Creating all chess pieces for both black and white player.
    public void makeWhiteChessPlayer() {
        // Set pawns for both players
            whiteBricks[0] = new Player("W");
            whiteBricks[0].setChessBricks(ChessBricks.PAWN);

        // Set rooks for both players
            whiteBricks[1] = new Player("W");
            whiteBricks[1].setChessBricks(ChessBricks.ROOK);

        // Set Bishops for both players
            whiteBricks[2] = new Player("W");
            whiteBricks[2].setChessBricks(ChessBricks.BISHOP);

        // Set knight
            whiteBricks[3] = new Player("W");
            whiteBricks[3].setChessBricks(ChessBricks.KNIGHT);

        // Set kings
        whiteBricks[4] = new Player("W");
        whiteBricks[4].setChessBricks(ChessBricks.KING);

        // Set Queen
        whiteBricks[5] = new Player("W");
        whiteBricks[5].setChessBricks(ChessBricks.QUEEN);
    }

    public void makeBlackChessPlayer() {
        // Set Pawns
        blackBricks[0] = new Player("B");
        blackBricks[0].setChessBricks(ChessBricks.PAWN);

        // Set Rooks
        blackBricks[1] = new Player("B");
        blackBricks[1].setChessBricks(ChessBricks.ROOK);

        // Set Bishops
        blackBricks[2] = new Player("B");
        blackBricks[2].setChessBricks(ChessBricks.BISHOP);

        // Set knights
        blackBricks[3] = new Player("B");
        blackBricks[3].setChessBricks(ChessBricks.KNIGHT);

        // Set King
        blackBricks[4] = new Player("B");
        blackBricks[4].setChessBricks(ChessBricks.KING);

        // Set Queen
        blackBricks[5] = new Player("B");
        blackBricks[5].setChessBricks(ChessBricks.QUEEN);
    }


    // Creating the chess board playing field
    public void createChessBoards() {
        for (int i = 1; i < chessBoards.length - 1; i++) {
            for (int j = 1; j < chessBoards[i].length - 1; j++) {
                chessBoards[i][j] = new ChessFields();
                chessBoards[i][j].setName(j);
                chessBoards[i][j].setPosition(i);
            }

        }
    }

    // Creating an outer ring of the chess board, for layout purposes
    public void createOuterBoardRing() {
        int boardNum = 1;

        for (int i = 0; i < chessBoards.length; i++) {
            for (int j = 0; j < chessBoards[i].length; j++) {

                // Creates and empty space at start of column and end, while adding Characters of chess fields A -> H
                if (i == 0 || i == 17) {
                    if (j == 0 || j == 9) {
                        chessBoards[i][j] = new ChessFields();
                        chessBoards[i][j].setOuterRingMatrix("   ");
                    } else {
                        chessBoards[i][j] = new ChessFields();
                        chessBoards[i][j].setOuterRingMatrix(Character.toString(65 + j -1) + "  ");
                    }
                }

                // Creates a dividing line between fields ---------
                if (i == 1 || i == 3 || i == 5 || i == 7 || i == 9 || i == 11 || i == 13 || i == 15) {
                    chessBoards[i][j] = new ChessFields();
                    chessBoards[i][j].setOuterRingMatrix("---");
                }

                // Creates empty spaces for print layout between black and white pieces at start -----
                if (i == 6 || i == 8 || i == 10 || i == 12) {
                    if (j > 0 && j < 9) {
                        chessBoards[i][j] = new ChessFields();
                        chessBoards[i][j].setOuterRingMatrix("   ");
                    }
                }

                // Creates the numbers so one can see the chess field locations -----
                if (i % 2 == 0 && j == 0 && i != 0) {
                    chessBoards[i][j] = new ChessFields();
                    chessBoards[i][j].setOuterRingMatrix(boardNum + "  ");
                    chessBoards[i][j+9] = new ChessFields();
                    chessBoards[i][j+9].setOuterRingMatrix(boardNum + "  ");
                    boardNum++;
                }
            }
        }
    }

    public void addChessPiecesToBoard() {
        // Add White Chess Pieces ----------------
        chessBoards[2][1].chessPiece[0] = whiteBricks[1];
        chessBoards[2][2].chessPiece[0] = whiteBricks[3];
        chessBoards[2][3].chessPiece[0] = whiteBricks[2];
        chessBoards[2][4].chessPiece[0] = whiteBricks[4];
        chessBoards[2][5].chessPiece[0] = whiteBricks[5];
        chessBoards[2][6].chessPiece[0] = whiteBricks[2];
        chessBoards[2][7].chessPiece[0] = whiteBricks[3];
        chessBoards[2][8].chessPiece[0] = whiteBricks[1];

        // Add Black Chess Pieces ----------------
        chessBoards[16][1].chessPiece[0] = blackBricks[1];
        chessBoards[16][2].chessPiece[0] = blackBricks[3];
        chessBoards[16][3].chessPiece[0] = blackBricks[2];
        chessBoards[16][4].chessPiece[0] = blackBricks[5];
        chessBoards[16][5].chessPiece[0] = blackBricks[4];
        chessBoards[16][6].chessPiece[0] = blackBricks[2];
        chessBoards[16][7].chessPiece[0] = blackBricks[3];
        chessBoards[16][8].chessPiece[0] = blackBricks[1];

        // Add Pawn pieces for both players -------
        for (int i = 1; i < chessBoards[0].length - 1; i++) {
            chessBoards[4][i].chessPiece[0] = whiteBricks[0];
            chessBoards[14][i].chessPiece[0] = blackBricks[0];
        }
    }


    public void print() {
        for (int i = 0; i < chessBoards.length; i++) {
            for (int j = 0; j < chessBoards[0].length; j++) {
                System.out.print(" |");

                // Making sure to always print chess pieces IN the game
                if (chessBoards[i][j].getOuterRingMatrix() == null) {
                    System.out.print(chessBoards[i][j].chessPiece[0].getColor() +
                            chessBoards[i][j].chessPiece[0].getChessBricks().getName());
                } else {
                System.out.print(chessBoards[i][j].getOuterRingMatrix());
                }

            }
            System.out.print(" |");
            System.out.println();
        }
    }
}
