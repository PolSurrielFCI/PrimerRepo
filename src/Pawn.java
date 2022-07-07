public class Pawn extends Piece{

    boolean firstMovementDone = false;

    Pawn(Color c){
        super(c);

    }


    @Override
    public boolean movementValid(BoardMovement mov, Piece[][] board) {

        int movdirection = -1;
        if(color == Color.BLACK)
            movdirection = 1;


        // calculamos el delta movement en ambos ejes
        int verticalMovement = Math.abs(mov.rowIndexOrigin - mov.rowIndexDestiny);
        int horizonalMovement = Math.abs(mov.columnIndexOrigin - mov.columnIndexDestiny);

        // Si se mueve sin comer ficha
        if(board[mov.rowIndexDestiny][mov.columnIndexDestiny] == null){

            // si se pasa de 2 mal
            if(verticalMovement > 2) return false;
            // si el primero ya está hecho y se pasa de 1 mal
            else if(verticalMovement > 1 && firstMovementDone) return false;

            // Si se mueve horizontalmente mal
            if(horizonalMovement != 0 ) return false;

            int actualMoveDir =  mov.rowIndexDestiny - mov.rowIndexOrigin;
            if(movdirection > 0 != actualMoveDir >0) return false;

            if(!firstMovementDone) {

                return board[mov.rowIndexOrigin + movdirection][mov.columnIndexOrigin] == null;
            }


        }else {
            if(verticalMovement != 1 || horizonalMovement != 1) return false;
            if(board[mov.rowIndexDestiny][mov.columnIndexDestiny].color == color) return false;

            int actualMoveDir =  mov.rowIndexDestiny - mov.rowIndexOrigin;
            if(movdirection > 0 != actualMoveDir >0) return false;

        }


        return true;
    }

    @Override
    public void executeMovement(BoardMovement mov){
        super.executeMovement(mov);

        firstMovementDone = true;
    }
}
