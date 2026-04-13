package modals;

import modals.TYPES.CellStatus;

public class Board {

    private int size;
    private Cell[][] cells;

    public Board(int size){
        cells = new Cell[size][size];
        for(int row = 0;row < size;row++){
            for(int col = 0;col < size;col++){
                cells[row][col] = new Cell(row,col,null, CellStatus.EMPTY);
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void displayBoard(){
        for(Cell[] row : cells){
            for(Cell cell : row){
                System.out.print(cell);
            }
            System.out.println();
        }
    }
}
