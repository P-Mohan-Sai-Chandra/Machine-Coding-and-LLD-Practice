package modals;

import modals.TYPES.CellStatus;

public class Cell {

    private int row;
    private int col;
    private Player player;
    private CellStatus status;

    public Cell(int row,int col,Player player,CellStatus status){
        this.row = row;
        this.col = col;
        this.player = player;
        this.status = status;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }


    public CellStatus getStatus() {
        return status;
    }

    public void setStatus(CellStatus status) {
        this.status = status;
    }

    @Override
    public String toString(){
        String value = (status == CellStatus.EMPTY)?"-":getPlayer().getSymbol().getSymbol();
        return "| " + value + "|";
    }
}
