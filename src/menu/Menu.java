package com.codeforall.online.damngame.menu;

import com.codeforall.online.damngame.controlers.DuckCatcher;
import com.codeforall.online.damngame.grid.Grid;
import com.codeforall.online.damngame.menu.Buttons.QuitButton;
import com.codeforall.online.damngame.menu.Buttons.StartButton;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu {
    private Grid grid;
    private Picture background;
    private StartButton startButton;
    private QuitButton quitButton;
    private DuckCatcher mouse;
    private boolean gameStart = false;
    private boolean quitGame = false;


    public Menu(Grid grid){
        this.grid = grid;
        this.startButton = new StartButton();
        this.quitButton = new QuitButton();

        drawBackground();
        drawTitle();
        drawButtons();
    }

    public Grid getGrid(){
        return this.grid;
    }

    public Picture getBackground(){
        return this.background;
    }

    public StartButton getStartButton(){
        return this.startButton;
    }

    public QuitButton getQuitButton(){
        return this.quitButton;
    }

    private void drawTitle(){
        Picture title =  new Picture(Grid.PADDING * 7.5 + grid.columnToX(this.background.getX()), Grid.PADDING, "resources/resources/menu/name.png");
        title.draw();
    }

    private void drawBackground(){
        this.background = new Picture(Grid.PADDING, Grid.PADDING, "resources/resources/menu/menuBackground.png");
        this.background.draw();
    }

    private void drawButtons(){
        startButton.drawButton(grid, background);
        quitButton.drawButton(grid, background);
    }

    public boolean getGameStart(){
        return this.gameStart;
    }
    public void setGameStart(){
        this.gameStart = true;
    }

    public boolean getQuitGame(){
        return this.quitGame;
    }

    public void setQuitGame(boolean quitGame){
        this.quitGame = quitGame;
    }

}
