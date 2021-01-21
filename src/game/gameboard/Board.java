package game.gameboard;

import game.players.PlayerType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Board {

    private HashMap<Integer, PlayerType> boardMap;

    public Board(){

    }

    public void initBoard(){
        boardMap = new HashMap<>();
        for(int i = 1; i<10; i++){
            boardMap.put(i, PlayerType.BLANK);
        }
    }

    public PlayerType getType(int pos){
        return boardMap.get(pos);
    }

    public boolean validateNewMove(int move, PlayerType type){
        if(boardMap.get(move) == PlayerType.BLANK){
            boardMap.put(move, type);
            return true;
        }
        return false;
    }

    public PlayerType checkWinner(){
        List criss = Arrays.asList(PlayerType.CRISS, PlayerType.CRISS, PlayerType.CRISS);
        List cross = Arrays.asList(PlayerType.CROSS, PlayerType.CROSS, PlayerType.CROSS);

        //Check all rows.
        for(int m = 0;m<3;m++){
            List current = new ArrayList();
            for(int n = 1;n<4;n++){
                current.add(getType(n+m*3));
            }
            if(current.equals(criss)){
                return PlayerType.CRISS;
            }
            if(current.equals(cross)){
                return PlayerType.CROSS;
            }
        }

        //Check all columns.
        for(int m = 2;m>=0;m--){
            List current = new ArrayList();
            for(int n = 1;n<4;n++){
                current.add(getType(n*3-m));
            }
            if(current.equals(criss)){
                return PlayerType.CRISS;
            }
            if(current.equals(cross)){
                return PlayerType.CROSS;
            }
        }
        int counter = 1;
        //Check all diagonals.
        for(int m = 0;m<2;m++){
            List current = new ArrayList();
            for(int n = 1;n<4;n++){
                current.add(getType(counter));
                counter+=4*Math.abs(m-1);
                counter+=m*2;
            }
            if(current.equals(criss)){
                return PlayerType.CRISS;
            }
            if(current.equals(cross)){
                return PlayerType.CROSS;
            }
            counter = 3;
        }

        return PlayerType.BLANK;
    }

}
