package game;

import game.assets.colors.ConsoleColors;
import game.gameboard.Board;
import game.players.PlayerType;

public class Game {

    private int ROUND = 1;
    private boolean gameLoop = true;

    public Game(){

    }

    public void start(){
        gameLoop = true;
        Board board = new Board();
        Display d = new Display(board);
        board.initBoard();
        d.clearScreen();
        while(gameLoop){
            d.showInformation(ROUND);
            d.drawBoard();
            playerMove(PlayerType.CRISS, board, d);
            cpuMove(PlayerType.CROSS, board, d);
        }
    }

    public void playerMove(PlayerType type, Board board, Display display){
        while(true){
            int input = Input.getNextMove(display);
            if(board.validateNewMove(input, type)){

                if(board.checkWinner() != PlayerType.BLANK){
                    display.clearScreen();
                    display.drawBoard();
                    System.out.println("Winner is: " + board.checkWinner().getType());
                    stopGame();
                }

                else{
                    ROUND++;
                    display.clearScreen();
                }
                break;
            }
            display.clearScreen();
            System.out.println(ConsoleColors.RED_BOLD + "That position is  already taken! Type a number with a free position!\n" + ConsoleColors.RESET);
        }
    }

    public void cpuMove(PlayerType type, Board board, Display display){
        while(true){
            int input = Input.nextCPUMove();
            if(board.validateNewMove(input, type)){

                if(board.checkWinner() != PlayerType.BLANK){
                    display.clearScreen();
                    display.drawBoard();
                    System.out.println("Winner is: " + board.checkWinner().getType());
                    stopGame();
                }

                else{
                    ROUND++;
                    display.clearScreen();
                }
                break;
            }
        }
    }

    public void stopGame(){
        Thread.
    }

}
