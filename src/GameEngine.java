package com.codeforall.online.damngame;

import com.codeforall.online.damngame.animals.AnimalFactory;
import com.codeforall.online.damngame.animals.ducks.Duck;
import com.codeforall.online.damngame.animals.sharks.Shark;
import com.codeforall.online.damngame.grid.Grid;
import com.codeforall.online.damngame.Player;

import java.util.ArrayList;
import java.util.List;

public class GameEngine {
    private Grid grid;
    private List<Duck> ducks = new ArrayList<>();
    private List<Shark> sharks = new ArrayList<>();
    private Player player;
    private KeyHandler keyHandler;

    public GameEngine() {
        this.grid = new Grid(70, 30);
        this.grid.init();
        this.player = new Player(this.grid);
        this.keyHandler = new KeyHandler(this.player);
    }

    public void init() {

    }

    public void start() throws InterruptedException {
        // animalsMove();
    }

    public void animalsMove() throws InterruptedException {
        int duckMovementCounter = 0;
        int sharkMovementCounter = 0;

        int duckDivisor = 300;
        int sharkDivisor = 100;

        while (true) {

            Thread.sleep(100);

            if (ducks.isEmpty() || duckMovementCounter % duckDivisor == 0) {
                ducks.add(AnimalFactory.getNewDuck(grid));
            }

            if (sharks.isEmpty() || sharkMovementCounter % sharkDivisor == 0) {
                sharks.add(AnimalFactory.getNewShark(grid));
            }

            if (duckDivisor > 100) {
                duckDivisor--;
            }

            if (sharkDivisor > 20) {
                sharkDivisor -= 2;
            }

            for (int i = 0; i < ducks.size(); i++) {
                Duck duck = ducks.get(i);
                duck.moveRight();
                duckMovementCounter++;

                if (duck.getRightBorder() > grid.columnToX(grid.getCols()) - 5) {
                    ducks.remove(i);
                }
            }

            for (Shark shark : sharks) {
                shark.moveUp();
                sharkMovementCounter++;

                if (shark.getUpperBorder() < grid.rowToY(grid.getRows()) / 1.53) {
                    shark.remove();
                }
            }
        }
    }
}
