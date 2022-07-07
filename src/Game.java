public class Game {

    public String[][] board = new String[][] {
            {"br", "bh", "bb", "bq", "bk", "bb", "bh", "br"},
            {"bp", "bp", "bp", "bp", "bp", "bp", "bp", "bp"},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {"wp", "wp", "wp", "wp", "wp", "wp", "wp", "wp"},
            {"wr", "wh", "wb", "wq", "wk", "wb", "wh", "wr"}
    };

    public Piece[][] logicBoard;

    Game(){
        logicBoard = new Piece[8][8];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if(board[i][j].equals(" ")){
                    logicBoard[i][j] = null;
                }else {
                    Piece.Color c;

                    if(board[i][j].charAt(0) == 'w')
                        c = Piece.Color.WHITE;
                    else
                        c = Piece.Color.BLACK;


                    if(board[i][j].charAt(1) == 'p'){
                        logicBoard[i][j] = new Pawn(c);

                    }else if (board[i][j].charAt(1) == 'q'){
                        logicBoard[i][j] = new Queen(c);

                    }else if (board[i][j].charAt(1) == 'k'){
                        logicBoard[i][j] = new King(c);

                    }else if (board[i][j].charAt(1) == 'h'){
                        logicBoard[i][j] = new Knight(c);

                    }else if (board[i][j].charAt(1) == 'r'){
                        logicBoard[i][j] = new Rook(c);

                    }else if (board[i][j].charAt(1) == 'b'){
                        logicBoard[i][j] = new Bishop(c);

                    }

                }

            }
        }
    }


    public static int columnCharToIndex(char letter){
        final int ALetterInt = (int) 'A';

        return (int)letter - ALetterInt;
    }

    public static int rowCharToIndex(char letter){
        return 8 - Integer.parseInt(""+letter);
    }

    public boolean movementValid(String userInput){

        var movement = new BoardMovement(userInput);

        boolean pieceOpinion =
                logicBoard[movement.rowIndexOrigin][movement.columnIndexOrigin] != null &&
                logicBoard[movement.rowIndexOrigin][movement.columnIndexOrigin].movementValid(movement, logicBoard);

        System.out.println(pieceOpinion);

        boolean boardOpinion = movement.columnIndexDestiny >=0 && movement.rowIndexDestiny >=0;

        return pieceOpinion && boardOpinion;
    }

    boolean playing = true;
    Piece.Color winner;

    public void processTurn(String userInput){
        var movement = new BoardMovement(userInput);
        logicBoard[movement.rowIndexOrigin][movement.columnIndexOrigin].executeMovement(movement);


        var destiny = logicBoard[movement.rowIndexDestiny][movement.columnIndexDestiny];
        if(destiny != null && destiny.getClass() == King.class ){
            playing = false;
            winner = logicBoard[movement.rowIndexOrigin][movement.columnIndexOrigin].color;
        }

        logicBoard[movement.rowIndexDestiny][movement.columnIndexDestiny] = logicBoard[movement.rowIndexOrigin][movement.columnIndexOrigin];
        logicBoard[movement.rowIndexOrigin][movement.columnIndexOrigin] = null;

        board[movement.rowIndexDestiny][movement.columnIndexDestiny] = board[movement.rowIndexOrigin][movement.columnIndexOrigin];
        board[movement.rowIndexOrigin][movement.columnIndexOrigin] = " ";



    }


    public boolean matchFinished() {
        return !playing;
    }

    public boolean whiteWon() {
        return winner == Piece.Color.WHITE;
    }
}
