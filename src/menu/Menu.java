package com.codeforall.online.damngame.menu;

import com.codeforall.online.damngame.controlers.DuckCatcher;
import com.codeforall.online.damngame.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu {
    private Grid grid;
    private Picture backgroud;
    private Picture startButton;
    private Picture quitButton;
    private DuckCatcher mouse;
    private boolean gameStart;


    public Menu(Grid grid){
        this.grid = grid;
        this.gameStart = false;

        drawBackground();
        drawTitle();
        drawButtons();
    }

    private void drawTitle(){
        Picture title =  new Picture(Grid.PADDING * 7.5 + grid.columnToX(this.backgroud.getX()), Grid.PADDING, "resources/resources/menu/name.png");
        title.draw();
    }

    private void drawBackground(){
        this.backgroud = new Picture(Grid.PADDING, Grid.PADDING, "resources/resources/menu/menuBackground.png");
        this.backgroud.draw();
    }

    private void drawButtons(){
        this.startButton = new Picture(Grid.PADDING * 10 + grid.columnToX(this.backgroud.getX()), Grid.PADDING + grid.rowToY(this.backgroud.getY()), "resources/resources/menu/start.png");
        startButton.draw();

        this.quitButton =  new Picture(Grid.PADDING * 10 + grid.columnToX(this.backgroud.getX()), Grid.PADDING * 7 + grid.rowToY(this.backgroud.getY()), "resources/resources/menu/quit.png");
        quitButton.draw();
    }

    public int getStartButtonX() {
        return this.startButton.getX();
    }

    public int getStartButtonY() {
        return this.startButton.getY();
    }

    public int getStartButtonHeight() {
        return this.startButton.getMaxY();
    }

    public int getStartButtonWidth() {
        return this.startButton.getMaxX();
    }

    public boolean getGameStart(){
        return this.gameStart;
    }
    public void setGameStart(){
        this.gameStart = true;
    }

}
