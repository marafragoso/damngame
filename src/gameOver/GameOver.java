package com.codeforall.online.damngame.gameOver;

import com.codeforall.online.damngame.GameEngine;
import com.codeforall.online.damngame.grid.Grid;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class GameOver implements MouseHandler {
    private GameEngine gameEngine;
    private Grid grid;
    private Picture gameOver;
    private Picture replayButton;
    private Mouse mouse;

    public GameOver(Grid grid, GameEngine gameEngine) throws InterruptedException {
        this.gameEngine = gameEngine;
        this.grid = grid;

        this.gameEngine.restartGame();
        //If this line is here - or anywhere else in this code - the restart is successfull! If it is associated with the replay button, it won't work!!

        gameOver = new Picture(grid.columnToX(grid.getCols()) / 2, grid.rowToY(grid.getRows()) / 3, "resources/resources/gameover.png");
        gameOver.draw();
        gameOver.translate(-100, 0);
        gameOver.grow(100, 100);

        replayButton = new Picture(this.gameOver.getX() + 80, this.gameOver.getY() + 300, "resources/resources/replayButton.png");
        replayButton.draw();

        mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();

        if (x >= this.replayButton.getX() &&
                x <= this.replayButton.getMaxX() &&
                y <= this.replayButton.getMaxY() + 50 &&
                y >= this.replayButton.getY()) {

            delete();
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
    }

    /**
     * Deletes all the elements from the game over screen
     * Calls the gameEngine restartGame method
     */
    public void delete() {
        this.gameOver.delete();
        this.replayButton.delete();

        this.gameEngine.restartGame();
    }
}
