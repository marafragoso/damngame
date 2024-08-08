package com.codeforall.online.damngame.gameOver;

import com.codeforall.online.damngame.GameEngine;
import com.codeforall.online.damngame.grid.Grid;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.swing.*;

public class GameOver implements MouseHandler {
    private GameEngine gameEngine;
    private Picture gameOver;
    private Picture replayButton;
    private Mouse mouse;

    public GameOver(Grid grid, GameEngine gameEngine) throws InterruptedException {
        this.gameEngine = gameEngine;
        // this.gameEngine.restartGame();

        gameOver = new Picture(grid.columnToX(grid.getCols()) / 2, grid.rowToY(grid.getRows()) / 3, "resources/gameover.png");
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

    public void delete() {
        this.gameOver.delete();
        this.replayButton.delete();

        this.gameEngine.restartGame();
    }
}
