package com.target20.tic_tac_toe.strategy;

import com.target20.tic_tac_toe.models.Board;
import com.target20.tic_tac_toe.models.Move;
import com.target20.tic_tac_toe.models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColWinningStrategy extends WinningStrategy {

    private List<Map<Player,Integer>> maps;

    public ColWinningStrategy(int boardSize){
        maps = new ArrayList<>();
        for(int cnt = 1;cnt <= boardSize;cnt++){
            maps.add(new HashMap<>());
        }
    }


    @Override
    public boolean checkIsWinner(Board board, Move move) {
        int col = move.getCell().getCol();
        Map<Player,Integer> map = maps.get(col);
        int prevCount = map.getOrDefault(move.getPlayer(),0);
        return prevCount + 1 == board.getSize();
    }
}
