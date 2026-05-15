package com.target20.tic_tac_toe.models;

import com.target20.tic_tac_toe.strategy.WinningStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
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

    public void initialzeBoard(int boardSize){
        Board board = new Board();
        this.board = board;
        this.board.setSize(boardSize);
        List<List<Cell>> cells = new ArrayList<>();
        for(int row = 0;row < boardSize;row++){
            List<Cell> cell_row = new ArrayList<>();
            for(int col = 0;col < boardSize;col++){
                Cell cell = new Cell();
                cell.setRow(row);
                cell.setCol(col);
                cell.setCellStatus(CellStatus.EMPTY);
                cell_row.add(cell);
            }
            cells.add(cell_row);
        }
        this.board.setCells(cells);
    }
    public void initializeWinningStrategies(int boardSize){
        if(strategies != null) return;
        strategies = new WinningStrategy[]{WinningStrategy.getStrategy(WinnerStrategy.ROW, boardSize),
        WinningStrategy.getStrategy(WinnerStrategy.COL, boardSize),
        WinningStrategy.getStrategy(WinnerStrategy.LEFT_DIAG, boardSize),
        WinningStrategy.getStrategy(WinnerStrategy.RIGHT_DIAG, boardSize)};
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
