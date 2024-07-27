package com.codeforall.online.damngame;

import com.codeforall.online.damngame.animals.Ducks.Duck;
import com.codeforall.online.damngame.animals.Ducks.DuckFactory;
import com.codeforall.online.damngame.grid.Grid;

public class GameEngine {
    private Grid grid;

    public GameEngine() {
        this.grid = new Grid(100, 50);
        this.grid.init();
    }

    public void init() throws InterruptedException {

        //Player appears

        //sharksInit();
    }


}
