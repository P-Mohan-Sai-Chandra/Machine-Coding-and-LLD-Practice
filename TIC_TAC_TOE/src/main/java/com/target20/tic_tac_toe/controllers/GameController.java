package com.target20.tic_tac_toe.controllers;

import ch.qos.logback.core.joran.sanity.Pair;
import com.target20.tic_tac_toe.models.*;
import com.target20.tic_tac_toe.strategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {

    private Game game;
    private Board board;
    private Scanner input;
    public GameController(){
        this.game = new Game();
        this.board = new Board();
        input = new Scanner(System.in);
    }


    public void startGame(List<Player> players,int boardSize){
        game.setPlayers(players);
        WinningStrategy[] winningStrategies = {WinningStrategy.getStrategy(WinnerStrategy.ROW,boardSize),
        WinningStrategy.getStrategy(WinnerStrategy.COL,boardSize),
        WinningStrategy.getStrategy(WinnerStrategy.LEFT_DIAG,boardSize),
        WinningStrategy.getStrategy(WinnerStrategy.RIGHT_DIAG,boardSize)};
        game.setStrategies(winningStrategies);
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
        board.setCells(cells);
        board.setSize(boardSize);
        game.setStatus(GameStatus.STARTED);
        game.setBoard(board);
        while(game.getStatus() == GameStatus.STARTED){
            Player player = game.nextPlayer();
            System.out.println("Enter the row and col  for the player " + player.getPlayerName());
            int row = input.nextInt();
            int col = input.nextInt();
            makeMove(row,col,player);
        }
        if(game.getStatus() == GameStatus.COMPLETED){
            System.out.println("The Winner is " + game.getWinner());
        }
        else if(game.getStatus() == GameStatus.TIE){
            System.out.println("Game is Tie");
        }
    }
    public void quitGame(){

    }
    public void restartGame(List<Player> players,int boardsize){
        startGame(players,boardsize);
    }
    public void getWinner(){

    }
    public void makeMove(int row,int col,Player player){
        game.makeMove(row,col,player);
    }


}
