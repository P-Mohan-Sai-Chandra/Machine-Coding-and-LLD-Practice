package strategies;

import modals.Board;
import modals.BotPlayer;
import modals.Move;
import modals.Player;
import modals.TYPES.BotDifficulty;

public abstract class BotPlayingStrategy {


    public static BotPlayingStrategy getStrategy(BotDifficulty difficult){
        if(difficult == BotDifficulty.EASY) return new EasyBotPlaying();
        else if(difficult == BotDifficulty.MEDIUM) return new MediumBotPlaying();
        return new HardBotPlaying();
    }


    public abstract Move botMove(Board board, Player bot);

}
