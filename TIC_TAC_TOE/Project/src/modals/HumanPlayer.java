package modals;

import modals.TYPES.BotDifficulty;
import modals.TYPES.ExceptionTypes;
import modals.TYPES.PlayerType;
import utils.Validations.ValidationImpl;
import utils.Validations.Validations;

import java.util.Scanner;

public class HumanPlayer extends Player{
    Scanner sc = new Scanner(System.in);
    Validations validator = new ValidationImpl();
    public HumanPlayer(String playerName, String playerId,String symbol, PlayerType playerType){
        super(playerName,playerId,symbol,playerType);
    }


    @Override
    public Move makeMove(Board board,Player player) {
        Cell[][] cells = board.getCells();
        System.out.println("Enter the Row and Col Number");
        int row = sc.nextInt();
        int col = sc.nextInt();
        if(validator.validCell(cells[row][col],board.getSize())) throw new RuntimeException(ExceptionTypes.INVALID_INPUT.toString());
        Move move = new Move(row,col,this);
        cells[row][col].setPlayer(this);
        return move;
    }
}
