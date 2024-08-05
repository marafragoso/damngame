package com.codeforall.online.damngame;

import com.codeforall.online.damngame.animals.AnimalFactory;
import com.codeforall.online.damngame.animals.ducks.Duck;
import com.codeforall.online.damngame.animals.sharks.Shark;
import com.codeforall.online.damngame.controlers.KeyHandler;
import com.codeforall.online.damngame.controlers.DuckCatcher;
import com.codeforall.online.damngame.grid.Grid;
import com.codeforall.online.damngame.menu.Menu;
import com.codeforall.online.damngame.menu.mouse.MousePointer;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameEngine {
    private Grid grid;
    private Player player;
    private List<Duck> ducks = new ArrayList<>();
    private List<Shark> sharks = new ArrayList<>();
    private KeyHandler keyHandler;
    private DuckCatcher duckCatcher;
    private MousePointer menuPointer;
    private boolean canGameStart;
    private boolean isGameOver;

    public GameEngine() {
        this.grid = new Grid(100, 50);

        this.canGameStart = false;
        this.isGameOver = false;
    }

    public void init() throws InterruptedException {
        Menu menu =  new Menu(this.grid);
        menuPointer = new MousePointer(menu);

        while(!canGameStart){
            if(menu.getGameStart()){
                this.canGameStart = true;
                menu = null;
                start();
            }else if(menu.getQuitGame()){
                System.exit(0);
            }
        }
    }

    public void start() throws InterruptedException {
        this.grid.init();
        this.player = new Player(this.grid);
        this.keyHandler = new KeyHandler(this.player);

        this.ducks.add(AnimalFactory.getNewDuck(grid));
        this.sharks.add(AnimalFactory.getNewShark(grid));

        int duckMovementCounter = 0;
        int sharkMovementCounter = 0;

        while(this.player.getLives() > 0) {

            Thread.sleep(100);

            duckMovementCounter = ducksMove(duckMovementCounter);

            sharkMovementCounter = sharksMove(sharkMovementCounter);
        }

        gameOver();
    }

    public void gameOver(){
        Picture gameOver = new Picture(grid.columnToX(grid.getCols()) / 2, grid.rowToY(grid.getRows()) / 3, "resources/gameover.png");
        gameOver.draw();
        gameOver.translate(-100,0);
        gameOver.grow(100,100);
    }

    public boolean collisionDetected(Picture p1, Picture p2) {

        if (p1.getX() + p1.getWidth() >= p2.getX() && p1.getY() + p1.getHeight() >= p2.getY()
                && p2.getX() + p2.getWidth() >= p1.getX()
                && p2.getY() + p2.getHeight() >= p1.getY()) {

            return true;
        }
        return false;
    }

    public int ducksMove(int duckMovementCounter) {
        if (ducks.isEmpty() || duckMovementCounter % 50 == 0) {
            ducks.add(AnimalFactory.getNewDuck(grid));
        }

        Iterator<Duck> duckIterator = ducks.iterator();
        while (duckIterator.hasNext()) {
            Duck duck = duckIterator.next();

            duckCatcher = new DuckCatcher(duck);

            duck.moveRight();
            duckMovementCounter ++;

            if (duck.getRightBorder() >= grid.columnToX(grid.getCols())) {
                duck.remove();
            }

            if (duck.getToRemove()) {
                duckIterator.remove();

            }
        }

        return duckMovementCounter;
    }

    public int sharksMove(int sharkMovementCounter) {
        if (sharks.isEmpty() || sharkMovementCounter % 20 == 0) {
            sharks.add(AnimalFactory.getNewShark(grid));
        }

        Iterator<Shark> sharkIterator = sharks.iterator();
        while (sharkIterator.hasNext()) {
            Shark shark = sharkIterator.next();

            shark.moveUp();
            sharkMovementCounter++;

            if (collisionDetected(this.player.getPicture(), shark.getPicture())) {
                this.player.decrementLives();

                shark.remove();
                sharkIterator.remove();

            } else if (shark.getUpperBorder() <= grid.rowToY(grid.getRows()) / 1.53) {
                shark.remove();
                sharkIterator.remove();
            }
        }

        return sharkMovementCounter;
    }
}
