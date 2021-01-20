package game.gameboard;

import game.players.PlayerType;

import java.util.HashMap;

public class Board {

    private HashMap<Integer, PlayerType> boardMap;

    public void Board(){

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

}
