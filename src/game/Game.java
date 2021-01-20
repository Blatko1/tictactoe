package game;

import game.assets.colors.ConsoleColors;
import game.gameboard.Board;
import game.players.PlayerType;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

                if(chechWinner(board) != PlayerType.BLANK){
                    d.clearScreen();
                    d.drawBoard();
                    System.out.println("Winner is: " + chechWinner(board).getType());
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

    public PlayerType chechWinner(Board b){
        List criss = Arrays.asList(PlayerType.CRISS, PlayerType.CRISS, PlayerType.CRISS);
        List cross = Arrays.asList(PlayerType.CROSS, PlayerType.CROSS, PlayerType.CROSS);

        //Check all rows.
        for(int m = 0;m<3;m++){
            List current = new ArrayList();
            for(int n = 1;n<4;n++){
                current.add(b.getType(n+m*3));
            }
            if(current.equals(criss)){
                return PlayerType.CRISS;
            }
            if(current.equals(cross)){
                return PlayerType.CROSS;
            }
        }

        //Check all coloumns.
        for(int m = 2;m>=0;m--){
            List current = new ArrayList();
            for(int n = 1;n<4;n++){
                current.add(b.getType(n*3-m));
            }
            if(current.equals(criss)){
                return PlayerType.CRISS;
            }
            if(current.equals(cross)){
                return PlayerType.CROSS;
            }
        }

        //Check all diagonals.
        for(int m = 1;m<3;m++){
            List current = new ArrayList();
            for(int n = 1;n<4;n++){
                current.add(/*b.getType(*/n*2-6+m*5/*)*/);
            }
            System.out.println(current.toString());
            if(current.equals(criss)){
                return PlayerType.CRISS;
            }
            if(current.equals(cross)){
                return PlayerType.CROSS;
            }
        }

        return PlayerType.BLANK;
    }

}
