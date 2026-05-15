package com.target20.tic_tac_toe.controllers;

import ch.qos.logback.core.joran.sanity.Pair;
import com.target20.tic_tac_toe.models.*;
import com.target20.tic_tac_toe.strategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {

    private Scanner input;
    public GameController(){
        input = new Scanner(System.in);
    }


    public void startGame(List<Player> players,int boardSize){
        /*
        1) Create a new game object
        2) intialize the board
        3) set the players
        4) intialize the winning strategies
        */
        Game game = new Game();
        game.setPlayers(players);
        game.initialzeBoard(boardSize);
        game.initializeWinningStrategies(boardSize);
        game.setStatus((GameStatus.STARTED));
        while(game.getStatus() == GameStatus.STARTED){
            makeMove(game);
        }
        if(game.getStatus() == GameStatus.COMPLETED){
            Player winner = game.getWinner();
            System.out.println("The winner is " + winner.getPlayerName() + " " + winner.getPlayerSymbol().getSymbolImage());
        }
        if(game.getStatus() == GameStatus.TIE){
            System.out.println("It is a TIE");
        }

    }
    public void quitGame(){

    }
    public void restartGame(List<Player> players,int boardsize){
        startGame(players,boardsize);
    }
    public void getWinner(){

    }
    public void makeMove(Game game){
        Player player = game.nextPlayer();
        System.out.println("It is " + player.getPlayerName() + "'s turn");
        System.out.println("Enter the row value");
        int row = input.nextInt();
        System.out.println("Enter the col value");
        int col = input.nextInt();
        game.makeMove(row,col,player);
    }


}
