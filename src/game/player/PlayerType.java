package game.player;

public enum PlayerType {
    CRISS("X"),
    CROSS("O"),
    BLANK(" ");

    String type;

    public String getString(){
        return type;
    }

    PlayerType(String s) {
        type = s;
    }
}
