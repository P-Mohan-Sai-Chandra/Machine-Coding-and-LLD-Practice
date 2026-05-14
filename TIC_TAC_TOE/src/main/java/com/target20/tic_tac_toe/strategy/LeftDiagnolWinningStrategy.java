package com.target20.tic_tac_toe.strategy;

import com.target20.tic_tac_toe.models.Board;
import com.target20.tic_tac_toe.models.Move;
import com.target20.tic_tac_toe.models.Player;

import java.util.HashMap;
import java.util.Map;

public class LeftDiagnolWinningStrategy extends WinningStrategy {

    private Map<Player,Integer> map;

    public LeftDiagnolWinningStrategy(int boardSize){
        map = new HashMap<>(boardSize);
    }


    @Override
    public boolean checkIsWinner(Board board, Move move) {
        int prevCount = map.getOrDefault(move.getPlayer(),0);
        map.put(move.getPlayer(),prevCount + 1);
        return prevCount + 1 == board.getSize();
    }
}
