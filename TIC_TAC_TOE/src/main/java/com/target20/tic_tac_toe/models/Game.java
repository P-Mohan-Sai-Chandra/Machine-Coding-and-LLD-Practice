package com.target20.tic_tac_toe.models;

import com.target20.tic_tac_toe.strategy.WinningStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Game {
    private Board board;
    private GameStatus status;
    private List<Player> players;
    private int nextPlayer;
    private Player winner;
    private WinningStrategy[] strategies;




    public Game(){
        this.nextPlayer = 0;
    }

    private void displayBoard(){
        for(List<Cell> cells : board.getCells()){
            for(Cell cell : cells){
                System.out.print(cell.getCellStatus() == CellStatus.EMPTY?" - ":cell.getPlayer().getPlayerSymbol().getSymbolImage());
            }
            System.out.println();
        }
    }


    public void makeMove(int row,int col,Player player){
        if(status == GameStatus.COMPLETED || status == GameStatus.TIE) return;
        Cell cell = board.getCells().get(row).get(col);
        if(cell.getCellStatus() != CellStatus.EMPTY) return;
        Move move = new Move();
        move.setCell(cell);
        move.setPlayer(player);
        cell.setCellStatus(CellStatus.FILLED);
        cell.setPlayer(player);
        nextPlayer++;
        nextPlayer%=players.size();
        displayBoard();
        checkWinner(move);
        if(status == GameStatus.COMPLETED) return;
        checkForTie();
    }

    public Player nextPlayer(){
        return players.get(nextPlayer);
    }

    public void checkWinner(Move move){
        for(WinningStrategy strategy : strategies){
            if(strategy.checkIsWinner(board,move)){
                winner = move.getPlayer();
                status = GameStatus.COMPLETED;
                break;
            }
        }
    }

    public void checkForTie(){
        boolean allFilled = true;
        for(List<Cell> board_row : board.getCells()){
            for(Cell board_cell : board_row){
                if(board_cell.getCellStatus() == CellStatus.EMPTY){
                    allFilled = false;
                    break;
                }
            }
        }
        if(allFilled){
            status = GameStatus.TIE;
        }
    }



}
