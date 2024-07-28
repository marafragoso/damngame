package com.codeforall.online.damngame;

import com.codeforall.online.damngame.animals.AnimalFactory;
import com.codeforall.online.damngame.animals.ducks.Duck;
import com.codeforall.online.damngame.animals.sharks.Shark;
import com.codeforall.online.damngame.controlers.MyMouse;
import com.codeforall.online.damngame.grid.Grid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameEngine {
    private Grid grid;
    private List<Duck> ducks = new ArrayList<>();
    private List<Shark> sharks = new ArrayList<>();
    private MyMouse mouse;

    public GameEngine() {
        this.grid = new Grid(100, 50);
        this.grid.init();
    }

    public void init() {

    }

    public void start() throws InterruptedException {
        animalsMove();
    }

    public void animalsMove() throws InterruptedException {
        int sharkCounter = 0;
        int duckCounter = 0;

        while(true){

            Thread.sleep(100);

            if(ducks.isEmpty() || duckCounter % 10 == 0){
                ducks.add(AnimalFactory.getNewDuck(grid));
                duckCounter++;
            }

            Iterator<Duck> duckIterator = ducks.iterator();
            while(duckIterator.hasNext()){
                Duck duck = duckIterator.next();
                
                mouse = new MyMouse();
                mouse.setDuck(duck);
                mouse.init();

                duck.moveRight();

                if (duck.getRightBorder() >= grid.columnToX(grid.getCols())) {
                    duck.remove();
                    duckIterator.remove();
                }
            }

            if(sharks.isEmpty() || sharkCounter % 5 == 0) {
                sharks.add(AnimalFactory.getNewShark(grid));
                sharkCounter++;
            }

            Iterator<Shark> sharkIterator = sharks.iterator();
            while(sharkIterator.hasNext()){
                Shark shark = sharkIterator.next();

                shark.moveUp();

                if(shark.getUpperBorder() <= grid.rowToY(grid.getRows()) / 1.53){
                    shark.remove();
                    sharkIterator.remove();
                }
            }
        }
    }
}



