package com.codeforall.online.damngame;

import com.codeforall.online.damngame.Grid;

public class GameEngine {
    private Grid grid;

    public GameEngine() {
        this.grid = new Grid(500, 500);
        this.grid.init();
    }

}
