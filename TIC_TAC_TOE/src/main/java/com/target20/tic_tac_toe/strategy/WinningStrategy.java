package com.target20.tic_tac_toe.strategy;

import com.target20.tic_tac_toe.models.Board;
import com.target20.tic_tac_toe.models.Move;
import com.target20.tic_tac_toe.models.WinnerStrategy;

public abstract class WinningStrategy {


    public static WinningStrategy getStrategy(WinnerStrategy strategy,int boardSize){
        if(strategy == WinnerStrategy.ROW){
            return new RowWinningStrategy(boardSize);
        }
        else if(strategy == WinnerStrategy.COL){
            return new ColWinningStrategy(boardSize);
        }
        else if(strategy == WinnerStrategy.LEFT_DIAG){
            return new LeftDiagnolWinningStrategy(boardSize);
        }
        else if(strategy == WinnerStrategy.RIGHT_DIAG){
            return new RightDiagnolWinningStrategy(boardSize);
        }
        return null;
    }


    public abstract boolean checkIsWinner(Board board, Move move);

}
