public class Bishop extends Piece{


    Bishop(Color color) {
        super(color);
    }

    @Override
    public boolean movementValid(BoardMovement mov, Piece[][] board) {
        // calculamos el delta movement en ambos ejes
        int verticalMovement = Math.abs(mov.rowIndexOrigin - mov.rowIndexDestiny);
        int horizonalMovement = Math.abs(mov.columnIndexOrigin - mov.columnIndexDestiny);

        int steps = Math.max(horizonalMovement, verticalMovement);

        boolean notDiagonal = (verticalMovement == 0 && horizonalMovement != 0 || horizonalMovement == 0 && verticalMovement != 0);

        if(!notDiagonal){
            if(verticalMovement != horizonalMovement) return false;
        }

        Piece destinyContent = board[mov.rowIndexDestiny][mov.columnIndexDestiny];

        if(destinyContent != null && destinyContent.color == color)
            return false;


        verticalMovement = (mov.rowIndexOrigin - mov.rowIndexDestiny);
        horizonalMovement = (mov.columnIndexOrigin - mov.columnIndexDestiny);

        int verticalIncrement = -1;
        int horizontalIncrement = -1;

        if(verticalMovement < 0)
            verticalIncrement *= -1;

        if(horizonalMovement < 0)
            horizontalIncrement *= -1;

        for (int i = 1; i < steps; i++) {
            Piece stepPiece = board[mov.rowIndexOrigin+verticalIncrement*i][mov.columnIndexOrigin+horizontalIncrement*i];

            if(stepPiece != null)
                return false;
        }

        if(notDiagonal)
            return false;

        return true;
    }
}
