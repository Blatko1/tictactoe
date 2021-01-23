package game.display;

import game.board.Board;

public class Display {

    private String space = "   ";

    public Display(){

    }

    public void drawBoard(Board board){
        System.out.println(
                space + " " + board.getSymbol(1,1).getString() + " | " + board.getSymbol(1,2).getString() + " | " + board.getSymbol(1,3).getString() + " \n" +
                space + "---+---+---\n" +
                space + " " + board.getSymbol(2,1).getString() + " | " + board.getSymbol(2,2).getString() + " | " + board.getSymbol(2,3).getString() + " \n" +
                space + "---+---+---\n" +
                space + " " + board.getSymbol(3,1).getString() + " | " + board.getSymbol(3,2).getString() + " | " + board.getSymbol(3,3).getString() + " \n");

    }

}
