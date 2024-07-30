package com.codeforall.online.damngame;

import com.codeforall.online.damngame.animals.AnimalFactory;
import com.codeforall.online.damngame.animals.ducks.Duck;
import com.codeforall.online.damngame.animals.sharks.Shark;
import com.codeforall.online.damngame.controlers.KeyHandler;
import com.codeforall.online.damngame.controlers.MyMouse;
import com.codeforall.online.damngame.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameEngine {
    private Grid grid;
    private List<Duck> ducks = new ArrayList<>();
    private List<Shark> sharks = new ArrayList<>();
    private Player player;
    private com.codeforall.online.damngame.controlers.KeyHandler keyHandler;
    private MyMouse mouse;
    private boolean isGameOver;

    public GameEngine() {
        this.grid = new Grid(100, 50);
        this.grid.init();
        this.player = new Player(this.grid);
        this.keyHandler = new KeyHandler(this.player);
        this.isGameOver = false;
    }

    public void init() {

    }

    public void start() throws InterruptedException {
        animalsMove();
    }

    public boolean collisionDetected(Picture p1, Picture p2) {

        if (p1.getX() + p1.getWidth() >= p2.getX() && p1.getY() + p1.getHeight() >= p2.getY()
                && p2.getX() + p2.getWidth() >= p1.getX()
                && p2.getY() + p2.getHeight() >= p1.getY()) {

            System.out.println("game over");
            return true;
        }
        return false;
    }

    public void animalsMove() throws InterruptedException {
        int sharkCounter = 0;
        int duckCounter = 0;

        while (!isGameOver) {

            Thread.sleep(100);

            if (ducks.isEmpty() || duckCounter % 10 == 0) {
                ducks.add(AnimalFactory.getNewDuck(grid));

                duckCounter++;
            }

            Iterator<Duck> duckIterator = ducks.iterator();
            while (duckIterator.hasNext()) {
                Duck duck = duckIterator.next();

                mouse = new MyMouse(duck);

                duck.moveRight();

                if (duck.getRightBorder() >= grid.columnToX(grid.getCols())) {
                    duck.remove();
                }

                if (duck.getToRemove()) {
                    duckIterator.remove();
                }
            }

            if (sharks.isEmpty() || sharkCounter % 5 == 0) {
                sharks.add(AnimalFactory.getNewShark(grid));
                sharkCounter++;
            }

            Iterator<Shark> sharkIterator = sharks.iterator();
            while (sharkIterator.hasNext()) {
                Shark shark = sharkIterator.next();

                shark.moveUp();

                if (shark.getUpperBorder() <= grid.rowToY(grid.getRows()) / 1.53) {
                    shark.remove();
                    sharkIterator.remove();
                }
                if (collisionDetected(this.player.getPicture(), shark.getPicture())) {
                    this.isGameOver = true;
                    shark.remove();
                    sharkIterator.remove();
                }

            }

        }
    }
}
