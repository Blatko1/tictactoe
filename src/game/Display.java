package game;

import game.gameboard.Board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Display {

    private String space = "    ";

    private Board board;

    public Display(Board board){
        this.board = board;
    }

    public void showInformation(int round){
        System.out.println("Round: " + round);
    }
    
    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void drawBoard(){
        System.out.println(
                space + " " + board.getType(1).getType() + " | " + board.getType(2).getType() + " | " + board.getType(3).getType() + " \n" +
                space + "---+---+---\n" +
                space + " " + board.getType(4).getType() + " | " + board.getType(5).getType() + " | " + board.getType(6).getType() + " \n" +
                space + "---+---+---\n" +
                space + " " + board.getType(7).getType() + " | " + board.getType(8).getType() + " | " + board.getType(9).getType() + " \n");
    }

}
