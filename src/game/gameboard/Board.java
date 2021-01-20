package game.gameboard;

import game.players.PlayerType;

import java.util.HashMap;

public class Board {

    private HashMap<Integer, PlayerType> map;

    public void Board(){

    }

    public void initBoard(){
        map = new HashMap<>();
        for(int i = 1; i<10; i++){
            map.put(i, PlayerType.BLANK);
        }
    }

    public PlayerType getType(int pos){
        return map.get(pos);
    }

    public boolean validateNewMove(int move, PlayerType type){
        if(map.get(move) == PlayerType.BLANK){
            map.put(move, type);
            return true;
        }
        return false;
    }

}
