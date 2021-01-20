package game.players;

public enum PlayerType {
    CRISS("X"),
    CROSS("O"),
    BLANK(" ");

    String type;

    public String getType() {
        return type;
    }

    PlayerType(String type) {
        this.type = type;
    }
}
