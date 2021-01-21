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
            delay();
            playerMove(PlayerType.CRISS, board, d);
            if(!gameLoop){
                break;
            }
            d.showInformation(ROUND);
            d.drawBoard();
            cpuMove(PlayerType.CROSS, board, d);
            delay();
        }
    }

    public void playerMove(PlayerType type, Board board, Display display){
        while(true){
            int input = Input.getNextMove(display);
            if(board.validateNewMove(input, type)){

                if(board.checkWinner() != PlayerType.BLANK){
                    delay();
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
        int input;
        System.out.println("Enter a number for your next move: ");
        while(true){
            input = Input.nextCPUMove();
            if(board.validateNewMove(input, type)){

                if(board.checkWinner() != PlayerType.BLANK){
                    System.out.println(input);
                    delay();
                    display.clearScreen();
                    display.drawBoard();
                    if(board.checkWinner() == PlayerType.TIE){
                        System.out.println("It's a " + PlayerType.TIE.getType());
                    }
                    else{
                        System.out.println("Winner is: " + board.checkWinner().getType());
                        stopGame();
                    }
                }

                else{
                    ROUND++;
                    display.clearScreen();
                    System.out.println(input);
                }
                break;
            }
        }
    }

    public void delay(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stopGame(){
        gameLoop = false;
    }

}
