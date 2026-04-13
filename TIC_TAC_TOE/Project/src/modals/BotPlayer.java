package modals;

import modals.TYPES.BotDifficulty;
import modals.TYPES.PlayerType;
import strategies.BotPlayingStrategy;

public class BotPlayer extends Player {

    private BotDifficulty botDifficulty;
    private BotPlayingStrategy botStrategy;

    public BotPlayer(String playerName, String playerId,String symbol,PlayerType type,BotDifficulty difficulty){
        super(playerName,playerId,symbol,type);
        this.botDifficulty = difficulty;
        this.botStrategy = BotPlayingStrategy.getStrategy(difficulty);
    }


    @Override
    public Move makeMove(Board board,Player player) {
        return botStrategy.botMove(board,player);
    }
}
