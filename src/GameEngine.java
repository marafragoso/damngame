package com.codeforall.online.damngame;

import com.codeforall.online.damngame.animals.AnimalFactory;
import com.codeforall.online.damngame.animals.ducks.Duck;
import com.codeforall.online.damngame.animals.sharks.Shark;
import com.codeforall.online.damngame.grid.Grid;

import java.util.ArrayList;
import java.util.List;

public class GameEngine {
    private Grid grid;
    private List<Duck> ducks =  new ArrayList<>();
    private List<Shark> sharks =  new ArrayList<>();

    public GameEngine() {
        this.grid = new Grid(100, 50);
        this.grid.init();
    }

    public void init() throws InterruptedException {
        while(true){

            sharksInit();

            ducksStart();
            //Player appears
        }
    }

    public void ducksStart() throws InterruptedException {
        Thread.sleep(100);

        int duckMovementCount = 0;

        if(ducks.size() == 0 || duckMovementCount % 40 == 0){
            ducks.add(AnimalFactory.getNewDuck(grid));
        }

        for(Duck duck : ducks) {
            duck.moveRight();
            duckMovementCount++;

            if (duck.getRightBorder() > grid.columnToX(grid.getCols()) - 5) {
                duck.remove();
            }
        }
    }

    public void sharksInit() throws InterruptedException {
        Thread.sleep(100);

        int sharkMovementCount = 0;

        if(sharks.size() == 0 || sharkMovementCount % 10 == 0){
            sharks.add(AnimalFactory.getNewShark(grid));
        }

        for(Shark shark : sharks) {
            shark.moveUp();
            sharkMovementCount++;

            if(shark.getUpperBorder() < grid.rowToY(grid.getRows()) / 1.53){
                shark.remove();
            }
        }
    }
}


