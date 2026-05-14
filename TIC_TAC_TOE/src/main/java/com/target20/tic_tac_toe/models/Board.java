package com.target20.tic_tac_toe.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Board {
    private int size;
    private List<List<Cell>> cells;

}
