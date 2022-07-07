public class BoardMovement {


    // Origin
    int columnIndexOrigin;
    int rowIndexOrigin;

    // Destiny
    int columnIndexDestiny;
    int rowIndexDestiny;

    

    BoardMovement(String userInput){

        // Origin
        columnIndexOrigin = Game.columnCharToIndex(userInput.charAt(0));
        rowIndexOrigin = Game.rowCharToIndex(userInput.charAt(1));

        // Destiny
        columnIndexDestiny = Game.columnCharToIndex(userInput.charAt(2));
        rowIndexDestiny = Game.rowCharToIndex(userInput.charAt(3));
    }


}
