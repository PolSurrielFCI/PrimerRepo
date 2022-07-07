import processing.core.PApplet;
import processing.core.PImage;

import java.util.HashMap;

public class Main extends PApplet {

    Game game;

    public static void main(String[] args){

        PApplet.main("Main", args);
    }

    public void settings(){
        size(500, 500);
    }

    HashMap<String, PImage> pieceImgBank = new HashMap<String, PImage>();

    public void setup(){
        game = new Game();

        pieceImgBank.put("bq", loadImage("./img/bq.png"));
        pieceImgBank.put("wq", loadImage("./img/wq.png"));
        pieceImgBank.put("bk", loadImage("./img/bk.png"));
        pieceImgBank.put("wk", loadImage("./img/wk.png"));
        pieceImgBank.put("bh", loadImage("./img/bh.png"));
        pieceImgBank.put("wh", loadImage("./img/wh.png"));
        pieceImgBank.put("bp", loadImage("./img/bp.png"));
        pieceImgBank.put("wp", loadImage("./img/wp.png"));
        pieceImgBank.put("br", loadImage("./img/br.png"));
        pieceImgBank.put("wr", loadImage("./img/wr.png"));
        pieceImgBank.put("bb", loadImage("./img/bb.png"));
        pieceImgBank.put("wb", loadImage("./img/wb.png"));
    }

    final int boardSize = 500;
    final int cellSize = boardSize / 8;
    final int pieceImageSizePixels = 60;

    public void drawBoardBG (){
        boolean white = true;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(i == selected[0] && j == selected[1]){
                    fill(color(150, 150, 150));
                }
                else if(i == hover[0] && j == hover[1]){
                    fill(color(200, 200,200));
                }
                else if(white){
                    fill(color(146, 178, 247));
                }else {
                    fill(color(68, 112, 207));
                }
                white = !white;
                rect(i*cellSize, j*cellSize, cellSize, cellSize);
            }
            white = !white;
        }

    }

    String userInput = "";

     String endMessage = "";

    public void onTurnExcutes(String userInput){

        if(game.movementValid(userInput)){
            game.processTurn(userInput);
        }

        if(game.matchFinished()){
            if(game.whiteWon()){
                endMessage = "¡Las blancas han ganado!";
            }else {
                endMessage = "¡Las negras han ganado!";
            }
        }


    }

    public void processMovementInput(){
        final int ALetterInt = (int) 'A';

        int boardX = mouseX / cellSize;
        int boardY = mouseY / cellSize;

        char columnChar = (char)(boardX + ALetterInt);
        int rowIndex = 8-boardY;
        userInput += columnChar + Integer.toString(rowIndex);

        if(userInput.length() >= 4){
            onTurnExcutes(userInput);
            userInput = "";
            selected = new int []{-1,-1};
        }else {
            selected = getIntexes(userInput);
        }
    }

    int [] hover = new int []{-1,-1};

    @Override
    public void mouseMoved() {


        final int ALetterInt = (int) 'A';

        int boardX = mouseX / cellSize;
        int boardY = mouseY / cellSize;

        char columnChar = (char)(boardX + ALetterInt);
        int rowIndex = 8-boardY;
        String hoverpos = columnChar + Integer.toString(rowIndex);
        hover = getIntexes(hoverpos);
    }

    int [] selected = new int[] {-1, -1};

    int [] getIntexes(String userInput){
        final int ALetterInt = (int) 'A';
        final int ZeroLetterInt = (int) '1';

        int originColumnIndex = (int)userInput.charAt(0) - ALetterInt;
        int originRowIndex = 7-((int)userInput.charAt(1)- ZeroLetterInt);
        return new int[]{originColumnIndex, originRowIndex};

    }


    public void mousePressed() {
        if(!game.matchFinished())
            processMovementInput();
        else {
            if(mouseX >= 193 && mouseX <= 193+120 && mouseY >= 260 && mouseY <= 260+30){
                game = new Game();
            }
        }

    }

    public void draw(){

        if(game.matchFinished()){
            selected = new int []{-1,-1};
            hover = new int []{-1,-1};
        }


        drawBoardBG();

        for (int i = 0; i < game.board.length; i++) {
            for (int j = 0; j < game.board[i].length; j++) {
                if(pieceImgBank.containsKey(game.board[i][j])){

                    image(pieceImgBank.get(game.board[i][j]), j*cellSize,i*cellSize);

                }
            }
        }

        if(game.matchFinished()){
            fill(color(180,180,220));
            rect(50,500/2-50,400,100);
            fill(color(0,0,0));
            textSize(17);
            text(endMessage, 160, 500/2 - 25);
            textSize(15);
            text("¿Quieres volver a jugar?", 180, 500/2);

            fill(color(0,235,0));
            rect(193, 260, 120,30);
            fill(color(0,0,0));
            text("Reiniciar partida", 200, 500/2+30);
        }
        
    }




}



