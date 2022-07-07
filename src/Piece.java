public abstract class Piece {

    public enum Color {
        WHITE,
        BLACK
    }


    Color color;

    Piece(Color color){
        this.color = color;
    }

    public abstract boolean movementValid(BoardMovement mov, Piece[][] board);
    public void executeMovement(BoardMovement mov){
    }

}
