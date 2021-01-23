package game;

import game.board.Board;
import game.display.Display;
import game.player.PlayerType;

public class Game {

    Display display;
    Board board;

    public Game(){
        display = new Display();
        board = new Board();
        board.initBoard();
    }

    public void startGame(){
        while(true){
            display.drawBoard(board);
            board.getPlayerInput(PlayerType.CRISS);
            if(board.checkForWinner() != PlayerType.BLANK){
                System.out.println("The winner is: " + board.checkForWinner().getString());
                return;
            }
        }
    }

}
