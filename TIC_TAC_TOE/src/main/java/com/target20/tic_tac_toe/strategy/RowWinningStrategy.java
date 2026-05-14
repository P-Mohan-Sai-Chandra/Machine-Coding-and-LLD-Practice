package com.target20.tic_tac_toe.strategy;

import com.target20.tic_tac_toe.models.Board;
import com.target20.tic_tac_toe.models.Cell;
import com.target20.tic_tac_toe.models.Move;
import com.target20.tic_tac_toe.models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RowWinningStrategy extends  WinningStrategy{

    private List<Map<Player,Integer>> score;

    public RowWinningStrategy(int boardSize){
        score = new ArrayList<>();
        for(int cnt = 1;cnt <= boardSize;cnt++){
            score.add(new HashMap<>());
        }
    }

    @Override
    public boolean checkIsWinner(Board board, Move move) {
        Cell cell = move.getCell();
        int row = cell.getRow();
        Map<Player,Integer> map = score.get(row);
        int prevCount = map.getOrDefault(move.getPlayer(),0);
        map.put(move.getPlayer(),prevCount + 1);
        if(prevCount + 1 == board.getSize()){
            return true;
        }
        return false;
    }
}
