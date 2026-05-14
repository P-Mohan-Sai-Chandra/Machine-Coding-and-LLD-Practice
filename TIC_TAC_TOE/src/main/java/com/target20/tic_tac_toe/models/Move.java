package com.target20.tic_tac_toe.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Move {
    private Cell cell;
    private Player player;
}
