package game.board;

import game.player.PlayerType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private PlayerType[][] board;

    private final List<PlayerType> winCombinationCriss = Arrays.asList(PlayerType.CRISS, PlayerType.CRISS, PlayerType.CRISS);
    private final List<PlayerType> winCombinationCross = Arrays.asList(PlayerType.CROSS, PlayerType.CROSS, PlayerType.CROSS);

    public void initBoard(){
        board = new PlayerType[3][3];
        for(int m = 0;m<3;m++){
            for(int n = 0;n<3;n++){
                board[m][n] = PlayerType.BLANK;
            }
        }
    }

    public void getPlayerInput(PlayerType type){
        System.out.println("Enter numbers that represent a field on the board: ");
        List<Integer> list;
        while(true){
            list  = Input.getInput();
            if(checkField(list.get(0), list.get(1))){
                board[list.get(0)-1][list.get(1)-1] = type;
                break;
            }
        }
    }

    public boolean checkField(int num1, int num2){
        return getSymbol(num1, num2) == PlayerType.BLANK;
    }

    public PlayerType getSymbol(int index1, int index2){
        return board[index1-1][index2-1];
    }

    public PlayerType checkForWinner(){
        //Check for winner through all rows, columns and diagonals.
        //Declare diagonal lists.
        List<PlayerType> diagonal1 = new ArrayList<>();
        List<PlayerType> diagonal2 = new ArrayList<>();
        //First loop
        for(int m = 1; m < 4; m++){
            //Declare list for every row and column.
            List<PlayerType> currentRow = new ArrayList<>();
            List<PlayerType> currentColumn = new ArrayList<>();
            //Inner loop for rows and columns.
            for(int n = 1; n < 4; n++){
                //Adding symbols to lists.
                currentRow.add(getSymbol(m, n));
                currentColumn.add(getSymbol(n, m));
            }
            //Adding a symbol to diagonal lists.
            diagonal1.add(getSymbol(m, m));
            diagonal2.add(getSymbol(m, 4-m));
            //Check if row, column or diagonal is equals to a win combination.
            if(currentRow.equals(winCombinationCriss) || currentRow.equals(winCombinationCross)){
                return currentRow.get(0);
            }
            if(currentColumn.equals(winCombinationCriss) || currentColumn.equals(winCombinationCross)){
                return currentColumn.get(0);
            }
        }
        if(diagonal1.equals(winCombinationCriss) || diagonal1.equals(winCombinationCross)){
            return diagonal1.get(0);
        }
        if(diagonal2.equals(winCombinationCriss) || diagonal2.equals(winCombinationCross)){
            return diagonal2.get(0);
        }

        return PlayerType.BLANK;
    }
}
