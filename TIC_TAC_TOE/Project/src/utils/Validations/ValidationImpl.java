package utils.Validations;

import modals.Cell;
import modals.TYPES.CellStatus;

public class ValidationImpl implements  Validations{

    @Override
    public boolean validCell(Cell cell, int size) {
        int row = cell.getRow();
        int col = cell.getCol();
        if(row < 0 || row >= size) return false;
        if(col < 0 || col >= size) return false;
        if(cell.getStatus() == CellStatus.FILLED) return false;
        return true;
    }
}
