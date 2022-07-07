public class Knight extends Piece {
    Knight(Color color) {
        super(color);
    }

    @Override
    public boolean movementValid(BoardMovement mov, Piece[][] board) {

        // calculamos el delta movement en ambos ejes
        int verticalMovement = Math.abs(mov.rowIndexOrigin - mov.rowIndexDestiny);
        int horizonalMovement = Math.abs(mov.columnIndexOrigin - mov.columnIndexDestiny);

        int maxMov = Math.max(verticalMovement, horizonalMovement);
        int minMov = Math.min(verticalMovement, horizonalMovement);


        if(!(maxMov == 2 && minMov == 1)) return false;

        Piece destinyContent = board[mov.rowIndexDestiny][mov.columnIndexDestiny];

        if(destinyContent != null && destinyContent.color == color)
            return false;

        return true;
    }
}
