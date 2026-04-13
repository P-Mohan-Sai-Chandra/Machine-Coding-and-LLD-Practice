package modals;

import modals.TYPES.PlayerType;

public abstract class Player {

    private String playerName;
    private String playerId;
    private PlayerType playerType;
    private Symbol symbol;

    public Player(String playerName,String playerId,String symbol,PlayerType type){
        this.playerName = playerName;
        this.playerId = playerId;
        this.playerType = type;
        this.symbol = new Symbol(symbol);
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public abstract Move makeMove(Board board,Player player);

}
