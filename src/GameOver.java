package com.codeforall.online.damngame;

import com.codeforall.online.damngame.animals.ducks.Duck;
import com.codeforall.online.damngame.animals.sharks.Shark;
import com.codeforall.online.damngame.controlers.DuckCatcher;
import com.codeforall.online.damngame.controlers.KeyHandler;
import com.codeforall.online.damngame.grid.Grid;
import com.codeforall.online.damngame.menu.mouse.MousePointer;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.List;

public class GameOver {
    private Text replayText;
    private Picture gameOverPic;


    public GameOver(Grid grid) {

        this.gameOverPic = new Picture(grid.columnToX(grid.getCols()) / 2, grid.rowToY(grid.getRows()) / 3, "resources/gameover.png");
        this.replayText = new Text(grid.columnToX(grid.getCols()) / 2, grid.rowToY(grid.getRows()) / 2 + 100, "Press \"R\" if you want to play again");

    }

    public void displayGameOver() {
        gameOverPic.draw();
        gameOverPic.translate(-100, 0);
        gameOverPic.grow(100, 100);
        replayText.draw();
    }

    public void removeGameOver() {
        replayText.delete();
        gameOverPic.delete();

    }
}