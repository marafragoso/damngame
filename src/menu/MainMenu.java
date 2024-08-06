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
    private MenuPointer menuPointer;

    private boolean gameStart = false;
    private boolean quitGame = false;

    public MainMenu(Grid grid) {
        super(grid);

        this.menuPointer = new MenuPointer(this);

        this.startButton = new StartButton(grid, background);
        this.settingsButton = new SettingsButton(grid, background);
        this.quitButton = new QuitButton(grid, background);

        drawTitle();
        drawButtons();
    }

    private void drawTitle() {
        title = new Picture(Grid.PADDING * 7.5 + grid.columnToX(this.background.getX()), Grid.PADDING, "resources/resources/menu/name.png");
        title.draw();
    }

    private void drawButtons() {
        startButton.drawButton();
        settingsButton.drawButton();
        quitButton.drawButton();
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

    public void startGame() {
        this.gameStart = true;
    }

    public boolean getQuitGame() {
        return this.quitGame;
    }

    public void exitGame() {
        this.quitGame = true;
    }


    public void delete() {
        this.startButton.delete();
        this.settingsButton.delete();
        this.quitButton.delete();
        this.title.delete();

        this.menuPointer = null;
    }

}
