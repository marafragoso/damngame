package com.codeforall.online.damngame;

import com.codeforall.online.damngame.animals.AnimalFactory;
import com.codeforall.online.damngame.animals.ducks.Duck;
import com.codeforall.online.damngame.animals.sharks.Shark;
import com.codeforall.online.damngame.controlers.KeyHandler;
import com.codeforall.online.damngame.grid.Grid;
import com.codeforall.online.damngame.menu.Menu;
import com.codeforall.online.damngame.menu.mouse.MousePointer;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
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
    private MousePointer menuPointer;
    private boolean canGameStart = false;
    private boolean isGameOver = false;
    private Text scoreText;

    public GameEngine() {
        this.grid = new Grid(100, 50);
    }

    public void init() throws InterruptedException {
        Menu menu = new Menu(this.grid);
        menuPointer = new MousePointer(menu);

        while (!canGameStart) {
            if (menu.getGameStart()) {
                this.canGameStart = true;
                menu = null;
                start();
            } else if (menu.getQuitGame()) {
                System.exit(0);
            }
        }
    }

    public void start() throws InterruptedException {
        this.grid.init();
        this.player = new Player(this.grid);

        this.scoreText = new Text(70, 70, "Score: " + player.getScore());
        this.scoreText.setColor(Color.LIGHT_GRAY);
        this.scoreText.grow(40, 20);
        scoreText.draw();

        this.keyHandler = new KeyHandler(this.player);

        int duckMovementCounter = 0;
        int sharkMovementCounter = 0;

        while (this.player.getLives() > 0) {

            Thread.sleep(100);

            duckMovementCounter = ducksMove(duckMovementCounter);

            sharkMovementCounter = sharksMove(sharkMovementCounter);
            this.scoreText.setText("Score: " + this.player.getScore()); // to print the score every cicle
        }

        gameOver();
    }

    public void gameOver() {
        Picture gameOver = new Picture(grid.columnToX(grid.getCols()) / 2, grid.rowToY(grid.getRows()) / 3, "resources/gameover.png");
        gameOver.draw();
        gameOver.translate(-100, 0);
        gameOver.grow(100, 100);
    }

    public boolean collisionDetected(Picture p1, Picture p2) {

        if (p1.getX() + p1.getWidth() >= p2.getX() && p1.getY() + p1.getHeight() >= p2.getY()
                && p2.getX() + p2.getWidth() >= p1.getX()
                && p2.getY() + p2.getHeight() >= p1.getY()) {

            return true;
        }
        return false;
    }

    /**
     * Iterates through the list of available ducks and moves them
     *
     * @param duckMovementCounter   The sum of the movements all the ducks have made so far
     * @return  updates de duckMovement counter
     */
    public int ducksMove(int duckMovementCounter) {
        if (ducks.isEmpty() || duckMovementCounter % 50 == 0) { //Generates a new duck if the list is empty or at every 50 global duck movement
            ducks.add(AnimalFactory.getNewDuck(grid));
        }

        Iterator<Duck> duckIterator = ducks.iterator();
        while (duckIterator.hasNext()) {
            Duck duck = duckIterator.next();

            duck.moveRight();
            duckMovementCounter++;

            if (duck.getRightBorder() >= grid.columnToX(grid.getCols())) { //Duck gets deleted at the edge of the screen
                duck.remove();
            }

            if (duck.isClicked()) { // If a player clicks a duck, it's score gets updated; duck gets deleted
                this.player.increaseScore();
                duckIterator.remove();
            }
        }

        return duckMovementCounter;
    }

    /**
     * Iterates through the list of available sharks and moves them
     *
     * @param sharkMovementCounter  The sum of the movements all the sharks have made so far
     * @return  updates de sharkMovement counter
     */
    public int sharksMove(int sharkMovementCounter) {
        if (sharks.isEmpty() || sharkMovementCounter % 20 == 0) { //Generates a new shark if the list is empty or at every 20 global shark movements
            sharks.add(AnimalFactory.getNewShark(grid));
        }

        Iterator<Shark> sharkIterator = sharks.iterator();
        while (sharkIterator.hasNext()) {
            Shark shark = sharkIterator.next();

            shark.moveUp();
            sharkMovementCounter++;

            if (collisionDetected(this.player.getPicture(), shark.getPicture())) { // Deletes shark if it colides
                this.player.decrementLives(); //Player loses a live

                shark.remove();
                sharkIterator.remove();

            } else if (shark.getUpperBorder() <= grid.rowToY(grid.getRows()) / 1.53) { // Shark gets deleted if it reaches the horizon line
                shark.remove();
                sharkIterator.remove();
            }
        }

        return sharkMovementCounter;
    }
}
