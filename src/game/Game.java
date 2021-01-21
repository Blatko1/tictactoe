package game;

import game.assets.colors.ConsoleColors;
import game.gameboard.Board;
import game.players.PlayerType;

public class Game {

    private int ROUND = 1;

    public Game(){

    }

    public void start(){
        Board board = new Board();
        Display d = new Display(board);
        board.initBoard();
        d.clearScreen();
        while(true){
            d.showInformation(ROUND);
            d.drawBoard();
            String input = Input.getNextMove();
            if(input.equals("stop") || input.equals("exit") || input.equals("close")){
                System.out.println(ConsoleColors.RED_BOLD + "Closing the Game!" + ConsoleColors.RESET);
                try {
                    Thread.sleep(750);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                d.clearScreen();
                break;
            }
            int in = Integer.parseInt(input);
            if(board.validateNewMove(in, PlayerType.CRISS)){

                if(board.checkWinner() != PlayerType.BLANK){
                    d.clearScreen();
                    d.drawBoard();
                    System.out.println("Winner is: " + board.checkWinner().getType());
                    break;
                }

                ROUND++;
                d.clearScreen();
                continue;
            }
            d.clearScreen();
            System.out.println(ConsoleColors.RED_BOLD + "That position is  already taken! Type a number with a free position!\n" + ConsoleColors.RESET);
        }
    }

    public void stop(){

    }

    public void nextPlayer(){

    }

}
