package modals;

import java.util.List;

public class Game {

    private List<Move> moveHistory;
    private List<Player> players;
    private Board board;
    private Player winner;
    private int nextPlayer;

    private Game(){}

    private Game(Builder builder){
        this.moveHistory = builder.moveHistory;
        this.board = builder.board;
        this.nextPlayer = builder.nextPlayer;
        this.players = builder.players;
        this.winner = builder.winner;
    }

    public void makeMove(){
        try{
            Player currPlayer = players.get(nextPlayer);
            Move move = currPlayer.makeMove(board,currPlayer);
            moveHistory.add(move);
            nextPlayer++;
            nextPlayer%=players.size();
        }
        catch (Exception e){

        }
    }

    public void undo(){

    }

    public Player checkWinner(){
        return null;
    }

    public static class Builder{
        private List<Move> moveHistory;
        private List<Player> players;
        private Board board;
        private Player winner;
        private int nextPlayer;

        public Board getBoard() {
            return board;
        }

        public Builder  setBoard(Board board) {
            this.board = board;
            return this;
        }

        public List<Move> getMoveHistory() {
            return moveHistory;
        }

        public Builder setMoveHistory(List<Move> moveHistory) {
            this.moveHistory = moveHistory;
            return this;
        }

        public int getNextPlayer() {
            return nextPlayer;
        }

        public Builder setNextPlayer(int nextPlayer) {
            this.nextPlayer = nextPlayer;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Player getWinner() {
            return winner;
        }

        public Builder setWinner(Player winner) {
            this.winner = winner;
            return this;
        }

        public Game build(){
            return new Game(this);
        }

    }


}
