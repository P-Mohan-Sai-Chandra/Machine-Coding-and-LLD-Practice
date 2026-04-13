package strategies;

import modals.*;
import modals.TYPES.CellStatus;

public class EasyBotPlaying extends BotPlayingStrategy{

    @Override
    public Move botMove(Board board, Player bot) {
        int n = board.getSize();
        Cell[][] cells = board.getCells();
        for(int row = 0;row < n;row++){
            for(int col = 0;col < n;col++){
                if(cells[row][col].getStatus() == CellStatus.EMPTY){
                    Move move = new Move(row,col,bot);
                    cells[row][col].setStatus(CellStatus.FILLED);
                    cells[row][col].setPlayer(bot);
                    return move;

                }
            }
        }
        return null;
    }
}
