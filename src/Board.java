public class Board {

    public ChessBricks[] whiteBricks = new ChessBricks[16];
    public ChessBricks[] blackBricks = new ChessBricks[16];



    public void makeChessPiecesForPlayers() {
        // Set pawns for both players
        for (int i = 0; i < 8; i++) {
            whiteBricks[i] = ChessBricks.PAWN;
            blackBricks[i] = ChessBricks.PAWN;
            setChessPlayer(i);
        }
        // Set rooks for both players
        for (int i = 8; i < 10; i++) {
            whiteBricks[i] = ChessBricks.ROOK;
            blackBricks[i] = ChessBricks.ROOK;
            setChessPlayer(i);
        }
        // Set Bishops for both players
        for (int i = 10; i < 12; i++) {
            whiteBricks[i] = ChessBricks.BISHOP;
            blackBricks[i] = ChessBricks.BISHOP;
            setChessPlayer(i);
        }
        // Set knights for both players
        for (int i = 12; i < 14; i++) {
            whiteBricks[i] = ChessBricks.KNIGHT;
            blackBricks[i] = ChessBricks.KNIGHT;
            setChessPlayer(i);
        }
        // Set kings
        whiteBricks[14] = ChessBricks.KING;
        blackBricks[14] = ChessBricks.KING;
        setChessPlayer(14);
        // Set Queens
        whiteBricks[15] = ChessBricks.QUEEN;
        blackBricks[15] = ChessBricks.QUEEN;
        setChessPlayer(15);
    }


    public void setChessPlayer(int i) {
            whiteBricks[i].getPlayer().setColor("W");
            blackBricks[i].getPlayer().setColor("B");
    }

    public void createChessBoards() {

    }









    private String[][] chessBoard = new String[18][10];

    public void createChessBoard() {
        int boardNum = 1;
        chessBoard[2][1] = "WRO";
        chessBoard[2][2] = "WKN";
        chessBoard[2][3] = "WBI";
        chessBoard[2][4] = "WQU";
        chessBoard[2][5] = "WKI";
        chessBoard[2][6] = "WBI";
        chessBoard[2][7] = "WKN";
        chessBoard[2][8] = "WRO";
        chessBoard[16][1] = "BRO";
        chessBoard[16][2] = "BKN";
        chessBoard[16][3] = "BBI";
        chessBoard[16][4] = "BKI";
        chessBoard[16][5] = "BQU";
        chessBoard[16][6] = "BBI";
        chessBoard[16][7] = "BKN";
        chessBoard[16][8] = "BRO";
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[0].length; j++) {
                boardLogic(i, j);
                if (i % 2 == 0 && j == 0 && i != 0){
                    chessBoard[i][j] = Integer.toString(boardNum) +"  ";
                    chessBoard[i][j+9] = Integer.toString(boardNum)+"  ";
                    boardNum ++;
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[0].length; j++) {
                System.out.print(" |");
                System.out.print(chessBoard[i][j]);
            }
            System.out.print(" |");
            System.out.println();
        }
    }

    public void boardLogic(int columns, int row) {
        switch (columns) {
            case 0, 17:
                if (row == 0 || row == 9) {
                    chessBoard[columns][row] = "   ";
                }else chessBoard[columns][row] = Character.toString(65 + row -1) + "  ";
                break;
            case 4:
                if (row > 0 && row < 9) {
                    chessBoard[columns][row] = "WPA";
                }
                break;
            case 1, 3, 5, 7, 9, 11, 13, 15:
                    chessBoard[columns][row] = "---";
                break;
            case 6, 8, 10, 12:
                if (row > 0 && row < 9) {
                    chessBoard[columns][row] = "   ";
                }
                break;
            case 14:
                if (row > 0 && row < 9) {
                    chessBoard[columns][row] = "BPA";
                }
                break;
        }
    }
    public void makePawn(){
        chessBoard[6][1] = chessBoard[4][1];
        chessBoard[4][1] = "   ";
    }
}
