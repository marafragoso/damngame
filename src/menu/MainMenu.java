package com.codeforall.online.damngame.menu;

import com.codeforall.online.damngame.grid.Grid;
import com.codeforall.online.damngame.menu.buttons.QuitButton;
import com.codeforall.online.damngame.menu.buttons.SettingsButton;
import com.codeforall.online.damngame.menu.buttons.StartButton;
import com.codeforall.online.damngame.menu.mouse.MenuPointer;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MainMenu extends Menu{
    private Picture title;
    private StartButton startButton;
    private SettingsButton settingsButton;
    private QuitButton quitButton;

    private boolean gameStart = false;
    private boolean quitGame = false;

    public MainMenu(Grid grid) {
        super(grid);

        new MenuPointer(this);

        this.startButton = new StartButton();
        this.settingsButton = new SettingsButton();
        this.quitButton = new QuitButton();

        drawTitle();
        drawButtons();
    }

    private void drawTitle() {
        title = new Picture(Grid.PADDING * 7.5 + grid.columnToX(this.background.getX()), Grid.PADDING, "resources/resources/menu/name.png");
        title.draw();
    }

    private void drawButtons() {
        startButton.drawButton(grid, background);
        settingsButton.drawButton(grid, background);
        quitButton.drawButton(grid, background);
    }

    public StartButton getStartButton() {
        return this.startButton;
    }

    public SettingsButton getSettingsButton() {
        return this.settingsButton;
    }

    public QuitButton getQuitButton() {
        return this.quitButton;
    }

    public void displaySettings() {
        delete();
        new SettingsMenu(this.grid);
    }

    public boolean getGameStart() {
        return this.gameStart;
    }

    public void setGameStart() {
        this.gameStart = true;
    }

    public boolean getQuitGame() {
        return this.quitGame;
    }

    public void setQuitGame() {
        this.quitGame = true;
    }


    public void delete() {
        this.startButton.delete();
        this.settingsButton.delete();
        this.quitButton.delete();

    }

}
