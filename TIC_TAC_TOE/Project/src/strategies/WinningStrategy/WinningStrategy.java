package strategies.WinningStrategy;

import modals.Board;
import modals.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);
}
