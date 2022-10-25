public class Board {

    public ChessBricks[] whiteBricks = new ChessBricks[16];
    public ChessBricks[] blackBricks = new ChessBricks[16];

    public ChessFields[][] chessBoards = new ChessFields[18][10];



    // Creating all chess pieces for both black and white player.
    public void makeChessPiecesForPlayers() {
        // Set pawns for both players
        for (int i = 0; i < 8; i++) {
            whiteBricks[i] = ChessBricks.PAWN;
            whiteBricks[i].getPlayer().setColor("W");
            blackBricks[i] = ChessBricks.PAWN;
            blackBricks[i].getPlayer().setColor("B");
        }
        // Set rooks for both players
        for (int i = 8; i < 10; i++) {
            whiteBricks[i] = ChessBricks.ROOK;
            whiteBricks[i].getPlayer().setColor("W");
            blackBricks[i] = ChessBricks.ROOK;
            blackBricks[i].getPlayer().setColor("B");
        }
        // Set Bishops for both players
        for (int i = 10; i < 12; i++) {
            whiteBricks[i] = ChessBricks.BISHOP;
            whiteBricks[i].getPlayer().setColor("W");
            blackBricks[i] = ChessBricks.BISHOP;
            blackBricks[i].getPlayer().setColor("W");
        }
        // Set knights for both players
        for (int i = 12; i < 14; i++) {
            whiteBricks[i] = ChessBricks.KNIGHT;
            whiteBricks[i].getPlayer().setColor("W");
            blackBricks[i] = ChessBricks.KNIGHT;
            blackBricks[i].getPlayer().setColor("B");
        }
        // Set kings
        whiteBricks[14] = ChessBricks.KING;
        whiteBricks[14].getPlayer().setColor("W");
        blackBricks[14] = ChessBricks.KING;
        blackBricks[14].getPlayer().setColor("B");
        // Set Queens
        whiteBricks[15] = ChessBricks.QUEEN;
        whiteBricks[15].getPlayer().setColor("W");
        blackBricks[15] = ChessBricks.QUEEN;
        blackBricks[14].getPlayer().setColor("B");
    }


    // Makes chessBricks have a unique color so two players can keep track of the bricks
    public void setChessPlayer(int i) {
            whiteBricks[i].getPlayer().setColor("W");
            blackBricks[i].getPlayer().setColor("B");
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
        chessBoards[2][1].chessPiece[0] = whiteBricks[8];
        chessBoards[2][2].chessPiece[0] = whiteBricks[12];
        chessBoards[2][3].chessPiece[0] = whiteBricks[10];
        chessBoards[2][4].chessPiece[0] = whiteBricks[15];
        chessBoards[2][5].chessPiece[0] = whiteBricks[14];
        chessBoards[2][6].chessPiece[0] = whiteBricks[11];
        chessBoards[2][7].chessPiece[0] = whiteBricks[13];
        chessBoards[2][8].chessPiece[0] = whiteBricks[9];
        chessBoards[16][1].chessPiece[0] = blackBricks[8];
        chessBoards[16][2].chessPiece[0] = blackBricks[12];
        chessBoards[16][3].chessPiece[0] = blackBricks[10];
        chessBoards[16][4].chessPiece[0] = blackBricks[15];
        chessBoards[16][5].chessPiece[0] = blackBricks[14];
        chessBoards[16][6].chessPiece[0] = blackBricks[11];
        chessBoards[16][7].chessPiece[0] = blackBricks[13];
        chessBoards[16][8].chessPiece[0] = blackBricks[9];
        for (int i = 1; i < chessBoards[0].length - 1; i++) {
            chessBoards[4][i].chessPiece[0] = whiteBricks[0];
            chessBoards[14][i].chessPiece[0] = blackBricks[0];
        }
    }


    public void print() {
        for (int i = 0; i < chessBoards.length; i++) {
            for (int j = 0; j < chessBoards[0].length; j++) {
                System.out.print(" |");
                if (chessBoards[i][j].getOuterRingMatrix() == null) {
                    System.out.print(chessBoards[i][j].chessPiece[0].getPlayer().getColor() +
                            chessBoards[i][j].chessPiece[0].getName());
                } else {
                System.out.print(chessBoards[i][j].getOuterRingMatrix());
                }

            }
            System.out.print(" |");
            System.out.println();
        }
    }
}
